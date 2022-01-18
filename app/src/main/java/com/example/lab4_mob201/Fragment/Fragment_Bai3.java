package com.example.lab4_mob201.Fragment;

import android.os.Build;
import android.os.Bundle;

import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.lab4_mob201.CheckConnect.CheckConnect;
import com.example.lab4_mob201.CheckConnect.NetWorkAvailable;
import com.example.lab4_mob201.R;

public class Fragment_Bai3 extends Fragment {
    private TextView tvCheck;
    private CheckConnect checkConnect;

    public Fragment_Bai3() {
        // Required empty public constructor
    }


    public static Fragment_Bai3 newInstance(String param1, String param2) {
        Fragment_Bai3 fragment = new Fragment_Bai3();

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment__bai3, container, false);
        this.initViewByID(view);
        this.initCheckNetwork();
        return view;
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    private void initCheckNetwork() {
        this.checkConnect = new CheckConnect(getActivity().getApplicationContext());
        this.checkConnect.requestConnect();
        if (NetWorkAvailable.isNetWorkAvailable) {
            this.tvCheck.setText("Đã kết nối mạng");
        } else {
            this.tvCheck.setText("Kết nối mạng thất bại");
        }
    }

    private void initViewByID(View view) {
        this.tvCheck = view.findViewById(R.id.tv_check);
    }
}