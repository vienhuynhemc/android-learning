package com.vientamthuong.th2_bai_2;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    // Khai báo các thuộc tính
    private TextView textViewHienThi;
    private Button buttonChonThucAn;
    private Button buttonChonDoUong;
    private Button buttonThoat;
    // Biến lấy dữ liệu
    public static final int DATA_FOOD_ACTIVITY = 0;
    public static final int DATA_DRINK_ACTIVITY = 1;
    private Intent intentFoodActivity;
    private Intent intentDrinkActivity;
    // Thông tin món ăn
    private String tenThucAn;
    private String tenDoUong;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);
        // Ánh xạ view
        getView();
        // Khởi tạo
        init();
        // action
        actionButton();
    }

    private void init() {
        // FOOD_ACTIVITY
        intentFoodActivity = new Intent();
        intentFoodActivity.setClass(MainActivity.this, FoodActivity.class);
        // DRINK_ACTIVITY
        intentDrinkActivity = new Intent();
        intentDrinkActivity.setClass(MainActivity.this, DrinkActivity.class);
        // string
        tenDoUong = "";
        tenThucAn = "";
    }

    private void actionButton() {
        // button thoat
        actionButtonQuit();
        // button chọn thức ăn
        actionButtonChonThucAn();
        // button Chọn đồ uống
        actionButtonChonDoUong();
    }

    private void actionButtonChonDoUong() {
        buttonChonDoUong.setOnClickListener(v -> {
            Bundle bundle = new Bundle();
            bundle.putString("data", tenDoUong);
            intentDrinkActivity.putExtra("data", bundle);
            startActivityForResult(intentDrinkActivity, DATA_DRINK_ACTIVITY);
        });
    }

    private void actionButtonChonThucAn() {
        buttonChonThucAn.setOnClickListener(v -> {
            Bundle bundle = new Bundle();
            bundle.putString("data", tenThucAn);
            intentFoodActivity.putExtra("data", bundle);
            startActivityForResult(intentFoodActivity, DATA_FOOD_ACTIVITY);
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (data != null) {
            switch (resultCode) {
                case DATA_FOOD_ACTIVITY:
                    tenThucAn = data.getBundleExtra("data").getString("data");
                    break;
                case DATA_DRINK_ACTIVITY:
                    tenDoUong = data.getBundleExtra("data").getString("data");
                    break;
            }
            updateTextViewHienThi();
        }
    }

    @SuppressLint("SetTextI18n")
    private void updateTextViewHienThi() {
        textViewHienThi.setText(tenThucAn + " - " + tenDoUong);
    }

    private void actionButtonQuit() {
        buttonThoat.setOnClickListener(v -> finish());
    }

    private void getView() {
        textViewHienThi = findViewById(R.id.main_textView_2);
        buttonChonThucAn = findViewById(R.id.main_button_1);
        buttonChonDoUong = findViewById(R.id.main_button_2);
        buttonThoat = findViewById(R.id.main_button_3);
    }
}