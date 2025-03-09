package com.example.animations;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    TextView vie;
    Button btn1,btn2,btn3,btn4;
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
        vie = findViewById(R.id.txtView);



        btn1=findViewById(R.id.anim1);
        btn2=findViewById(R.id.anim2);
        btn3=findViewById(R.id.anim3);
        btn4=findViewById(R.id.anim4);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Animation move = AnimationUtils.loadAnimation(MainActivity.this,R.anim.move);
                vie.startAnimation(move);
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Animation alpha = AnimationUtils.loadAnimation(MainActivity.this,R.anim.alpha);
                vie.startAnimation(alpha);
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Animation rotation = AnimationUtils.loadAnimation(MainActivity.this,R.anim.rotate);
                vie.startAnimation(rotation);
            }
        });
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Animation scalling = AnimationUtils.loadAnimation(MainActivity.this,R.anim.scale);
                vie.startAnimation(scalling);
            }
        });
    }
}