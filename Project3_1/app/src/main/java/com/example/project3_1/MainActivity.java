package com.example.project3_1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    Button button1, button2, button3, button4;

    View.OnClickListener mClick = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Toast.makeText(getApplicationContext(),"김희재입니다",Toast.LENGTH_SHORT).show();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button1 = findViewById(R.id.btn1);
        button2 = findViewById(R.id.btn2); button2.setOnClickListener(MainActivity.this);
        button3 = findViewById(R.id.btn3); button3.setOnClickListener(mClick);
        button4 = findViewById(R.id.btn4);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "버튼1을 클릭했습니다.",
                        Toast.LENGTH_SHORT).show();
            }
        });

    }
    @Override
    public void onClick(View view) {
        Toast.makeText(MainActivity.this, "버튼2을 클릭했습니다.",
                Toast.LENGTH_SHORT).show();
    }


    public void Click_Method(View v) {
        switch (v.getId()){
            case R.id.btn4:
                Toast.makeText(MainActivity.this, "버튼4을 클릭했습니다.",
                        Toast.LENGTH_SHORT).show();
                break;
        }
    }
}