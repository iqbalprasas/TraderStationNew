package com.example.telc2.traderstation.model;

/**
 * Created by iqbal on 12/22/2017.
 */

public class PAMM {
    int id, rate;
    String name, profitability, today;

    public PAMM(int id, int rate, String name, String profitability, String today) {
        this.id = id;
        this.rate = rate;
        this.name = name;
        this.profitability = profitability;
        this.today = today;
    }

    public PAMM(int id, int rate, String name) {
        this.id = id;
        this.rate = rate;
        this.name = name;
    }

    public PAMM(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public int getRate() {
        return rate;
    }

    public String getName() {
        return name;
    }

    public String getProfitability() {
        return profitability;
    }

    public String getToday() {
        return today;
    }
}
