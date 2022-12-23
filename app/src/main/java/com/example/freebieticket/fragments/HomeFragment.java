package com.example.freebieticket.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.freebieticket.Adapter.CollectionsAdapter;
import com.example.freebieticket.Adapter.DiscoverAdapter;
import com.example.freebieticket.Adapter.ForYouAdapter;
import com.example.freebieticket.Adapter.UpcomingAdapter;
import com.example.freebieticket.Model.Event;
import com.example.freebieticket.User.CollectionsModel;
import com.example.freebieticket.User.DiscoverModel;
import com.example.freebieticket.User.UpcomingModel;
import com.example.freebieticket.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;


public class HomeFragment extends Fragment {
    View view;
    RecyclerView FYevent,Colevent,Discover,Upcoming;
    DatabaseReference AdminRef;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_home, container, false);
        InisializationOfFealds();

        LinearLayoutManager manager = new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false);
        FYevent.setLayoutManager(manager);
        fetchDataFromDB();

        CollectionsContent();

        DiscoverContent();

        UpcomingContent();


        return view;
    }
    private void InisializationOfFealds(){
        FYevent = view.findViewById(R.id.FYevent);
        Colevent = view.findViewById(R.id.Colevent);
        Discover = view.findViewById(R.id.Discover);
        Upcoming = view.findViewById(R.id.Upcoming);
        AdminRef = FirebaseDatabase.getInstance(getContext().getString(R.string.DBURL)).getReference().child("Events");

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
                ForYouAdapter adapter = new ForYouAdapter(Events,getContext());
                FYevent.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
    private void CollectionsContent(){

        ArrayList<CollectionsModel> Colevents = new ArrayList<>();
        Colevents.add(new CollectionsModel(R.drawable.img1,"Brightlight Music Festival","Electronica"));
        Colevents.add(new CollectionsModel(R.drawable.img8,"Brightlight Music Festival","Electronica"));
        Colevents.add(new CollectionsModel(R.drawable.img2,"Brightlight Music Festival","Electronica"));
        Colevents.add(new CollectionsModel(R.drawable.img4,"Brightlight Music Festival","Electronica"));
        Colevents.add(new CollectionsModel(R.drawable.img9,"Brightlight Music Festival","Electronica"));
        Colevents.add(new CollectionsModel(R.drawable.img5,"Brightlight Music Festival","Electronica"));

        CollectionsAdapter adapter = new CollectionsAdapter(Colevents, getContext());
        Colevent.setAdapter(adapter);

        LinearLayoutManager manager = new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false);
        Colevent.setLayoutManager(manager);
    }
    private void DiscoverContent(){

        ArrayList<DiscoverModel> Discovers = new ArrayList<>();
        Discovers.add(new DiscoverModel(R.drawable.ic_misc___maplocation,"YOUR AREA"));
        Discovers.add(new DiscoverModel(R.drawable.ic_tags___music,"MUSIC"));
        Discovers.add(new DiscoverModel(R.drawable.ic_tags___sport,"SPORTS"));

        DiscoverAdapter adapter = new DiscoverAdapter(Discovers, getContext());
        Discover.setAdapter(adapter);

        LinearLayoutManager manager = new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false);
        Discover.setLayoutManager(manager);
    }
    private void UpcomingContent(){

        ArrayList<UpcomingModel> Upcomings = new ArrayList<>();
        Upcomings.add(new UpcomingModel(R.drawable.img4,R.drawable.img1,"12","THU","SEP","Electonica Next Mounth","Electronica"));
        Upcomings.add(new UpcomingModel(R.drawable.img6,R.drawable.img2,"14","WEN","SEP","Electonica Next Mounth","Electronica"));
        Upcomings.add(new UpcomingModel(R.drawable.img7,R.drawable.img3,"19","MON","SEP","Electonica Next Mounth","Electronica"));
        Upcomings.add(new UpcomingModel(R.drawable.img1,R.drawable.img8,"20","SUN","SEP","Electonica Next Mounth","Electronica"));
        Upcomings.add(new UpcomingModel(R.drawable.img3,R.drawable.img9,"21","SUT","SEP","Electonica Next Mounth","Electronica"));
        Upcomings.add(new UpcomingModel(R.drawable.img8,R.drawable.img5,"25","FRI","SEP","Electonica Next Mounth","Electronica"));
        Upcomings.add(new UpcomingModel(R.drawable.img9,R.drawable.img6,"28","THU","SEP","Electonica Next Mounth","Electronica"));
        Upcomings.add(new UpcomingModel(R.drawable.img5,R.drawable.img4,"30","WEN","SEP","Electonica Next Mounth","Electronica"));
        Upcomings.add(new UpcomingModel(R.drawable.img2,R.drawable.img7,"1","SUN","OCT","Electonica Next Mounth","Electronica"));

        UpcomingAdapter adapter = new UpcomingAdapter(Upcomings, getContext());
        Upcoming.setAdapter(adapter);

        LinearLayoutManager manager = new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false);
        Upcoming.setLayoutManager(manager);
    }


}