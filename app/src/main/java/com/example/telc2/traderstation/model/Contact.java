package com.example.telc2.traderstation.model;

/**
 * Created by iqbal on 11/15/2017.
 */

public class Contact {
    private String idContact, contactName, contactPhoto, contactStatus;

    public Contact(String idContact, String contactName, String contactPhoto, String contactStatus) {
        this.idContact = idContact;
        this.contactName = contactName;
        this.contactPhoto = contactPhoto;
        this.contactStatus = contactStatus;
    }

    public String getIdContact() {
        return idContact;
    }

    public String getContactName() {
        return contactName;
    }

    public String getContactPhoto() {
        return contactPhoto;
    }

    public String getContactStatus() {
        return contactStatus;
    }
}
