package com.example.freebieticket.Admin.Admin.AdminFragments.HomeFragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.freebieticket.R;


public class AddDiscoverCardFragment extends Fragment {
    View view;
    ImageView AddType;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_add_discover_card, container, false);
        InisializationOfFealds();

        AddType.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        return view;
    }
    private void InisializationOfFealds(){
        AddType = view.findViewById(R.id.AddType);
    }
}