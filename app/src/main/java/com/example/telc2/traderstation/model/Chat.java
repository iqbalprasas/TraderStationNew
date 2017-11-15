package com.example.telc2.traderstation.model;

/**
 * Created by iqbal on 11/15/2017.
 */

public class Chat {
    private String id, profilePhoto, profileName, chat, numChat;

    public Chat(String id, String profilePhoto, String profileName, String chat, String numChat) {
        this.id = id;
        this.profilePhoto = profilePhoto;
        this.profileName = profileName;
        this.chat = chat;
        this.numChat = numChat;
    }

    public String getId() {
        return id;
    }

    public String getProfilePhoto() {
        return profilePhoto;
    }

    public String getProfileName() {
        return profileName;
    }

    public String getChat() {
        return chat;
    }

    public String getNumChat() {
        return numChat;
    }
}
