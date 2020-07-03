package com.group24.demo.entity;

import javax.persistence.*;

@Entity

public class Follower {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int followerId;
    //粉丝的账号
    private String followerAccount;
    @ManyToOne(cascade = CascadeType.ALL,optional = false,fetch = FetchType.LAZY)
    private User followerUser;

    public User getFollowerUser() {
        return followerUser;
    }

    public String getFollowerAccount() {
        return followerAccount;
    }

    public void setFollowerUser(User followerUser) {
        this.followerUser = followerUser;
    }

    public void setFollowerAccount(String followerAccount) {
        this.followerAccount = followerAccount;
    }
}
