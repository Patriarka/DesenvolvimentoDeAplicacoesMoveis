package com.example.atividade_02.activity;

import com.example.atividade_02.R;

public class Character {
    public static final int LUKE = 0;
    public static final int LEIA = 1;
    public static final int BB8 = 2;

    public String name;
    private final int type;

    public Character(String name,int type) {
        this.name = name;
        this.type = type;
    }

    public int getImage() {
        switch (type) {
            case LUKE:
                return R.drawable.luke;
            case LEIA:
                return R.drawable.leia;
            case BB8:
                return R.drawable.bb8;
        }
        return R.drawable.naoencontrado;
    }

    @Override
    public String toString() {
        return name;
    }
}
