package com.example.fragaria;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class RegisztracioActivity extends AppCompatActivity {
    private adatbazis adatbazisSegito;
    private EditText editTextEmail, editTextJelszo;
    private Button bttnReg, bttnVissza;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_regisztracio);
        init();
        bttnVissza.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(RegisztracioActivity.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        });



    }
    public void init(){
        adatbazisSegito= new adatbazis(this);
        editTextEmail= findViewById(R.id.editTextEmail);
        editTextJelszo=findViewById(R.id.editTextJelszo);
        bttnReg=findViewById(R.id.bttnReg);
        bttnVissza=findViewById(R.id.bttnVissza);


    }
}
