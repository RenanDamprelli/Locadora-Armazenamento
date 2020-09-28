package com.example.locadora_intent;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText login;
    EditText senha;
    TextView txtlogin;
    TextView txtsenha;
    Button entrar;
    Button local;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        login = (EditText) findViewById(R.id.edtxt_login);
        senha = (EditText) findViewById(R.id.edtxt_senha);
        txtlogin = (TextView) findViewById(R.id.txt_login);
        txtsenha = (TextView) findViewById(R.id.txt_senha);
        entrar = (Button) findViewById(R.id.btn_entrar);
        local = (Button) findViewById(R.id.btn_local);
    }

    public void Entrar (View view) {

        String log = login.getText().toString();
        String password = senha.getText().toString();

        if (log.length() ==0) {
            login.setError("Preencha o campo");
        }
        if (password.length() <5) {
            senha.setError("Insira no mínimo 5 caracteres");
        }
        else{

            Intent intentenviar = new Intent(this,Settings.class);
            Bundle bundle = new Bundle();

            bundle.putString("key_login",log);
            bundle.putString("key_senha",password);

            intentenviar.putExtras(bundle);

            startActivity(intentenviar);
        }

    }
}