package com.vientamthuong.learning_14;

import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Lấy view
        Button button1 = findViewById(R.id.button_1);
        Button button2 = findViewById(R.id.button_2);
        Button button3 = findViewById(R.id.button_3);
        ConstraintLayout constraintLayout = findViewById(R.id.main_view);

        //  Tạo snackbar
        //  snackbar1
        Snackbar snackbar1 = Snackbar.make(constraintLayout, "Tạo snackbar đơn giản", Snackbar.LENGTH_SHORT);
        //  snackbar2
        Snackbar snackbar2 = Snackbar.make(constraintLayout, "Tạo snackbar có hàm callback", Snackbar.LENGTH_SHORT);
        snackbar2.setAction("Snackbar2", v -> Toast.makeText(MainActivity.this, "Bạn vừa click vào Snackbar2", Toast.LENGTH_SHORT).show());
        //  snackbar3
        Snackbar snackbar3 = Snackbar.make(constraintLayout, "Tạo snackbar với tùy chọn màu", Snackbar.LENGTH_SHORT);
        snackbar3.setAction("Snackbar3", v -> Toast.makeText(MainActivity.this, "Bạn vừa click vào Snackbar3", Toast.LENGTH_SHORT).show());
        snackbar3.setTextColor(getColor(R.color.teal_200));
        snackbar3.setActionTextColor(getColor(R.color.purple_200));
        snackbar3.setBackgroundTint(getColor(R.color.white));

        //  action for button
        button1.setOnClickListener(v -> snackbar1.show());
        button2.setOnClickListener(v -> snackbar2.show());
        button3.setOnClickListener(v -> snackbar3.show());

    }
}