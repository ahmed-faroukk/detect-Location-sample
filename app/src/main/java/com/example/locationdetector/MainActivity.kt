package com.example.locationdetector

import LocationHelper
import android.annotation.SuppressLint
import android.location.Location
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView

class MainActivity : AppCompatActivity() ,LocationHelper.OnLocationFetchedListener {
    lateinit var getLocationBtn : Button
    lateinit var textview : TextView
    var x = 0
    private lateinit var locationHelper: LocationHelper
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        getLocationBtn = findViewById(R.id.getlocationBtn)
        textview = findViewById(R.id.main_tv)

        getLocationBtn.setOnClickListener {

            locationHelper = LocationHelper(this)
            locationHelper.fetchLocation(this)
            x++
        }

        }
    override fun onLocationFetched(location: Location?, address: String?) {
        textview.text = address
    }

    override fun onError(error: String?) {
        textview.text = error
    }
    }

