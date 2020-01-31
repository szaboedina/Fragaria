package com.example.fragaria;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class novenyfelvetel extends AppCompatActivity {

    private EditText nevEditText,leirasEditText,aktualisSzintEditText,maxSzintEditText;
    private Button novenyfelvetelButton, menu;
    private TextView novenylista;
    private AdatbazisSegito db;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_novenyfelvetel);
        init();

        novenyfelvetelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                novenyRogzites();
            }
        });
        menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(novenyfelvetel.this,MenuActivity.class);
                startActivity(intent);
                finish();
            }
        });

    }
    public void init(){
        nevEditText = findViewById(R.id.nevEditText);
        leirasEditText = findViewById(R.id.leirasEditText);
        aktualisSzintEditText = findViewById(R.id.aktualisSzintEditText);
        maxSzintEditText = findViewById(R.id.maxSzintEditText);
        novenyfelvetelButton = findViewById(R.id.novenyfelvetelButton);
        novenylista = findViewById(R.id.novenylista);


    }
    public  void novenyRogzites()
    {
        String nev = nevEditText.getText().toString();
        String leiras = leirasEditText.getText().toString();
        String aktualisSzint= aktualisSzintEditText.getText().toString();
        String maxSzint = maxSzintEditText.getText().toString();

        if(TextUtils.isEmpty(nev) || TextUtils.isEmpty(leiras) || TextUtils.isEmpty(aktualisSzint) || TextUtils.isEmpty(maxSzint)){
            Toast.makeText(novenyfelvetel.this,"minden mezot ki kell tolteni!" ,Toast.LENGTH_SHORT).show();

        }
        Boolean ell = db.novenyFelvetel(nev,leiras,aktualisSzint,maxSzint);
        if (ell){
            Toast.makeText(novenyfelvetel.this,"Sikeres felvetel!",Toast.LENGTH_SHORT).show();
        }
        else {
            Toast.makeText(novenyfelvetel.this,"Sikertelen felvetel!",Toast.LENGTH_SHORT).show();

        }
    }
}
