package com.example.atividade_02.activity;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;
import android.util.Log;

import java.util.ArrayList;

public class ListNamesWithImage extends ListActivity {
    protected static final String CATEGORY = "character";

    @Override
    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);

        ArrayList<Character> list = new ArrayList<Character>();

        list.add(new Character("Pedro", Character.LUKE));
        list.add(new Character("João", Character.LEIA));
        list.add(new Character("Maria", Character.BB8));

        setListAdapter(new CharactersAdapter(this, list));
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);

        Character character = (Character) this.getListAdapter().getItem(position);

        Log.i(CATEGORY, character.name);
        Toast.makeText(this, "Você selecionou o character: " + character.name, Toast.LENGTH_SHORT).show();
    }
}
