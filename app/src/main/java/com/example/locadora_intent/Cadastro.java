package com.example.locadora_intent;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Cadastro extends AppCompatActivity {

    private EditText nome;
    private EditText email;
    private EditText user;
    private EditText senha;
    private UsuarioDAO dao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        nome = findViewById(R.id.editNome);
        email = findViewById(R.id.editEmail);
        user = findViewById(R.id.editUser);
        senha = findViewById(R.id.editSenha);
        dao = new UsuarioDAO(this);
    }

    public void Cadastrar (View view){
        Usuario u = new Usuario();
        u.setNome(nome.getText().toString());
        u.setEmail(email.getText().toString());
        u.setUser(user.getText().toString());
        u.setSenha(senha.getText().toString());
        long id = dao.inserir(u);
        Toast.makeText(this, "Usuário cadastrado: " + id, Toast.LENGTH_SHORT).show();

        Intent intentcad = new Intent(this,MainActivity.class);
        startActivity(intentcad);
    }

}