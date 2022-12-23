package com.example.freebieticket.Admin.Admin.AdminFragments.HomeFragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.freebieticket.Admin.Admin.Adapter.CollectionAdminAdapter;
import com.example.freebieticket.Admin.Admin.Adapter.ForYouAdminAdapter;
import com.example.freebieticket.Model.Event;
import com.example.freebieticket.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class AdminHomeFragment extends Fragment {
    ImageView principaleImg;
    RecyclerView AdminFYevent,AdminColevent;
    DatabaseReference AdminRef;
    View view;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_admin_home, container, false);
        InisializationOfFealds();

        LinearLayoutManager managerFY = new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false);
        AdminFYevent.setLayoutManager(managerFY);
        LinearLayoutManager managerCol = new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false);
        AdminColevent.setLayoutManager(managerCol);
        fetchDataFromDB();



        return view;
    }
    private void InisializationOfFealds(){
        AdminFYevent = view.findViewById(R.id.AdminFYevent);
        AdminColevent= view.findViewById(R.id.AdminColevent);
        principaleImg = view.findViewById(R.id.principaleImg);
        AdminRef = FirebaseDatabase.getInstance(getContext().getString(R.string.DBURL))
                .getReference().child("Events");
    }
    private void fetchDataFromDB(){
        ArrayList<Event> Events = new ArrayList<>();
        AdminRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                Events.clear();
                for (DataSnapshot oneSnapshot : snapshot.getChildren()){
                    Event FYevent = oneSnapshot.getValue(Event.class);
                    Events.add(FYevent);
                }
                ForYouAdminAdapter adapterFY = new ForYouAdminAdapter(Events,getActivity());
                AdminFYevent.setAdapter(adapterFY);
                CollectionAdminAdapter adaptercol = new CollectionAdminAdapter(Events,getActivity());
                AdminColevent.setAdapter(adaptercol);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}