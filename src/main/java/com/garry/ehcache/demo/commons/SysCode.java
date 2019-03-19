package com.garry.ehcache.demo.commons;

/**
 * Author : GarryLuo
 * Date  : 2019/1/21 16:15
 * Description : 返回错误码类，不要改动码
 */
public enum SysCode {

    SUCCESS("0000", "成功"),
    EXCEPTION("1001", "系统异常"),
    DIY_EXCEPTION("1002", "自定义系统异常");

    private String code;

    private String message;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    SysCode(String code, String message) {
        this.code = code;
        this.message = message;
    }
}
