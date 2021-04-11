package com.vientamthuong.phuongtrinhbachaiintent;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {

    private TextView textView2;
    private Button button1;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_FULLSCREEN);
        setContentView(R.layout.activity_second);

        getView();
        getData();
        action();
    }

    private void action() {
        button1.setOnClickListener(v -> finish());
    }

    private void getData() {
        Intent intent = getIntent();
        Bundle bundle = intent.getBundleExtra("data");
        double a = bundle.getDouble("a");
        double b = bundle.getDouble("b");
        double c = bundle.getDouble("c");
        double denta = b * b - 4 * a * c;
        if (denta < 0) {
            textView2.setText("Phương trình vô nghiệm!");
        } else if (denta == 0) {
            double nghiemKep = -b / (2 * a);
            textView2.setText("Phương trình có nghiệm kép x1 = x2 = " + nghiemKep);
        } else {
            double n1 = (-b - Math.sqrt(denta)) / (2 * a);
            double n2 = (-b + Math.sqrt(denta)) / (2 * a);
            textView2.setText("Phương trình có 2 nghiệm là x1 = " + n1 + " và x2 = " + n2);
        }
    }

    private void getView() {
        textView2 = findViewById(R.id.textView_2);
        button1 = findViewById(R.id.button_1);
    }
}
