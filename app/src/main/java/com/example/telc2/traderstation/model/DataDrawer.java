package com.example.telc2.traderstation.model;

/**
 * Created by iqbal on 11/webinar7/2017.
 */

public class DataDrawer {
    public int icon;
    public String name;

    public DataDrawer(int icon, String name) {
        this.icon = icon;
        this.name = name;
    }

    public DataDrawer(String name){
        this.name = name;
        this.icon = 0;
    }
}
