package com.example.freebieticket.Admin.Admin.AdminFragments.AddEventFragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.view.View;
import android.widget.Toast;

import com.example.freebieticket.R;


public class AddEventAdminFragment2 extends AppCompatActivity {
    CardView event_add_BackBtn;
    CardView AddEventBtn;
    String EventID;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_event_admin2);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            EventID = extras.getString("EventID");
            //The key argument here must match that used in the other activity
        }else {
            Toast.makeText(this,"extras is null", Toast.LENGTH_SHORT).show();
        }
        InisializationOfFealds();
        EventAddInformations();
    }
    private void InisializationOfFealds(){
        AddEventBtn = findViewById(R.id.AddEventBtn);
        event_add_BackBtn = findViewById(R.id.event_add_BackBtn);
    }
    private void EventAddInformations(){

        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.AddEventFragment2,new PreOrgFragment()).commit();

        AddEventBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(AddEventAdminFragment2.this,AddEventAdminActivity.class);
                startActivity(i);
                finish();
            }
        });
        event_add_BackBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
    }

    public String getMyData() {
        return EventID;
    }
}