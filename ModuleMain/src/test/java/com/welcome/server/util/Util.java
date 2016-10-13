package com.welcome.server.util;

import com.welcome.server.entity.Raiting;
import com.welcome.server.entity.User;

/**
 * Created by ivanf on 13.10.2016.
 */
public class Util {

    public static User createUser(){
        User user =new User();
        user.setNickname("SuperVasya");
        user.setEmail("vasya@gmail.com");
        user.setImei("SuperNokiaPhone");
        user.setRaiting(new Raiting(user, 0L, 0L,0,0));
        return user;
    }
}
