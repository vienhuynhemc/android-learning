package com.vientamthuong.uicomponentexampleadvance_lan_1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    // Khởi tạo các thuộc tính
    private RecyclerView recyclerView;
    private RegisterObject registerObject;
    private RegisterAdapter registerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //  Lấy view từ activity
        getView();
        // Khởi tạo
        init();
    }

    private void init() {
        // Khởi tạo reyclerview
        initRecyclerView();
    }

    private void initRecyclerView() {
        // managerlayout
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(MainActivity.this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);
        // adapter
        registerObject = new RegisterObject();
        registerAdapter = new RegisterAdapter(MainActivity.this, registerObject);
        recyclerView.setAdapter(registerAdapter);
    }

    private void getView() {
        recyclerView = findViewById(R.id.recyclerView_1);
    }

}