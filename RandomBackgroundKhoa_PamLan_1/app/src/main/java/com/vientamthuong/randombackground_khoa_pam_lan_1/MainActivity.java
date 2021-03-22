package com.vientamthuong.randombackground_khoa_pam_lan_1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    // Khai báo biến
    private List<Integer> listBackGround;
    private LinearLayout linearLayout;
    private Random random;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Ánh xạ view
        getView();
        // Khởi tạo
        init();
        // Đổi backgrond
        setBackground();
    }

    private void setBackground(){
        linearLayout.setBackground(getDrawable(listBackGround.get(random.nextInt(listBackGround.size()))));
    }

    private void getView(){
        linearLayout = findViewById(R.id.linearLayout_1);
    }

    private void init(){
        // list background
        listBackGround = new ArrayList<>();
        listBackGround.add(R.drawable.h1);
        listBackGround.add(R.drawable.h2);
        listBackGround.add(R.drawable.h3);
        listBackGround.add(R.drawable.h4);
        listBackGround.add(R.drawable.h5);
        listBackGround.add(R.drawable.h6);
        // random
        random = new Random();
    }
}