package com.vientamthuong.nghenhac;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

import com.vientamthuong.nghenhac.model.Music;
import com.vientamthuong.nghenhac.viewDanhSachNhac.ViewDanhSachNhacAdpater;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    // Khai báo các thuộc tính
    // View
    private AutoCompleteTextView autoCompleteTextViewSearch;
    private RecyclerView recyclerViewList;
    private ViewDanhSachNhacAdpater viewDanhSachNhacAdpater;
    private SeekBar seekBarThoiGian;
    private TextView textViewThoiGianDaSuDung;
    private TextView textViewThoiGianToiDa;
    private ImageView imageViewRandom;
    private ImageView imageViewRepeat;
    // Data
    // List danh sach cac bai hat
    private List<Music> danhSachNhac;
    // Trạng thái
    private int state;
    public static final int PAUSE = 0;
    public static final int START = 1;
    private boolean isRandom;
    private boolean isReapeat;
    // Bản nhạc hiện tại
    private MediaPlayer nowMedia;

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
    }

    private void init() {
        // tải danh sách nhạc
        loadData();
        // danhsachnhac
        viewDanhSachNhac();
        // action
        action();
    }

    private void action() {
        imageViewRandom.setOnClickListener(v -> {
            if (isRandom) {
                isRandom = false;
                imageViewRandom.setImageResource(R.drawable.ic_baseline_shuffle_24);
            } else {
                isRandom = true;
                imageViewRandom.setImageResource(R.drawable.ic_baseline_shuffle_24_select);
            }
        });
        imageViewRepeat.setOnClickListener(v -> {
            if (isReapeat) {
                isReapeat = false;
                imageViewRepeat.setImageResource(R.drawable.ic_baseline_360_24);
            } else {
                isReapeat = true;
                imageViewRepeat.setImageResource(R.drawable.ic_baseline_360_24_select);
            }
        });
    }

    private void viewDanhSachNhac() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(MainActivity.this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        linearLayoutManager.setSmoothScrollbarEnabled(true);
        recyclerViewList.setLayoutManager(linearLayoutManager);
        viewDanhSachNhacAdpater = new ViewDanhSachNhacAdpater(MainActivity.this);
        recyclerViewList.setAdapter(viewDanhSachNhacAdpater);
    }

    private void loadData() {
        danhSachNhac = new ArrayList<>();
        List<String> tenBaiHat = new ArrayList<>();
        tenBaiHat.add("Nơi Đó Còn Chờ Em");
        tenBaiHat.add("Sau tất cả");
        tenBaiHat.add("Yêu Lại Người Yêu Cũ (Lời Mở Đầu)");
        tenBaiHat.add("Yêu Lại Người Yêu Cũ (Lời Dẫn 1)");
        tenBaiHat.add("Yêu Lại Người Yêu Cũ (Lời Dẫn 2)");
        tenBaiHat.add("Yêu Lại Người Yêu Cũ (Lời Dẫn 3)");
        tenBaiHat.add("Yêu Lại Người Yêu Cũ (Lời Kết)");
        tenBaiHat.add("Yêu Lại Từ Đầu");
        tenBaiHat.add("Yêu Một Người Có Lẽ");
        List<String> tenCaSy = new ArrayList<>();
        tenCaSy.add("Đông nhi");
        tenCaSy.add("ERIK");
        tenCaSy.add("Chạm");
        tenCaSy.add("Chạm");
        tenCaSy.add("Chạm");
        tenCaSy.add("Chạm");
        tenCaSy.add("Chạm");
        tenCaSy.add("Khắc Việt");
        tenCaSy.add("Lou Hoàng, Miu Lê");
        String[] array = getResources().getStringArray(R.array.ten_danh_sach_nhac);
        for (int i = 0; i < array.length; i++) {
            int idImage = getResources().getIdentifier(array[i], "drawable", getPackageName());
            int idSound = getResources().getIdentifier(array[i], "raw", getPackageName());
            MediaPlayer mediaPlayer = MediaPlayer.create(MainActivity.this, idSound);
            String time = coverTimeToString(mediaPlayer.getDuration());
            danhSachNhac.add(new Music(idImage, tenBaiHat.get(i), idSound, time, tenCaSy.get(i)));
        }
        first();
    }

    private void first() {
        createAudio(0);
    }

    private void createAudio(int position) {
        for (Music music : danhSachNhac) {
            if (music.isSelect()) music.setSelect(false);
        }
        danhSachNhac.get(position).setSelect(true);
        nowMedia = MediaPlayer.create(MainActivity.this, danhSachNhac.get(position).getIdSound());
        textViewThoiGianDaSuDung.setText("00:00");
        textViewThoiGianToiDa.setText(coverTimeToString(nowMedia.getDuration()));
        seekBarThoiGian.setMax(nowMedia.getDuration());
    }

    private String coverTimeToString(long duration) {
        int giay = (int) (duration / 1000);
        int phut = giay / 60;
        giay -= phut * 60;
        String sPhut = phut + "";
        if (phut < 10) {
            sPhut = "0" + sPhut;
        }
        String sGiay = giay + "";
        if (giay < 10) {
            sGiay = "0" + sGiay;
        }
        return sPhut + ":" + sGiay;
    }

    private void getView() {
        autoCompleteTextViewSearch = findViewById(R.id.main_search);
        recyclerViewList = findViewById(R.id.main_listNhac);
        seekBarThoiGian = findViewById(R.id.thoi_gian);
        textViewThoiGianDaSuDung = findViewById(R.id.main_thoiGianDaChay);
        textViewThoiGianToiDa = findViewById(R.id.main_thoiGianToiDa);
        imageViewRandom = findViewById(R.id.button_random);
        imageViewRepeat = findViewById(R.id.button_repeat);
    }

    public List<Music> getDanhSachNhac() {
        return danhSachNhac;
    }

    public void setDanhSachNhac(List<Music> danhSachNhac) {
        this.danhSachNhac = danhSachNhac;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }
}