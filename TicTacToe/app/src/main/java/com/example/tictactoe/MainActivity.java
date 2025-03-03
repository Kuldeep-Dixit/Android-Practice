package com.example.tictactoe;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    Button btn00,btn01,btn02,btn10,btn11,btn12,btn20,btn21,btn22;
    TextView winner;
    int flag=0;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        init();
        winner=findViewById(R.id.txt_winner);
    }


    private void init(){
        btn00 = findViewById(R.id.btn00);
        btn01 = findViewById(R.id.btn01);
        btn02 = findViewById(R.id.btn02);
        btn10 = findViewById(R.id.btn10);
        btn11 = findViewById(R.id.btn11);
        btn12 = findViewById(R.id.btn12);
        btn20 = findViewById(R.id.btn20);
        btn21 = findViewById(R.id.btn21);
        btn22 = findViewById(R.id.btn22);
    }

    public void Check(View view){
        Button btnCurrent = (Button)view;
        winner.setText("");
        if(btnCurrent.getText().toString().equals("")) {
            if (flag % 2 == 0) {
                btnCurrent.setText("X");
            } else {
                btnCurrent.setText("0");
            }
            flag++;
            if (flag > 4) {
                String b00 = btn00.getText().toString();
                String b01 = btn01.getText().toString();
                String b02 = btn02.getText().toString();
                String b10 = btn10.getText().toString();
                String b11 = btn11.getText().toString();
                String b12 = btn12.getText().toString();
                String b20 = btn20.getText().toString();
                String b21 = btn21.getText().toString();
                String b22 = btn22.getText().toString();

                if (b00.equals(b01) && b01.equals(b02) && !b01.equals("")) {
                    Toast.makeText(this, "Winner is " + b00, Toast.LENGTH_SHORT).show();
                    winner.setText("Winner is " + b00);
                    Restart(view);
                } else if (b10.equals(b11) && b11.equals(b12) && !b10.equals("")) {
                    Toast.makeText(this, "Winner is " + b10, Toast.LENGTH_SHORT).show();
                    winner.setText("Winner is " + b10);
                    Restart(view);
                } else if (b20.equals(b21) && b21.equals(b22) && !b20.equals("")) {
                    Toast.makeText(this, "Winner is " + b20, Toast.LENGTH_SHORT).show();
                    winner.setText("Winner is " + b20);
                    Restart(view);
                } else if (b00.equals(b10) && b10.equals(b20) && !b00.equals("'")) {
                    Toast.makeText(this, "Winner is " + b00, Toast.LENGTH_SHORT).show();
                    winner.setText("Winner is " + b00);
                    Restart(view);
                } else if (b01.equals(b11) && b11.equals(b21) && !b01.equals("")) {
                    Toast.makeText(this, "Winner is " + b01, Toast.LENGTH_SHORT).show();
                    winner.setText("Winner is " + b11);
                    Restart(view);
                } else if (b02.equals(b12) && b12.equals(b22) && !b02.equals("")) {
                    Toast.makeText(this, "Winner is " + b02, Toast.LENGTH_SHORT).show();
                    winner.setText("Winner is " + b02);
                    Restart(view);
                } else if (b00.equals(b11) && b11.equals(b22) && !b00.equals("")) {
                    Toast.makeText(this, "Winner is " + b00, Toast.LENGTH_SHORT).show();
                    Restart(view);
                    winner.setText("Winner is " + b00);
                } else if (b02.equals(b11) && b11.equals(b20) && !b02.equals("")) {
                    Toast.makeText(this, "Winner is " + b02, Toast.LENGTH_SHORT).show();
                    winner.setText("Winner is " + b02);
                    Restart(view);
                } else if (!b00.equals("") && !b01.equals("") && !b02.equals("") && !b10.equals("")
                        && !b11.equals("") && !b12.equals("") && !b20.equals("") && !b21.equals("")
                        && !b22.equals("")) {
                    // or if(flag==9) then it will be draw
                    Toast.makeText(this, "This is Draw!!", Toast.LENGTH_SHORT).show();
                    winner.setText("Draw!");
                    Restart(view);
                }
            }
        }

    }
    public void Restart(View view){
        flag=0;
        btn00.setText("");
        btn01.setText("");
        btn02.setText("");
        btn10.setText("");
        btn11.setText("");
        btn12.setText("");
        btn20.setText("");
        btn21.setText("");
        btn22.setText("");

    }
}