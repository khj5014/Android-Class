package com.pbl.kimhuijae;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    DBHelper DBHelper;
    SQLiteDatabase db;
    EditText edtID, edtPassword;
    Button btnlogin;
    String SQL;
    Cursor cursor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        DBHelper = new DBHelper(this);
        db = DBHelper.getReadableDatabase();
//        db.close();

        edtID = findViewById(R.id.ID);
        edtPassword = findViewById(R.id.PASSWORD);
        btnlogin = findViewById(R.id.btnLogin);

        btnlogin.setOnClickListener(v -> {
            db = DBHelper.getWritableDatabase();
            String id = edtID.getText().toString();
            String pw = edtPassword.getText().toString();

            if (id.length() == 0 || pw.length() == 0) {
                //아이디와 비밀번호는 필수 입력사항입니다.
                Toast toast = Toast.makeText(LoginActivity.this, "아이디와 비밀번호는 필수 입력사항입니다.", Toast.LENGTH_SHORT);
                toast.show();
                return;
            }
            //쿼리
            SQL = "SELECT * FROM student WHERE EMAIL = '" + id + "'";
            //커서
            cursor = db.rawQuery(SQL, null);

            //아이디 검사
            if (cursor.getCount() != 1) {
                //아이디가 틀렸을 때
                Toast.makeText(LoginActivity.this, "존재하지 않는 아이디입니다.", Toast.LENGTH_SHORT).show();
                return;
            }

            cursor.moveToNext();

            //비밀번호 검사
            if (!pw.equals(cursor.getString(4))) {
                //비밀번호가 틀렸습니다.
                Toast.makeText(LoginActivity.this, "비밀번호가 틀렸습니다.", Toast.LENGTH_SHORT).show();
                AlertDialog.Builder dig = new AlertDialog.Builder(this);
                dig.setTitle("로그인 실패!"); //제목
                dig.setMessage("이메일과 패스워드를 확인하시오"); // 메시지
                dig.setIcon(R.drawable.logo); // 아이콘 설정

                //버튼 클릭시 동작
                dig.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                dig.setNegativeButton("취소", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                dig.show();
            } else {
                Toast.makeText(LoginActivity.this, "로그인 성공", Toast.LENGTH_SHORT).show();

                AlertDialog.Builder dig = new AlertDialog.Builder(this);
                dig.setTitle("로그인 성공!"); //제목
                dig.setMessage("다음 화면으로 이동하시겠습니까?"); // 메시지
                dig.setIcon(R.drawable.logo); // 아이콘 설정

                //버튼 클릭시 동작
                dig.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        //회원 리스트로 이동
                        Intent intent = new Intent(LoginActivity.this, ListActivity.class);
                        startActivity(intent);

                        finish();
                    }
                });
                dig.setNegativeButton("취소", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                dig.show();
            }

            cursor.close();

        });
    }
}
