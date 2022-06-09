package com.example.project11_01;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.os.Bundle;
import android.widget.ListAdapter;
import android.widget.ListView;

public class CustomActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom);
        setTitle("커스텀 리스트 뷰");

        ListView customListview = findViewById(R.id.customListview);

        ListViewAdapter adapter = new ListViewAdapter();

        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.cat), "고양이", "야생의 고양이가 나타났다!");
        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.dog), "강아지", "야생의 강아지가 나타났다!");
        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.rabbit), "토끼", "야생의 토끼가 나타났다!");

        customListview.setAdapter(adapter);
    }
}