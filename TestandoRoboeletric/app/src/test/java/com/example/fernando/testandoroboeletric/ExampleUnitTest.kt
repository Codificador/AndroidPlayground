package com.example.fernando.testandoroboeletric

import kotlinx.android.synthetic.main.activity_main.*
import org.junit.Test

import org.junit.Assert.*
import org.junit.runner.RunWith
import org.robolectric.Robolectric
import org.robolectric.RobolectricTestRunner


@RunWith(RobolectricTestRunner::class)
class ExampleUnitTest {

    @Test
    fun clickEmTextView() {
        val act = Robolectric.setupActivity(MainActivity::class.java)
        act.textview.callOnClick()
        assertEquals(act.textview.text, "OK")
    }

    @Test
    fun doidClicksEmTextView() {
        val act = Robolectric.setupActivity(MainActivity::class.java)
        act.textview.callOnClick()
        act.textview.callOnClick()
        assertEquals(act.textview.text, "OK GOOGLE")
    }

}
