package com.example.project12_01;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    myDBHelper myDBHelper;
    SQLiteDatabase db;


    EditText edtName, edtNumber, edtNameResult, edtNumberResult;
    Button btnInit, btnInsert, btnUpdate, btnDelete, btnSelect;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edtName = findViewById(R.id.edtName);
        edtNumber = findViewById(R.id.edtNumber);
        edtNameResult = findViewById(R.id.edtNameResult);
        edtNumberResult = findViewById(R.id.edtNumberResult);

        btnInit = findViewById(R.id.btnInit);
        btnInsert = findViewById(R.id.btnInsert);
        btnSelect = findViewById(R.id.btnSelect);
        btnUpdate = findViewById(R.id.btnUpdate);
        btnDelete = findViewById(R.id.btnDelete);

        myDBHelper = new myDBHelper(this);
//        db = myDBHelper.getWritableDatabase();
//        db.close();

        /*//쿼리를 이용한 삽입
        btnInsert.setOnClickListener(view -> {
            db = myDBHelper.getWritableDatabase();
            db.execSQL("insert into groupTBL values('" + edtName.getText().toString() + "' , "
                    + edtNumber.getText().toString() + ");");
            db.close();
            edtNumber.setText("");
            edtName.setText("");
            //edtName.setFocusable(true);
            //키패드 없애기
            InputMethodManager im = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
            im.hideSoftInputFromWindow(edtName.getWindowToken(), 0);

            edtName.requestFocus();

            Toast.makeText(this, "입력완료", Toast.LENGTH_SHORT).show();
        });*/

        btnInsert.setOnClickListener(view -> {
            db = myDBHelper.getWritableDatabase();
            ContentValues values = new ContentValues();
            values.put("gName", edtName.getText().toString());
            values.put("gNumber", edtNumber.getText().toString());
            db.insert("groupTBL", null, values);

            edtNumber.setText("");
            edtName.setText("");
            //edtName.setFocusable(true);
            //키패드 없애기
            InputMethodManager im = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
            im.hideSoftInputFromWindow(edtName.getWindowToken(), 0);

            edtName.requestFocus();
        });
        btnSelect.setOnClickListener(view -> {
            db = myDBHelper.getWritableDatabase();
            Cursor cursor;
            cursor = db.rawQuery("select * from groupTBl;", null);

            String strNames = "그룹이름" + "\r\n" + "------------" + "\r\n";
            String strNumbers = "그룹인원" + "\r\n" + "------------" + "\r\n";
            while (cursor.moveToNext()) {
                strNames += cursor.getString(0) + "\r\n";
                strNumbers += cursor.getString(1) + "\r\n";
            }
            edtNameResult.setText(strNames);
            edtNumberResult.setText(strNumbers);

            cursor.close();
            db.close();
        });


    }

    public class myDBHelper extends SQLiteOpenHelper {

        public myDBHelper(@Nullable Context context) {
            super(context, "groupDB.db", null, 1);
        }


        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL("create table groupTBL (gName char(20) primary key, gNumber integer);");
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int i, int i1) {
            db.execSQL("drop table if exists groupTBL");
            onCreate(db);
        }
    }
}