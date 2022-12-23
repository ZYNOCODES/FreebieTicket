package com.example.freebieticket.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.freebieticket.DetailsActivity;
import com.example.freebieticket.Model.Event;
import com.example.freebieticket.User.ForYouModel;
import com.example.freebieticket.ViewHolder.ForYouViewHolder;
import com.example.freebieticket.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class ForYouAdapter extends RecyclerView.Adapter<ForYouViewHolder> {
    ArrayList<Event> Events; //list of data
    Context context;

    public ForYouAdapter(ArrayList<Event> events, Context context) {
        Events = events;
        this.context = context;
    }

    @NonNull
    @Override
    public ForYouViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.foryoucards,parent,false);
        return new ForYouViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ForYouViewHolder holder, int position) {
        holder.BroadcastDate.setText(Events.get(position).getDayOfEvent());
        holder.EventTitle.setText(Events.get(position).getTitle());
        holder.MusicTitle.setText(Events.get(position).getTypeOfEvent());
        holder.MusicTicket.setText(Events.get(position).getPrice());
        Picasso.get().load(Events.get(position).getImage()).into(holder.PrincipaleImg);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(context, DetailsActivity.class);
                i.putExtra("EventID",Events.get(position).getEventID());
                context.startActivity(i);
            }
        });

    }

    @Override
    public int getItemCount() {
        return Events.size();
    }
}
