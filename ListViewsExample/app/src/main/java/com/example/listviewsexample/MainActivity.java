package com.example.listviewsexample;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Spinner spinner;
    AutoCompleteTextView autoComplete;
    ListView listView;

    String [] li1 = {"Ram","Shyam","Sita","Gita"};
    String [] li2 = {"Aadhar Card","Pen Card","Votar ID","PassPort"};
    String [] li3 = {"C","C++","Java","Python"};

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        spinner = findViewById(R.id.spinner);
        autoComplete = findViewById(R.id.autoComplete);
        listView = findViewById(R.id.listView);


        ArrayAdapter listV = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1,li1);
        ArrayAdapter spi = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1,li2);
        ArrayAdapter acom = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1,li3);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this, "You have clicked "+(position+1), Toast.LENGTH_SHORT).show();
            }
        });

        listView.setAdapter(listV);
        spinner.setAdapter(spi);
        autoComplete.setAdapter(acom);
        autoComplete.setThreshold(1);
    }
}