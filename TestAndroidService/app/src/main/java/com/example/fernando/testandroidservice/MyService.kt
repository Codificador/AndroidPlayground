package com.example.fernando.testandroidservice

import android.app.Service
import android.content.Intent
import android.os.Binder
import android.os.IBinder
import android.util.Log

class MyService : Service(), Counter{

    private val TAG = "TESTANDO"
    private var count = 0


    inner class LocalBinder: Binder() {
        fun getCounter(): Counter {
            return this@MyService
        }
    }

    override fun onBind(intent: Intent?): IBinder? {
        Log.d(TAG, "servico em onBind")
        return LocalBinder()
    }

    override fun onStart(intent: Intent?, startId: Int) {
        super.onStart(intent, startId)
        Log.d(TAG, "servico em onStart")
    }

    override fun onCreate() {
        super.onCreate()
        Log.d(TAG, "service criado")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "service destruido")
    }

    override fun count(): Int {
        return this.count
    }

    override fun append() {
        this.count++
    }
}
