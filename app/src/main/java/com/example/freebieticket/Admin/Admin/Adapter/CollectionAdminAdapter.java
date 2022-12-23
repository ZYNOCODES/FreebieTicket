package com.example.freebieticket.Admin.Admin.Adapter;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.freebieticket.Admin.Admin.ViewHolder.ForYouAdmineViewHolder;
import com.example.freebieticket.Model.Event;
import com.example.freebieticket.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class CollectionAdminAdapter extends RecyclerView.Adapter<ForYouAdmineViewHolder> {
    ArrayList<Event> Events;
    Context context;
    DatabaseReference EventsRef;
    public CollectionAdminAdapter(ArrayList<Event> events, Context context) {
        Events = events;
        this.context = context;
    }

    @NonNull
    @Override
    public ForYouAdmineViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.collectionsadmincards,parent,false);
        return new ForYouAdmineViewHolder(view);    }

    @Override
    public void onBindViewHolder(@NonNull ForYouAdmineViewHolder holder, int position) {
        Picasso.get().load(Events.get(position).getImage()).into(holder.PrincipaleImg);
        holder.EventTitle.setText(Events.get(position).getTitle());
        holder.MusicTitle.setText(Events.get(position).getTypeOfEvent());
        EventsRef = FirebaseDatabase.getInstance(context.getString(R.string.DBURL))
                .getReference()
                .child("Events");
        holder.Delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // delete the product from the database
                AlertDialog.Builder mydialog = new AlertDialog.Builder(context);
                mydialog.setTitle("Delete "+Events.get(position).getTitle());
                mydialog.setMessage("Do you really want to delete "
                        +Events.get(position).getTitle()+" ?");
                mydialog.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        // deleting the product
                        EventsRef.child(Events.get(position).getEventID()).removeValue()
                                .addOnCompleteListener(new OnCompleteListener<Void>() {
                                    @Override
                                    public void onComplete(@NonNull Task<Void> task) {
                                        if(task.isSuccessful()){
                                            Toast.makeText(context, "Product deleted", Toast.LENGTH_SHORT).show();
                                        }else{
                                            Toast.makeText(context, "Error , check your internet connexion", Toast.LENGTH_SHORT).show();

                                        }
                                    }
                                });
                    }
                });
                mydialog.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                });
                mydialog.show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return  Events.size();
    }
}
