package com.example.freebieticket.Admin.Admin.AdminFragments.AddEventFragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.freebieticket.R;

public class AddEventAdminFragment extends Fragment {
    View view;
    CardView AddEventBtn;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_add_event_admin4, container, false);
        InisializationOfFealds();
        AddEventBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getActivity(),AddEventAdminActivity.class);
                getActivity().startActivity(i);
            }
        });

        return view;
    }
    private void InisializationOfFealds() {
        AddEventBtn = view.findViewById(R.id.AddEventBtn);
    }
    }