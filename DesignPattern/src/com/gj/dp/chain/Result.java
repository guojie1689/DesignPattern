package com.gj.dp.chain;

public class Result {
    private boolean isPass;
    private String msg;

    public Result() {

    }

    public Result(boolean isPass, String msg) {
        this.isPass = isPass;
        this.msg = msg;
    }

    public boolean isPass() {
        return isPass;
    }

    public void setPass(boolean pass) {
        isPass = pass;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
