package com.example.bottomnavigation;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

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

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    int menuID = R.menu.chat_toolbar;

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

        Toolbar toolbar = findViewById(R.id.toolbar);
        BottomNavigationView bnv = findViewById(R.id.bottomNavigation);

        setSupportActionBar(toolbar);

        bnv.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();

                if (getSupportActionBar() != null) {
                    getSupportActionBar().setDisplayHomeAsUpEnabled(false);
                    if (id == R.id.chats) {
                        getSupportActionBar().setTitle("WhatsApp");
                        menuID = R.menu.chat_toolbar;
                        loadFragment(new chatsFragment(),1);

                    } else if (id == R.id.updates) {
                        getSupportActionBar().setTitle("Updates");
                        menuID = R.menu.updates_toolbar;
                        loadFragment(new updatesFragment(),1);

                    } else if (id == R.id.community) {
                        getSupportActionBar().setTitle("Community");
                        menuID = R.menu.community_toolbar;
                        loadFragment(new communityFragment(),1);
                    } else if (id == R.id.calls) {
                        getSupportActionBar().setTitle("Calls");
                        menuID = R.menu.calls_toolbar;
                        loadFragment(new callsFragment(),1 );
                    }
                }
                return true;
            }
        });
        bnv.setSelectedItemId(R.id.chats);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        new MenuInflater(this).inflate(menuID,menu);
        return super.onCreateOptionsMenu(menu);
    }
    public void loadFragment(Fragment fg, int flag){
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        if(flag==0) {
            ft.add(R.id.container, fg);
        }
        else{
            ft.replace(R.id.container,fg);
        }
        ft.commit();

    }
}