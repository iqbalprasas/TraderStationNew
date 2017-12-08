package com.example.telc2.traderstation.model;

/**
 * Created by iqbal on 12/8/2017.
 */

public class Webinar {

    private String idWebinar, imgWebinar, title, date, desc;

    public Webinar(String idWebinar, String imgWebinar, String title, String date, String desc) {
        this.idWebinar = idWebinar;
        this.imgWebinar = imgWebinar;
        this.title = title;
        this.date = date;
        this.desc = desc;
    }

    public Webinar(String idWebinar, String title, String date, String desc) {
        this.idWebinar = idWebinar;
        this.title = title;
        this.date = date;
        this.desc = desc;
    }

    public Webinar() {
    }

    public String getIdWebinar() {
        return idWebinar;
    }

    public String getImgWebinar() {
        return imgWebinar;
    }

    public String getTitle() {
        return title;
    }

    public String getDate() {
        return date;
    }

    public String getDesc() {
        return desc;
    }
}
