package com.vientamthuong.giaiphuongtrinhbacnhat_lan_1;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    //   Khởi tạo các biến
    private EditText etHeSoA;
    private EditText etHeSoB;
    private EditText etHeSoC;
    private Button btGiaiPhuongTrinh;
    private TextView tvShowKetQua;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Lấy view
        getView();
        // Gán action cho button
        setActionForBtGiaiPhuongTrinh();
    }

    private void setActionForBtGiaiPhuongTrinh() {
        // Gán action for button
        btGiaiPhuongTrinh.setOnClickListener(getOnlickForButton());
    }

    @SuppressLint({"SetTextI18n", "DefaultLocale"})
    private View.OnClickListener getOnlickForButton() {
        return v -> {
            try {
                // Lấy 2 hệ số a và b
                double heSoA = Double.parseDouble(etHeSoA.getText().toString());
                double heSoB = Double.parseDouble(etHeSoB.getText().toString());
                double heSoC = Double.parseDouble(etHeSoC.getText().toString());
                // Tính toán kết quả
                double ketQua = (heSoC - heSoB) / heSoA;
                //  Show kết quả
                tvShowKetQua.setText(getString(R.string.result_1) +"   "+ String.format("%.2f", ketQua));
            } catch (Exception e) {
                // Nếu như có vấn đề về parse thì có nghĩa là người dùng chưa nhập số
                // Khi đó show cho người ta biết
                tvShowKetQua.setText(getString(R.string.error_1));
            }
        };
    }

    private void getView() {
        etHeSoA = findViewById(R.id.editText_1);
        etHeSoB = findViewById(R.id.editText_2);
        etHeSoC = findViewById(R.id.editText_3);
        btGiaiPhuongTrinh = findViewById(R.id.button_1);
        tvShowKetQua = findViewById(R.id.textView_3);
    }

}