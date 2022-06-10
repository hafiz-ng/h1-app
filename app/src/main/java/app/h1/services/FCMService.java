package app.h1.services;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.Service;
import android.content.Intent;
import android.os.Build;
import android.os.IBinder;

import androidx.annotation.NonNull;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

import app.h1.R;
import app.h1.ui.LoadReportActivity;


public class FCMService extends FirebaseMessagingService {

    String CHANNEL_ID = "2";

    public FCMService() {
    }

    @Override
    public void onMessageReceived(@NonNull RemoteMessage remoteMessage) {
        if(remoteMessage.getNotification() != null) {

            // create and display notification
            showNotification(remoteMessage.getNotification().getTitle(), remoteMessage.getNotification().getBody());
        };

    }

    @Override
    public void onNewToken(@NonNull String token) {
        super.onNewToken(token);
    }

    private void showNotification(String title, String text) {

        // create notification channel
        createNotificationChannel();
        NotificationCompat.Builder builder = new NotificationCompat.Builder(FCMService.this, CHANNEL_ID)
                .setSmallIcon(R.drawable.notify_icon)
                .setContentTitle(title)
                .setContentTitle(text)
                .setAutoCancel(true)
                .setPriority(NotificationCompat.PRIORITY_DEFAULT);

        NotificationManagerCompat notificationManagerCompat = NotificationManagerCompat.from(FCMService.this);

        // Notification ID is unique for each notification you create
        notificationManagerCompat.notify(2, builder.build());
    }

    private void createNotificationChannel() {
        // create notification channel on API level 26+
        // NotificationChannel is a new Class and not in a support library

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            String name = "Channel Name2";
            String description = "My Channel description2";
            int importance = NotificationManager.IMPORTANCE_DEFAULT;

            NotificationChannel channel = new NotificationChannel(CHANNEL_ID, name, importance);

            channel.setDescription(description);

            // Register the channel with the system
            // You cannot change importance or other notification behaviours after this
            NotificationManager manager = getSystemService(NotificationManager.class);
            manager.createNotificationChannel(channel);

        }
    }
}