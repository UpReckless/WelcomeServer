package com.welcome.server.controller;

import com.welcome.server.entity.User;
import com.welcome.server.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by ivanf on 12.10.2016.
 */
@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    UserService userService;

    @RequestMapping(value = "/reg/{user}",method = RequestMethod.POST)
    @ResponseBody
    public String registration(@PathVariable User user){
        return userService.regNewUser(user);
    }
}
