package com.example.freebieticket.Admin.Admin.Adapter;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.freebieticket.Admin.Admin.AdminFragments.AddEventFragment.AddEventAdminActivity;
import com.example.freebieticket.Admin.Admin.AdminFragments.AddEventFragment.AddEventAdminFragment2;
import com.example.freebieticket.Model.Performer;
import com.example.freebieticket.R;
import com.example.freebieticket.User.DiscoverModel;
import com.example.freebieticket.User.PreOrgModel;
import com.example.freebieticket.ViewHolder.DiscoverViewHolder;
import com.example.freebieticket.ViewHolder.PreOrgViewHolder;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.concurrent.RecursiveAction;

public class PerformerAdapter extends RecyclerView.Adapter<PreOrgViewHolder> {
    ArrayList<Performer> Performers;
    Context context;
    DatabaseReference PerformersRef;
    String EventID;

    public PerformerAdapter(ArrayList<Performer> performers, Context context, String eventID) {
        Performers = performers;
        this.context = context;
        EventID = eventID;
    }

    @NonNull
    @Override
    public PreOrgViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.preorgadmincard,parent,false);
        return new PreOrgViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PreOrgViewHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.Name.setText(Performers.get(position).getName());
        holder.TypeOfEvent.setText(Performers.get(position).getTypeOfEvent());
        Picasso.get().load(Performers.get(position).getPerformerImg()).into(holder.PreOrgImg);
        PerformersRef = FirebaseDatabase.getInstance(context.getString(R.string.DBURL))
                .getReference()
                .child("Events")
                .child(EventID)
                .child("Performers");
        holder.Delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // delete the product from the database
                AlertDialog.Builder mydialog = new AlertDialog.Builder(context);
                mydialog.setTitle("Delete "+Performers.get(position).getName());
                mydialog.setMessage("Do you really want to delete "
                        +Performers.get(position).getName()+" ?");
                mydialog.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        // deleting the product
                        PerformersRef.child(Performers.get(position).getPerformerID()).removeValue()
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
        return Performers.size();
    }
}
