package com.pbl.kimhuijae;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {
    //생성자
    public DBHelper(@Nullable Context context) {
        super(context, "student_information.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("CREATE TABLE student ( DNO CHAR(20) PRIMARY KEY, NAME INTEGER not null ,TEL CHAR(20), EMAIL CHAR(20) not null,PWD CHAR(20) not null);");
        db.execSQL("INSERT INTO student VALUES('1234','홍길동','010-1234-3287','hong@gmail.com','1234!');");
        db.execSQL("INSERT INTO student VALUES('5678','박문수','011-3333-2222','park@gmail.com','5678!');");
        db.execSQL("INSERT INTO student VALUES('9012','이순신','010-9999-2222','lee@gmail.com','9012!');");
        db.execSQL("INSERT INTO student VALUES('20174257','김희재','010-5291-5014','kimje@gmail.com','20174257!');");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS student");
        onCreate(db);
    }
}