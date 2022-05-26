package com.example.project11_01;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class CustomActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom);
        setTitle("커스텀 리스트 뷰");


                
    }
}