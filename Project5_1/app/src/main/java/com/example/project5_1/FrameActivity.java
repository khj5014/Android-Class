package com.example.project5_1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

public class FrameActivity extends AppCompatActivity implements View.OnClickListener {

    TextView textView1, textView2, textView3;
    FrameLayout frame;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frame);
        findViewById(R.id.btn1).setOnClickListener(this);
        findViewById(R.id.btn2).setOnClickListener(this);
        findViewById(R.id.btn3).setOnClickListener(this);

        frame = findViewById(R.id.framlayout);
        textView1 = findViewById(R.id.textView);
        textView2 = findViewById(R.id.textView2);
        textView3 = findViewById(R.id.textView3);

        frame.removeView(textView2);
        frame.removeView(textView3);
    }

    @Override
    public void onClick(View view) {

        frame.removeViewAt(0);
        switch (view.getId()) {
            case R.id.btn1:
                frame.addView(textView1);
                break;
            case R.id.btn2:
                frame.addView(textView2);
                break;
            case R.id.btn3:
                frame.addView(textView3);
                break;
        }
    }
}