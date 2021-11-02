package com.vientamthuong.learning_5;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private int baiHocHienTai;
    private TextView textView;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //  Khởi tạo thuộc tính ban đầu
        baiHocHienTai = 1;

        //  Lấy view
        textView = findViewById(R.id.textView_1);
        button = findViewById(R.id.button_1);

        button.setOnClickListener(v -> {
            baiHocHienTai++;
            textView.setText("Bài học hiện tại: " + baiHocHienTai);
        });

        textView.setText("Bài học hiện tại: " + baiHocHienTai);

    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("baihoc", baiHocHienTai);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        baiHocHienTai = savedInstanceState.getInt("baihoc");
        textView.setText("Bài học hiện tại: " + baiHocHienTai);
    }

}