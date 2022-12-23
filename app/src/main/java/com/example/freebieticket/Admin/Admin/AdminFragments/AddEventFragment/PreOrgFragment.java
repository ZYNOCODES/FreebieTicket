package com.example.freebieticket.Admin.Admin.AdminFragments.AddEventFragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.freebieticket.Admin.Admin.Adapter.ForYouAdminAdapter;
import com.example.freebieticket.Admin.Admin.Adapter.PerformerAdapter;
import com.example.freebieticket.Model.Event;
import com.example.freebieticket.Model.Performer;
import com.example.freebieticket.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class PreOrgFragment extends Fragment {
    View view;
    RecyclerView event_add_RecyclePerformersPreOrg,event_add_RecycleOrganizersPreOrg;
    CardView event_add_Performers,event_add_Organizers;
    DatabaseReference PreOrg_ref,Events_ref;
    ImageView PreOrgImg;
    TextView PerformerName,TypeOfEvent;
    String EventID;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view =inflater.inflate(R.layout.fragment_pre_org, container, false);
        Bundle extras = getActivity().getIntent().getExtras();
        if (extras != null) {
            EventID = extras.getString("EventID");
            //The key argument here must match that used in the other activity
        }else {
            Toast.makeText(getActivity(),"extras is null", Toast.LENGTH_SHORT).show();
        }
        InisializationOfFealds();

        EventAddInformations();

        LinearLayoutManager pmanager = new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL,false);
        event_add_RecyclePerformersPreOrg.setLayoutManager(pmanager);
        fetchDataFromDB();

        return view;
    }
    private void InisializationOfFealds(){
        TypeOfEvent = view.findViewById(R.id.TypeOfEvent);
        PerformerName = view.findViewById(R.id.PerformerName);
        PreOrgImg = view.findViewById(R.id.PreOrgImg);

        event_add_Performers = view.findViewById(R.id.event_add_Performers);
        event_add_Organizers = view.findViewById(R.id.event_add_Organizers);
        event_add_RecyclePerformersPreOrg = view.findViewById(R.id.event_add_RecyclePerformersPreOrg);
        event_add_RecycleOrganizersPreOrg = view.findViewById(R.id.event_add_RecycleOrganizersPreOrg);
        PreOrg_ref = FirebaseDatabase.getInstance(getString(R.string.DBURL))
                .getReference().child("Events")
                .child(EventID)
                .child("Performers");
        Events_ref = FirebaseDatabase.getInstance(getString(R.string.DBURL))
                .getReference().child("Events");
    }
    private void EventAddInformations(){

        event_add_Performers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction()
                        .replace(R.id.AddEventFragment2, new AddPerformersFragment());
                fragmentTransaction.commit();
            }
        });
        event_add_Organizers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction()
                        .replace(R.id.AddEventFragment2, new AddOrganizersFragment())
                        .addToBackStack(null);
                fragmentTransaction.commit();
            }
        });


    }
    private void fetchDataFromDB(){
        ArrayList<Performer> Performers = new ArrayList<>();
        PreOrg_ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                Performers.clear();
                for (DataSnapshot oneSnapshot : snapshot.getChildren()){
                    Performer FYevent = oneSnapshot.getValue(Performer.class);
                    Performers.add(FYevent);
                }
                PerformerAdapter adapterFY = new PerformerAdapter(Performers,getActivity(),EventID);
                event_add_RecyclePerformersPreOrg.setAdapter(adapterFY);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

}