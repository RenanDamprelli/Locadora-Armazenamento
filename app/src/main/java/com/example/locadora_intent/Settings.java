package com.example.locadora_intent;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Settings extends AppCompatActivity {

    TextView loginview;
    TextView senhaview;
    TextView localview;
    ImageView imgFoto;

    @Override
    protected void onCreate(final Bundle SavedInstanceState) {
        super.onCreate(SavedInstanceState);
        setContentView(R.layout.activity_settings);

        Intent receber = getIntent();
        Bundle bundle = receber.getExtras();

        String log = bundle.getString("key_login");
        String sen = bundle.getString("key_senha");


        loginview = (TextView) findViewById(R.id.txt_txtlogin);
        senhaview = (TextView) findViewById(R.id.txt_txtsenha);

        loginview.setText(log);
        senhaview.setText(sen);

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);

        bottomNavigationView.setSelectedItemId(R.id.activity_settings);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch(menuItem.getItemId()){
                    case R.id.activity_settings:

                        return false;
                    case R.id.activity_home:

                        startActivity(new Intent(getApplicationContext(),Home.class));
                        overridePendingTransition(0 , 0);
                        return true;
                }
                return false;
            }
        });
        if(ActivityCompat.checkSelfPermission(Settings.this, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(Settings.this, new String[] {Manifest.permission.CAMERA}, 0);
        }
        imgFoto = (ImageView) findViewById(R.id.img_foto);
    }

    public void CapturarFoto(){
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(intent,1);
    }
    public void Captura (View view){ CapturarFoto();}


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if(requestCode ==1 && resultCode== RESULT_OK) {
            Bundle extras = data.getExtras();
            Bitmap imagem = (Bitmap) extras.get("data");
            imgFoto.setImageBitmap(imagem);
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
    public void Localizacao (View view){
        Intent intentenviar = new Intent(this,Localizacao.class);
        startActivity(intentenviar);
    }
    }