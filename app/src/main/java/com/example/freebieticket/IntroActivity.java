package com.example.freebieticket;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.google.firebase.auth.FirebaseAuth;

public class IntroActivity extends AppCompatActivity {
    FirebaseAuth mauth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);
        mauth = FirebaseAuth.getInstance();
        Thread thread = new Thread(){
            @Override
            public void run() {
                super.run();
                try {
                    sleep(800);
                }catch (Exception e){

                }finally {
                    if (mauth.getCurrentUser() != null){
                        Intent i = new Intent(IntroActivity.this,SignInUpActivity.class);
                        startActivity(i);
                        finish();
                    }else {
                        Intent i = new Intent(IntroActivity.this,SignInUpActivity.class);
                        startActivity(i);
                        finish();

                    }

                }
            }
        };
        thread.start();
    }
}