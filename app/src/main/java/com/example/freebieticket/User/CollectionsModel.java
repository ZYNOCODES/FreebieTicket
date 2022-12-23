package com.example.freebieticket.User;

public class CollectionsModel {
    private int PrincipaleImgC;
    private  String EventTitleC;
    private String MusicTitleC;

    public CollectionsModel(int principaleImgC, String eventTitleC, String musicTitleC) {
        PrincipaleImgC = principaleImgC;
        EventTitleC = eventTitleC;
        MusicTitleC = musicTitleC;
    }

    public int getPrincipaleImgC() {
        return PrincipaleImgC;
    }

    public String getEventTitleC() {
        return EventTitleC;
    }

    public String getMusicTitleC() {
        return MusicTitleC;
    }
}
