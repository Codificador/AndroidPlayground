package com.example.fernando.testandoalarme

import android.app.AlarmManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {

    private val initialTime: Long   = 1000 * 2
    private val repTime: Long       = 1000 * 5
    private val intentAction       = "EXECUTAR_ALARME"


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val alarmManager  = getSystemService(Context.ALARM_SERVICE) as AlarmManager
        val intent = Intent(intentAction)
        val pendingIntent = PendingIntent.getBroadcast(this, 0, intent, 0)

        alarmManager.setRepeating(AlarmManager.RTC_WAKEUP, initialTime, repTime, pendingIntent)
    }

}
