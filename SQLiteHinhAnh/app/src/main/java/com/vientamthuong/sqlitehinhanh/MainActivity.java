package com.vientamthuong.sqlitehinhanh;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    public static Database database;
    @SuppressLint("StaticFieldLeak")
    public static AdapterView adapterView;
    public static List<DoVat> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);
        Button button = findViewById(R.id.button_them_do_vat);
        database = new Database(MainActivity.this, "database.sqlite", null, 1);
        list = database.getListDoVat();
        ListView listView = findViewById(R.id.listView_1);
        adapterView = new AdapterView(MainActivity.this, R.layout.custom_view, list);
        listView.setAdapter(adapterView);
        button.setOnClickListener(v -> {
            Intent intent = new Intent();
            intent.setClass(MainActivity.this, ThemDoVatActivity.class);
            startActivity(intent);
        });
    }
}