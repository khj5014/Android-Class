package com.example.project7_1;

import android.graphics.Color;
import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.util.DisplayMetrics;
import android.util.Log;
import android.view.ContextMenu;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.MenuInflater;
import android.view.View;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.project7_1.databinding.ActivityMainBinding;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration appBarConfiguration;
    private ActivityMainBinding binding;
    CoordinatorLayout coordinator;
    View view;
    ConstraintLayout FirstFragment1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.toolbar);

        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        appBarConfiguration = new AppBarConfiguration.Builder(navController.getGraph()).build();
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);

        binding.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        FirstFragment1 = findViewById(R.id.FirstFragment1);
        registerForContextMenu(FirstFragment1);
    }

    //콘텍스트 메뉴 생성
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater menuInflater = getMenuInflater();
        if (v == FirstFragment1) {
            menu.setHeaderTitle("배경색 변경");
            menuInflater.inflate(R.menu.context1_menu, menu);
        }
    }

    //콘텍스트 메뉴 선택
    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        Button button_first = findViewById(R.id.button_first);
        switch (item.getItemId()) {
            case R.id.subRotate:
                button_first.setRotation(45);
                break;
            case R.id.subSize:
                button_first.setScaleX(3);
                button_first.setScaleY(2);
                break;
        }

        return super.onContextItemSelected(item);
    }

    //메뉴 생성
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.main_menu, menu);
        //메뉴 아이템 중에서 검색을 위해 정의한 아이템을 뷰 객체로 참조
        view = (LinearLayout) menu.findItem(R.id.search_button).getActionView();
        EditText editText = view.findViewById(R.id.editText);

        if (editText != null) {
            editText.setOnEditorActionListener(new TextView.OnEditorActionListener() {
                @Override
                public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                    Toast.makeText(getApplicationContext(), "입력되었습니다.", Toast.LENGTH_SHORT).show();
                    return false;
                }
            });
        }

        return true;
    }

    //옵션 아이템 선택
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        coordinator = findViewById(R.id.coordinator);


        switch (item.getItemId()) {
            case R.id.itemRed:
                coordinator.setBackgroundColor(Color.RED);
                break;
            case R.id.itemBlue:
                coordinator.setBackgroundColor(Color.BLUE);
                break;
            case R.id.refresh:
                toast();
                break;
        }

        return true;
    }

    public void toast() {
        Toast msg = Toast.makeText(this, "refresh click", Toast.LENGTH_SHORT);
        DisplayMetrics metrics = getResources().getDisplayMetrics();

        int width = (int) (Math.random() * metrics.widthPixels);
        int height = (int) (Math.random() * metrics.heightPixels);

        Log.i("tag : ", "width: " + width + "");
        Log.i("tag : ", "height: " + height + "");

        msg.setGravity(Gravity.LEFT | Gravity.TOP, width, height);
        msg.show();

    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        return NavigationUI.navigateUp(navController, appBarConfiguration)
                || super.onSupportNavigateUp();
    }
}