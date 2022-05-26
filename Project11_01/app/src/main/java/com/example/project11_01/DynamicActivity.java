package com.example.project11_01;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class DynamicActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dynamic);
        setTitle("동적리스트뷰");



    }
}