package com.example.atividade_04;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SeekBar seekbar = (SeekBar) findViewById(R.id.seekBar);
        TextView percent_seek_bar = (TextView) findViewById(R.id.percent_seek_bar);

        DecimalFormat df = new DecimalFormat("#,###.00");

        EditText contaTotal = (EditText) findViewById(R.id.contaTotal);

        EditText total_customizado = (EditText) findViewById(R.id.total_custom);
        EditText gorjeta_customizado = (EditText) findViewById(R.id.gorjeta_customizado);

        seekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean b) {
                percent_seek_bar.setText(progress + "%");

                double contaTotalNumber;
                if(contaTotal.getText().length() > 0) {
                    contaTotalNumber = Float.parseFloat(String.valueOf(contaTotal.getText()));

                    double valorGorjeta = contaTotalNumber * ((double) progress / 100);

                    gorjeta_customizado.setText(df.format(valorGorjeta));
                    total_customizado.setText(df.format(contaTotalNumber + valorGorjeta));
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) { }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) { }
        });

        EditText gorjeta_10 = (EditText) findViewById(R.id.gorjeta_10);
        EditText gorjeta_15 = (EditText) findViewById(R.id.gorjeta_15);
        EditText gorjeta_20 = (EditText) findViewById(R.id.gorjeta_20);

        EditText total_10 = (EditText) findViewById(R.id.total_10);
        EditText total_15 = (EditText) findViewById(R.id.total_15);
        EditText total_20 = (EditText) findViewById(R.id.total_20);

        contaTotal.addTextChangedListener(new TextWatcher() {

            public void afterTextChanged(Editable s) {}

            public void beforeTextChanged(CharSequence s, int start,
                                          int count, int after) {
            }

            public void onTextChanged(CharSequence s, int start,
                                      int before, int count) {

                double contaTotalNumber;
                if(contaTotal.getText().length() > 0) {
                    contaTotalNumber = Float.parseFloat(String.valueOf(contaTotal.getText()));

                    double desconto_10 = contaTotalNumber * (double) (10.0 / 100.0);
                    double desconto_15 = contaTotalNumber * (double) (15.0 / 100.0);
                    double desconto_20 = contaTotalNumber * (double) (20.0 / 100.0);

                    gorjeta_10.setText(df.format(desconto_10));
                    gorjeta_15.setText(df.format(desconto_15));
                    gorjeta_20.setText(df.format(desconto_20));

                    total_10.setText(df.format(desconto_10 + contaTotalNumber));
                    total_15.setText(df.format(desconto_15 + contaTotalNumber));
                    total_20.setText(df.format(desconto_20 + contaTotalNumber));
                }
            }
        });
    }
}