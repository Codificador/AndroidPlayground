package com.myapp.testandogooglemaps


import android.Manifest
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.google.android.gms.common.api.GoogleApiClient

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.google.android.gms.location.*
import java.lang.Exception
import android.support.v4.app.ActivityCompat
import android.content.pm.PackageManager
import android.support.v4.content.ContextCompat





class MapsActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var mMap: GoogleMap
    private lateinit var client: GoogleApiClient
    private var position = LatLng(-22.754633,-45.607954)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_maps)

        askPermissions()
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)


        val locationCallback = object: LocationCallback() {
            override fun onLocationResult(locationResult: LocationResult?) {
                locationResult ?: return
                for (it in locationResult.locations){
                    mMap.run {
                        clear()
                        setIndoorEnabled(true)
                        position = LatLng(it.latitude, it.longitude)
                        addMarker(MarkerOptions().position(position).title("ME"))
                        moveCamera(CameraUpdateFactory.newLatLng(position))
                    }
                }
            }
        }

        val locationRequest = LocationRequest.create()
        locationRequest.run {
                setInterval(1000)
                setFastestInterval(1000)
            setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY);
        }

        try {
            LocationServices.getFusedLocationProviderClient(this)
                .requestLocationUpdates(locationRequest, locationCallback, null)
        } catch (e : SecurityException) {

        } catch (e : Exception) {

        }


    }

    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap
    }

    fun askPermissions() {
        if (ContextCompat.checkSelfPermission(
                this,
                Manifest.permission.ACCESS_FINE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED || ContextCompat.checkSelfPermission(
                this,
                Manifest.permission.ACCESS_COARSE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            ActivityCompat.requestPermissions(
                this,
                arrayOf(Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION),
                123
            )
        }

    }
}
