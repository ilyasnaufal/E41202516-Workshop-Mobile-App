package com.example.listapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    // membuat variabel
    private Spinner spinner;
    private AutoCompleteTextView autocomplete;

    RecyclerView recyclerView;
    RecyclerView.Adapter recyclerViewAdapter;
    RecyclerView.LayoutManager recyclerViewLayoutManager;
    ArrayList<ItemModel> data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // menginsialisasi
        spinner = findViewById(R.id.spinner);
        autocomplete = findViewById(R.id.autocompleteView);
        recyclerView = findViewById(R.id.recycleView);

    // SPINNER
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.item, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
        spinner.setAdapter(adapter);

        // memberikan aksi ketika listener diklik
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView adapterView, View view, int i, long l) {
                // jika item diklik akan menampilkan toast
                Toast.makeText(getApplicationContext(),"Musik "+adapter.getItem(i), Toast.LENGTH_SHORT).show();
            }

            @Override
            // jika item tidak di klik
            public void onNothingSelected(AdapterView adapterView) {
            }
        });


    // TEXT AUTO COMPLETE
        ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_activated_1, MyItem.headLine);
        autocomplete.setAdapter(adapter2);

        // memberikan aksi ketika item di klik
        autocomplete.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                // jika item diklik akan menampilkan toast
                Toast.makeText(getApplicationContext(),"Musik yang dipilih: "+adapterView.getItemAtPosition(i), Toast.LENGTH_SHORT).show();
            }
        });


    // RECYCLER VIEW
        recyclerView.setHasFixedSize(true);

        recyclerViewLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(recyclerViewLayoutManager);
        recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));

        data = new ArrayList<>();
        // memanggil data
        for (int i = 0; i < MyItem.headLine.length; i++) {
            data.add(new ItemModel(
                    MyItem.headLine[i],
                    MyItem.subHeadLine[i],
                    MyItem.iconList[i]
            ));
        }

        recyclerViewAdapter = new AdapterRecyclerView(this, data);
        recyclerView.setAdapter(recyclerViewAdapter);
    }
}