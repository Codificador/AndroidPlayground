package com.example.fernando.testandocorrotinasdokotlin

import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.*

class MainActivity : AppCompatActivity() {

    private val job = Job()
    private val TAG = "CORROTINAS"
    private val uiScope = CoroutineScope(Dispatchers.Main + job)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        load()
    }

    suspend fun async1(): String {
        Log.d(TAG, "async 1")
        delay(1000 * 2)

        return "A1"
    }

    suspend fun async2(): String {
        Log.d(TAG, "async 2")
        delay(10)
        return "A2"
    }

    fun load() {
        uiScope.launch {
            val s1 = async1()
            val s2 = async2()
            button.text = "$s1 $s2"
            delay(100)
        }
    }
}