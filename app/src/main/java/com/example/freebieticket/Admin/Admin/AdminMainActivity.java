package com.example.freebieticket.Admin.Admin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.freebieticket.Admin.Admin.AdminFragments.AddEventFragment.AddEventAdminActivity;
import com.example.freebieticket.Admin.Admin.AdminFragments.AddEventFragment.AddEventAdminFragment;
import com.example.freebieticket.Admin.Admin.AdminFragments.AddEventFragment.AddPerformersFragment;
import com.example.freebieticket.Admin.Admin.AdminFragments.HomeFragment.AdminHomeFragment;
import com.example.freebieticket.R;
import com.example.freebieticket.fragments.TicketFragment;
import com.example.freebieticket.fragments.UserFragment;

public class AdminMainActivity extends AppCompatActivity {
    ImageView Ic_Home,Ic_Search,Ic_Ticket,Ic_User;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_main);
        InisializationOfFealds();
        IconsOnClickListener();

    }
    private void InisializationOfFealds(){
        Ic_Home = findViewById(R.id.ic_Home);
        Ic_Search = findViewById(R.id.ic_Search);
        Ic_Ticket = findViewById(R.id.ic_Ticket);
        Ic_User = findViewById(R.id.ic_User);
    }
    private  void IconsOnClickListener(){
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.AdminFragmentContainer,new AdminHomeFragment()).commit();
        Ic_Home.setColorFilter(getColor(R.color.darkred), PorterDuff.Mode.SRC_IN);

        Ic_Home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.AdminFragmentContainer,new AdminHomeFragment())
                        .commit();
                Ic_Home.setColorFilter(getColor(R.color.darkred), PorterDuff.Mode.SRC_IN);
                Ic_Search.setColorFilter(getColor(R.color.white), PorterDuff.Mode.SRC_IN);
                Ic_Ticket.setColorFilter(getColor(R.color.white),PorterDuff.Mode.SRC_IN);
                Ic_User.setColorFilter(getColor(R.color.white), PorterDuff.Mode.SRC_IN);
            }
        });
        Ic_Search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.AdminFragmentContainer,new AddEventAdminFragment())
                        .commit();
                Ic_Search.setColorFilter(getColor(R.color.darkred),PorterDuff.Mode.SRC_IN);
                Ic_Home.setColorFilter(getColor(R.color.white), PorterDuff.Mode.SRC_IN);
                Ic_Ticket.setColorFilter(getColor(R.color.white),PorterDuff.Mode.SRC_IN);
                Ic_User.setColorFilter(getColor(R.color.white), PorterDuff.Mode.SRC_IN);
            }
        });
        Ic_Ticket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.AdminFragmentContainer,new TicketFragment())
                        .commit();
                Ic_Ticket.setColorFilter(getColor(R.color.darkred),PorterDuff.Mode.SRC_IN);
                Ic_User.setColorFilter(getColor(R.color.white), PorterDuff.Mode.SRC_IN);
                Ic_Search.setColorFilter(getColor(R.color.white),PorterDuff.Mode.SRC_IN);
                Ic_Home.setColorFilter(getColor(R.color.white), PorterDuff.Mode.SRC_IN);
            }
        });
        Ic_User.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.AdminFragmentContainer,new UserFragment())
                        .commit();
                Ic_User.setColorFilter(getColor(R.color.darkred), PorterDuff.Mode.SRC_IN);
                Ic_Ticket.setColorFilter(getColor(R.color.white),PorterDuff.Mode.SRC_IN);
                Ic_Search.setColorFilter(getColor(R.color.white),PorterDuff.Mode.SRC_IN);
                Ic_Home.setColorFilter(getColor(R.color.white), PorterDuff.Mode.SRC_IN);
            }
        });
    }
}