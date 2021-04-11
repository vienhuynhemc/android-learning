package com.vientamthuong.bt1_th2_thay_toan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);
        Button button = findViewById(R.id.button_1);
        button.setOnClickListener(v -> {
            Intent intent = new Intent();
            intent.setClass(MainActivity.this,SecondActivity.class);
            startActivity(intent);
        });
    }
}