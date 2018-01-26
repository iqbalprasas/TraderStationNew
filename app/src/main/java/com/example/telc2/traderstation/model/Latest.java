package com.example.telc2.traderstation.model;

/**
 * Created by iqbal on 1/24/2018.
 */

public class Latest {
    String id, name, imgProfile, time, imgPost, title, desc;

    public Latest(String id, String name, String imgProfile, String time, String imgPost, String title, String desc) {
        this.id = id;
        this.name = name;
        this.imgProfile = imgProfile;
        this.time = time;
        this.imgPost = imgPost;
        this.title = title;
        this.desc = desc;
    }

    public Latest(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getImgProfile() {
        return imgProfile;
    }

    public String getTime() {
        return time;
    }

    public String getImgPost() {
        return imgPost;
    }

    public String getTitle() {
        return title;
    }

    public String getDesc() {
        return desc;
    }
}
