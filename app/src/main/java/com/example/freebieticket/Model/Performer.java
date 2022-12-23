package com.example.freebieticket.Model;

public class Performer {
    private String Name;
    private String TypeOfEvent;
    private String PerformerImg;
    private String PerformerID;

    public Performer(String name, String typeOfEvent, String performerImg, String performerID) {
        Name = name;
        TypeOfEvent = typeOfEvent;
        PerformerImg = performerImg;
        PerformerID = performerID;
    }

    public Performer() {
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getTypeOfEvent() {
        return TypeOfEvent;
    }

    public void setTypeOfEvent(String typeOfEvent) {
        TypeOfEvent = typeOfEvent;
    }

    public String getPerformerImg() {
        return PerformerImg;
    }

    public void setPerformerImg(String performerImg) {
        PerformerImg = performerImg;
    }

    public String getPerformerID() {
        return PerformerID;
    }

    public void setPerformerID(String performerID) {
        PerformerID = performerID;
    }
}
