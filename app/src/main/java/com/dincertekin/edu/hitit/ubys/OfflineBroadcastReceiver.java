package com.dincertekin.edu.hitit.ubys;

import static com.dincertekin.edu.hitit.ubys.MainActivity.checkConnection;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class OfflineBroadcastReceiver extends BroadcastReceiver
{
    public OfflineBroadcastReceiver() {}

    @Override
    public void onReceive(Context context, Intent intent)
    {
        // No connection
        if (!checkConnection(context))
        {
            // Activity with dialog
            Intent offline = new Intent(context, OfflineActivity.class);
            context.startActivity(offline);
        }
        // Connected
        else
        {
            Intent online = new Intent(context, OnlineActivity.class);
            context.startActivity(online);
        }
    }
}
