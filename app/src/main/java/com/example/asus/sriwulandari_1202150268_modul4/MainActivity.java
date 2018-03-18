package com.example.asus.sriwulandari_1202150268_modul4;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button listnama, carigambar;

    @SuppressLint("WrongConstant")

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listnama = findViewById(R.id.listnama);
        carigambar = findViewById(R.id.mencarigambar);

        listnama.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent x = new Intent(MainActivity.this,ListNamaMahasiswa.class);
                startActivity(x);
            }
        });

        carigambar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent z = new Intent(MainActivity.this,CariGambar.class);
                startActivity(z);
            }
        });
    }
}
