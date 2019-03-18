package com.garry.ehcache.demo.service;

import com.garry.ehcache.demo.entity.User;

import java.util.List;

/**
 * Author : moon
 * Date  : 2019/3/18 16:15
 * Description : Interface for
 */
public interface IUserService {
    List getUserList(User user);

    void addUser(User user);
}
