package com.example.lab4_mob201.CheckConnect;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkRequest;
import android.os.Build;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;

public class CheckConnect {
    private Context context;

    public CheckConnect(Context context) {
        this.context = context;
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public void requestConnect() {
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);

            connectivityManager.registerDefaultNetworkCallback(new ConnectivityManager.NetworkCallback() {
                @Override
                public void onAvailable(@NonNull Network network) {
                    NetWorkAvailable.isNetWorkAvailable = true;
                }

                @Override
                public void onLost(@NonNull Network network) {
                    NetWorkAvailable.isNetWorkAvailable = false;
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
            NetWorkAvailable.isNetWorkAvailable = false;
        }
    }
}
