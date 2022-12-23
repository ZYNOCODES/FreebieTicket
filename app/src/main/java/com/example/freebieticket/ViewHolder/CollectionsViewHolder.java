package com.example.freebieticket.ViewHolder;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.freebieticket.R;

public class CollectionsViewHolder extends RecyclerView.ViewHolder {
    public ImageView PrincipaleImgC;
    public TextView EventTitleC,MusicTitleC;
    public CollectionsViewHolder(@NonNull View itemView) {

        super(itemView);
        InisializationOfFealds();
    }
    private void InisializationOfFealds(){
        PrincipaleImgC = itemView.findViewById(R.id.PrincipaleImgC);
        EventTitleC = itemView.findViewById(R.id.EventTitleC);
        MusicTitleC = itemView.findViewById(R.id.MusicTitleC);
    }
}
