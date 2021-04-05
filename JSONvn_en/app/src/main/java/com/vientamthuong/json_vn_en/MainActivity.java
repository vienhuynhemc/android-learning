package com.vientamthuong.json_vn_en;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    // Khai báo các thuộc tính
    private TextView textViewVietNam;
    private TextView textViewEnglish;
    private TextView textViewHienThi;
    private ObjectLanguage objectLanguage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Xóa status bar
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);
        // Ánh xạ view
        getView();
        // init
        init();
        // action
        action();
    }

    private void action() {
        textViewVietNam.setOnClickListener(v -> showTextView("vn"));
        textViewEnglish.setOnClickListener(v -> showTextView("en"));
    }

    private void init() {
        objectLanguage = new ObjectLanguage(new JSONObject());
        new LoadJSONFile(objectLanguage).execute("https://khoapham.vn/KhoaPhamTraining/json/tien/demo3.json");
    }

    private void showTextView(String lang) {
        try {
            JSONObject j = objectLanguage.getJsonObject().getJSONObject(lang);
            String name = j.getString("name");
            String diaChi = j.getString("address");
            String course1 = j.getString("course1");
            String course2 = j.getString("course2");
            String course3 = j.getString("course3");
            textViewHienThi.setText(name + "\n" + diaChi + "\n" + course1 + "\n" + course2 + "\n" + course3);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private void getView() {
        textViewVietNam = findViewById(R.id.textView_1);
        textViewEnglish = findViewById(R.id.textView_2);
        textViewHienThi = findViewById(R.id.textView_3);
    }

}