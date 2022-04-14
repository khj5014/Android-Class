package com.example.project5_1;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class InflateActivity extends AppCompatActivity {

    TextView textView1, textView2, textView3;
    FrameLayout frame;
    LayoutInflater inflater;
    View view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inflate);

        addChangeView(0);
        findViewById(R.id.btn1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addChangeView(0);
            }
        });
        findViewById(R.id.btn2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addChangeView(1);
            }
        });
        findViewById(R.id.btn3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addChangeView(2);
            }
        });
    }

    private void addChangeView(int index) {
        frame = findViewById(R.id.frame1);
        inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        if (frame.getChildCount() > 0) frame.removeViewAt(0);


        switch (index) {
            case 0:
                view = inflater.inflate(R.layout.page1, frame, false);
                break;
            case 1:
                view = inflater.inflate(R.layout.page2, frame, false);
                break;
            case 2:
                view = inflater.inflate(R.layout.page3, frame, false);
                break;
        }
        if (view != null) {
            frame.addView(view);
        }
    }
}