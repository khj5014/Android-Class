package com.example.project4_2;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Switch chk;
    TextView textView2;
    RadioGroup rgroup;
    RadioButton rdoCat, rdoDog, rdoRabbit;
    Button btnOk, finishbt, reset;
    ImageView img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("애완동물 선호도 조사");

        chk = findViewById(R.id.chkAgree);
        textView2 = findViewById(R.id.textView2);
        rgroup = findViewById(R.id.rdoGroup);
        img = findViewById(R.id.imgPet);
        finishbt = findViewById(R.id.finishbt);
        reset = findViewById(R.id.reset);

        chk.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (chk.isChecked()) {
                    textView2.setVisibility(View.VISIBLE);
                    rgroup.setVisibility(View.VISIBLE);
                    reset.setVisibility(View.VISIBLE);
                    finishbt.setVisibility(View.VISIBLE);
                } else {
                    textView2.setVisibility(View.INVISIBLE);
                    rgroup.setVisibility(View.INVISIBLE);
                    img.setVisibility(View.GONE);
                    finishbt.setVisibility(View.INVISIBLE);
                    reset.setVisibility(View.INVISIBLE);
                }
            }
        });
        rgroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {

                img.setVisibility(View.VISIBLE);
                switch (rgroup.getCheckedRadioButtonId()) {
                    case R.id.rdocat:
                        img.setImageResource(R.drawable.cat);
                        break;
                    case R.id.rdodog:
                        img.setImageResource(R.drawable.dog);
                        break;
                    case R.id.rdorabbit:
                        img.setImageResource(R.drawable.rabbit);
                        break;
                }
            }
        });

        finishbt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finishAffinity();
            }
        });

        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rgroup.clearCheck();
                chk.setChecked(false);
                img.setVisibility(view.GONE);
            }
        });
    }
}