package com.example.fernando.testandoroboeletric

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    val TEXT_STATE = "text_state"
    val ONCLICK_STATE = "onclick_state"

    lateinit var text: String
    var typeOnclick = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if(savedInstanceState != null) {
            typeOnclick = savedInstanceState.getInt(ONCLICK_STATE)
            text = savedInstanceState.getString(TEXT_STATE)
            if(typeOnclick == 0)
                textview.setOnClickListener(firstClick())
            else
                textview.setOnClickListener(secondClick())
        } else {
            textview.setOnClickListener(firstClick())
        }



    }

    fun firstClick(): View.OnClickListener {
        text = "OK"
        return View.OnClickListener {
            textview.text = text
            textview.setOnClickListener(secondClick())
            typeOnclick = 1
        }
    }

    fun secondClick(): View.OnClickListener {
        text = "${textview.text} GOOGLE"
        return View.OnClickListener {
            textview.text = text
            textview.setOnClickListener(firstClick())
            typeOnclick = 0
        }
    }

    override fun onSaveInstanceState(outState: Bundle?) {
        outState!!.putString(TEXT_STATE, text)
        outState!!.putInt(ONCLICK_STATE, typeOnclick)
        super.onSaveInstanceState(outState)
    }

}
