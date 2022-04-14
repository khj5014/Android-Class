package com.example.project5_1;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    LinearLayout linearLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);
        linearLayout = new LinearLayout(this);

        linearLayout.setOrientation(LinearLayout.VERTICAL);
        linearLayout.setBackgroundColor(Color.CYAN);
        Button btn = new Button(this);
        btn.setText("추가");
        btn.setTextSize(22);


        LinearLayout.LayoutParams btnlaLayoutParams = new LinearLayout.LayoutParams(200, 200);

        linearLayout.addView(btn, btnlaLayoutParams);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                TextView textView = new TextView(MainActivity.this);
                textView.setBackgroundColor(Color.YELLOW);
                LinearLayout.LayoutParams textlayoutParams = new LinearLayout.LayoutParams(200, 200);

                textlayoutParams.setMargins(20, 10, 0, 10);
                linearLayout.addView(textView, textlayoutParams);

            }
        });

        //액티비티 이동버튼 추가
        Button btnMove = new Button(this);
        btnMove.setText("액티비티 이동");
        btnMove.setTextSize(19);
        LinearLayout.LayoutParams btnMoveLayoutParam = new LinearLayout.LayoutParams(250,200);

        linearLayout.addView(btnMove, btnMoveLayoutParam);
        btnMove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //명시적 인텐트
                Intent i = new Intent(MainActivity.this, RelativeActivity.class);
                startActivity(i);
            }
        });
        //프레임 레이아웃 이동
        Button btnFrame = new Button(this);
        btnFrame.setText("프레임 레이아웃 이동");
        LinearLayout.LayoutParams BtnFrameLayoutParams = new LinearLayout.LayoutParams(250, 200);

        linearLayout.addView(btnFrame, BtnFrameLayoutParams );
        btnFrame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, FrameActivity.class);
                startActivity(i);
            }
        });

        //레이아웃인플레이터 액티비티로 이동
        Button btnInflate = new Button(this);
        btnInflate.setText("레이아웃인플레이터로 이동");
        LinearLayout.LayoutParams BtnInflateLayoutParams = new LinearLayout.LayoutParams(250, 200);

        linearLayout.addView(btnInflate, BtnInflateLayoutParams );
        btnInflate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, InflateActivity.class);
                startActivity(i);
            }
        });
        
        //프래그먼트 레이아웃 만들기
        Button btnFrag = new Button(this);
        btnFrag.setText("프래그먼트로 이동");
        LinearLayout.LayoutParams BtnFragLayoutParams = new LinearLayout.LayoutParams(250, 200);

        linearLayout.addView(btnFrag, BtnFragLayoutParams );
        btnFrag.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, FragActivity.class);
                startActivity(i);
            }
        });
        
        setContentView(linearLayout);
    }
}