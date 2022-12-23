package com.example.freebieticket.Admin.Admin.ViewHolder;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.freebieticket.R;

public class DiscoverAdminViewHolder extends RecyclerView.ViewHolder {
    ImageView IconCardDiscover;
    TextView TitleCardDiscover;
    public DiscoverAdminViewHolder(@NonNull View itemView) {
        super(itemView);
        InisializationOfFealds();
    }
    private void InisializationOfFealds(){
        IconCardDiscover = itemView.findViewById(R.id.iconCardDiscover);
        TitleCardDiscover = itemView.findViewById(R.id.titleCardDiscover);

    }
}
