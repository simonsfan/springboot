package com.simonsfan.cn.task;

import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

/**
 * Created by fanrx on 2018/6/1.
 */
public class DelayQueueTask implements Delayed {
    @Override
    public long getDelay(TimeUnit unit) {
        return 0;
    }

    @Override
    public int compareTo(Delayed o) {
        return 0;
    }
}
