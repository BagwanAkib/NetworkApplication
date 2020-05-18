package com.akibbagwan.networkapplication;

import android.app.Application;
import android.content.IntentFilter;

/**
 * Created by Bagwan Akib on 5/18/2020. for com.akibbagwan.networkapplication
 */
public class App extends Application {

    /*
    * Single object that can help to manage is network is connected or not
    * */
    public static boolean isConnected;

    private NetworkBroadcastReceiver networkStateReceiver = new NetworkBroadcastReceiver();

    @Override
    public void onCreate() {
        super.onCreate();
        registerReceiver(networkStateReceiver, new IntentFilter(android.net.ConnectivityManager.CONNECTIVITY_ACTION));
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
        unregisterReceiver(networkStateReceiver);
    }
}
