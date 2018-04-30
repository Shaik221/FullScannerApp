package dagger.jani.com.filescanner;

import android.app.Activity;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.support.v4.app.NotificationCompat;


import dagger.jani.com.filescanner.ui.main.MainActivity;

import static android.content.Context.NOTIFICATION_SERVICE;

public class NotificationHandler {


    public static final String CHANNEL_ID = "file_op";

    public static void setNotification(CharSequence textTitle, CharSequence textContent, Context context) {
        Intent intent = new Intent(context, MainActivity.class);
        PendingIntent pIntent = PendingIntent.getActivity(context, 1, intent, PendingIntent.FLAG_ONE_SHOT);

        NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(context, CHANNEL_ID)
                .setSmallIcon(R.mipmap.ic_launcher)
                .setContentTitle(textTitle)
                .setContentText(textContent)
                .setAutoCancel(true)
                .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                .setContentIntent(pIntent);

        NotificationManager notificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel channel = new NotificationChannel("notify_001",
                    CHANNEL_ID,
                    NotificationManager.IMPORTANCE_DEFAULT);
            notificationManager.createNotificationChannel(channel);
        }
        notificationManager.notify(0, mBuilder.build());

    }

    public static void cancelNotification(Activity context) {
        NotificationManager mNotificationManager = (NotificationManager)
                context.getSystemService(NOTIFICATION_SERVICE);
        mNotificationManager.cancelAll();
    }


}
