package com.garry.ehcache.demo.commons;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * Author : GarryLuo
 * Date  : 2019/1/21 16:15
 * Description : 返回错误码类，不要改动码
 */
@Getter
@AllArgsConstructor
public enum SysCode {
    SUCCESS("0000", "成功"),
    EXCEPTION("1001", "系统异常"),
    DIY_EXCEPTION("1002", "自定义系统异常");

    private String code;
    private String message;
}
