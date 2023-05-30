package com.example.smartcity.pojo.personal;

public class PersonalTokenData {

    /**
     * msg : 操作成功
     * code : 200
     * token : eyJhbGciOiJIUzUxMiJ9.eyJsb2dpbl91c2VyX2tleSI6ImJiNTUwMjg3LTUxOGMtNDk4NS1iMzgwLTQwYTA5ZDliODM0YSJ9.OfxB5i8OCYmcYPicG--l1e9zA4sGP-4v2zTGlRcswox0EUvMYv39qZNT5kVA7KtkSZb7Cfe3y9BQbgPPa4_4QQ
     */

    private String msg;
    private int code;
    private String token;

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

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
