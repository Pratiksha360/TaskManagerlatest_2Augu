package com.franchiseworld.taskmanager.customexception;

public class TaskNotFoundException extends RuntimeException {
    private String msg;

    public TaskNotFoundException(String msg) {
        super(msg);
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
    }

