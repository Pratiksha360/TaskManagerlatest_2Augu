package com.franchiseworld.taskmanager.customexception;

public class UserNameNotFoundException extends  RuntimeException{
    private String msg;

    public UserNameNotFoundException(String msg) {
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
