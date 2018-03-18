package com.example.asus.sriwulandari_1202150268_modul4;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.util.ArrayList;

public class ListNamaMahasiswa extends AppCompatActivity {

    //disini membuat array untuk nama mahasiswa
    private String[] nama = {"Nita","Nayla", "Fani", "Rafif", "Muti", "Rehan", "Bayu", "Rizky", "Dafit", "Bila", "Hafiz", "Alfa", "Agus", "Wanto", "Lina", "Shafa"};
    ListView listnama;
    Button btnmulai;

    private static Parcelable ListViewScrollPos = null;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_nama_mahasiswa);

        listnama = findViewById(R.id.namanama);
        btnmulai = findViewById(R.id.btnmulai);

        //mengatur adapter array
        listnama.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,new ArrayList<String>()));

        //mengembalkan posisi listView
        if (ListViewScrollPos !=null){
            listnama.onRestoreInstanceState(ListViewScrollPos);
        }


        btnmulai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //memanggil class mytask dan mengeksekusinya
                new mytask().execute();

            }
        });
    }

    @Override
    public void onSaveInstanceState(Bundle outState){
        super.onSaveInstanceState(outState);

        // menyimpan posisi list
        ListViewScrollPos = listnama.onSaveInstanceState();

    }

    class mytask extends AsyncTask<Void, String,String>{

        ArrayAdapter<String> adapter;
        ProgressDialog progressdialog;
        int count;


        @Override
        protected void onPreExecute(){
            //mengambil adpater dari array tersebut
            adapter = (ArrayAdapter<String>)listnama.getAdapter();

            //membuat objek progres dialog
            progressdialog = new ProgressDialog(ListNamaMahasiswa.this);

            //membuat judul dari progres dialog
            progressdialog.setTitle("Loading Data");
            progressdialog.setProgressStyle(progressdialog.STYLE_HORIZONTAL);
            progressdialog.setMax(15);
            progressdialog.setProgress(0);

            //menampilkan progres dialog
            progressdialog.show();

            //memastikan bahwa hitungan sebelum dieksekusi adalah 0
            count = 0;

        }

        @Override
        protected String doInBackground(Void... voids){

            //membuat perulangan yang akan memunculkan nama mahasiswa
            for (String namamahasiswa : nama){
                publishProgress(namamahasiswa);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException a){
                    a.printStackTrace();
                }
            }
            //mengembalikan nilai dengan tulisan
            return "nama sudah muncul";
        }

        @Override
        protected void onProgressUpdate(String... values) {
            //adapter array akan memula array 0
            adapter.add(values[0]);

            //hitungan akan bertambah pada saat proggres diupdate
            count++;

            //mengatur hitungan di dalam progree dialog
            progressdialog.setProgress(count);

        }

        @Override
        protected void onPostExecute(String result) {
            //akan menampilkan nilai  dari return yang ada di method doInbackground
            Toast.makeText(getApplicationContext(),result,Toast.LENGTH_LONG).show();

            //ketika loading progress sudah penuh maka otomatis akan hilang progree dialognya
            progressdialog.hide();
        }
    }
}
