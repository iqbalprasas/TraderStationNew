package com.example.telc2.traderstation.model;

/**
 * Created by iqbal on 11/14/2017.
 */

public class Timeline {
    private String idTimeline, profilePhoto, profileName, postPhoto, time, desc1, desc, status, numLike, numDislike, numComment, numShare;

    public Timeline(String idTimeline, String profilePhoto, String profileName, String postPhoto, String time, String desc1, String desc, String status, String numLike, String numDislike, String numComment, String numShare) {
        this.idTimeline = idTimeline;
        this.profilePhoto = profilePhoto;
        this.profileName = profileName;
        this.postPhoto = postPhoto;
        this.time = time;
        this.desc = desc;
        this.desc1 = desc1;
        this.status = status;
        this.numLike = numLike;
        this.numDislike = numDislike;
        this.numComment = numComment;
        this.numShare = numShare;
    }

    public Timeline(String profileName, String status, String time) {
        this.profileName = profileName;
        this.status = status;
        this.time = time;
    }

    public String getDesc1() {
        return desc1;
    }

    public String getStatus() {
        return status;
    }

    public String getIdTimeline() {
        return idTimeline;
    }

    public String getProfilePhoto() {
        return profilePhoto;
    }

    public String getProfileName() {
        return profileName;
    }

    public String getPostPhoto() {
        return postPhoto;
    }

    public String getTime() {
        return time;
    }

    public String getDesc() {
        return desc;
    }

    public String getNumLike() {
        return numLike;
    }

    public String getNumDislike() {
        return numDislike;
    }

    public String getNumComment() {
        return numComment;
    }

    public String getNumShare() {
        return numShare;
    }
}
