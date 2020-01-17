package com.example.fragaria;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class NovenyValasztoActivity extends AppCompatActivity {
    private FirebaseDatabase fragaria = FirebaseDatabase.getInstance();
    private DatabaseReference ref ;
    private Button bttnVissza;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_noveny_valaszto);
        init();
        bttnVissza.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(NovenyValasztoActivity.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
    public void init(){
        bttnVissza = findViewById(R.id.bttnVissza);

    }
}
