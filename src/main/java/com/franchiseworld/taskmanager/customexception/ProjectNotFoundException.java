package com.franchiseworld.taskmanager.customexception;

public class ProjectNotFoundException extends  RuntimeException{

    private String msg;

    public ProjectNotFoundException(String msg) {
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
