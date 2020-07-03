package com.group24.demo.entity;

import javax.persistence.*;

@Entity

public class Subscriber {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int subscriberId;
    //关注者的账号
    private String subscriberAccount;
    @ManyToOne(cascade = CascadeType.ALL,optional = false,fetch = FetchType.LAZY)
    private User subscriberUser;

    public User getSubscriberUser() {
        return subscriberUser;
    }

    public String getSubscriberAccount() {
        return subscriberAccount;
    }

    public void setSubscriberUser(User subscriberUser) {
        this.subscriberUser = subscriberUser;
    }

    public void setSubscriberAccount(String subscriberAccount) {
        this.subscriberAccount = subscriberAccount;
    }
}
