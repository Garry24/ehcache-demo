package com.garry.ehcache.demo.exception;

/**
 * 自定义异常demo
 */
public class DIYException extends RuntimeException {
    public DIYException(String message) {
        super(message);
    }
}