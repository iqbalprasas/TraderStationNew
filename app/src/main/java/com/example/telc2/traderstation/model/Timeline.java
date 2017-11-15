package com.example.telc2.traderstation.model;

/**
 * Created by iqbal on 11/14/2017.
 */

public class Timeline {
    private String idTimeline, profilePhoto, profileName, postPhoto, time, desc, numLike, numDislike, numComment, numShare;

    public Timeline(String idTimeline, String profilePhoto, String profileName, String postPhoto, String time, String desc, String numLike, String numDislike, String numComment, String numShare) {
        this.idTimeline = idTimeline;
        this.profilePhoto = profilePhoto;
        this.profileName = profileName;
        this.postPhoto = postPhoto;
        this.time = time;
        this.desc = desc;
        this.numLike = numLike;
        this.numDislike = numDislike;
        this.numComment = numComment;
        this.numShare = numShare;
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
