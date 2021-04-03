package com.vientamthuong.th2_bai_2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class FoodActivity extends AppCompatActivity {

    // Khai báo các thuộc tính
    private RadioButton radioButton1;
    private RadioButton radioButton2;
    private RadioButton radioButton3;
    private RadioButton radioButton4;
    private Button buttonDatMon;
    // intent
    private Intent intentSendDataToMain;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_FULLSCREEN);
        setContentView(R.layout.activity_food);
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
        buttonDatMon.setOnClickListener(v -> {
            String tenMonAn = radioButton1.getText().toString();
            if (radioButton2.isChecked()) {
                tenMonAn = radioButton2.getText().toString();
            } else if (radioButton3.isChecked()) {
                tenMonAn = radioButton3.getText().toString();
            } else if (radioButton4.isChecked()) {
                tenMonAn = radioButton4.getText().toString();
            }
            Bundle bundle = new Bundle();
            bundle.putString("data", tenMonAn);
            intentSendDataToMain.putExtra("data", bundle);
            setResult(MainActivity.DATA_FOOD_ACTIVITY, intentSendDataToMain);
            finish();
        });
    }

    private void init() {
        intentSendDataToMain = getIntent();
        String tenMonAn = intentSendDataToMain.getBundleExtra("data").getString("data");
        switch (tenMonAn) {
            case "Phở Hà Nội":
                radioButton1.setChecked(true);
                break;
            case "Bún Bò Huế":
                radioButton2.setChecked(true);
                break;
            case "Mì Quảng":
                radioButton3.setChecked(true);
                break;
            case "Hủ Tíu Sài Gòn":
                radioButton4.setChecked(true);
                break;
        }
    }

    private void getView() {
        radioButton1 = findViewById(R.id.food_radioButton_1);
        radioButton2 = findViewById(R.id.food_radioButton_2);
        radioButton3 = findViewById(R.id.food_radioButton_3);
        radioButton4 = findViewById(R.id.food_radioButton_4);
        buttonDatMon = findViewById(R.id.food_button_1);
    }

}
