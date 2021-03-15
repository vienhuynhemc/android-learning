package com.vientamthuong.giaiphuongtrinhbachai_lan_1;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    // Khởi tạo các biến
    // view
    private EditText etHeSoA;
    private EditText etHeSoB;
    private EditText etHeSoC;
    private EditText etHeSoD;
    private TextView tvShowResult;
    private Button btCheck;
    // Toask
    private Toast errorToast;
    private Toast succesToast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Khởi tạo các biết khác view
        initOrderVariable();
        // Lấy view từ activity
        getViewFromActivity();
        // set action for button
        setActionForButton();
    }

    @SuppressLint("ShowToast")
    private void initOrderVariable() {
        errorToast = Toast.makeText(MainActivity.this, "Thiếu dữ liệu", Toast.LENGTH_SHORT);
        succesToast = Toast.makeText(MainActivity.this, "Giải thành công", Toast.LENGTH_SHORT);
    }

    @SuppressLint({"SetTextI18n", "DefaultLocale"})
    private void setActionForButton() {
        btCheck.setOnClickListener(v -> {
            try {
                // lấy 4 hệ số
                double heSoA = Double.parseDouble(etHeSoA.getText().toString());
                double heSoB = Double.parseDouble(etHeSoB.getText().toString());
                double heSoC = Double.parseDouble(etHeSoC.getText().toString());
                double heSoD = Double.parseDouble(etHeSoD.getText().toString());
                // Tính denta
                double denta = heSoB * heSoB - 4 * heSoA * (heSoC - heSoD);
                // Nếu denta nhỏ hơn không thì phương trình vô nghiệm
                if (denta < 0) {
                    tvShowResult.setText("Phương trình vô nghiệm");
                } else if (denta == 0) {
                    // bằng 0 thì có nghiệm kép
                    String nghiemKep = String.format("%.2f", -heSoB / (2 * heSoA));
                    tvShowResult.setText("Phương trình có nghiệm kép x1 = x2 = " + nghiemKep);
                } else {
                    // lớn hơn 0 thì 2 nghiệm phân biệt
                    double x1 = (-heSoB - Math.sqrt(denta)) / (2 * heSoA);
                    double x2 = (-heSoB + Math.sqrt(denta)) / (2 * heSoA);
                    tvShowResult.setText("x1 = " + String.format("%.2f", x1) + " \nx2 = " + String.format("%.2f", x2));
                }
                // Thông báo giải thành công
                showSuccess();
            } catch (Exception e) {
                // Nếu như thiếu dữ liệu thì sẽ ra ngoại lệ này
                // show ở kết quả và Toast
                showError();
            }
        });
    }

    private void showSuccess() {
        succesToast.show();
    }

    @SuppressLint("SetTextI18n")
    private void showError() {
        tvShowResult.setText("Vui lòng điền đầy đủ 4 hệ số");
        errorToast.show();
    }

    private void getViewFromActivity() {
        etHeSoA = findViewById(R.id.editText_1);
        etHeSoB = findViewById(R.id.editText_2);
        etHeSoC = findViewById(R.id.editText_3);
        etHeSoD = findViewById(R.id.editText_4);
        tvShowResult = findViewById(R.id.textView_7);
        btCheck = findViewById(R.id.button_1);
    }


}