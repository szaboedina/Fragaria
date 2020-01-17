package com.example.fragaria;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MenuActivity extends AppCompatActivity {


    private Button bttnNovenyNevelo, bttnShop, bttGaleria;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        init();

        bttnNovenyNevelo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MenuActivity.this,NovenyNeveloActivity.class);
                startActivity(intent);
                finish();
            }
        });
        bttGaleria.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MenuActivity.this,GaleriaActivity.class);
                startActivity(intent);
                finish();
            }
        });
        bttnShop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MenuActivity.this,ShopActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
    public void init(){
        bttnNovenyNevelo = findViewById(R.id.bttnNovenyNevelo);
        bttGaleria = findViewById(R.id.bttnGaleria);
        bttnShop = findViewById(R.id.bttnShop);
    }

}
