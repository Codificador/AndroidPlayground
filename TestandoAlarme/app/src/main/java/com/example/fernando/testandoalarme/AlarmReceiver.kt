package com.example.fernando.testandoalarme

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log

class AlarmReceiver : BroadcastReceiver() {

    private val tag = "TESTANDO"

    override fun onReceive(context: Context, intent: Intent) {
        Log.d(tag, "alarme disparado")
    }
}
