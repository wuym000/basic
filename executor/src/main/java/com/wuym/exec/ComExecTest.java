package com.wuym.exec;

import java.util.concurrent.*;

/**
 * Created by wuym on 2018/6/3.
 */
public class ComExecTest {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        CompletionService<String> completionService = new ExecutorCompletionService<String>(executorService);
        for(int i = 0; i<100; i++){
            ComTask task = new ComTask();
            completionService.submit(task);
        }
        executorService.shutdown();
        try {
            for(int i = 0; i<100; i++){
                Future<String> future = completionService.take();
                String time = future.get();
                System.out.println("完成" + i + "条作业，当前完成的耗时" + time);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
