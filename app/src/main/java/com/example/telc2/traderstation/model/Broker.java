package com.example.telc2.traderstation.model;

/**
 * Created by iqbal on 12/15/2017.
 */

public class Broker {
    int id, rate;
    String nama, broker, desc;

    public Broker(int id, int rate, String nama, String broker, String desc) {
        this.id = id;
        this.rate = rate;
        this.nama = nama;
        this.broker = broker;
        this.desc = desc;
    }

    public int getId() {
        return id;
    }

    public int getRate() {
        return rate;
    }

    public String getNama() {
        return nama;
    }

    public String getBroker() {
        return broker;
    }

    public String getDesc() {
        return desc;
    }
}
