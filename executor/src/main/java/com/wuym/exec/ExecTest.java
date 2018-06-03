package com.wuym.exec;

import java.util.Random;
import java.util.UUID;
import java.util.concurrent.*;

/**
 * Created by wuym on 2018/6/3.
 * 简单模拟生成订单，到指派相关服务人员。订单生成的同时，指派过程并行执行
 * 若指派先完成，将等待订单完成后，将两者关联
 */
public class ExecTest {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        //订单task
        Callable<String> orderTask = new Callable<String>() {
            /**
             * 生成订单
             * */
            public String call() throws Exception {
                //生成订单
                String uuid = UUID.randomUUID().toString();
                uuid = uuid.replace("-", "");
                //模拟生成过程需要耗时
                Thread.sleep(3000);
                System.out.println("订单生成成功，订单号为 ：" + uuid);
                return uuid;
            }
        };
        //使用FutureTask方式调用
        /*FutureTask<String> futureTask = new FutureTask<String>(orderTask);
        executorService.submit(futureTask);*/
        Future<String> orderFuture = executorService.submit(orderTask);
        executorService.shutdown();
        /*try {
            Thread.sleep(4000);//模拟订单将先生成
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
        //继续指派订单服务人员，此时订单可能还在生成入库当中
        Random random = new Random(100);
        int personId = random.nextInt();
        System.out.println("服务人员指派成功，服务人员id ：" + personId);

        if(!orderFuture.isDone()){
            System.out.println("订单尚未生成成功，暂无法将服务人员与订单关联");
        }
        String orderId = null;//若生成订单过程仍在进行，线程将阻塞等待计算结果完成
        try {
            orderId = orderFuture.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        System.out.println("已将订单与服务人员关联：" + orderId + "----->" + personId);
        /*
        //安全方式关闭线程池
        try {
            executorService.awaitTermination(3,TimeUnit.SECONDS);
            executorService.shutdown();
            System.out.println("线程池执行完毕");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
    }


}
