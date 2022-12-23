package com.example.freebieticket.ViewHolder;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.freebieticket.R;

public class DetailsViewHolder extends RecyclerView.ViewHolder {
    public ImageView ImgOfEvent;
    public TextView EventTitle,DayOfEvent,PlaningOfEvent,LocationOfEvent,LocationOfEvent2,TypeOfEvent,PriceOfEvent,OrganizerOfEvent,DetailsOfEvent;
    public RecyclerView event_add_RecycleOrganizers,event_add_RecyclePerformers;
    public DetailsViewHolder(@NonNull View itemView) {
        super(itemView);
        InisializationOfFealds();
    }
    private void InisializationOfFealds(){
        ImgOfEvent = itemView.findViewById(R.id.ImgOfEvent);
        EventTitle = itemView.findViewById(R.id.EventTitle);
        DayOfEvent = itemView.findViewById(R.id.DayOfEvent);
        PlaningOfEvent = itemView.findViewById(R.id.PlaningOfEvent);
        LocationOfEvent = itemView.findViewById(R.id.LocationOfEvent);
        LocationOfEvent2 = itemView.findViewById(R.id.LocationOfEvent2);
        TypeOfEvent = itemView.findViewById(R.id.TypeOfEvent);
        PriceOfEvent = itemView.findViewById(R.id.PriceOfEvent);
        OrganizerOfEvent = itemView.findViewById(R.id.OrganizerOfEvent);
        DetailsOfEvent = itemView.findViewById(R.id.DetailsOfEvent);
        event_add_RecycleOrganizers = itemView.findViewById(R.id.event_add_RecycleOrganizers);
        event_add_RecyclePerformers = itemView.findViewById(R.id.event_add_RecyclePerformers);


    }
}
