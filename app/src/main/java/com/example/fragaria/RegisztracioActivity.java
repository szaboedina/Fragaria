package com.example.fragaria;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

//import com.google.android.gms.tasks.OnCompleteListener;
//import com.google.android.gms.tasks.Task;
//import com.google.firebase.auth.AuthResult;
//import com.google.firebase.auth.FirebaseAuth;

import java.net.Authenticator;

public class RegisztracioActivity extends AppCompatActivity {
    private EditText editTextEmail, editTextJelszo;
    private Button bttnReg, bttnVissza;
   // private FirebaseAuth fAuth;
    private ProgressBar prBar;
    private AdatbazisSegito db;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_regisztracio);
        init();






        bttnReg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                adatRogzites();
            }

        });
        bttnVissza.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent vissza = new Intent(RegisztracioActivity.this,MainActivity.class);
                startActivity(vissza);
                finish();
            }
        });



    }
    public void init(){
        db= new AdatbazisSegito(this);
        editTextEmail= findViewById(R.id.editTextEmail);
        editTextJelszo=findViewById(R.id.editTextJelszo);
        bttnReg=findViewById(R.id.bttnReg);
        bttnVissza=findViewById(R.id.bttnVissza);
        //fAuth = FirebaseAuth.getInstance();
        prBar = findViewById(R.id.prBar);


    }

    public  void adatRogzites()
    {
        String email= editTextEmail.getText().toString();
        String jelszo = editTextJelszo.getText().toString();
        String valasztottNovenyID= "";

        if(TextUtils.isEmpty(email)){
            editTextEmail.setError("E-mail megadása szükséges!");
        }
        if(TextUtils.isEmpty(email)){
            editTextJelszo.setError("Jelszó megadása szükséges!");
        }
      /*  if (jelszo.length()<6){
            editTextJelszo.setError("A jelszónak legalább 6 karakternek kell lennie!");
        }*/
        if (db.emailEsJelszoEllenorzes(email,jelszo)){
            Toast.makeText(RegisztracioActivity.this,"Ez az e-mail cím már foglalt!" ,Toast.LENGTH_SHORT).show();

        }
        Boolean ell = db.adatFelvetel(email,jelszo,valasztottNovenyID);
        if (ell){
            Toast.makeText(RegisztracioActivity.this,"Sikeres regisztráció!",Toast.LENGTH_SHORT).show();
            Intent sikeres = new Intent(RegisztracioActivity.this,MainActivity.class);
            startActivity(sikeres);
        }
        else {
            Toast.makeText(RegisztracioActivity.this,"Sikertelen regisztráció!",Toast.LENGTH_SHORT).show();

        }
    }

}
