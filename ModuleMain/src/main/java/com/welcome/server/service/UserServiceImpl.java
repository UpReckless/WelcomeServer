package com.welcome.server.service;

import com.google.firebase.auth.FirebaseAuth;
import com.google.gson.annotations.Since;
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
            return repository.save(user);
        }
        throw new IllegalArgumentException("Nickname is empty or already exists");
    }


    @Override
    @Transactional
    public String authUser(User user) throws IllegalArgumentException{
        if (checkCredentials(user.getImei(),user.getId())){
            String uid = String.valueOf(user.getId());
            return FirebaseAuth.getInstance().createCustomToken(uid);
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

    private boolean checkCredentials(String imei, Long id) {
        if (imei!=null && id!=null){
            return repository.checkCredentials(imei,id);
        }
        return false;
    }


    private boolean checkUserName(String name) {
        return repository.checkUserName(name);
    }

}
