package com.example.telc2.traderstation.model;

/**
 * Created by iqbal on 12/14/2017.
 */

public class TraderPerformance {
    int id, rate;
    String imgProfile, username, retrn, drawdown, follower, balance, copier, reverser, info;

    public TraderPerformance(int id, String imgProfile, String username, int rate, String retrn, String drawdown, String follower, String balance, String copier, String reverser, String info) {
        this.id = id;
        this.imgProfile = imgProfile;
        this.username = username;
        this.rate = rate;
        this.retrn = retrn;
        this.drawdown = drawdown;
        this.follower = follower;
        this.balance = balance;
        this.copier = copier;
        this.reverser = reverser;
        this.info = info;
    }

    public TraderPerformance(int id, String username, int rate) {
        this.id = id;
        this.username = username;
        this.rate = rate;
    }

    public int getId() {
        return id;
    }

    public String getImgProfile() {
        return imgProfile;
    }

    public String getUsername() {
        return username;
    }

    public int getRate() {
        return rate;
    }

    public String getRetrn() {
        return retrn;
    }

    public String getDrawdown() {
        return drawdown;
    }

    public String getFollower() {
        return follower;
    }

    public String getBalance() {
        return balance;
    }

    public String getCopier() {
        return copier;
    }

    public String getReverser() {
        return reverser;
    }

    public String getInfo() {
        return info;
    }
}
