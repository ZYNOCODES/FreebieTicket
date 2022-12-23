package com.example.freebieticket.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.freebieticket.User.DiscoverModel;
import com.example.freebieticket.ViewHolder.DiscoverViewHolder;
import com.example.freebieticket.R;

import java.util.ArrayList;

public class DiscoverAdapter extends RecyclerView.Adapter<DiscoverViewHolder> {
    ArrayList<DiscoverModel>Discovers;
    Context context;

    public DiscoverAdapter(ArrayList<DiscoverModel> discovers, Context context) {
        Discovers = discovers;
        this.context = context;
    }

    @NonNull
    @Override
    public DiscoverViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.discovercards,parent,false);
        return new DiscoverViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DiscoverViewHolder holder, int position) {
        holder.IconCardDiscover.setImageResource(Discovers.get(position).getIconCardDiscover());
        holder.TitleCardDiscover.setText(Discovers.get(position).getTitleCardDiscover());

    }

    @Override
    public int getItemCount() {
        return Discovers.size();
    }
}
