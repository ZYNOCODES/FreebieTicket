package com.example.freebieticket.ViewHolder;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.freebieticket.R;

public class ForYouViewHolder extends RecyclerView.ViewHolder {
    public ImageView PrincipaleImg;
    public TextView BroadcastDate,EventTitle,MusicTitle,MusicTicket;
    public ForYouViewHolder(@NonNull View itemView) {
        super(itemView);
        PrincipaleImg = itemView.findViewById(R.id.principaleImg);
        BroadcastDate = itemView.findViewById(R.id.broadcastDate);
        EventTitle = itemView.findViewById(R.id.eventTitle);
        MusicTitle = itemView.findViewById(R.id.musicTitle);
        MusicTicket = itemView.findViewById(R.id.musicTicket);
    }

}
