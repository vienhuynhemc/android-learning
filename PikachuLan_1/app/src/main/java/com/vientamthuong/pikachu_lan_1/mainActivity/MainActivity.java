package com.vientamthuong.pikachu_lan_1.mainActivity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;

import android.os.Bundle;
import android.view.View;

import com.vientamthuong.pikachu_lan_1.R;
import com.vientamthuong.pikachu_lan_1.trangThaiActivity.TrangThaiActivity;

public class MainActivity extends AppCompatActivity {

    // Khai báo các thuộc tính
    // Biến để làm các vấn đề về activity
    private TrangThaiActivity trangThaiActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // khởi tạo
        init();
    }

    private void init() {
        // Trạng thái activity
        trangThaiActivity = new TrangThaiActivity(MainActivity.this);
        // Ẩn status bar
        trangThaiActivity.hiddenStatusBar();

    }

}