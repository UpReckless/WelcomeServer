package com.welcome.server.repository;

/**
 * Created by ivanf on 12.10.2016.
 */
public interface UserRepositoryCustom {

    boolean checkUserName(String name);
    boolean checkCredentials(String imei);
}
