package com.wuym.exec;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Created by wuym on 2018/6/3.
 */
public class ExecParam {
    public static void main(String[] args) {
        ExecutorService es = Executors.newSingleThreadExecutor();
        Task task = new Task();
        task.setTaskId("id001");

        try {
            System.out.println("主线程等待两秒");
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Future<String> future = es.submit(task);
        es.shutdown();
        String id = null;
        try {
            id = future.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        System.out.println(id);
    }
}
