package com.akibbagwan.networkapplication;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/**
 * Created by Bagwan Akib on 5/18/2020. for com.akibbagwan.networkapplication
 */
public class NetworkBroadcastReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        ConnectivityManager manager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        /* previous way of doing it*/
        NetworkInfo ni = null;
        if (manager != null) {
            ni = manager.getActiveNetworkInfo();
        }
        App.isConnected = ni != null && ni.isConnected();
    }
}
