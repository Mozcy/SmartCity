package com.example.smartcity.pojo.personal;

public class PersonalFileData {

    /**
     * msg : 操作成功
     * fileName : /profile/upload/2022/07/20/facc07a1-657c-4af8-b489-4f9713f16143.png
     * code : 200
     * url : http://smart.ifast3.vipnps.vip/profile/upload/2022/07/20/facc07a1-657c-4af8-b489-4f9713f16143.png
     */

    private String msg;
    private String fileName;
    private int code;
    private String url;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
