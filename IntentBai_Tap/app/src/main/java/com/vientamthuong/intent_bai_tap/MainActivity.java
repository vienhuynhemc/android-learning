package com.vientamthuong.intent_bai_tap;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.vientamthuong.intent_bai_tap.idImg.IdImg;
import com.vientamthuong.intent_bai_tap.selectHinh.SelectHinhAdapter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    // Khai báo các thuộc tính
    private ImageView imageViewHinhMau;
    private ImageView imageViewChonHinh;
    private List<String> listNameImage;
    private Random random;
    private Dialog dialog;
    private IdImg idImg;
    private int indexValueRoot;
    private ImageView imageViewDoiHinhMoi;
    private TextView textViewHienThiDiem;
    private int diem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Xóa status bar
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);
        // Ánh xạ view
        getView();
        // Khởi tạo
        init();
        // action
        action();
    }

    @SuppressLint("SetTextI18n")
    private void init() {
        String[] arrayString = getResources().getStringArray(R.array.array_hinh);
        listNameImage = Arrays.asList(arrayString);
        random = new Random();
        idImg = new IdImg(-1);
        diem = 100;
        textViewHienThiDiem.setText(diem + "");
        // random 2 imgage
        randomHinhMauVaChonHinh();
        // Tạo dialog
        createDialog();
    }

    private void action() {
        // action chon hinh
        actionImageViewChonHinh();
        // action dialog
        actionDialog();
        // action doi hinh moi
        actionDoiHinhMoi();
    }

    private void actionDoiHinhMoi() {
        imageViewDoiHinhMoi.setOnClickListener(v -> randomMau());
    }

    @SuppressLint("SetTextI18n")
    private void actionDialog() {
        dialog.setOnDismissListener(dialog1 -> {
            if (idImg.getIndex() == -1) {
                Toast.makeText(MainActivity.this, "Bạn chưa chọn hình ^^", Toast.LENGTH_SHORT).show();
            } else {
                if (getResources().getIdentifier(listNameImage.get(idImg.getIndex()), "drawable", getPackageName()) == indexValueRoot) {
                    Toast.makeText(MainActivity.this, "Chính xác ^^", Toast.LENGTH_SHORT).show();
                    diem += 10;
                    textViewHienThiDiem.setText(diem + "");
                    Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            randomMau();
                        }
                    }, 800);
                } else {
                    diem -= 10;
                    textViewHienThiDiem.setText(diem + "");
                    Toast.makeText(MainActivity.this, "Sai rồi ^^", Toast.LENGTH_SHORT).show();
                }
                imageViewChonHinh.setImageResource(getResources().getIdentifier(listNameImage.get(idImg.getIndex()), "drawable", getPackageName()));
                idImg.setIndex(-1);
            }

            // ẩn thành status bar
            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_FULLSCREEN);
        });
    }

    private void actionImageViewChonHinh() {
        imageViewChonHinh.setOnClickListener(v -> dialog.show());
    }

    private void createDialog() {
        dialog = new Dialog(MainActivity.this);
        dialog.setContentView(R.layout.activity_select_hinh);
        RecyclerView recyclerView = dialog.findViewById(R.id.selectHinh_recyclerView_1);
        // layout manger
        GridLayoutManager gridLayoutManager = new GridLayoutManager(MainActivity.this, 3);
        gridLayoutManager.setOrientation(GridLayoutManager.VERTICAL);
        gridLayoutManager.setSmoothScrollbarEnabled(true);
        recyclerView.setLayoutManager(gridLayoutManager);
        // adapter
        List<Integer> listImgId = getListIdImg();
        SelectHinhAdapter selectHinhAdapter = new SelectHinhAdapter(listImgId, R.layout.view_holder_one_image, MainActivity.this, idImg, dialog);
        recyclerView.setAdapter(selectHinhAdapter);
    }

    private List<Integer> getListIdImg() {
        List<Integer> result = new ArrayList<>();
        for (String string : listNameImage) {
            result.add(getResources().getIdentifier(string, "drawable", getPackageName()));
        }
        return result;
    }

    private void randomHinhMauVaChonHinh() {
        int id = getResources().getIdentifier(listNameImage.get(random.nextInt(listNameImage.size())), "drawable", getPackageName());
        imageViewChonHinh.setImageResource(id);
        randomMau();
    }

    private void randomMau() {
        int id = getResources().getIdentifier(listNameImage.get(random.nextInt(listNameImage.size())), "drawable", getPackageName());
        imageViewHinhMau.setImageResource(id);
        indexValueRoot = id;
    }

    private void getView() {
        imageViewHinhMau = findViewById(R.id.main_imageView_1);
        imageViewChonHinh = findViewById(R.id.main_imageView_2);
        imageViewDoiHinhMoi = findViewById(R.id.main_imageView_3);
        textViewHienThiDiem = findViewById(R.id.main_textView_2);
    }

}