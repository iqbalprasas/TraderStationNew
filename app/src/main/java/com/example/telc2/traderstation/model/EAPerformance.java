package com.example.telc2.traderstation.model;

/**
 * Created by iqbal on 12/19/2017.
 */

public class EAPerformance {
    int id, rate;
    String username, by, retrn, drawdown, gain, balance, profit, equity, desc;

    public EAPerformance(int id, int rate, String username, String by, String retrn, String drawdown, String gain, String balance, String profit, String equity, String desc) {
        this.id = id;
        this.rate = rate;
        this.username = username;
        this.by = by;
        this.retrn = retrn;
        this.drawdown = drawdown;
        this.gain = gain;
        this.balance = balance;
        this.profit = profit;
        this.equity = equity;
        this.desc = desc;
    }

    public EAPerformance(int id, String username) {
        this.id = id;
        this.username = username;
    }

    public int getId() {
        return id;
    }

    public int getRate() {
        return rate;
    }

    public String getUsername() {
        return username;
    }

    public String getBy() {
        return by;
    }

    public String getRetrn() {
        return retrn;
    }

    public String getDrawdown() {
        return drawdown;
    }

    public String getGain() {
        return gain;
    }

    public String getBalance() {
        return balance;
    }

    public String getProfit() {
        return profit;
    }

    public String getEquity() {
        return equity;
    }

    public String getDesc() {
        return desc;
    }
}
