package com.example.locadora_intent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

public class Info3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info3);
    }
    public void Alugar (View view) {
        Intent intentenviar = new Intent(this,Pag1.class);
        startActivity(intentenviar);
    }
    public void Elenco (View view) {

        Intent elenco = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.adorocinema.com/filmes/filme-61282/creditos/".toString()));
        startActivity(elenco);
    }
    public void Sinopse (View view) {

        Intent sinopse = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.adorocinema.com/filmes/filme-61282/".toString()));
        startActivity(sinopse);
    }

}