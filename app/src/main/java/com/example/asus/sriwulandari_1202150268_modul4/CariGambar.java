package com.example.asus.sriwulandari_1202150268_modul4;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import java.io.InputStream;

public class CariGambar extends AppCompatActivity {
    Button cari;
    ImageView tampilgambar;
    EditText url;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cari_gambar);

        cari = findViewById(R.id.btnCari);
        url = findViewById(R.id.linkgambar);
        tampilgambar = findViewById(R.id.gambar);

        cari.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String URLGambar = url.getText().toString();
                new DownloadImage().execute(URLGambar);
            }
        });

    }

    class DownloadImage extends AsyncTask<String, Void, Bitmap>{

        @Override
        protected void onPreExecute(){
            super.onPreExecute();
        }

        @Override
        protected Bitmap doInBackground(String...voids){

            String imageURL = voids[0];

            Bitmap bitmap = null;
            try {
                //source code untuk mendownload gambar dari url
                InputStream input = new java.net.URL(imageURL).openStream();
                //mengubah input dari url ke bitmap
                bitmap = BitmapFactory.decodeStream(input);
            } catch (Exception a) {
                a.printStackTrace();
            }
            return bitmap;
    }

    @Override
        protected void onPostExecute(Bitmap result) {
        //mengeset bitmap ke dalam imageView yang telah disediakan
        tampilgambar.setImageBitmap(result);
        }
    }
}
