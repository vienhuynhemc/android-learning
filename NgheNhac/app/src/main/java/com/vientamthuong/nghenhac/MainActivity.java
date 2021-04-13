package com.vientamthuong.nghenhac;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AutoCompleteTextView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

import com.vientamthuong.nghenhac.model.Music;
import com.vientamthuong.nghenhac.viewAutoSearch.ViewAutoSearchAdapter;
import com.vientamthuong.nghenhac.viewDanhSachNhac.ViewDanhSachNhacAdpater;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

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
    private ImageView buttonPlay;
    private ImageView hinhNen;
    private ImageView buttoNext;
    private ImageView buttonPre;
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
    private int nowPosition;
    // random
    private Random random;
    // animation
    private Animation quayHinhNen;
    // handle
    private Handler handler;

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
        handler = new Handler();
        random = new Random();
        quayHinhNen = AnimationUtils.loadAnimation(MainActivity.this, R.anim.hinh_nen_quay);
        // danhsachnhac
        viewDanhSachNhac();
        // tải danh sách nhạc
        loadData();
        // view autocomplete
        autoComplete();
        // action
        action();
    }

    private void autoComplete() {
        List<Music> newList = new ArrayList<>();
        newList.addAll(danhSachNhac);
        ViewAutoSearchAdapter viewAutoSearchAdapter = new ViewAutoSearchAdapter(MainActivity.this, R.layout.custom_view_holder, newList, this);
        autoCompleteTextViewSearch.setAdapter(viewAutoSearchAdapter);
    }

    private void next() {
        if (isRandom) {
            int newIndex = random.nextInt(danhSachNhac.size());
            while (newIndex == nowPosition) {
                newIndex = random.nextInt(danhSachNhac.size());
            }
            createAudio(newIndex);
            viewDanhSachNhacAdpater.notifyDataSetChanged();
        } else {
            if (nowPosition < danhSachNhac.size()) {
                nowPosition++;
            }
            if (nowPosition == danhSachNhac.size()) {
                if (isReapeat) {
                    nowPosition = 0;
                    createAudio(nowPosition);
                } else {
                    state = PAUSE;
                    hinhNen.clearAnimation();
                    buttonPlay.setImageResource(R.drawable.ic_baseline_play_circle_outline_24);
                    nowMedia.pause();
                    if (nowPosition == danhSachNhac.size()) {
                        danhSachNhac.get(nowPosition - 1).setPlay(false);
                    } else if (nowPosition == -1) {
                        danhSachNhac.get(nowPosition + 1).setPlay(false);
                    } else {
                        danhSachNhac.get(nowPosition).setPlay(false);
                    }
                    viewDanhSachNhacAdpater.notifyDataSetChanged();
                }
            } else {
                createAudio(nowPosition);
                viewDanhSachNhacAdpater.notifyDataSetChanged();
            }
        }
    }

    private void pre() {
        if (isRandom) {
            int newIndex = random.nextInt(danhSachNhac.size());
            while (newIndex == nowPosition) {
                newIndex = random.nextInt(danhSachNhac.size());
            }
            createAudio(newIndex);
            viewDanhSachNhacAdpater.notifyDataSetChanged();
        } else {
            if (nowPosition > -1) {
                nowPosition--;
            }
            if (nowPosition == -1) {
                if (isReapeat) {
                    nowPosition = danhSachNhac.size() - 1;
                    createAudio(nowPosition);
                } else {
                    state = PAUSE;
                    hinhNen.clearAnimation();
                    buttonPlay.setImageResource(R.drawable.ic_baseline_play_circle_outline_24);
                    nowMedia.pause();
                    if (nowPosition == -1) {
                        danhSachNhac.get(nowPosition + 1).setPlay(false);
                    } else {
                        danhSachNhac.get(nowPosition).setPlay(false);
                    }
                    viewDanhSachNhacAdpater.notifyDataSetChanged();
                }
            } else {
                createAudio(nowPosition);
                viewDanhSachNhacAdpater.notifyDataSetChanged();
            }
        }
    }

    private void action() {
        // button
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
        // media
        nowMedia.setOnCompletionListener(mp -> {
            next();
        });
        // play
        buttonPlay.setOnClickListener(v -> {
            if (state == START) {
                nowMedia.pause();
                state = PAUSE;
                buttonPlay.setImageResource(R.drawable.ic_baseline_play_circle_outline_24);
                hinhNen.clearAnimation();
                if (nowPosition == danhSachNhac.size()) {
                    danhSachNhac.get(nowPosition - 1).setPlay(false);
                } else if (nowPosition == -1) {
                    danhSachNhac.get(nowPosition + 1).setPlay(false);
                } else {
                    danhSachNhac.get(nowPosition).setPlay(false);
                }
                viewDanhSachNhacAdpater.notifyDataSetChanged();
            } else {
                state = START;
                hinhNen.startAnimation(quayHinhNen);
                buttonPlay.setImageResource(R.drawable.ic_baseline_pause_circle_outline_24);
                if (nowPosition == danhSachNhac.size()) {
                    createAudio(nowPosition - 1);
                } else if (nowPosition == -1) {
                    danhSachNhac.get(nowPosition + 1).setPlay(false);
                }
                nowMedia.start();
                if (nowPosition == danhSachNhac.size()) {
                    danhSachNhac.get(nowPosition - 1).setPlay(true);
                } else if (nowPosition == -1) {
                    danhSachNhac.get(nowPosition + 1).setPlay(false);
                } else {
                    danhSachNhac.get(nowPosition).setPlay(true);
                }
                viewDanhSachNhacAdpater.notifyDataSetChanged();
            }
        });
        // seekbar
        seekBarThoiGian.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                nowMedia.seekTo(seekBar.getProgress());
            }
        });
        // next
        buttoNext.setOnClickListener(v -> next());
        buttonPre.setOnClickListener(v -> pre());
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
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                seekBarThoiGian.setProgress(nowMedia.getCurrentPosition());
                String nowTime = coverTimeToString(nowMedia.getCurrentPosition());
                textViewThoiGianDaSuDung.setText(nowTime);
                handler.postDelayed(this, 500);
            }
        }, 500);
    }

    public void createAudio(int position) {
        for (Music music : danhSachNhac) {
            if (music.isSelect()) music.setSelect(false);
            if (music.isPlay()) music.setPlay(false);
        }
        danhSachNhac.get(position).setSelect(true);
        if (nowMedia == null) {
            nowMedia = MediaPlayer.create(MainActivity.this, danhSachNhac.get(position).getIdSound());
        } else {
            nowMedia.stop();
            nowMedia.release();
            nowMedia = MediaPlayer.create(MainActivity.this, danhSachNhac.get(position).getIdSound());
            nowMedia.setOnCompletionListener(mp -> next());
            recyclerViewList.scrollToPosition(position);
        }
        if (state == START) {
            nowMedia.start();
            danhSachNhac.get(position).setPlay(true);
        }
        textViewThoiGianDaSuDung.setText("00:00");
        textViewThoiGianToiDa.setText(coverTimeToString(nowMedia.getDuration()));
        seekBarThoiGian.setMax(nowMedia.getDuration());
        viewDanhSachNhacAdpater.notifyDataSetChanged();
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
        buttonPlay = findViewById(R.id.button_play);
        hinhNen = findViewById(R.id.main_hinhNhac);
        buttoNext = findViewById(R.id.button_next);
        buttonPre = findViewById(R.id.button_pre);
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

    public int getNowPosition() {
        return nowPosition;
    }

    public void setNowPosition(int nowPosition) {
        this.nowPosition = nowPosition;
    }

    public AutoCompleteTextView getAutoCompleteTextViewSearch() {
        return autoCompleteTextViewSearch;
    }
}