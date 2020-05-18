package com.akibbagwan.networkapplication;

import android.content.Context;
import android.net.wifi.WifiManager;

import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.SmallTest;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import androidx.test.rule.ActivityTestRule;


/**
 * Created by Bagwan Akib on 5/18/2020. for com.akibbagwan.networkapplication
 */
@RunWith(AndroidJUnit4.class)
@SmallTest
public class CheckInternetState {
    @Rule
    public ActivityTestRule<MainActivity> activityRule
            = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void testMethod() {
        /*
         * While testing it make sure your internet connection is on active state
         * */
        WifiManager wifi = (WifiManager) activityRule.getActivity().getSystemService(Context.WIFI_SERVICE);
        if (wifi != null) {
            wifi.setWifiEnabled(true);
        }
        boolean result = App.isConnected;
        assert wifi != null;
        assertEquals(wifi.isWifiEnabled(), result);
    }

    /*
     * To test bellow test please off Sim card internet
     * */
    @Test
    public void broadcastOnTest() {
        boolean result = false;
        try {
            WifiManager wifi = (WifiManager) activityRule.getActivity().getSystemService(Context.WIFI_SERVICE);
            if (wifi != null) {
                wifi.setWifiEnabled(true);
            }
            Thread.sleep(17000);
            result = App.isConnected;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        assertTrue(result);
    }

    @Test
    public void broadcastOffTest() {
        boolean result = false;
        try {
            WifiManager wifi = (WifiManager) activityRule.getActivity().getSystemService(Context.WIFI_SERVICE);
            if (wifi != null) {
                wifi.setWifiEnabled(false);
            }
            Thread.sleep(3000);
            result = App.isConnected;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        assertFalse(result);
    }
}
