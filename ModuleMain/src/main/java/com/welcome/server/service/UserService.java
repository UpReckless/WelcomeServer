package com.welcome.server.service;

import com.google.firebase.internal.NonNull;
import com.welcome.server.entity.User;
import com.welcome.server.helper.*;

import java.security.NoSuchAlgorithmException;
import java.util.List;


public interface UserService {

    RegistryResponse regNewUser(RegistryRequest registryRequest) throws NoSuchAlgorithmException;

    AuthResponse authUser(@NonNull AuthRequest authRequest) throws Exception;

    UpdateUserResponse updateUser(UpdateUserRequest updateUserRequest) throws NoSuchAlgorithmException;

    List<User> getAll();

    boolean checkName(String name);

    User getUserById(long id);
}
