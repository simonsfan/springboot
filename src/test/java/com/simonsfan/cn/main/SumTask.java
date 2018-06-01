package com.simonsfan.cn.main;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

/**
 * Created by fanrx on 2018/5/21.
 */
public class SumTask extends RecursiveTask<Integer> {

    private static final int THRESHOLD =3; //设定一个阈值

    Integer start;
    Integer end;

    public SumTask(Integer start, Integer end) {
        this.start = start;
        this.end = end;
    }

    @Override
    protected Integer compute() {
        // 如果任务小于阈值，说明任务足够小，不切分直接计算
        int sum = 0;
        if (end - start <= THRESHOLD) {
            for (int i = start; i <= end; i++) {
                sum += i;
            }
            return sum;
        }
        // 超过阈值，假定分为切分为2个任务:
        int middle = (end + start) / 2;
        SumTask subtask1 = new SumTask(start, middle);
        SumTask subtask2 = new SumTask(middle+1, end);
        invokeAll(subtask1, subtask2);
        Integer result1 = subtask1.join();
        Integer result2 = subtask2.join();
        //合并任务
        sum = result1 + result2;
        System.out.println("result1+result2"+"="+sum);
        return sum;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ForkJoinPool joinPool = new ForkJoinPool();
        List<Integer> list = new ArrayList<Integer>();
        for (int i = 1; i <=10; i++) {
            list.add(i);  //size=10
        }
        SumTask task = new SumTask(1,10);
        ForkJoinTask<Integer> result = joinPool.submit(task);
        Integer integer = result.get();
        System.out.println(integer);
    }

}
