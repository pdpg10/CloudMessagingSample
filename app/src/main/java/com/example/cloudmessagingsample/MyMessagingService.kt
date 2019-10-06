package com.example.cloudmessagingsample

import android.app.NotificationChannel
import android.app.NotificationManager
import android.os.Build
import android.util.Log
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage

private const val CHANNEL_ID = "test_id"

class MyMessagingService : FirebaseMessagingService() {

    override fun onMessageReceived(message: RemoteMessage) {
        super.onMessageReceived(message)
        Log.d("onMessageReceived", message.from)

        showNotification(message)
    }

    private fun showNotification(message: RemoteMessage) {
        val builder = NotificationCompat.Builder(this, CHANNEL_ID)
            .setSmallIcon(R.drawable.ic_android)
            .setContentTitle(message.notification!!.title)
            .setContentText(message.notification!!.body)

        val notificationManager = NotificationManagerCompat.from(this)

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channel = NotificationChannel(
                CHANNEL_ID,
                "test channel",
                NotificationManager.IMPORTANCE_HIGH
            )
            notificationManager.createNotificationChannel(channel)
        }
        notificationManager.notify(1, builder.build())
    }

    override fun onNewToken(token: String) {
        super.onNewToken(token)
        Log.d("onNewToken", token)
    }

    override fun onDeletedMessages() {
        super.onDeletedMessages()
    }
}