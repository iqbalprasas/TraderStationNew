package com.example.telc2.traderstation.model;

/**
 * Created by iqbal on competition11/webinar7/2017.
 */

public class Yesterday {
    private String time, name, act, cons, prev, nation, currency;
    private int id,rate;

    public Yesterday(int id, String time, String name, int rate, String act, String cons, String prev, String nation, String currency) {
        this.id = id;
        this.time = time;
        this.name = name;
        this.rate = rate;
        this.act = act;
        this.cons = cons;
        this.prev = prev;
        this.nation = nation;
        this.currency = currency;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

    public String getAct() {
        return act;
    }

    public void setAct(String act) {
        this.act = act;
    }

    public String getCons() {
        return cons;
    }

    public void setCons(String cons) {
        this.cons = cons;
    }

    public String getPrev() {
        return prev;
    }

    public void setPrev(String prev) {
        this.prev = prev;
    }

    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }
}
