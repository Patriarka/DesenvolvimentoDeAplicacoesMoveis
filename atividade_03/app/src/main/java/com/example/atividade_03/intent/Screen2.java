package com.example.atividade_03.intent;

import android.app.Activity;
import android.os.Bundle;
import com.example.atividade_03.R;
import android.content.Intent;

public class Screen2 extends Activity {

    private int RESULT_OK = 1;

    @Override
    protected void onCreate(Bundle icicle) {
        super.onCreate(icicle);

        setContentView(R.layout.layout_hello_world);

        Bundle params = new Bundle();
        params.putString("msg", "Hello World: By Steph Curry");

        Intent intent = new Intent();
        intent.putExtras(params);
        setResult(RESULT_OK, intent);
    }
}
