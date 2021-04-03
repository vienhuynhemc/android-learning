package com.vientamthuong.th2;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class SignUpActivity extends AppCompatActivity {

    // Khai báo các thuộc tính
    private EditText editTextTenKhachHang;
    private EditText editTextEmail;
    private Button buttonGui;
    private Toast toast;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_FULLSCREEN);
        setContentView(R.layout.activity_sign_up);
        // Ánh xạ view
        getView();
        // Khởi tạo
        init();
        // Action
        action();
    }

    @SuppressLint("ShowToast")
    private void init() {
        toast = Toast.makeText(SignUpActivity.this, "", Toast.LENGTH_SHORT);
    }

    private void action() {
        // button
        actionButton();
    }

    private void actionButton() {
        buttonGui.setOnClickListener(v -> {
            String tenKhachHang = editTextTenKhachHang.getText().toString().trim();
            String email = editTextEmail.getText().toString().trim();
            if (tenKhachHang.length() == 0 || email.length() == 0) {
                toast.setText("Vui lòng điền đầy đủ thông tin");
                toast.show();
            } else {
                // Tạo inten
                Intent intent = new Intent();
                // Set class đến
                intent.setClass(SignUpActivity.this, WelcomeActivity.class);
                // Tạo gói dữ liệu
                Bundle bundle = new Bundle();
                bundle.putString("tenKhachHang", tenKhachHang);
                bundle.putString("email", email);
                intent.putExtra("data", bundle);
                // start
                startActivity(intent);
            }
        });
    }

    private void getView() {
        editTextTenKhachHang = findViewById(R.id.editText_1);
        editTextEmail = findViewById(R.id.editText_2);
        buttonGui = findViewById(R.id.button_1);
    }

}