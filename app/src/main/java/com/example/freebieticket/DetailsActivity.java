package com.example.freebieticket;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.freebieticket.Model.Event;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

public class DetailsActivity extends AppCompatActivity {
    ImageView Back_to_home,ImgOfEvent;
    TextView BuyTicket,EventTitle,DayOfEvent,PlaningOfEvent,LocationOfEvent,LocationOfEvent2,TypeOfEvent,PriceOfEvent,OrganizerOfEvent,DetailsOfEvent;
    RecyclerView event_add_RecycleOrganizers,event_add_RecyclePerformers;
    FirebaseAuth mauth;
    String EventID;
    DatabaseReference EventRef,CartRef;
    Event event;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        EventID = getIntent().getStringExtra("EventID");
        InisializationOfFealds();
        GetEventDetails();
        Back_to_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
        BuyTicket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AddEventTicketToCart();
            }
        });
    }
    private void InisializationOfFealds(){
        Back_to_home = findViewById(R.id.back_to_home);
        ImgOfEvent = findViewById(R.id.ImgOfEvent);
        EventTitle = findViewById(R.id.EventTitle);
        BuyTicket = findViewById(R.id.BuyTicket);
        DayOfEvent = findViewById(R.id.DayOfEvent);
        PlaningOfEvent = findViewById(R.id.PlaningOfEvent);
        LocationOfEvent = findViewById(R.id.LocationOfEvent);
        LocationOfEvent2 = findViewById(R.id.LocationOfEvent2);
        TypeOfEvent = findViewById(R.id.TypeOfEvent);
        PriceOfEvent = findViewById(R.id.PriceOfEvent);
        OrganizerOfEvent = findViewById(R.id.OrganizerOfEvent);
        DetailsOfEvent = findViewById(R.id.DetailsOfEvent);
        event_add_RecycleOrganizers = findViewById(R.id.event_add_RecycleOrganizers);
        event_add_RecyclePerformers = findViewById(R.id.event_add_RecyclePerformers);
        mauth = FirebaseAuth.getInstance();
        EventRef = FirebaseDatabase.getInstance(getString(R.string.DBURL))
                .getReference()
                .child("Events")
                .child(EventID);
        CartRef = FirebaseDatabase.getInstance(getString(R.string.DBURL))
                .getReference()
                .child("Users")
                .child(mauth.getCurrentUser().getUid())
                .child("Cart");
    }
    private void GetEventDetails(){
        EventRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                event = snapshot.getValue(Event.class);
                if(event!=null){
                    Picasso.get().load(event.getImage())
                            .into(ImgOfEvent);
                    EventTitle.setText(event.getTitle());
                    DayOfEvent.setText(event.getDayOfEvent());
                    PlaningOfEvent.setText(event.getPlaningOfEvent());
                    PriceOfEvent.setText(String.valueOf(event.getPrice()));
                    LocationOfEvent.setText(event.getLocation());
                    LocationOfEvent2.setText(event.getLocation());
                    TypeOfEvent.setText(event.getTypeOfEvent());
                    DetailsOfEvent.setText(event.getDetails());

                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
    private void AddEventTicketToCart(){
        if(event!=null){
            CartRef.child(EventID).setValue(event).addOnCompleteListener(new OnCompleteListener<Void>() {
                @Override
                public void onComplete(@NonNull Task<Void> task) {
                    if(task.isSuccessful()){
                        Toast.makeText(DetailsActivity.this, "Ticket added to your cart !", Toast.LENGTH_SHORT).show();
                    }else{
                        Toast.makeText(DetailsActivity.this, task.getException().getMessage(), Toast.LENGTH_SHORT).show();

                    }
                }
            });
        }
    }
}