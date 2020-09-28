package com.example.locadora_intent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class Pag1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pag1);

        final RadioButton sete;
        final RadioButton quatorze;
        final RadioButton vinteum;
        final RadioButton card;
        final RadioButton din;
        final TextView price;
        final TextView error;
        final Button pag;

        sete = (RadioButton) findViewById(R.id.rd_7);
        quatorze = (RadioButton) findViewById(R.id.rd_14);
        vinteum = (RadioButton) findViewById(R.id.rd_21);

        card = (RadioButton) findViewById(R.id.rd_card);
        din = (RadioButton) findViewById(R.id.rd_din);
        price = (TextView) findViewById(R.id.txt_price);
        error = (TextView) findViewById(R.id.txt_erro);
        pag = (Button) findViewById(R.id.btn_pag);



        sete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (sete.isChecked()) {
                    price.setText("Preço: R$9,99");
                }
            }
        });
        quatorze.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (quatorze.isChecked()) {
                    price.setText("Preço: R$12,99");
                }
            }
        });
        vinteum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (vinteum.isChecked()) {
                    price.setText("Preço: R$14,99");
                }

            }
        });

        pag.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (sete.isChecked() || quatorze.isChecked() || vinteum.isChecked()) {
                    if (card.isChecked() || din.isChecked()) {
                        startActivity(new Intent(getApplicationContext(), SplashPay.class));
                        overridePendingTransition(0, 0);
                    }
                    else{
                        error.setText("Preencha os campos");
                        error.setError("Preencha os campos");
                    }
                }
                else{
                    error.setText("Preencha os campos");
                    error.setError("Preencha os campos");
                }
            }
        });
    }
}