package com.vientamthuong.asynctask_loadimageinternet;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.vientamthuong.asynctask_loadimageinternet.asynTaskProcess.AsyncTaskLoadImg;
import com.vientamthuong.asynctask_loadimageinternet.recyclerViewShowImg.ShowImgAdapter;

public class MainActivity extends AppCompatActivity {

    // Khai báo thuộc tính
    private Button buttonTaiHinh;
    private RecyclerView recyclerViewHienThiHinh;
    private ProgressBar progressBarTienTrinh;
    private String[] linkImgs;
    private Bitmap[] bitmaps;
    private ShowImgAdapter showImgAdapter;
    private boolean isTaiDuLieu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Ẩn status bar
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
        buttonTaiHinh.setOnClickListener(v -> {
            if (isTaiDuLieu) {
                isTaiDuLieu = false;
                progressBarTienTrinh.setProgress(0);
                for (int i = 0; i < bitmaps.length; i++) {
                    bitmaps[i] = null;
                }
                showImgAdapter.notifyDataSetChanged();
            }
            new AsyncTaskLoadImg(MainActivity.this).execute(linkImgs);
        });
    }

    private void init() {
        // Lấy link hình và set tham số cho progressBar tiển trình
        linkImgs = getResources().getStringArray(R.array.name_img);
        progressBarTienTrinh.setMax(linkImgs.length * 10);
        // tạo mảng bitmaps
        bitmaps = new Bitmap[linkImgs.length];
        // recyclerView
        createRecyclerView();
    }

    private void createRecyclerView() {
        // layout
        GridLayoutManager gridLayoutManager = new GridLayoutManager(MainActivity.this, 3);
        gridLayoutManager.setOrientation(GridLayoutManager.VERTICAL);
        gridLayoutManager.setSmoothScrollbarEnabled(true);
        recyclerViewHienThiHinh.setLayoutManager(gridLayoutManager);
        // adapter
        showImgAdapter = new ShowImgAdapter(R.layout.view_holder_recycler_view, MainActivity.this, bitmaps);
        recyclerViewHienThiHinh.setAdapter(showImgAdapter);
    }

    private void getView() {
        buttonTaiHinh = findViewById(R.id.button_1);
        recyclerViewHienThiHinh = findViewById(R.id.recyclerView_1);
        progressBarTienTrinh = findViewById(R.id.progressBar_1);
    }

    // Getter and setter
    public ProgressBar getProgressBarTienTrinh() {
        return progressBarTienTrinh;
    }

    public Bitmap[] getBitmaps() {
        return bitmaps;
    }

    public ShowImgAdapter getShowImgAdapter() {
        return showImgAdapter;
    }

    public void setTaiDuLieu(boolean taiDuLieu) {
        isTaiDuLieu = taiDuLieu;
    }

}