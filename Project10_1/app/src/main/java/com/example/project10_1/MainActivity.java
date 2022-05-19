package com.example.project10_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btnResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("명화 선호도 조사");
        int voteCount[] = new int[9];

        for (int i = 0; i < 9; i++)
            voteCount[i] = 0;
        Integer ImageId[] = {R.id.iv1, R.id.iv2, R.id.iv3, R.id.iv4, R.id.iv5, R.id.iv6, R.id.iv7, R.id.iv8, R.id.iv9};

        final String imgName[] = {"독서하는 소녀", "꽃장식 모자 소녀", "부채를 든 소녀",

                "이레느깡 단 베르양", "잠자는 소녀", "테라스의 두 자매", "피아노 레슨", "피아노 앞의 소녀들",

                "해변에서"};

        ImageView image[] = new ImageView[9];
        for (int i = 0; i < ImageId.length; i++) {
            int index = i;
            image[index] = findViewById(ImageId[i]);

            image[index].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    voteCount[index]++;
                    Toast.makeText(MainActivity.this, imgName[index] + ": " + voteCount[index] + "표를 선택", Toast.LENGTH_SHORT).show();
                }
            });
        }

        btnResult = findViewById(R.id.btnResult);
        btnResult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ResultActivity.class);

                intent.putExtra("VoteCount", voteCount);
                intent.putExtra("ImgName", imgName);

                startActivity(intent);
            }
        });

    }
}