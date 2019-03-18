package com.garry.ehcache.demo.dao;

import com.garry.ehcache.demo.entity.User;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Author : GarryLuo
 * Date  : 2019/3/18 16:15
 */
@Repository
public interface UserMapper {
    List getUserList(User user);

    void addUser(User user);
}
