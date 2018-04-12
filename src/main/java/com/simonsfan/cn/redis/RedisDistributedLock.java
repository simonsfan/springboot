package com.simonsfan.cn.redis;

import redis.clients.jedis.Jedis;

import java.util.Collections;

/**
 *  基于redis的分布式锁实现
 *  本文取自 https://www.cnblogs.com/linjiqin/p/8003838.html
 * Created by fanrx on 2018/4/3.
 */
public class RedisDistributedLock {

    private static final String LOCKED_SUCCESS = "OK";
    private static final String SET_IF_NOT_EXIST = "NX";
    private static final String SET_WITH_EXPIRE_TIME = "PX";

    /**
     * 尝试获取分布式锁
     * @param jedis
     * @param lockKey 锁的key
     * @param uniqueId 请求标识
     * @param expireTime 超期时间
     * @return 是否获取成功
     */
    public static boolean tryDistributedLock(Jedis jedis, String lockKey, String uniqueId, int expireTime) {
        String result = jedis.set(lockKey, uniqueId, SET_IF_NOT_EXIST, SET_WITH_EXPIRE_TIME, expireTime);
        if (LOCKED_SUCCESS.equals(result)) {
            return true;
        }
        return false;
    }

    private static final Long RELEASE_SUCCESS = 1L;
    /**
     * 释放分布式锁
     * @param jedis Redis客户端
     * @param lockKey 锁
     * @param requestId 请求标识
     * @return 是否释放成功
     */
    public static boolean releaseDistributedLock(Jedis jedis, String lockKey, String requestId) {
        String script = "if redis.call('get', KEYS[1]) == ARGV[1] then return redis.call('del', KEYS[1]) else return 0 end";
        Object result = jedis.eval(script, Collections.singletonList(lockKey), Collections.singletonList(requestId));

        if (RELEASE_SUCCESS.equals(result)) {
            return true;
        }
        return false;

    }

}
