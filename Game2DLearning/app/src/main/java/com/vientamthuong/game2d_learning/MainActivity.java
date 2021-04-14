package com.vientamthuong.game2d_learning;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.vientamthuong.game2d_learning.loadData.LoadAnimation;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Xóa status bar
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);
        LoadAnimation loadAnimation = new LoadAnimation(MainActivity.this);
        loadAnimation.loadAnimation();
    }
}