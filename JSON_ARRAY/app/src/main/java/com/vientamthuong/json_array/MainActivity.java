package com.vientamthuong.json_array;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ListView listView;
    private ArrayAdapter arrayAdapter;
    private List<String> listObject;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listView);
        listObject = new ArrayList<>();
        arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, listObject);
        listView.setAdapter(arrayAdapter);
        new AsynTaskReadJSON(this).execute("https://khoapham.vn/KhoaPhamTraining/json/tien/demo4.json");
    }

    public ArrayAdapter getArrayAdapter() {
        return arrayAdapter;
    }

    public List<String> getListObject() {
        return listObject;
    }
}