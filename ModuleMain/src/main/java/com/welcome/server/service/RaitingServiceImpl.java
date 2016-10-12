package com.welcome.server.service;

import com.welcome.server.entity.Raiting;
import com.welcome.server.entity.User;
import com.welcome.server.repository.RaitingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by ivanf on 12.10.2016.
 */
@Service
public class RaitingServiceImpl implements RaitingService {

    @Autowired
    private RaitingRepository repository;

    @Override
    public void regNewUser(User user) {
        if (user!=null) {
            Raiting raiting = new Raiting(user, 0L, 0L, 0, 0);
            repository.save(raiting);
        }else throw new IllegalArgumentException("User can't be null");

    }
}
