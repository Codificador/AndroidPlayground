package com.myapp.testandozachbublilchoreographer

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import zachinio.choreographer.Choreographer
import zachinio.choreographer.animation.EnterAnimation
import zachinio.choreographer.animation.FadeAnimation
import zachinio.choreographer.animation.ScaleAnimation

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val animation1 = View.OnClickListener {
            Choreographer()
                .addAnimation(EnterAnimation(textView, EnterAnimation.Direction.TOP, 560))
                .addAnimation(FadeAnimation(textView,0.2f,560))
                .addAnimation(FadeAnimation(textView,1f,560))
                .animate()
        }

        val animation2 = View.OnClickListener {
            Choreographer()
                .addAnimation(EnterAnimation(textView, EnterAnimation.Direction.TOP, 560))
                .addAnimation(FadeAnimation(textView,0.2f,560))
                .addAnimationAsync(ScaleAnimation(button, 0.5f, 0.5f, 560))
                .animate()
        }

        button.setOnClickListener(animation1)
        textView.setOnClickListener(animation2)
    }

}
