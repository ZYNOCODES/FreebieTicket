package com.example.freebieticket;

import android.graphics.PorterDuff;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.freebieticket.fragments.HomeFragment;
import com.example.freebieticket.fragments.SearchFragment;
import com.example.freebieticket.fragments.TicketFragment;
import com.example.freebieticket.fragments.UserFragment;

public class MainActivity extends AppCompatActivity {
    ImageView Ic_Home,Ic_Search,Ic_Ticket,Ic_User;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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
                .replace(R.id.fragment_container,new HomeFragment()).commit();
        Ic_Home.setColorFilter(getColor(R.color.red), PorterDuff.Mode.SRC_IN);

        Ic_Home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragment_container,new HomeFragment())
                        .commit();
                Ic_Home.setColorFilter(getColor(R.color.red), PorterDuff.Mode.SRC_IN);
                Ic_Search.setColorFilter(getColor(R.color.gray), PorterDuff.Mode.SRC_IN);
                Ic_Ticket.setColorFilter(getColor(R.color.gray),PorterDuff.Mode.SRC_IN);
                Ic_User.setColorFilter(getColor(R.color.gray), PorterDuff.Mode.SRC_IN);
            }
        });
        Ic_Search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragment_container,new SearchFragment())
                        .commit();
                Ic_Search.setColorFilter(getColor(R.color.red),PorterDuff.Mode.SRC_IN);
                Ic_Home.setColorFilter(getColor(R.color.gray), PorterDuff.Mode.SRC_IN);
                Ic_Ticket.setColorFilter(getColor(R.color.gray),PorterDuff.Mode.SRC_IN);
                Ic_User.setColorFilter(getColor(R.color.gray), PorterDuff.Mode.SRC_IN);
            }
        });
        Ic_Ticket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragment_container,new TicketFragment())
                        .commit();
                Ic_Ticket.setColorFilter(getColor(R.color.red),PorterDuff.Mode.SRC_IN);
                Ic_User.setColorFilter(getColor(R.color.gray), PorterDuff.Mode.SRC_IN);
                Ic_Search.setColorFilter(getColor(R.color.gray),PorterDuff.Mode.SRC_IN);
                Ic_Home.setColorFilter(getColor(R.color.gray), PorterDuff.Mode.SRC_IN);
            }
        });
        Ic_User.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragment_container,new UserFragment())
                        .commit();
                Ic_User.setColorFilter(getColor(R.color.red), PorterDuff.Mode.SRC_IN);
                Ic_Ticket.setColorFilter(getColor(R.color.gray),PorterDuff.Mode.SRC_IN);
                Ic_Search.setColorFilter(getColor(R.color.gray),PorterDuff.Mode.SRC_IN);
                Ic_Home.setColorFilter(getColor(R.color.gray), PorterDuff.Mode.SRC_IN);
            }
        });
    }
}