package com.example.atividade_02;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.atividade_02.activity.ListNames;
import com.example.atividade_02.activity.ListNamesWithImage;

public class Menu extends ListActivity {
    private static final String[] menu_options = new String[] { "ListNames", "ListNamesWithImage", "Sair" };

    @Override
    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        this.setListAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, menu_options));
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        String msg = "hello man!";
        switch (position) {
            case 0:
                startActivity(new Intent(this, ListNames.class));
                break;
            case 1:
                startActivity(new Intent(this, ListNamesWithImage.class));
                break;
            default:
                finish();
        }
    }
}
