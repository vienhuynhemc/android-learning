package com.vientamthuong.pikachu_lan_1.startActivity;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.vientamthuong.pikachu_lan_1.R;
import com.vientamthuong.pikachu_lan_1.mainActivity.MainActivity;
import com.vientamthuong.pikachu_lan_1.trangThaiActivity.TrangThaiActivity;

public class StartActivity extends AppCompatActivity {

    // Khai báo các thuộc tính
    // Biến để làm các vấn đề về activity
    private TrangThaiActivity trangThaiActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        // khởi tạo
        init();
    }

    private void init() {
        // Trạng thái activity
        trangThaiActivity = new TrangThaiActivity(StartActivity.this);
        // Ẩn status bar
        trangThaiActivity.hiddenStatusBar();
    }
}
