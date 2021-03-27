package com.vientamthuong.demngayxaem_khoa_pham_lan_1;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Date;

public class MainActivity extends AppCompatActivity {

    // Khai báo các thuộct tính
    private Button buttonDemNgay;
    private EditText editTextChonNgayDen;
    private EditText editTextChonNgayDi;
    private TextView textViewHienThi;
    private DatePickerDialog datePickerDialogNgayDen, datePickerDialogNgayDi;
    private Date dateNgayDen;
    private Date dateNgayDi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);

        // ánh xạ view
        anhXaView();
        // init()
        init();
        // action
        action();
    }

    private void action() {
        editTextChonNgayDen.setOnFocusChangeListener((v, hasFocus) -> {
            if (hasFocus) {
                datePickerDialogNgayDen.show();
            }
        });
        editTextChonNgayDi.setOnFocusChangeListener((v, hasFocus) -> {
            if (hasFocus) {
                datePickerDialogNgayDi.show();
            }
        });
        buttonDemNgay.setOnClickListener(v -> {
            if (dateNgayDen != null && dateNgayDi != null) {
                textViewHienThi.setText("Bên nhau được: " + ((dateNgayDi.getTime() - dateNgayDen.getTime()) / (1000 * 60 * 60 * 24)) + " ngày");
            } else {
                Toast.makeText(MainActivity.this, "Vui lòng điền đầy đủ thông tin", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void init() {
        datePickerDialogNgayDen = new DatePickerDialog(MainActivity.this, (view, year, month, dayOfMonth) -> {
            editTextChonNgayDen.setText(dayOfMonth + "/" + (month + 1) + "/" + year);
            dateNgayDen = new Date(year, month, dayOfMonth);
        }, 2020, 4, 5);
        datePickerDialogNgayDi = new DatePickerDialog(MainActivity.this, (view, year, month, dayOfMonth) -> {
            editTextChonNgayDi.setText(dayOfMonth + "/" + (month + 1) + "/" + year);
            dateNgayDi = new Date(year, month, dayOfMonth);
        }, 2020, 4, 5);

    }

    private void anhXaView() {
        buttonDemNgay = findViewById(R.id.button_1);
        editTextChonNgayDen = findViewById(R.id.editText_1);
        editTextChonNgayDi = findViewById(R.id.editText_2);
        textViewHienThi = findViewById(R.id.textView_1);
    }
}