package com.akibbagwan.networkapplication;


import android.os.Bundle;
import android.util.Log;

public class MainActivity extends BaseActivity {

    /*
     * Check the log for the proper results
     * */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void networkAvailable() {
        Log.e("NETWORK_STATE", "Connected");
    }

    @Override
    public void networkUnavailable() {
        Log.e("NETWORK_STATE", "Not Connected");
    }
}
