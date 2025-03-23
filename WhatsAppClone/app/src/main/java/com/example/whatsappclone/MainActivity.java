package com.example.whatsappclone;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class MainActivity extends AppCompatActivity {
    Button btnChats,btnStatus,btnCalls;
    int menuID=R.menu.chats_menu;

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
        btnChats = findViewById(R.id.btnChats);
        btnStatus = findViewById(R.id.btnStatus);
        btnCalls = findViewById(R.id.btnCalls);

        Toolbar toolbar = findViewById(R.id.toolbar);

        // Step 1
        setSupportActionBar(toolbar);

        //step 2
        if(getSupportActionBar()!=null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(false);
            getSupportActionBar().setTitle("WhatsApp");

        }
        getFragments(new ChatFragment(),0);

        btnChats.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                menuID = R.menu.chats_menu;
                getSupportActionBar().setTitle("WhatsApp");

                getFragments(new ChatFragment(),1);

            }
        });
        btnStatus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                menuID = R.menu.updates_menu;
                getSupportActionBar().setTitle("Updates");
                getFragments(new StatusFragment(),1);

            }
        });
        btnCalls.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                menuID = R.menu.calls_menu;
                getSupportActionBar().setTitle("Calls");
                getFragments(new CallFragment(),1);

            }
        });

    }
    public void getFragments(Fragment fragment, int flag){
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();

        if(flag==0)
            ft.add(R.id.container,fragment);
        else
            ft.replace(R.id.container,fragment);

        ft.commit();
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        new MenuInflater(this).inflate(menuID,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int itemId = item.getItemId();
        if (itemId == R.id.opt_camera) {
            Toast.makeText(this, "Opening Camera", Toast.LENGTH_SHORT).show();
        }
        return super.onOptionsItemSelected(item);
    }
}