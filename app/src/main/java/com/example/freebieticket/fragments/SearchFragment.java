package com.example.freebieticket.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.example.freebieticket.R;


public class SearchFragment extends Fragment implements OnMapReadyCallback {
    View view;
    private GoogleMap googleMap;


    public static SearchFragment newInstance() {
        SearchFragment fragment = new SearchFragment();
        return fragment;
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_search, null, false);

        SupportMapFragment mapFragment = ((SupportMapFragment) this.getChildFragmentManager().findFragmentById(R.id.maps));
        mapFragment.getMapAsync(this);

        return view;
    }

    @Override
    public void onMapReady(final GoogleMap gmap) {
        this.googleMap = gmap;

        // Set default position
        // Add a marker in Sydney and move the camera
        LatLng Algeria = new LatLng(28.0339, 1.6596); // 28.0339° N, 1.6596° E
        this.googleMap.addMarker(new MarkerOptions().position(Algeria).title("Marker in Algeria"));
        this.googleMap.moveCamera(CameraUpdateFactory.newLatLng(Algeria));

        this.googleMap.setOnMapClickListener(new GoogleMap.OnMapClickListener() {
            @Override
            public void onMapClick(LatLng latLng) {
                MarkerOptions markerOptions = new MarkerOptions();
                markerOptions.position(latLng);
                markerOptions.title(latLng.latitude + " : "+ latLng.longitude);
                // Clear previously click position.
                googleMap.clear();
                // Zoom the Marker
                googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(latLng, 10));
                // Add Marker on Map
                googleMap.addMarker(markerOptions);
            }
        });
    }
}