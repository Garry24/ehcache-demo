package com.garry.ehcache.demo.controller;

import com.garry.ehcache.demo.commons.SysResult;
import com.garry.ehcache.demo.entity.User;
import com.garry.ehcache.demo.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Author : GarryLuo
 * Date  : 2019/3/18 16:13
 */
@RestController
@RequestMapping("/api/user")
public class UserController {
    @Autowired
    private IUserService userService;

    @RequestMapping(value = "/getUserList", method = RequestMethod.GET)
    public SysResult getUserList(@RequestBody User user) {
        return SysResult.okList(userService.getUserList(user));
    }

    @RequestMapping(value = "/addUser", method = RequestMethod.POST)
    public SysResult addUser(@RequestBody User user) {
        userService.addUser(user);
        return SysResult.ok(user);
    }

}
