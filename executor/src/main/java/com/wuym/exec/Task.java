package com.wuym.exec;

import java.util.concurrent.Callable;

/**
 * Created by wuym on 2018/6/3.
 */
public class Task implements Callable<String> {
    private String taskId;

    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }

    public String call() throws Exception {
        return taskId;
    }
}
