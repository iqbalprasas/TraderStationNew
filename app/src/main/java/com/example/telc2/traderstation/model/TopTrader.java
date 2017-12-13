package com.example.telc2.traderstation.model;

/**
 * Created by iqbal on 12/12/2017.
 */

public class TopTrader {
    int id,rate;
    String imgProfile, username, country, live, gain, profit, balance, equity, open, close;

    public TopTrader(int id, String imgProfile, String username, int rate, String country, String live, String gain, String profit, String balance, String equity, String open, String close) {
        this.id = id;
        this.imgProfile = imgProfile;
        this.username = username;
        this.rate = rate;
        this.country = country;
        this.live = live;
        this.gain = gain;
        this.profit = profit;
        this.balance = balance;
        this.equity = equity;
        this.open = open;
        this.close = close;
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

    public String getCountry() {
        return country;
    }

    public String getLive() {
        return live;
    }

    public String getGain() {
        return gain;
    }

    public String getProfit() {
        return profit;
    }

    public String getBalance() {
        return balance;
    }

    public String getEquity() {
        return equity;
    }

    public String getOpen() {
        return open;
    }

    public String getClose() {
        return close;
    }
}
