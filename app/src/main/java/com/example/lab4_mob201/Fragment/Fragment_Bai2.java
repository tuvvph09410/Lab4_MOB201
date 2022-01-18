package com.example.lab4_mob201.Fragment;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.lab4_mob201.R;


public class Fragment_Bai2 extends Fragment {
    private TextView tvCheckConnect;
    private ConnectivityManager connectivityManager;
    private NetworkInfo myWifi, myLTE;

    public Fragment_Bai2() {
        // Required empty public constructor
    }

    public static Fragment_Bai2 newInstance(String param1, String param2) {
        Fragment_Bai2 fragment = new Fragment_Bai2();

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment__bai2, container, false);
        this.initViewByID(view);
        this.initConnectivity();
        return view;
    }

    private void initConnectivity() {
        this.connectivityManager = (ConnectivityManager) getActivity().getSystemService(Context.CONNECTIVITY_SERVICE);
        this.CheckConnect();
    }

    private void CheckConnect() {
        this.myLTE = this.connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE);
        this.myWifi = this.connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI);
        if (myWifi.isConnected() == true) {
            this.tvCheckConnect.setText("Đang dùng wifi");
        } else if (myLTE.isConnected() == true) {
            this.tvCheckConnect.setText("Đang dùng mạng LTE");
        } else {
            this.tvCheckConnect.setText("Chưa kết nối mạng");
        }
    }

    private void initViewByID(View view) {
        this.tvCheckConnect = view.findViewById(R.id.tv_CheckConnect);
    }
}