package com.vientamthuong.learning_16;

import androidx.appcompat.app.AppCompatActivity;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.TextView;

import com.vientamthuong.learning_16.behavior.FirstBehavior;
import com.vientamthuong.learning_16.recyclerView.BasicRecyclerViewAdapter;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView1 = findViewById(R.id.recyclerView_1);
        RecyclerView recyclerView2 = findViewById(R.id.recyclerView_2);

        String[] arWords = new String[] {
                "Phần Tử 1", "Phần Tử 2",
                "Phần Tử 3", "Phần Tử 4",
                "Phần Tử 5", "Phần Tử 6",
                "Phần Tử 7", "Phần Tử 8", "Phần Tử 9", "Phần Tử 10",
                "Phần Tử 11", "Phần Tử 12", "Phần Tử 13", "Phần Tử 14",
                "Phần Tử 15", "Phần Tử 16", "Phần Tử 17",
                "Phần Tử 18", "Phần Tử 19", "Phần Tử 20", "Phần Tử 21",
                "Phần Tử 22", "Phần Tử 23", "Phần Tử 24", "Phần Tử 25"};

        BasicRecyclerViewAdapter basicRecyclerViewAdapter = new BasicRecyclerViewAdapter(Arrays.asList(arWords));
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(MainActivity.this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        LinearLayoutManager linearLayoutManager2 = new LinearLayoutManager(MainActivity.this);
        linearLayoutManager2.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView1.setLayoutManager(linearLayoutManager);
        recyclerView1.setAdapter(basicRecyclerViewAdapter);
        recyclerView2.setLayoutManager(linearLayoutManager2);
        recyclerView2.setAdapter(basicRecyclerViewAdapter);
    }
}