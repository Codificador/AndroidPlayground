package com.example.fernando.testandoroboeletric

import android.content.pm.ActivityInfo
import kotlinx.android.synthetic.main.activity_main.*
import org.junit.Test

import org.junit.Assert.*
import org.junit.runner.RunWith
import org.robolectric.Robolectric
import org.robolectric.RobolectricTestRunner
import android.os.Bundle
import org.robolectric.android.controller.ActivityController


@RunWith(RobolectricTestRunner::class)
class ExampleUnitTest {

    @Test
    fun clickEmTextView() {
        val act = Robolectric.setupActivity(MainActivity::class.java)
        act.textview.callOnClick()
        assertEquals("OK", act.textview.text)
    }

    @Test
    fun doisClicksEmTextView() {
        val act = Robolectric.setupActivity(MainActivity::class.java)
        act.textview.callOnClick()
        act.textview.callOnClick()
        assertEquals("OK GOOGLE", act.textview.text)
    }

    @Test
    fun tresClicksEmTextView() {
        val act = Robolectric.setupActivity(MainActivity::class.java)
        act.textview.callOnClick()
        act.textview.callOnClick()
        act.textview.callOnClick()

        assertEquals("OK", act.textview.text)
    }

    @Test
    fun rotacionaTela() {
        val act = Robolectric.setupActivity(MainActivity::class.java)
        act.textview.callOnClick()
        assertEquals("OK", act.textview.text)
        act.textview.callOnClick()
        act.recreate()
        assertEquals("OK GOOGLE", act.textview.text)
    }

}
