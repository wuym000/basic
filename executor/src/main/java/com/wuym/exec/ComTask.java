package com.wuym.exec;

import java.util.concurrent.Callable;

/**
 * Created by wuym on 2018/6/3.
 */
public class ComTask implements Callable<String> {


    public String call() throws Exception {
        Double d = Math.random();
        long l = new Double(d * 10000).longValue();
        Thread.sleep(l);
        return l + "";
    }
}
