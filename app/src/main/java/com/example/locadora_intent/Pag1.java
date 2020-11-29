package com.example.locadora_intent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class Pag1 extends AppCompatActivity {

     RadioGroup rg1;
    RadioGroup rg2;
    RadioButton sete;
     RadioButton quatorze;
     RadioButton vinteum;
     RadioButton card;
     RadioButton din;

     SharedPreferences prefs;

     TextView price;
     TextView error;
     Button pag;
     RadioButton radio;
     RadioButton radiodois;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pag1);

        rg1 = (RadioGroup) findViewById(R.id.radioGroup);
        rg2 = (RadioGroup) findViewById(R.id.radioGroup2);
        sete = (RadioButton) findViewById(R.id.rd_7);
        quatorze = (RadioButton) findViewById(R.id.rd_14);
        vinteum = (RadioButton) findViewById(R.id.rd_21);

        card = (RadioButton) findViewById(R.id.rd_card);
        din = (RadioButton) findViewById(R.id.rd_din);

        prefs = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
        pag = (Button) findViewById(R.id.btn_pag);

        price = (TextView) findViewById(R.id.txt_price);
        error = (TextView) findViewById(R.id.txt_erro);


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


                int selectedId = rg1.getCheckedRadioButtonId();
                int selectId = rg2.getCheckedRadioButtonId();
                radio = (RadioButton) findViewById(selectedId);
                radiodois = (RadioButton) findViewById(selectId);
                SharedPreferences.Editor editor = prefs.edit();
                String rad = radio.getText().toString();
                String rad2 = radiodois.getText().toString();
                editor.putString("rad_key", rad);
                editor.putString("rad_key", rad2);
                editor.commit();
                Toast.makeText(getApplicationContext(), "Forma de pagamento escolhida: "+rad+" e período alugado: "+rad2, Toast.LENGTH_SHORT).show();

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