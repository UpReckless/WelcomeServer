package com.welcome.server.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;

/**
 * Created by royal on 10/3/16.
 */
@Entity
@Table(name = "archive_photo")
public class ArchivePhoto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "photo_ref",nullable = false)
    private String photoRef;

    @ManyToOne
    @JoinColumn(name = "user_id",referencedColumnName = "id",nullable = false)
    @JsonManagedReference
    private User user;

    public ArchivePhoto(){}

    public ArchivePhoto(String photoRef, User user) {
        this.photoRef = photoRef;
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPhotoRef() {
        return photoRef;
    }

    public void setPhotoRef(String photoRef) {
        this.photoRef = photoRef;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
