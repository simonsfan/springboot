package com.simonsfan.cn.task;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ArrayBlockingQueue;

/**
 * Created by fanrx on 2018/6/10.
 */
public class ArrayBlockingQueueTest {


    static   final  List<String> list = new ArrayList<String>() {
            {
                add("wangwu");
                add("lisi");
                add("zhangsan");
            }
        };
static   final Map<String,String> map = new HashMap<String,String>() {
            {
                put("1","wangwu");
                put("2","lisi");
                put("3","zhangsan");
            }
        };

    public static void main(String[] args) throws InterruptedException {
        ArrayBlockingQueue queue = new ArrayBlockingQueue(2000);
        queue.offer(map);

        boolean add = queue.add(list);
        System.out.println(add);
        Object take1 = queue.peek();
        System.out.println(take1);

//        Object take = queue.poll();
//        System.out.println(take);
    }
}
