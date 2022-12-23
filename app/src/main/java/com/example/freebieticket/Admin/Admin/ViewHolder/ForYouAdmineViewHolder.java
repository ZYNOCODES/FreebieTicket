package com.example.freebieticket.Admin.Admin.ViewHolder;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.freebieticket.R;

public class ForYouAdmineViewHolder extends RecyclerView.ViewHolder {

    public ImageView PrincipaleImg,Delete;
    public TextView BroadcastDate,EventTitle,MusicTitle,MusicTicket;

    public ForYouAdmineViewHolder(@NonNull View itemView) {
        super(itemView);
        InisializationOfFealds();
    }
    private void InisializationOfFealds(){
        PrincipaleImg = itemView.findViewById(R.id.principaleImg);
        BroadcastDate = itemView.findViewById(R.id.broadcastDate);
        EventTitle = itemView.findViewById(R.id.eventTitle);
        MusicTitle = itemView.findViewById(R.id.musicTitle);
        MusicTicket = itemView.findViewById(R.id.musicTicket);
        Delete = itemView.findViewById(R.id.Delete);
    }
}
