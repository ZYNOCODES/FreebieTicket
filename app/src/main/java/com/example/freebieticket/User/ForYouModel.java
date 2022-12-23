package com.example.freebieticket.User;

public class ForYouModel {
    private int PrincipaleImg;
    private String BroadcastDate;
    private  String EventTitle;
    private String MusicTitle;
    private String MusicTicket;

    public ForYouModel() {
    }

    public ForYouModel(int principaleImg, String broadcastDate, String eventTitle, String musicTitle, String musicTicket) {
        PrincipaleImg = principaleImg;
        BroadcastDate = broadcastDate;
        EventTitle = eventTitle;
        MusicTitle = musicTitle;
        MusicTicket = musicTicket;
    }


    public int getPrincipaleImg() {
        return PrincipaleImg;
    }

    public String getBroadcastDate() {
        return BroadcastDate;
    }

    public String getEventTitle() {
        return EventTitle;
    }

    public String getMusicTitle() {
        return MusicTitle;
    }

    public String getMusicTicket() {
        return MusicTicket;
    }
}
