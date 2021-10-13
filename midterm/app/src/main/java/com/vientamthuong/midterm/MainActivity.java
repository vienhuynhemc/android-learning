package com.vientamthuong.midterm;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    private AppCompatButton b1;
    private AppCompatButton b2;
    private AppCompatButton b3;

    private Database database;

    DialogThemNhacSi dialogThemNhacSi;
    DialogXemNhacSi dialogXemNhacSi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("LTDD - Giữa kỳ");
        setContentView(R.layout.activity_main);
        database = new Database(MainActivity.this, "midterm.sqlite", null, 1);
        dialogThemNhacSi = new DialogThemNhacSi(MainActivity.this);

        b1 = findViewById(R.id.b1);
        b2 = findViewById(R.id.b2);
        b3 = findViewById(R.id.b3);
        b1.setOnClickListener(v -> {
            dialogThemNhacSi.show();
        });
        b2.setOnClickListener(v -> {
            dialogXemNhacSi = new DialogXemNhacSi(MainActivity.this);
            dialogXemNhacSi.show();
        });
    }

    public Database getDatabase() {
        return database;
    }
}