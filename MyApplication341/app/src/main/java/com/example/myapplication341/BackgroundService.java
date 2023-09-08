package com.example.myapplication341;

import static android.content.pm.ServiceInfo.FOREGROUND_SERVICE_TYPE_NONE;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Handler;
import android.os.IBinder;
import android.util.Log;

import androidx.core.app.NotificationCompat;

public class BackgroundService extends Service {
    private static final String TAG = "BackgroundService";
    private Handler handler;
    private Runnable runnable;

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d(TAG, "Background service onCreate");
        handler = new Handler();
        runnable = new Runnable() {
            @Override
            public void run() {
                // 여기에 주기적으로 실행할 작업을 작성합니다.
                makeNotification();
                Log.d(TAG, "Background task is running.");
                handler.postDelayed(this, 5000); // 5초마다 작업을 실행
            }
        };
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {

            startForeground(1, createNotification() , FOREGROUND_SERVICE_TYPE_NONE); // 1은 알림 ID
//            new Handler().postDelayed(()->{
//
//                stopSelf();
//            },5000);
        }
        handler.post(runnable);
        return START_NOT_STICKY;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        handler.removeCallbacks(runnable);
        stopForeground(true); // Foreground 서비스 중지
        stopSelf(); // 서비스 중지
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
    public void makeNotification(){
        String chanelID="CHANNEL_ID_NOTIFICATION1";
        NotificationCompat.Builder builder = new NotificationCompat.Builder(getApplicationContext(),chanelID);
        builder.setSmallIcon(R.drawable.ic_notifications)
                .setContentTitle("Notification Title")
                .setContentText("Some text for notification here")
                .setAutoCancel(true).setPriority(NotificationCompat.PRIORITY_DEFAULT);
        Intent intent = new Intent(getApplicationContext(), NotificationActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
                .putExtra("data","Somevalue to be passed here");

        PendingIntent pendingIntent = PendingIntent.getActivity(getApplicationContext(),0,intent,PendingIntent.FLAG_MUTABLE);
        builder.setContentIntent(pendingIntent);
        NotificationManager notificationManager= (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            NotificationChannel notificationChannel = notificationManager.getNotificationChannel(chanelID);
            if (notificationChannel==null){
                int importance = NotificationManager.IMPORTANCE_HIGH;
                notificationChannel = new NotificationChannel(chanelID,"Some description", importance);
                notificationChannel.setLightColor(Color.GREEN);
                notificationChannel.enableVibration(true);
                notificationManager.createNotificationChannel(notificationChannel);
            }
        }
        notificationManager.notify(0,builder.build());
    }
    public Notification createNotification() {
        Log.d(TAG, "이거 안떴으면");
        String chanelID = "CHANNEL_ID_NOTIFICATION2";
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this, chanelID);
        builder.setSmallIcon(R.drawable.ic_notifications)
                .setContentTitle("Foreground Service")
                .setContentText("Foreground service is running...")
                .setAutoCancel(true).setPriority(NotificationCompat.PRIORITY_MIN);

        Intent intent = new Intent(this, NotificationActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
                .putExtra("data", "Some value to be passed here");

        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_MUTABLE|PendingIntent.FLAG_ONE_SHOT);
        builder.setContentIntent(pendingIntent);

        return builder.build();
    }

}
