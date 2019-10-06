package com.example.cloudmessagingsample

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.messaging.FirebaseMessaging
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)
        FirebaseMessaging.getInstance().subscribeToTopic("G10")
            .addOnSuccessListener {
                Log.d("MainActivity", "subscribe successfully")
            }
    }
}
