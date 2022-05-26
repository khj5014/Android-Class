package com.example.project11_01;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class DynamicActivity extends AppCompatActivity {
    EditText editName;
    Button btnInsert, btnDelete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dynamic);
        setTitle("동적리스트뷰");

        editName = findViewById(R.id.editText1);
        btnInsert =findViewById(R.id.btnInsert);
        btnInsert =findViewById(R.id.btnDelete);
        
        
        //1. 데이터 저장
        ArrayList<String> item = new ArrayList<String>();

        //2. 리스트뷰 객체 참조
        ListView dynamicListView  = findViewById(R.id.dynamicListView);
        
        //3. 어댑터 생성
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_single_choice, item);

        //4. 리스트에 어댑터를 붙인다.
        dynamicListView.setAdapter(adapter);
        dynamicListView.setChoiceMode(ListView.CHOICE_MODE_SINGLE);

        btnInsert.setOnClickListener(view -> {
            item.add(editName.getText().toString());
            editName.setText("");
            editName.setHint("이름을 입력하세요");
            adapter.notifyDataSetChanged();
        });
    }
}