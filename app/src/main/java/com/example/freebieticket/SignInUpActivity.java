package com.example.freebieticket;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.freebieticket.fragments.HomeFragment;
import com.example.freebieticket.fragments.LogInFragment;

public class SignInUpActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in_up);
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.LogInOutfragment_container,new LogInFragment()).commit();
    }
}