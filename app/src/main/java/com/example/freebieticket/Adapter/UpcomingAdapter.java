package com.example.freebieticket.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.freebieticket.User.UpcomingModel;
import com.example.freebieticket.ViewHolder.UpcomingViewHolder;
import com.example.freebieticket.R;

import java.util.ArrayList;

public class UpcomingAdapter extends RecyclerView.Adapter<UpcomingViewHolder> {
    ArrayList<UpcomingModel>Upcomings;
    Context context;

    public UpcomingAdapter(ArrayList<UpcomingModel> upcomings, Context context) {
        Upcomings = upcomings;
        this.context = context;
    }

    @NonNull
    @Override
    public UpcomingViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.upcomingcards,parent,false);
        return new UpcomingViewHolder(view);    }

    @Override
    public void onBindViewHolder(@NonNull UpcomingViewHolder holder, int position) {
        holder.upcomingimg.setImageResource(Upcomings.get(position).getUpcomingimg());
        holder.upcomingmoreeventimg.setImageResource(Upcomings.get(position).getUpcomingmoreeventimg());
        holder.upcomingsubtitle.setText(Upcomings.get(position).getUpcomingsubtitle());
        holder.upcomingtitle.setText(Upcomings.get(position).getUpcomingtitle());
        holder.day.setText(Upcomings.get(position).getDay());
        holder.month.setText(Upcomings.get(position).getMonth());
        holder.numberofday.setText(Upcomings.get(position).getNumberofday());
    }

    @Override
    public int getItemCount() {
        return Upcomings.size();
    }
}
