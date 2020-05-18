package com.akibbagwan.networkapplication;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

/**
 * Created by Bagwan Akib on 5/18/2020. for com.akibbagwan.networkapplication
 */
@SuppressLint("Registered")
public abstract class BaseActivity extends AppCompatActivity implements NetworkChangeListener {

    /*
     *you can create own object for it
     * */
    private BroadcastReceiver networkStateReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            ConnectivityManager manager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
            /* previous way of doing it*/
            NetworkInfo ni = null;
            if (manager != null) {
                ni = manager.getActiveNetworkInfo();
            }
            if (ni != null && ni.isConnected()) {
                networkAvailable();
            } else {
                networkUnavailable();
            }
        }
    };

    /*
     * If you like to check it manually you also cam use the bellow function for it
     * */
    public void checkInternet() {
        ConnectivityManager manager = (ConnectivityManager) this.getSystemService(Context.CONNECTIVITY_SERVICE);
        /* previous way of doing it*/
        NetworkInfo ni = null;
        if (manager != null) {
            ni = manager.getActiveNetworkInfo();
        }
        if (ni != null && ni.isConnected()) {
            networkAvailable();
        } else {
            networkUnavailable();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.e("NETWORK_STATE", "networkStateReceiver registerReceiver");
        registerReceiver(networkStateReceiver, new IntentFilter(android.net.ConnectivityManager.CONNECTIVITY_ACTION));
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.e("NETWORK_STATE", "networkStateReceiver unregisterReceiver");
        unregisterReceiver(networkStateReceiver);
    }
}
