package com.myapp.testandocamerakit

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.camerakit.CameraKitView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button.setOnClickListener {
            camera.captureImage(CameraKitView.ImageCallback { cameraKitView, bytes ->
                //TODO salvar imaagem
            })

        }

    }

    override fun onStart() {
        super.onStart()
        camera.onStart()
    }

    override fun onResume() {
        super.onResume();
        camera.onResume()
    }

    override fun onPause() {
        camera.onPause()
        super.onPause();
    }

    override fun onStop() {
        camera.onStop();
        super.onStop();
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        camera.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }
}
