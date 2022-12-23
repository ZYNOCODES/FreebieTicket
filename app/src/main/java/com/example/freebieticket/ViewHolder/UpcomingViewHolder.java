package com.example.freebieticket.ViewHolder;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.freebieticket.R;

public class UpcomingViewHolder extends RecyclerView.ViewHolder {
    public ImageView upcomingmoreeventimg,upcomingimg;
    public TextView numberofday,day,month,upcomingtitle,upcomingsubtitle;
    public UpcomingViewHolder(@NonNull View itemView) {
        super(itemView);
        InisializationOfFealds();

    }
    private void InisializationOfFealds(){
        upcomingmoreeventimg = itemView.findViewById(R.id.upcomingmoreeventimg);
        upcomingimg = itemView.findViewById(R.id.upcomingimg);
        numberofday = itemView.findViewById(R.id.numberofday);
        day = itemView.findViewById(R.id.day);
        month = itemView.findViewById(R.id.month);
        upcomingtitle = itemView.findViewById(R.id.upcomingtitle);
        upcomingsubtitle = itemView.findViewById(R.id.upcomingsubtitle);


    }
}
