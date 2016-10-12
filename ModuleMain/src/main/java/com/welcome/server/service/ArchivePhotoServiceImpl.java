package com.welcome.server.service;

import com.welcome.server.entity.ArchivePhoto;
import com.welcome.server.entity.User;
import com.welcome.server.repository.ArchivePhotoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by ivanf on 12.10.2016.
 */
@Service
public class ArchivePhotoServiceImpl implements ArchivePhotoService{

    @Autowired
    ArchivePhotoRepository repository;

    @Override
    public void regNewUser(User user) {
        if(user!=null){
            ArchivePhoto archivePhoto=new ArchivePhoto(null,user);
            repository.save(archivePhoto);

        }else throw new IllegalArgumentException("User can't be null");
    }
}
