package com.sematec.basic.receiver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import com.sematec.basic.utils.toast

class OnBootCompletedReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {
        "Your phone has been booted".toast()
    }
}