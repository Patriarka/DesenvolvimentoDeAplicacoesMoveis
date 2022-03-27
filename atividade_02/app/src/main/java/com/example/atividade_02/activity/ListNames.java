package com.example.atividade_02.activity;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;
import android.util.Log;

import com.example.atividade_02.R;

import java.util.HashMap;

import java.util.ArrayList;

public class ListNames extends ListActivity {
    private static final String[] list_names = new String[] { "Pedro", "João", "Maria" };

    @Override
    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);

        setContentView(R.layout.layout_listview_names);

        setListAdapter(createAdapter());
    }

    private ListAdapter createAdapter() {
        ArrayList<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();

        for(String name: list_names){
            HashMap<String,String> item = new HashMap<String,String>();
            item.put("name", name);
            list.add(item);
        }

        String[] from = new String[] { "name" };

        int[] to = new int[] { R.id.name };

        SimpleAdapter adapter = new SimpleAdapter(this, list, R.layout.layout_list_names, from, to);

        return adapter;
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);

        Object o = this.getListAdapter().getItem(position);

        String item = o.toString();
        item = item.substring(6, item.length()-1);

        Log.i("name", item);
        Toast.makeText(this, "Você selecionou: " + item, Toast.LENGTH_SHORT).show();
    }
}
