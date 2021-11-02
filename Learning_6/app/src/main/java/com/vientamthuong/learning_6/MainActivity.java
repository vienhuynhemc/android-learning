package com.vientamthuong.learning_6;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private CheckBox checkBox_1;
    private CheckBox checkBox_2;
    private CheckBox checkBox_3;
    private CheckBox checkBox_4;
    private Button buttonKetQua;
    private Button buttonGoiY;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Lấy view
        checkBox_1 = findViewById(R.id.checkBox_1);
        checkBox_2 = findViewById(R.id.checkBox_2);
        checkBox_3 = findViewById(R.id.checkBox_3);
        checkBox_4 = findViewById(R.id.checkBox_4);
        buttonKetQua = findViewById(R.id.button_1);
        buttonGoiY = findViewById(R.id.button_2);

        //  Action cho cac checkbox
        checkBox_1.setOnClickListener(getActionCheckBox());
        checkBox_2.setOnClickListener(getActionCheckBox());
        checkBox_3.setOnClickListener(getActionCheckBox());
        checkBox_4.setOnClickListener(getActionCheckBox());


        //  Action cho button goi y
        buttonGoiY.setOnClickListener(getActionButtonGoiY());

        //  Action cho button ket qua
        buttonKetQua.setOnClickListener(getActionButtonKetQua());

    }

    private View.OnClickListener getActionCheckBox() {
        return v -> Toast.makeText(MainActivity.this, ((CheckBox) v).getText() + " | " + ((CheckBox) v).isChecked(), Toast.LENGTH_SHORT).show();
    }

    private View.OnClickListener getActionButtonKetQua() {
        return v -> {
            if (!checkBox_3.isChecked() && !checkBox_1.isChecked() && !checkBox_2.isChecked() && !checkBox_4.isChecked()) {
                Toast.makeText(MainActivity.this, "Chọn đáp án đi má ơi", Toast.LENGTH_SHORT).show();
            } else {
                if (checkBox_3.isChecked() && !checkBox_1.isChecked() && !checkBox_2.isChecked() && !checkBox_4.isChecked()) {
                    Toast.makeText(MainActivity.this, "Đúng rồi", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, "Sai rồi", Toast.LENGTH_SHORT).show();
                }
                checkBox_1.setChecked(true);
                checkBox_2.setChecked(true);
                checkBox_3.setChecked(true);
                checkBox_4.setChecked(true);
                checkBox_1.setEnabled(false);
                checkBox_2.setEnabled(false);
                checkBox_4.setEnabled(false);
                checkBox_3.setTextColor(Color.RED);
            }
        };
    }

    private View.OnClickListener getActionButtonGoiY() {
        return v -> {
            checkBox_1.setChecked(false);
            checkBox_2.setChecked(false);
            checkBox_3.setChecked(true);
            checkBox_4.setChecked(false);
        };
    }

}