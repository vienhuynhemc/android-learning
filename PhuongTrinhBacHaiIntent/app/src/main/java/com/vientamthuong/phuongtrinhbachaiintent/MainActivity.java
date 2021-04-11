package com.vientamthuong.phuongtrinhbachaiintent;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText editText1;
    private EditText editText2;
    private EditText editText3;
    private Button button1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);

        getView();
        action();
    }

    private void action() {
        button1.setOnClickListener(v -> {
            try {

                double number1 = Double.parseDouble(editText1.getText().toString());
                double number2 = Double.parseDouble(editText2.getText().toString());
                double number3 = Double.parseDouble(editText3.getText().toString());
                Bundle bundle = new Bundle();
                bundle.putDouble("a", number1);
                bundle.putDouble("b", number2);
                bundle.putDouble("c", number3);
                Intent intent = new Intent();
                intent.setClass(MainActivity.this, SecondActivity.class);
                intent.putExtra("data", bundle);
                startActivity(intent);
            } catch (Exception e) {
                Toast.makeText(MainActivity.this, "Plesea fill 3 number", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void getView() {
        editText1 = findViewById(R.id.editText_1);
        editText2 = findViewById(R.id.editText_2);
        editText3 = findViewById(R.id.editText_3);
        button1 = findViewById(R.id.button_1);
    }
}