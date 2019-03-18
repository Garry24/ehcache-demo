package com.garry.ehcache.demo.entity;

import lombok.Data;

/**
 * Author : GarryLuo
 * Date  : 2019/3/18 16:05
 */
@Data
public class User {
    private Integer id;
    private String userName;
    private Integer age;

    public User() {
    }

    public User(String userName, Integer age) {
        this.userName = userName;
        this.age = age;
    }
}
