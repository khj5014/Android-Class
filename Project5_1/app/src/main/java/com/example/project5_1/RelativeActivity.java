package com.example.project5_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

public class RelativeActivity extends AppCompatActivity {

    Button backbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_relative);

        Button btnbackMove = new Button(this);
        btnbackMove.setText("액티비티 이동");
        btnbackMove.setTextSize(19);


        btnbackMove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //명시적 인텐트
                Intent i = new Intent(RelativeActivity.this, MainActivity.class);
                startActivity(i);
            }
        });
    }
}

