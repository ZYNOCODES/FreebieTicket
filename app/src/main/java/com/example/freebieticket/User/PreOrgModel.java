package com.example.freebieticket.User;

public class PreOrgModel {
    private int PreOrgImg;
    private String Name;
    private  String TypeOfEvent;

    public PreOrgModel(int preOrgImg, String name, String typeOfEvent) {
        PreOrgImg = preOrgImg;
        Name = name;
        TypeOfEvent = typeOfEvent;
    }

    public PreOrgModel() {
    }

    public int getPreOrgImg() {
        return PreOrgImg;
    }

    public String getName() {
        return Name;
    }

    public String getTypeOfEvent() {
        return TypeOfEvent;
    }
}
