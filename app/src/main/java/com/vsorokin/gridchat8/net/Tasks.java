package com.vsorokin.gridchat8.net;

import java.util.concurrent.Callable;

public class Tasks implements Callable<Integer> {

    private int taskId;

    public Tasks(int taskId) {
        this.taskId = taskId;
    }

    @Override
    public Integer call() throws Exception {
        System.out.println("executing task Id: " + taskId);
        return taskId;
    }

}