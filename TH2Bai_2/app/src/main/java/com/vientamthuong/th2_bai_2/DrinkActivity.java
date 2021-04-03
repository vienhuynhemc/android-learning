package com.vientamthuong.th2_bai_2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class DrinkActivity extends AppCompatActivity {

    // Khai báo các thuộc tính
    private RadioButton radioButton1;
    private RadioButton radioButton2;
    private RadioButton radioButton3;
    private RadioButton radioButton4;
    private Button buttonChonDoUong;
    // intent
    private Intent intentSendDataToMain;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_FULLSCREEN);
        setContentView(R.layout.activity_drink);
        // getview
        getView();
        // Khởi tạo
        init();
        // action
        action();
    }

    private void action() {
        // buttonDatMon
        actionButtonDatMon();
    }

    private void actionButtonDatMon() {
        buttonChonDoUong.setOnClickListener(v -> {
            String tenDoUong = radioButton1.getText().toString();
            if (radioButton2.isChecked()) {
                tenDoUong = radioButton2.getText().toString();
            } else if (radioButton3.isChecked()) {
                tenDoUong = radioButton3.getText().toString();
            } else if (radioButton4.isChecked()) {
                tenDoUong = radioButton4.getText().toString();
            }
            Bundle bundle = new Bundle();
            bundle.putString("data", tenDoUong);
            intentSendDataToMain.putExtra("data", bundle);
            setResult(MainActivity.DATA_DRINK_ACTIVITY, intentSendDataToMain);
            finish();
        });
    }

    private void init() {
        intentSendDataToMain = getIntent();
        String tenDoUong = intentSendDataToMain.getBundleExtra("data").getString("data");
        switch (tenDoUong) {
            case "Pepsi":
                radioButton1.setChecked(true);
                break;
            case "Heineken":
                radioButton2.setChecked(true);
                break;
            case "Tiger":
                radioButton3.setChecked(true);
                break;
            case "Sài Gòn Đỏ":
                radioButton4.setChecked(true);
                break;
        }
    }

    private void getView() {
        radioButton1 = findViewById(R.id.drink_radioButton_1);
        radioButton2 = findViewById(R.id.drink_radioButton_2);
        radioButton3 = findViewById(R.id.drink_radioButton_3);
        radioButton4 = findViewById(R.id.drink_radioButton_4);
        buttonChonDoUong = findViewById(R.id.drink_button_1);
    }


}
