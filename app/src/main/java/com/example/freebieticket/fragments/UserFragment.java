package com.example.freebieticket.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import com.example.freebieticket.Adapter.ForYouAdapter;
import com.example.freebieticket.Model.Event;
import com.example.freebieticket.Model.User;
import com.example.freebieticket.R;
import com.example.freebieticket.SignInUpActivity;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class UserFragment extends Fragment {
    CardView LogOutBtn;
    View view;
    FirebaseAuth Mauth;
    DatabaseReference UserRef;
    TextView Fullname,Email;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_user, container, false);
        InisializationOfFealds();
        GetUserDetails();
        LogOutBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getActivity(), SignInUpActivity.class);
                getActivity().startActivity(i);
                getActivity().finish();
            }
        });
        return view;
    }
    private void InisializationOfFealds(){
        LogOutBtn = view.findViewById(R.id.LogOutBtn);
        Fullname = view.findViewById(R.id.Fullname);
        Email = view.findViewById(R.id.Email);
        Mauth = FirebaseAuth.getInstance();
        UserRef = FirebaseDatabase.getInstance(getActivity().getString(R.string.DBURL))
                .getReference()
                .child(Mauth.getCurrentUser().getUid());

    }
    private void GetUserDetails(){
        UserRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                User user = snapshot.getValue(User.class);
                if(user!=null){
                    Fullname.setText(user.getName() + user.getSecondName());
                    Email.setText(user.getEmail());
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}