package com.example.atividade_03;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import com.example.atividade_03.intent.Screen1;
import com.example.atividade_03.intent.Screen2;
import android.util.Log;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private int REQUEST_CODE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button1 = (Button) findViewById(R.id.button1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i("click_info", "Botão 1");
                Intent intent = new Intent(MainActivity.this, Screen1.class);
                startActivity(intent);
            }
        });

        Button button2 = (Button) findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i("click_info", "Botão 2");
                Intent intent = new Intent(MainActivity.this, Screen2.class);
                startActivityForResult(intent, REQUEST_CODE);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == REQUEST_CODE){
            if(data == null){
                Log.i("name", "nada");
                return;
            }
            Bundle params = data.getExtras();
            String message = params.getString("msg");

            Log.i("msg_by", message);
            Toast.makeText(this, "A mensagem é: " + message,Toast.LENGTH_SHORT).show();
        }
    }
}