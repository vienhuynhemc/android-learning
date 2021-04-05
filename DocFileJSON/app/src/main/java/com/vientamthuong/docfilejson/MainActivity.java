package com.vientamthuong.docfilejson;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.textView_1);
        new LoadFileJSON(textView).execute("https://khoapham.vn/KhoaPhamTraining/json/tien/demo1.json");
        new LoadFileJSONArray(textView).execute("https://khoapham.vn/KhoaPhamTraining/json/tien/demo2.json");
    }
}