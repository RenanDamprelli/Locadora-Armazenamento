package com.example.locadora_intent;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Conexao extends SQLiteOpenHelper {

    private static final String name = "locadora.db";
    private static final int version = 1;

    public Conexao(Context context){
        super(context,name,null,version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("CREATE TABLE Usuario(id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "nome VARCHAR(50), email VARCHAR(50), user VARCHAR(25), senha VARCHAR(30))");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
