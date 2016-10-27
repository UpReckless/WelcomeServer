package com.welcome.server.entity;


import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.List;

/**
 * Created by royal on 10/3/16.
 */
@Entity
@Table(name = "user")
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY, getterVisibility = JsonAutoDetect.Visibility.NONE, setterVisibility = JsonAutoDetect.Visibility.NONE)
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "nickname",length = 20, nullable = false, unique = true)
    private String nickname;

    @Column(name = "email")
    private String email;

    @Column(name = "photo_ref")
    private String photoRef;

    @Column(name = "imei",nullable = false)
    private String imei;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL,orphanRemoval = true)
    @JoinColumn(name = "raiting_id",referencedColumnName = "id",unique = true,nullable = false)
    private Raiting raiting;

    @OneToMany(fetch = FetchType.LAZY,mappedBy = "id")
    @JsonBackReference
    private List<ArchivePhoto> archivePhotos;

    public User(){}

    public Long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhotoRef() {
        return photoRef;
    }

    public void setPhotoRef(String photoRef) {
        this.photoRef = photoRef;
    }

    public String getImei() {
        return imei;
    }

    public void setImei(String imei) {
        this.imei = imei;
    }

    public Raiting getRaiting() {
        return raiting;
    }

    public void setRaiting(Raiting raiting) {
        this.raiting = raiting;
    }

    public List<ArchivePhoto> getArchivePhotos() {
        return archivePhotos;
    }

    public void setArchivePhotos(List<ArchivePhoto> archivePhotos) {
        this.archivePhotos = archivePhotos;
    }
}
