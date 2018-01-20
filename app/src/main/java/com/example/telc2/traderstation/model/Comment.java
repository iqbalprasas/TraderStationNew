package com.example.telc2.traderstation.model;

/**
 * Created by iqbal on 1/19/2018.
 */

public class Comment {

    String id, name, comment, imgProfile, imgComment, sumLike, sumDislike;

    public Comment(String id, String name, String comment, String imgProfile, String imgComment, String sumLike, String sumDislike) {
        this.id = id;
        this.name = name;
        this.comment = comment;
        this.imgProfile = imgProfile;
        this.imgComment = imgComment;
        this.sumLike = sumLike;
        this.sumDislike = sumDislike;
    }

    public Comment(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getComment() {
        return comment;
    }

    public String getImgProfile() {
        return imgProfile;
    }

    public String getImgComment() {
        return imgComment;
    }

    public String getSumLike() {
        return sumLike;
    }

    public String getSumDislike() {
        return sumDislike;
    }
}
