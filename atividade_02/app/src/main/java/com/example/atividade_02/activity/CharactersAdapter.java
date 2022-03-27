package com.example.atividade_02.activity;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import com.example.atividade_02.R;

public class CharactersAdapter extends BaseAdapter {

    protected static final String CATEGORIA = "star_wars";
    private Context context;
    private List<Character> lista;

    public CharactersAdapter(Context context, List<Character> lista) {
        this.context = context;
        this.lista = lista;
    }
    public int getCount() {
        return lista.size();
    }
    public Object getItem(int posicao) {
        Character character = lista.get(posicao);
        return character;
    }
    public long getItemId(int posicao) {
        Log.i(CATEGORIA,"CharactersAdapter.getItemId("+posicao+") > " + posicao);
        return posicao;
    }
    public View getView(int posicao, View convertView, ViewGroup parent) {
        Log.i(CATEGORIA,"CharactersAdapter.getView("+posicao+")");

        Character character = lista.get(posicao);

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View v = inflater.inflate(R.layout.characters_details, null);

        TextView textNome = (TextView) v.findViewById(R.id.character_name);
        textNome.setText(character.name);

        ImageView img = (ImageView) v.findViewById(R.id.character_img);
        img.setImageResource(character.getImage());

        return v;
    }
}
