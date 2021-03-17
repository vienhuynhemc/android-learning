package com.vientamthuong.baitaplinearlayout_dotplayscom_bai_2_lan_1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    //   Khai báo các biến
    private RecyclerView recyclerView;
    private RecyclerViewAdapter recyclerViewAdapter;
    private List<SubRecyclerViewObject> subRecyclerViewObjectList;
    private LinearLayoutManager linearLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Lấy view về
        getView();

        // Khởi tạo các thuộc tính cần thiết cho chương trình
        init();

        // thiết lập cho recyclerview bind với listobject
        setup();

    }

    private void setup() {
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(recyclerViewAdapter);
    }

    private void init() {
        // list object
        subRecyclerViewObjectList = new ArrayList<>();
        subRecyclerViewObjectList.add(new SubRecyclerViewObject("Chicken", "100 $", R.mipmap.ic_launcher_round));
        subRecyclerViewObjectList.add(new SubRecyclerViewObject("Beef", "100 $", R.mipmap.ic_launcher_round));
        subRecyclerViewObjectList.add(new SubRecyclerViewObject("Meat", "100 $", R.mipmap.ic_launcher_round));
        subRecyclerViewObjectList.add(new SubRecyclerViewObject("Cookies", "100 $", R.mipmap.ic_launcher_round));
        subRecyclerViewObjectList.add(new SubRecyclerViewObject("Menu", "100 $", R.mipmap.ic_launcher_round));
        // adapter
        recyclerViewAdapter = new RecyclerViewAdapter(subRecyclerViewObjectList, MainActivity.this);
        // layoutmanager
        linearLayoutManager = new LinearLayoutManager(MainActivity.this, LinearLayoutManager.VERTICAL, false);
    }

    private void getView() {
        recyclerView = findViewById(R.id.recyclerView_1);
    }

}