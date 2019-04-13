package com.example.fernando.testandoroboeletric

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        textview.setOnClickListener(firstClick())
    }

    fun firstClick(): View.OnClickListener {
        return View.OnClickListener {
            textview.text = "OK"
            textview.setOnClickListener(secondClick())
        }
    }

    fun secondClick(): View.OnClickListener {
        return View.OnClickListener {
            textview.text = "${textview.text} GOOGLE"
            textview.setOnClickListener(firstClick())
        }
    }
}
