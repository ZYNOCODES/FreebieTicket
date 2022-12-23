package com.example.freebieticket.Model;

public class Event {
     String Title;
     String DayOfEvent;
     String PlaningOfEvent;
     String Location;
     String TypeOfEvent;
     String Price;
     String Details;
     String Image;
     String EventID;

    public Event(String title, String dayOfEvent, String planingOfEvent, String location, String typeOfEvent, String price, String details, String image, String eventID) {
        Title = title;
        DayOfEvent = dayOfEvent;
        PlaningOfEvent = planingOfEvent;
        Location = location;
        TypeOfEvent = typeOfEvent;
        Price = price;
        Details = details;
        Image = image;
        EventID = eventID;
    }

    public Event() {
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getDayOfEvent() {
        return DayOfEvent;
    }

    public void setDayOfEvent(String dayOfEvent) {
        DayOfEvent = dayOfEvent;
    }

    public String getPlaningOfEvent() {
        return PlaningOfEvent;
    }

    public void setPlaningOfEvent(String planingOfEvent) {
        PlaningOfEvent = planingOfEvent;
    }

    public String getLocation() {
        return Location;
    }

    public void setLocation(String location) {
        Location = location;
    }

    public String getTypeOfEvent() {
        return TypeOfEvent;
    }

    public void setTypeOfEvent(String typeOfEvent) {
        TypeOfEvent = typeOfEvent;
    }

    public String getPrice() {
        return Price;
    }

    public void setPrice(String price) {
        Price = price;
    }

    public String getDetails() {
        return Details;
    }

    public void setDetails(String details) {
        Details = details;
    }

    public String getImage() {
        return Image;
    }

    public void setImage(String image) {
        Image = image;
    }

    public String getEventID() {
        return EventID;
    }

    public void setEventID(String eventID) {
        EventID = eventID;
    }
}

