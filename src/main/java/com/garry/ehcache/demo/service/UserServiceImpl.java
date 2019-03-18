package com.garry.ehcache.demo.service;

import com.garry.ehcache.demo.dao.UserMapper;
import com.garry.ehcache.demo.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Author : GarryLuo
 * Date  : 2019/3/18 16:14
 */
@Service
public class UserServiceImpl implements IUserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    @Cacheable(value = "user", key = "'getUserList'+#user")
    public List getUserList(User user) {
        return userMapper.getUserList(user);
    }

    @Override
    public void addUser(User user) {
        userMapper.addUser(user);
    }
}
