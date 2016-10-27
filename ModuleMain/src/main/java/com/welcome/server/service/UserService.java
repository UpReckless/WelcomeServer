package com.welcome.server.service;

import com.welcome.server.entity.User;

/**
 * Created by ivanf on 12.10.2016.
 */
public interface UserService {

    User regNewUser(User user);
    String authUser(String imei);
    User updateUser(User user);
    void deleteUser(User user);
}
