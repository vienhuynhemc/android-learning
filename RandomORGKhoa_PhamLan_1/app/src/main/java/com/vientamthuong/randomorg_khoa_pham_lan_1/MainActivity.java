package com.vientamthuong.randomorg_khoa_pham_lan_1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    // Khai báo các biến
    private TextView tvShowResult;
    private EditText etInputNumberOne;
    private EditText etInputNumberTwo;
    private Button btCreateRandomNumber;
    // random
    private Random random;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Ánh xạ các view từ activity
        getView();
        // Khởi tạo
        init();
        // action
        setAction();

    }

    private void setAction() {
        // button create
        setActionForButtonCreate();
    }

    private void setActionForButtonCreate() {
        btCreateRandomNumber.setOnClickListener(v -> {
            try {
                int numberOne = Integer.parseInt(etInputNumberOne.getText().toString().trim());
                int numberTwo = Integer.parseInt(etInputNumberTwo.getText().toString().trim());
                int space = numberOne >= numberTwo ? numberOne - numberTwo : numberTwo - numberOne;
                space++;
                tvShowResult.setText(random.nextInt(space) + (numberOne >= numberTwo ? numberTwo : numberOne) + "");
            } catch (Exception e) {
                Toast.makeText(MainActivity.this, "Vui lòng nhập đầy đủ thông tin", Toast.LENGTH_SHORT);
            }
        });
    }

    private void init() {
        random = new Random();
    }

    private void getView() {
        tvShowResult = findViewById(R.id.textView_2);
        etInputNumberOne = findViewById(R.id.editText_1);
        etInputNumberTwo = findViewById(R.id.editText_2);
        btCreateRandomNumber = findViewById(R.id.button_1);
    }

}