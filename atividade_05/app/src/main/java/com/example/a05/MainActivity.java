package com.example.a05;

import com.example.a05.utils.NotificationUtil;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.view.View;

public class MainActivity extends AppCompatActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button = (Button) findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                String tickerText = "Olá, jovem padawan!";
                String title = "Matheus Patriarca";
                String message = "Foco, força e fé";

                createNotification(tickerText, title, message);
            }
        });
    }

    protected void createNotification(String tickerText, String title, String message)
    {
        NotificationUtil.create(this, tickerText, title, message, R.drawable.yoda);
    }
}