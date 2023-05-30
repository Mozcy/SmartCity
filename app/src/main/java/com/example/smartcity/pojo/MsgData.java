package com.example.smartcity.pojo;

public class MsgData {

    /**
     * msg : 操作成功
     * code : 200
     */

    private String msg;
    private int code;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "MsgData{" +
                "msg='" + msg + '\'' +
                ", code=" + code +
                '}';
    }
}
