package com.welcome.server.controller;

import com.welcome.server.entity.Raiting;
import com.welcome.server.entity.User;
import com.welcome.server.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by ivanf on 12.10.2016.
 */
@RestController
@RequestMapping("/user")
public class AuthController {

    @Autowired
    UserService userService;

    @RequestMapping(value = "/reg/{user}", method = RequestMethod.POST)
    @ResponseBody
    public User registration(@PathVariable User user) {
        return userService.regNewUser(user);
    }

    @RequestMapping(value = "/auth/{user}")
    @ResponseBody
    public String auth(@PathVariable User user) {
        return userService.authUser(user);
    }

    @RequestMapping(value = "/testReg", method = RequestMethod.GET)
    @ResponseBody
    public User testReg() {
        User user = new User();
        user.setNickname("SuperVasya");
        user.setEmail("vasya@gmail.com");
        user.setImei("SuperNokiaPhone");
        user.setRaiting(new Raiting(user, 0L, 0L, 0, 0));
        return userService.regNewUser(user);
    }

    @RequestMapping(value = "/testAuth", method = RequestMethod.GET)
    @ResponseBody
    public String testAuth() {
        User user = new User();
        user.setId(1);
        user.setNickname("SuperVasya");
        user.setImei("SuperNokiaPhone");
        return userService.authUser(user);
    }

    @RequestMapping(value = "/testUpdate", method = RequestMethod.GET)
    @ResponseBody
    public User testUpdate() {
        User user = new User();
        user.setId(1);
        user.setImei("SuperNokiaPhone");
        user.setNickname("Petuna");
        user.setEmail("MAIL");
        user.setPhotoRef("asdasd");
        return userService.updateUser(user);
    }

}
