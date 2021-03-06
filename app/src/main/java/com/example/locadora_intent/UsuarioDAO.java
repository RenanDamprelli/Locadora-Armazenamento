package com.example.locadora_intent;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

public class UsuarioDAO {

    private Conexao conexao;
    private SQLiteDatabase banco;

    public UsuarioDAO(Context context){
        conexao = new Conexao(context);
        banco = conexao.getWritableDatabase();
    }

    public long inserir(Usuario usuario){
        ContentValues values = new ContentValues();
        values.put("nome",usuario.getNome());
        values.put("email",usuario.getEmail());
        values.put("user",usuario.getUser());
        values.put("senha",usuario.getSenha());
        return banco.insert("Usuario",null,values);
    }
}
