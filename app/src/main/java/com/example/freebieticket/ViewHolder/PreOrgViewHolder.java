package com.example.freebieticket.ViewHolder;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.freebieticket.R;

public class PreOrgViewHolder extends RecyclerView.ViewHolder {
    public ImageView PreOrgImg;
    public CardView Delete;
    public TextView Name,TypeOfEvent;
    public PreOrgViewHolder(@NonNull View itemView) {
        super(itemView);
        InisializationOfFealds();
    }
    private void InisializationOfFealds(){
        PreOrgImg = itemView.findViewById(R.id.PreOrgImg);
        Name = itemView.findViewById(R.id.PerformerName);
        TypeOfEvent = itemView.findViewById(R.id.TypeOfEvent);
        Delete = itemView.findViewById(R.id.DeletePreOrg);

    }
}
