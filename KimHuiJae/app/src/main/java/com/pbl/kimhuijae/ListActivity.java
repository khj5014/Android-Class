package com.pbl.kimhuijae;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.ListView;

public class ListActivity extends AppCompatActivity {
    ListView lvList;
    DBHelper DBHelper;
    SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("기말고사 프로젝트");
        lvList = (ListView)findViewById(R.id.Email_list);

        displayList();
    }

    void displayList(){
        //Dbhelper의 읽기모드 객체를 가져와 SQLiteDatabase에 담아 사용준비
        DBHelper helper = new DBHelper(this);
        SQLiteDatabase database = helper.getReadableDatabase();

        //Cursor라는 그릇에 목록을 담아주기
        Cursor cursor = database.rawQuery("SELECT * FROM student",null);

        //리스트뷰에 목록 채워주는 도구인 adapter준비
        ListViewAdapter adapter = new ListViewAdapter();

        //목록의 개수만큼 순회하여 adapter에 있는 list배열에 add
        while(cursor.moveToNext()){
            //num 행은 가장 첫번째에 있으니 0번이 되고, name은 1번
            adapter.addItemToList(cursor.getString(3),cursor.getString(4));
        }

        lvList.setAdapter(adapter);

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent(ListActivity.this, LoginActivity.class);
        startActivity(intent);
    }
}
