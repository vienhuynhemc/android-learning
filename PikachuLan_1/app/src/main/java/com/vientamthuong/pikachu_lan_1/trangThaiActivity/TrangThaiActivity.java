package com.vientamthuong.pikachu_lan_1.trangThaiActivity;

import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class TrangThaiActivity {

    private AppCompatActivity appCompatActivity;

    public TrangThaiActivity(AppCompatActivity appCompatActivity) {
        this.appCompatActivity = appCompatActivity;
    }

    public void hiddenStatusBar() {
        appCompatActivity.getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_FULLSCREEN);
    }

}
