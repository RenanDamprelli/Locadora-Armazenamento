package com.example.locadora_intent;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Home extends AppCompatActivity {


    public void Info (View view) {
        Intent intentenviar = new Intent(this,Info1.class);
        startActivity(intentenviar);
    }
    public void Info1 (View view) {
        Intent intentenviar = new Intent(this,Info2.class);
        startActivity(intentenviar);
    }
    public void Info2 (View view) {
        Intent intentenviar = new Intent(this,Info3.class);
        startActivity(intentenviar);
    }

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_home);

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);

        bottomNavigationView.setSelectedItemId(R.id.activity_home);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch(menuItem.getItemId()){
                    case R.id.activity_home:

                        return true;
                    case R.id.activity_settings:

                        startActivity(new Intent(getApplicationContext(),Settings.class));
                        overridePendingTransition(0 , 0);
                        return true;
            }
            return false;
        }
        });

    }
}