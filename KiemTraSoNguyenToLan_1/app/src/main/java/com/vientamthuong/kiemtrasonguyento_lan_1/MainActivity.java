package com.vientamthuong.kiemtrasonguyento_lan_1;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    // Khởi tạo các biến
    // View
    private TextView tvShowResult;
    private EditText etInputFromEndUser;
    private Button btCheck;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Lấy các view từ activity về
        getView();
        // Xử lý sự kiện click cho button
        setActionForButton();

    }

    @SuppressLint("SetTextI18n")
    private void setActionForButton() {
        // Button kiểm tra
        btCheck.setOnClickListener(v -> {
            try {
                // Lấy số input
                int inputNumber = Integer.parseInt(etInputFromEndUser.getText().toString());
                // Kiểm tra và show kết quả ra textView
                if (isSoNguyenTo(inputNumber)) {
                    tvShowResult.setText(inputNumber + " là số nguyên tố");
                } else {
                    tvShowResult.setText(inputNumber + " không phải làsố nguyên tố");
                }
            } catch (Exception e) {
                // Nếu như người dùng chưa nhập
                // Hiển thị ra textView cho người ta bíết
                tvShowResult.setText("Vui lòng nhập số để kiểm tra");
            }
        });
    }

    private boolean isSoNguyenTo(int number) {
        // Kiểm tra có là 0 hoặc 1
        if (number < 2) {
            return false;
        }
        // Kiểm tra có chia hết cho số nào nữa từ 2 tới n -1
        for (int i = 2; i < number; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }

    private void getView() {
        tvShowResult = findViewById(R.id.textView_1);
        etInputFromEndUser = findViewById(R.id.editText_1);
        btCheck = findViewById(R.id.button_1);
    }
}