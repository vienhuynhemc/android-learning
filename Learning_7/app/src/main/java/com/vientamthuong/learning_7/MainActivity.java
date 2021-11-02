package com.vientamthuong.learning_7;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private TextView textViewKetQua;
    private RadioButton ketQua1;
    private RadioButton ketQua2;
    private RadioButton ketQua3;
    private Button buttonKetQua;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
        addAction();

    }

    private void addAction() {
        //  radiobutton
        ketQua1.setOnCheckedChangeListener(getActionRadiobutton());
        ketQua2.setOnCheckedChangeListener(getActionRadiobutton());
        ketQua3.setOnCheckedChangeListener(getActionRadiobutton());

        //button
        buttonKetQua.setOnClickListener(getActionButton());
    }

    private void init() {
        // Lấy View
        textViewKetQua = findViewById(R.id.textView_1);
        buttonKetQua = findViewById(R.id.button_1);
        ketQua1 = findViewById(R.id.radioButton_1);
        ketQua2 = findViewById(R.id.radioButton_2);
        ketQua3 = findViewById(R.id.radioButton_3);
    }

    private CompoundButton.OnCheckedChangeListener getActionRadiobutton() {
        return (buttonView, isChecked) -> {
            if (isChecked) {
                textViewKetQua.setText("Bạn chọn: " + buttonView.getText().toString().trim());
            }
        };
    }

    private View.OnClickListener getActionButton() {
        return v -> {
            if (ketQua1.isChecked() || ketQua2.isChecked() || ketQua3.isChecked()) {
                if (ketQua3.isChecked()) {
                    textViewKetQua.setText("Đúng rồi");
                } else {
                    textViewKetQua.setText("Sai rồi");
                }
            }
        };
    }

}