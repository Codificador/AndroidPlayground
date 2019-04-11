package com.example.fernando.testandroidservice

import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.ServiceConnection
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.IBinder
import android.util.Log

class MainActivity : AppCompatActivity(), ServiceConnection {

    val TAG = "TESTANDO"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // chamando service
        val serviceConection = this
        bindService(Intent(this, MyService::class.java), serviceConection, Context.BIND_AUTO_CREATE)

    }

    override fun onServiceDisconnected(name: ComponentName?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onServiceConnected(name: ComponentName?, service: IBinder?) {
        val binder = service as MyService.LocalBinder
        val contador = service.getCounter()

        Log.d(TAG, "mainAct ${contador.count()}")
        contador.append()
        Log.d(TAG, "mainAct ${contador.count()}")
    }
}
