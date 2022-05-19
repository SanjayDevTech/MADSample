package com.sample.mad.eigth;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.widget.Button;

import com.sample.mad.R;

public class AlertMsgActivity extends AppCompatActivity {
    private final String CHANNEL_NAME = "peace Notification";
    private final String CHANNEL_ID = "give-me-peace";
    private final int NOTIFICATION_ID = 8;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alert_msg);
        Button button = findViewById(R.id.insertBtn);
        button.setOnClickListener(v -> {
            NotificationManagerCompat notificationManager = NotificationManagerCompat.from(getApplicationContext());
            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
                NotificationChannel channel = new NotificationChannel(CHANNEL_ID, CHANNEL_NAME, NotificationManager.IMPORTANCE_DEFAULT);
                notificationManager.createNotificationChannel(channel);
            }
            NotificationCompat.Builder builder = new NotificationCompat.Builder(getApplicationContext(), CHANNEL_ID)
                    .setSmallIcon(R.drawable.ic_launcher_foreground)
                    .setLargeIcon(BitmapFactory.decodeResource(getResources(), R.drawable.ic_launcher_foreground))
                    .setContentTitle("Very beautiful sunset")
                    .setContentText("Sun sets in west")
                    .setStyle(new NotificationCompat.BigPictureStyle()
                            .bigPicture(BitmapFactory.decodeResource(getResources(), R.drawable.sunset)))
                    .setPriority(NotificationCompat.PRIORITY_DEFAULT);
            notificationManager.notify(NOTIFICATION_ID, builder.build());
        });
    }
}