package com.welcome.server.entity;

import javax.persistence.*;

/**
 * Created by royal on 10/3/16.
 */
@Entity
@Table(name = "raiting")
public class Raiting {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id",referencedColumnName = "id")
    private User user;

    @Column(name = "like_count")
    private Long likeCount;

    @Column(name = "willcome_count")
    private Long willcomeCount;

    @Column(name = "post_count")
    private Integer postCount;

    @Column(name = "vippost_count")
    private Integer vippostCount;

    public Raiting(){}

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Long getLikeCount() {
        return likeCount;
    }

    public void setLikeCount(Long likeCount) {
        this.likeCount = likeCount;
    }

    public Long getWillcomeCount() {
        return willcomeCount;
    }

    public void setWillcomeCount(Long willcomeCount) {
        this.willcomeCount = willcomeCount;
    }

    public Integer getPostCount() {
        return postCount;
    }

    public void setPostCount(Integer postCount) {
        this.postCount = postCount;
    }

    public Integer getVippostCount() {
        return vippostCount;
    }

    public void setVippostCount(Integer vippostCount) {
        this.vippostCount = vippostCount;
    }
}
