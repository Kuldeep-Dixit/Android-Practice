package com.example.bmicalculator;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        LinearLayout lay;
        EditText height_inch,height_feet,weight;
        TextView result;
        Button calculate;
        lay = findViewById(R.id.main);
        height_inch=findViewById(R.id.btn_height_inch);
        height_feet=findViewById(R.id.btn_height_feet);
        weight=findViewById(R.id.btn_weight);
        calculate=findViewById(R.id.btn_calculate);
        result=findViewById(R.id.btn_Result);

        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int wt = Integer.parseInt(weight.getText().toString());
                int feet = Integer.parseInt(height_feet.getText().toString());
                int inch = Integer.parseInt(height_inch.getText().toString());

                int totalInch = feet * 12 + inch;
                double centi = totalInch * 2.53;
                double meter = centi / 100;

                double bmi = wt/(meter * meter);

                if(bmi>25){
                    result.setText("You're OverWeight!");
                    lay.setBackgroundColor(getResources().getColor(R.color.overWeight));
                }
                else if(bmi<18){
                    result.setText("You're UnderWeight!");
                    lay.setBackgroundColor(getResources().getColor(R.color.underWeight));
                }
                else{
                    result.setText("You're Healthy!");
                    lay.setBackgroundColor(getResources().getColor(R.color.healthy));
                }
            }
        });



        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}