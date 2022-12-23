package com.example.freebieticket.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.freebieticket.R;
import com.example.freebieticket.User.DetailsModel;
import com.example.freebieticket.User.DiscoverModel;
import com.example.freebieticket.ViewHolder.DetailsViewHolder;
import com.example.freebieticket.ViewHolder.DiscoverViewHolder;

import java.util.ArrayList;

public class DetailsAdapter extends RecyclerView.Adapter<DetailsViewHolder> {
    ArrayList<DetailsModel> Details;
    Context context;

    public DetailsAdapter(ArrayList<DetailsModel> details, Context context) {
        Details = details;
        this.context = context;
    }

    @NonNull
    @Override
    public DetailsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.fragment_details,parent,false);
        return new DetailsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DetailsViewHolder holder, int position) {
        holder.ImgOfEvent.setImageResource(Details.get(position).getImgOfEvent());
        holder.EventTitle.setText(Details.get(position).getEventTitle());
        holder.DayOfEvent.setText(Details.get(position).getDayOfEvent());
        holder.PlaningOfEvent.setText(Details.get(position).getPlaningOfEvent());
        holder.LocationOfEvent.setText(Details.get(position).getLocationOfEvent());
        holder.LocationOfEvent2.setText(Details.get(position).getLocationOfEvent2());
        holder.TypeOfEvent.setText(Details.get(position).getTypeOfEvent());
        holder.PriceOfEvent.setText(Details.get(position).getPriceOfEvent());
        holder.OrganizerOfEvent.setText(Details.get(position).getOrganizerOfEvent());
        holder.DetailsOfEvent.setText(Details.get(position).getDetailsOfEvent());

    }

    @Override
    public int getItemCount() {
        return Details.size();
    }
}
