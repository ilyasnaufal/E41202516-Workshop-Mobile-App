package com.example.listapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class DetailMusikActivity extends AppCompatActivity {

    // membuat variabel
    ListView listView;
    private TextView tvDefault, tvDeskripsi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_musik);

        tvDefault = findViewById(R.id.tvDefault);
        tvDeskripsi = findViewById(R.id.tvDeskripsi);
        listView = findViewById(R.id.listView);

        Intent i = getIntent();

        String namaLomba = i.getStringExtra("TEXT");
        String deskripsi = i.getStringExtra("SUBTEXT");

        tvDefault.setText(namaLomba);
        tvDeskripsi.setText(deskripsi);

    // LIST VIEW
        // fungsi untuk menampilkan data list ke list view
        ArrayAdapter<String> adapter3 = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, MyItem.headLine);
        listView.setAdapter(adapter3);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(),"Lagu "+parent.getItemAtPosition(position), Toast.LENGTH_SHORT).show();
            }
        });
    }
}