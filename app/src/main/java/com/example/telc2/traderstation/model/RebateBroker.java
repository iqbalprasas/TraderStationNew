package com.example.telc2.traderstation.model;

/**
 * Created by iqbal on 12/15/2017.
 */

public class RebateBroker {
    int id;
    String name, type, rebate, join;

    public RebateBroker(int id, String name, String type, String rebate, String join) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.rebate = rebate;
        this.join = join;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public String getRebate() {
        return rebate;
    }

    public String getJoin() {
        return join;
    }
}
