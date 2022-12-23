package com.example.freebieticket.ViewHolder;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.freebieticket.R;

public class DiscoverViewHolder extends RecyclerView.ViewHolder {
    public ImageView IconCardDiscover;
    public TextView TitleCardDiscover;
    public DiscoverViewHolder(@NonNull View itemView) {
        super(itemView);
        InisializationOfFealds();
    }
    private void InisializationOfFealds(){
        IconCardDiscover = itemView.findViewById(R.id.iconCardDiscover);
        TitleCardDiscover = itemView.findViewById(R.id.titleCardDiscover);

    }
}
