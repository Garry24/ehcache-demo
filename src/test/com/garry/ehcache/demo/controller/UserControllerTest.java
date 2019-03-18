package com.garry.ehcache.demo.controller;

import com.garry.ehcache.demo.entity.User;
import com.garry.ehcache.demo.service.IUserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class UserControllerTest {
    @Autowired
    private IUserService userService;

    @Test
    public void getUserList() throws Exception {
        System.out.println(userService.getUserList(new User()));
    }

    @Test
    public void addUser() throws Exception {
        User user = new User("王五", 27);
        userService.addUser(user);
    }

    @Test
    public void compare() {
        User user = new User("王五", 27);
        User user1 = new User("王五", 27);
        System.out.println((user.equals(user1)));
    }

}