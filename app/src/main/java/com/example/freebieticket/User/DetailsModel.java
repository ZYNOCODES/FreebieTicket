package com.example.freebieticket.User;

import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

public class DetailsModel {
    private int ImgOfEvent;
    private String EventTitle,DayOfEvent
            ,PlaningOfEvent,LocationOfEvent
            ,LocationOfEvent2,TypeOfEvent
            ,PriceOfEvent,OrganizerOfEvent
            ,DetailsOfEvent;

    public DetailsModel(int imgOfEvent, String eventTitle, String dayOfEvent, String planingOfEvent, String locationOfEvent, String locationOfEvent2, String typeOfEvent, String priceOfEvent, String organizerOfEvent, String detailsOfEvent) {
        ImgOfEvent = imgOfEvent;
        EventTitle = eventTitle;
        DayOfEvent = dayOfEvent;
        PlaningOfEvent = planingOfEvent;
        LocationOfEvent = locationOfEvent;
        LocationOfEvent2 = locationOfEvent2;
        TypeOfEvent = typeOfEvent;
        PriceOfEvent = priceOfEvent;
        OrganizerOfEvent = organizerOfEvent;
        DetailsOfEvent = detailsOfEvent;
    }

    public int getImgOfEvent() {
        return ImgOfEvent;
    }

    public String getEventTitle() {
        return EventTitle;
    }

    public String getDayOfEvent() {
        return DayOfEvent;
    }

    public String getPlaningOfEvent() {
        return PlaningOfEvent;
    }

    public String getLocationOfEvent() {
        return LocationOfEvent;
    }

    public String getLocationOfEvent2() {
        return LocationOfEvent2;
    }

    public String getTypeOfEvent() {
        return TypeOfEvent;
    }

    public String getPriceOfEvent() {
        return PriceOfEvent;
    }

    public String getOrganizerOfEvent() {
        return OrganizerOfEvent;
    }

    public String getDetailsOfEvent() {
        return DetailsOfEvent;
    }
}
