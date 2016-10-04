package com.welcome.server.entity;


import javax.persistence.*;
import java.util.List;

/**
 * Created by royal on 10/3/16.
 */
@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "nickname",length = 20, nullable = false)
    private String nickname;

    @Column(name = "email")
    private String email;

    @Column(name = "photo_ref")
    private String photoRef;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "raiting_id",referencedColumnName = "id")
    private Raiting raiting;

    @OneToMany(fetch = FetchType.LAZY,mappedBy = "id")
    private List<ArchivePhoto> archivePhotos;

    public User(){}

    public long getId() {
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
