package com.vientamthuong.learning_4_1;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class DisplayActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_3);

        //  Lấy view
        TextView textView = findViewById(R.id.textView_2);
        Button button = findViewById(R.id.button_3);

        //  Lấy intent và dữ liệu
        Intent intent = getIntent();
        String data = intent.getStringExtra("data");

        //  Set dữ liệu cho textView
        textView.setText(data);

        //  Add action cho button
        button.setOnClickListener(v -> {
            finish();
            Toast.makeText(getApplicationContext(), "Trờ về Activity 1", Toast.LENGTH_SHORT).show();
        });

    }

}
