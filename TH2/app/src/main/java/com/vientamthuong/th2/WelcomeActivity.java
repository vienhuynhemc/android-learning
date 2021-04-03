package com.vientamthuong.th2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class WelcomeActivity extends AppCompatActivity {

    // Khai báo các thuộc tính
    private TextView textViewTenKhachHang;
    private TextView textViewEmail;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_FULLSCREEN);
        setContentView(R.layout.activity_welcome);
        // Ánh xạ view
        getView();
        // load dữ liệu
        loadData();
    }

    private void loadData() {
        // get data
        Intent intent = getIntent();
        Bundle bundle = intent.getBundleExtra("data");
        String tenKhachHang = bundle.getString("tenKhachHang");
        String email = bundle.getString("email");
        // set text
        textViewTenKhachHang.setText(tenKhachHang);
        textViewEmail.setText(email);
    }

    private void getView() {
        textViewTenKhachHang = findViewById(R.id.textView_7);
        textViewEmail = findViewById(R.id.textView_8);
    }

}
