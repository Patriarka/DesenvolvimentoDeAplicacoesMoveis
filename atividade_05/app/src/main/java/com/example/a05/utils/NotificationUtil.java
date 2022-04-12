package com.example.a05.utils;

import android.app.Instrumentation;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.os.Build;
import android.util.Log;

import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.core.content.ContextCompat;

import com.example.a05.R;

public class NotificationUtil {
    static Thread t = null;

    public static void create(Context context, String tickerText, String title, String message, int icon)
    {
        if(t != null)
            if(t.isAlive())
                return;

        NotificationManagerCompat notificationManager = NotificationManagerCompat.from(context);

        NotificationCompat.Builder builder = new NotificationCompat.Builder(context, "CHANNEL_1");

        createNotificationChannel(context, "CHANNEL_1", "CHANNEL_1", "CHANNEL_1");

        builder.setContentTitle("Testando")
                .setContentText("Estamos em busca de uma frase para você")
                .setSmallIcon(icon)
                .setPriority(NotificationCompat.PRIORITY_LOW);

        int PROGRESS_MAX = 100, PROGRESS_CURRENT = 0;

        builder.setProgress(PROGRESS_MAX, PROGRESS_CURRENT, false);
        notificationManager.notify(0, builder.build());

         t = new Thread(
                new Runnable() {
                    @Override
                    public void run() {
                        int i;
                        for (i = 0; i <= 100; i+=5) {
                            builder.setProgress(100, i, false);
                            notificationManager.notify(0, builder.build());
                            try {
                                Thread.sleep(5*1000);
                            } catch (InterruptedException e) {
                                Log.d("Error", "sleep failure");
                            }
                        }
                        builder.setContentTitle(title);
                        builder.setTicker(tickerText);
                        builder.setContentText(message)
                                .setProgress(0,0,false);
                        notificationManager.notify(0, builder.build());
                    }
                }
        );
        t.start();
    }

    public static void createNotificationChannel(Context context, String nome, String descricao, String Channel_id)
    {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O)
        {
            CharSequence name = nome;
            String description = descricao;

            int importance = NotificationManager.IMPORTANCE_DEFAULT;

            NotificationChannel channel = new NotificationChannel(Channel_id, name, importance);
            channel.setDescription(description);

            NotificationManager notificationManager = ContextCompat.getSystemService(context, NotificationManager.class);
            notificationManager.createNotificationChannel(channel);
        }
    }
}
