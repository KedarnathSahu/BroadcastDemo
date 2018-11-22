package com.cumulations.broadcastdemo;

import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    BroadcastReceiver broadcastReceiver,broadcastReceiver1;
    CustomBroadcastReceiver customBroadcastReceiver;
    IntentFilter intentFilter;
    LocalBroadcastManager localBroadcastManager;
    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        broadcastReceiver=new SMSBroadcastReceiver();
        broadcastReceiver1=new SMSBroadcastReceiver();
        customBroadcastReceiver=new CustomBroadcastReceiver();
        localBroadcastManager=localBroadcastManager.getInstance(this);
    }

    @Override
    protected void onStart() {
        super.onStart();

        intentFilter = new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE");
        registerReceiver(broadcastReceiver,intentFilter);

        intentFilter = new IntentFilter("android.net.wifi.WIFI_STATE_CHANGED");
        registerReceiver(broadcastReceiver1,intentFilter);

//        intentFilter = new IntentFilter("com.custom.broadcast.test1");
//        localBroadcastManager.registerReceiver(customBroadcastReceiver,intentFilter);

        intentFilter = new IntentFilter("com.custom.broadcast.test1");
        registerReceiver(customBroadcastReceiver,intentFilter);
    }

    @Override
    protected void onStop() {
        super.onStop();
//        unregisterReceiver(broadcastReceiver);
//        unregisterReceiver(broadcastReceiver1);
//        unregisterReceiver(customBroadcastReceiver);
//        localBroadcastManager.unregisterReceiver(customBroadcastReceiver);
    }

    public void sendBroadcast(View view) {
//        intent = new Intent("com.custom.broadcast.test1");
//        localBroadcastManager.sendBroadcast(intent);

        intent = new Intent("com.custom.broadcast.test1");
        sendBroadcast(intent);

    }
}
