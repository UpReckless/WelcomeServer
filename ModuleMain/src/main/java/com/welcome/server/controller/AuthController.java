package com.welcome.server.controller;

import com.welcome.server.entity.Raiting;
import com.welcome.server.entity.User;
import com.welcome.server.service.UserService;
import org.apache.http.impl.entity.StrictContentLengthStrategy;
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

    @RequestMapping(value = "/reg", method = RequestMethod.POST)
    @ResponseBody
    public User registration(@RequestBody User user) {
        return userService.regNewUser(user);
    }

    @RequestMapping(value = "/auth", method = RequestMethod.POST)
    @ResponseBody
    public String auth(@RequestBody String imei) {
        return userService.authUser(imei);
    }

    @RequestMapping(value = "/delete",method = RequestMethod.POST)
    @ResponseBody
    public void delete(@RequestBody User user){userService.deleteUser(user);}

}
