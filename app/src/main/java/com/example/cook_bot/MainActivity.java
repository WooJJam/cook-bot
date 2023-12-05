package com.example.cook_bot;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toolbar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // "요리하기" 버튼 설정
        Button cookButton = findViewById(R.id.button_cook);
        cookButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // "요리하기" 버튼 클릭 시 다음 화면으로 이동
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                startActivity(intent);
            }
        });

        // 액션바 설정
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayShowTitleEnabled(false);  // 기본 타이틀을 감춤
        }
    }
}
