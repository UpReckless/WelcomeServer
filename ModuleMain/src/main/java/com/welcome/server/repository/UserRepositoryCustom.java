package com.welcome.server.repository;

import com.welcome.server.entity.User;

/**
 * Created by ivanf on 12.10.2016.
 */
public interface UserRepositoryCustom {

    boolean checkUserName(String name);
    boolean checkCredentials(String imei, long id);
}
