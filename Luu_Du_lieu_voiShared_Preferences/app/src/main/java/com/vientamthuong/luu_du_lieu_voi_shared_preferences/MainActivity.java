package com.vientamthuong.luu_du_lieu_voi_shared_preferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    // Khai báo các thuộc tính
    private EditText editTextTaiKhoan;
    private EditText editTextMatKhau;
    private CheckBox checkBoxNhoMatKhau;
    private Button buttonDangNhap;
    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);
        // Ánh xạ view
        getView();
        // init
        init();
        // action
        actionForButton();
    }

    private void actionForButton() {
        buttonDangNhap.setOnClickListener(v -> {
            String taiKhoan = editTextTaiKhoan.getText().toString();
            String matKhau = editTextMatKhau.getText().toString();
            if (taiKhoan.equals("taiKhoan") && matKhau.equals("matKhau")) {
                Toast.makeText(MainActivity.this, "Đăng nhập thành công", Toast.LENGTH_SHORT).show();
                if (checkBoxNhoMatKhau.isChecked()) {
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putBoolean("nhoMatKhau", true);
                    editor.putString("taiKhoan", taiKhoan);
                    editor.putString("matKhau", matKhau);
                    editor.apply();
                }
                Intent intent = new Intent();
                intent.setClass(MainActivity.this, SuccessActivity.class);
                startActivity(intent);
                finish();
            } else {
                Toast.makeText(MainActivity.this, "Sai thông tin đăng nhập", Toast.LENGTH_SHORT).show();
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.remove("taiKhoan");
                editor.remove("matKhau");
                editor.remove("nhoMatKhau");
                editor.apply();
            }
        });
    }

    private void init() {
        sharedPreferences = getSharedPreferences("dataLogin", MODE_PRIVATE);
        editTextTaiKhoan.setText(sharedPreferences.getString("taiKhoan", ""));
        editTextMatKhau.setText(sharedPreferences.getString("matKhau", ""));
        checkBoxNhoMatKhau.setChecked(sharedPreferences.getBoolean("nhoMatKhau", false));
    }

    private void getView() {
        editTextTaiKhoan = findViewById(R.id.editText_1);
        editTextMatKhau = findViewById(R.id.editText_2);
        checkBoxNhoMatKhau = findViewById(R.id.checkBox_1);
        buttonDangNhap = findViewById(R.id.button_1);
    }
}