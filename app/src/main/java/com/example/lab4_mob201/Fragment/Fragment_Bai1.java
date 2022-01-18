package com.example.lab4_mob201.Fragment;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.lab4_mob201.R;


public class Fragment_Bai1 extends Fragment implements LocationListener {
    private TextView tvLong, tvLat;
    private LocationManager locationManager;

    public Fragment_Bai1() {
        // Required empty public constructor
    }


    public static Fragment_Bai1 newInstance(String param1, String param2) {
        Fragment_Bai1 fragment = new Fragment_Bai1();


        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment__bai1, container, false);
        this.initViewByID(view);
        this.initServiceLocation();
        return view;
    }

    private void initServiceLocation() {
        this.locationManager = (LocationManager) getActivity().getSystemService(Context.LOCATION_SERVICE);
        this.requestPermission();
    }

    private void requestPermission() {
        if (ContextCompat.checkSelfPermission(getActivity(), Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED &&
                ContextCompat.checkSelfPermission(getActivity(), Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            return;
        } else {
            this.locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 100, 1, (LocationListener) this);
        }
    }

    private void initViewByID(View view) {
        this.tvLong = view.findViewById(R.id.tv_longTiTu);
        this.tvLat = view.findViewById(R.id.tv_latTiTu);
    }

    @Override
    public void onLocationChanged(@NonNull Location location) {
        double longTitu = location.getLongitude();
        double latTitu = location.getLatitude();
        this.tvLong.setText("Tạo độ long: " + String.valueOf(longTitu));
        this.tvLat.setText("Tạo độ lat: " + String.valueOf(latTitu));
    }
}