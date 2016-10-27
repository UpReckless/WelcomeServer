package com.welcome.server.service;

import com.google.firebase.auth.FirebaseAuth;
import com.google.gson.annotations.Since;
import com.welcome.server.entity.Raiting;
import com.welcome.server.entity.User;
import com.welcome.server.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by ivanf on 12.10.2016.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository repository;


    @Override
    @Transactional
    public User regNewUser(User user) throws IllegalArgumentException{
        if (!user.getNickname().isEmpty() && !checkUserName(user.getNickname())) {
            user.setRaiting(new Raiting(user, 0L, 0L,0,0));
            return repository.save(user);
        }
        throw new IllegalArgumentException("Nickname is empty or already exists");
    }


    @Override
    @Transactional
    public String authUser(String imei) throws IllegalArgumentException{
        if (checkCredentials(imei)){
            return FirebaseAuth.getInstance().createCustomToken(imei);
        }
        throw new IllegalArgumentException("Imei or id are invalid");
    }

    @Override
    @Transactional
    public User updateUser(User user) {
        if (!user.getNickname().isEmpty() && user.getId()!=null){
            User updatableUser=repository.findOne(user.getId());
            if (updatableUser!=null) {
                updatableUser.setEmail(user.getEmail());
                updatableUser.setNickname(user.getNickname());
                updatableUser.setPhotoRef(user.getPhotoRef());
                repository.saveAndFlush(updatableUser);
                return updatableUser;
            }else throw new IllegalArgumentException("This user doesn't exists");
        }else throw new IllegalArgumentException("nickname or id is empty");
    }

    @Override
    @Transactional
    public void deleteUser(User user) {
        if (repository.exists(user.getId())) {
            repository.delete(user);
        }else throw new IllegalArgumentException("This user doesn't exists");
    }


    private boolean checkCredentials(String imei) {
        if (imei!=null){
            return repository.checkCredentials(imei);
        }
        return false;
    }


    private boolean checkUserName(String name) {
        return repository.checkUserName(name);
    }

}
