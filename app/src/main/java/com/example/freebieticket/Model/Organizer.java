package com.example.freebieticket.Model;

public class Organizer {
    private String Name;
    private String TypeOfEvents;
    private String PerformerImg;
    private String PerformerID;

    public Organizer(String name, String typeOfEvents, String performerImg, String performerID) {
        Name = name;
        TypeOfEvents = typeOfEvents;
        PerformerImg = performerImg;
        PerformerID = performerID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getTypeOfEvents() {
        return TypeOfEvents;
    }

    public void setTypeOfEvents(String typeOfEvents) {
        TypeOfEvents = typeOfEvents;
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
