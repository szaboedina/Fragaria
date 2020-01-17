package com.example.fragaria;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class NovenyNeveloActivity extends AppCompatActivity {
    private FirebaseDatabase fragaria = FirebaseDatabase.getInstance();
    private DatabaseReference ref ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_noveny_nevelo);
    }
}
