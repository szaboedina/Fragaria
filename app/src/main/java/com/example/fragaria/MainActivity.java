package com.example.fragaria;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

//import com.google.android.gms.tasks.OnCompleteListener;
//import com.google.android.gms.tasks.Task;
//import com.google.firebase.auth.AuthResult;
//import com.google.firebase.auth.FirebaseAuth;
//import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {
    private EditText editTextEmail, editTextJelszo;
    private Button bttnBej,bttnReg;
 //   private FirebaseAuth fAuth;
    private ProgressBar prBar;
    private AdatbazisSegito db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       // fAuth = FirebaseAuth.getInstance();
        init();
        bttnReg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent regisztracio = new Intent(MainActivity.this,RegisztracioActivity.class);
                startActivity(regisztracio);
                finish();
            }
        });

        bttnBej.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                String email= editTextEmail.getText().toString();
                String jelszo = editTextJelszo.getText().toString();
                boolean ell = db.emailEsJelszoEllenorzes(email,jelszo);


                if(TextUtils.isEmpty(email)){
                    editTextEmail.setError("E-mail megadása szükséges!");
                }
                if(TextUtils.isEmpty(email)){
                    editTextJelszo.setError("Jelszó megadása szükséges!");
                }
               /* if (jelszo.length()<6){
                    editTextJelszo.setError("A jelszónak legalább 6 karakternek kell lennie!");
                }*/
                if (ell == true){
                    Toast.makeText(MainActivity.this,"Sikeres bejelentkezés!",Toast.LENGTH_SHORT).show();
                    Intent sikeres = new Intent(MainActivity.this,MenuActivity.class);
                    startActivity(sikeres);
                    finish();
                }
                else{
                    Toast.makeText(MainActivity.this,"Sikertelen bejelentkezés!" ,Toast.LENGTH_SHORT).show();

                }

            }

        });


    }


    public void init(){
        editTextEmail = findViewById(R.id.editTextEmail);
        editTextJelszo = findViewById(R.id.editTextJelszo);
        bttnBej = findViewById(R.id.bttnBej);
        bttnReg=findViewById(R.id.bttnReg);
        prBar=findViewById(R.id.prBar);
        db = new AdatbazisSegito(MainActivity.this);
    }



}
