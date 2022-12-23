package com.example.freebieticket.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.freebieticket.User.CollectionsModel;
import com.example.freebieticket.ViewHolder.CollectionsViewHolder;
import com.example.freebieticket.R;

import java.util.ArrayList;

public class CollectionsAdapter extends RecyclerView.Adapter<CollectionsViewHolder> {
    ArrayList<CollectionsModel> Colevents; //list of data
    Context context;

    public CollectionsAdapter(ArrayList<CollectionsModel> colevents, Context context) {
        Colevents = colevents;
        this.context = context;
    }

    @NonNull
    @Override
    public CollectionsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.collectionscards,parent,false);
        return new CollectionsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CollectionsViewHolder holder, int position) {
        holder.PrincipaleImgC.setImageResource(Colevents.get(position).getPrincipaleImgC());
        holder.EventTitleC.setText(Colevents.get(position).getEventTitleC());
        holder.MusicTitleC.setText(Colevents.get(position).getMusicTitleC());

    }

    @Override
    public int getItemCount() {
        return Colevents.size();
    }
}
