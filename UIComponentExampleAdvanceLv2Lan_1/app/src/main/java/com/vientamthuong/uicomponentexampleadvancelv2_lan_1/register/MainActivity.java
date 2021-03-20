package com.vientamthuong.uicomponentexampleadvancelv2_lan_1.register;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import com.vientamthuong.uicomponentexampleadvancelv2_lan_1.R;
import com.vientamthuong.uicomponentexampleadvancelv2_lan_1.selectBirthDay.BirthDay;

public class MainActivity extends AppCompatActivity {

    //  Khai báo các biến
    // EditText
    private EditText etHoVaTen;
    private EditText etDienThoai;
    private EditText etEmail;
    private EditText etDiaChi;
    // button
    private Button btChonNgaySinh;
    // textView
    private TextView tvHienThiNgaySinh;

    // Liên quan đến chọn ngày sinh
    // datePickedDialog
    private DatePickerDialog datePickerDialog;
    // birthDay
    private BirthDay birthDay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Lấy view từ activity
        getViewFromActivity();
        // Khởi tạo các phần tử
        init();
        // set action cho các phần tử
        setActionForComponent();

    }

    private void init() {
        // tạo các thứ liên quan đến ngày sinh
        initSelectDay();
    }

    private void getViewFromActivity() {
        // EditText
        etHoVaTen = findViewById(R.id.register_editText_1);
        etDienThoai = findViewById(R.id.register_editText_2);
        etEmail = findViewById(R.id.register_editText_3);
        etDiaChi = findViewById(R.id.register_editText_4);
        // button
        btChonNgaySinh = findViewById(R.id.register_button_1);
        // textView
        tvHienThiNgaySinh = findViewById(R.id.register_textView_1);

    }

    private void setActionForComponent() {
        // button chọn ngày sinh
        setActionForButtonChonNgaySinh();
    }

    private void setActionForButtonChonNgaySinh() {
        btChonNgaySinh.setOnClickListener(v -> {
            // Mỗi lần click thì show bảng chọn ngày
            datePickerDialog.show();
        });
    }

    private void initSelectDay() {
        // tạo birthDay , mặc định là 1 - 1 -2000
        birthDay = new BirthDay(1, 1, 2000);
        // tạo datePickedDialog
        datePickerDialog = new DatePickerDialog(MainActivity.this, (view, year, month, dayOfMonth) -> {
            // set lại cho birth day mỗi khi có sự chon lựa ngày mới, và tvHienThiNgaySinh
            birthDay.setDay(dayOfMonth);
            birthDay.setMonth(month+1);
            birthDay.setYear(year);
            tvHienThiNgaySinh.setText(birthDay.toString());
        }, 2000, 0, 1);
    }

}