package com.vientamthuong.cuocduakythu_khoa_pham_lan_1;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    // View
    // Seekbar
    private SeekBar sbHuou;
    private SeekBar sbHeo;
    private SeekBar sbCho;
    // button
    private Button btPlay;
    // checkbox
    private CheckBox cbHuou;
    private CheckBox cbHeo;
    private CheckBox cbCho;
    // imageView
    private ImageView ivLogo;
    // textView
    private TextView tvBackGround;

    // Animation
    // huou
    private AnimationDrawable huouDungIm;
    private AnimationDrawable huouChay;
    // heo
    private AnimationDrawable heoDungIm;
    private AnimationDrawable heoChay;
    // cho
    private AnimationDrawable choDungIm;
    private AnimationDrawable choChay;
    // button
    private Animation btPlayHidden;
    private Animation btPlayShow;
    // textViewBackGround
    private Animation tvBackGroundHidden;
    private Animation tvBackGroundShow;
    // logo
    private Animation ivLogoHidden;
    private Animation ivLogoShow;

    // Thuộc tính java
    // toast
    private Toast toast;
    // countdownTime
    private CountDownTimer countDownTimerWait;
    private CountDownTimer countDownTimerRun;
    // random
    private Random random;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // ánh xạ view
        initView();
        // Ánh xạ animation
        initAnimation();
        // chạy các animation đầu tiên
        runAnimationFirst();
        // khởi tạo trạng thái của các view ban đầu
        initStateFirst();
        // khởi tạo các thuộc tính java
        init();
        // Thiết lập action cho các view
        initActionToView();
    }

    @SuppressLint("ShowToast")
    private void init() {
        // toast
        toast = Toast.makeText(MainActivity.this, "", Toast.LENGTH_SHORT);
        // random
        random = new Random();
        // count down timer
        countDownTimerRun = new CountDownTimer(20000, 25) {
            @Override
            public void onTick(long millisUntilFinished) {
                if (sbHuou.getProgress() >= 9000 || sbHeo.getProgress() >= 9000 || sbCho.getProgress() >= 9000) {
                    // nếu có con nào chơi đích thì endgame
                    endGame();
                } else {
                    sbHuou.setProgress(sbHuou.getProgress() + random.nextInt(50));
                    sbHeo.setProgress(sbHeo.getProgress() + random.nextInt(50));
                    sbCho.setProgress(sbCho.getProgress() + random.nextInt(50));
                }
            }

            @Override
            public void onFinish() {
                start();
            }
        };
        countDownTimerWait = new CountDownTimer(2000, 2000) {
            @Override
            public void onTick(long millisUntilFinished) {
                // không làm gì cả
            }

            @Override
            public void onFinish() {
                // Mục đích là chờ 2s, sau 2s mới bắt đầu chạy
                countDownTimerRun.start();
                // set animtion cho các con vật thành chạy
                allAnimalRun();
            }
        };
    }

    private void allAnimalRun() {
        huouDungIm.stop();
        sbHuou.setThumb(huouChay);
        huouChay.start();
        heoDungIm.stop();
        sbHeo.setThumb(heoChay);
        heoChay.start();
        choDungIm.stop();
        sbCho.setThumb(choChay);
        choChay.start();
    }

    private void allAnimalStopRun() {
        huouChay.stop();
        sbHuou.setThumb(huouDungIm);
        huouDungIm.start();
        heoChay.stop();
        sbHeo.setThumb(heoDungIm);
        heoDungIm.start();
        choChay.stop();
        sbCho.setThumb(choDungIm);
        choDungIm.start();
    }

    private void endGame() {
        // dừng count dơn time lại
        countDownTimerRun.cancel();
        // Làm cho các con vật đứng lại
        allAnimalStopRun();
        // lấy ra con vật chiến thắng
        String animalWin;
        boolean check = false;
        int best;
        if (sbHuou.getProgress() > sbHeo.getProgress()) {
            best = sbHuou.getProgress();
            animalWin = "HƯƠU";
            if (cbHuou.isChecked()) check = true;
        } else {
            best = sbHeo.getProgress();
            animalWin = "HEO";
            if (cbHeo.isChecked()) check = true;
        }
        if (sbCho.getProgress() > best) {
            animalWin = "CHÓ";
            if (cbCho.isChecked()) check = true;
        }
        String result = check ? animalWin + " chiến thắng, bạn đã THẮNG cá cược!" : animalWin + " chiến thắng, bạn đã THUA cá cược";
        showNotification(result);
        // cho các component trở lại
        showCheckBox();
        ivLogo.startAnimation(ivLogoShow);
        tvBackGround.startAnimation(tvBackGroundShow);
        btPlay.startAnimation(btPlayShow);
    }

    private void showNotification(String notification) {
        toast.setText(notification);
        toast.show();
    }

    private void initActionToView() {
        // button play
        initActionToButtonPlay();
        // các checkbox
        initACtionToCheckBoxs();
    }

    private void initACtionToCheckBoxs() {
        cbHuou.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) {
                cbHeo.setChecked(false);
                cbCho.setChecked(false);
            }
        });
        cbHeo.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) {
                cbHuou.setChecked(false);
                cbCho.setChecked(false);
            }
        });
        cbCho.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) {
                cbHeo.setChecked(false);
                cbHuou.setChecked(false);
            }
        });
    }

    private void initActionToButtonPlay() {
        btPlay.setOnClickListener(v -> {
            // Kiểm tra xem thử có click checkbox nào chưa
            if (!cbHuou.isChecked() && !cbCho.isChecked() && !cbHeo.isChecked()) {
                // Thông báo
                showNotification("Vui lòng chọn CON VẬT mà bạn nghĩ sẽ thắng");
            } else {
                // Đã chọn rồi thì ẩn các component tương ứng rồi cho các con vật chạy
                btPlay.startAnimation(btPlayHidden);
                tvBackGround.startAnimation(tvBackGroundHidden);
                ivLogo.startAnimation(ivLogoHidden);
                // cho các con vật về vị trí ban đầu
                sbCho.setProgress(0);
                sbHeo.setProgress(0);
                sbHuou.setProgress(0);
                // làm cho các chẹckbox không thểm tác động được
                hiddenCheckBox();
                // chạy countdown time
                countDownTimerWait.start();
            }
        });
    }

    private void hiddenCheckBox() {
        cbHuou.setEnabled(false);
        cbCho.setEnabled(false);
        cbHeo.setEnabled(false);
    }

    private void showCheckBox() {
        cbHuou.setEnabled(true);
        cbHeo.setEnabled(true);
        cbCho.setEnabled(true);
    }

    private void initStateFirst() {
        // Làm cho seekbar không thể tác động
        sbHuou.setEnabled(false);
        sbHeo.setEnabled(false);
        sbCho.setEnabled(false);
    }

    private void runAnimationFirst() {
        sbHuou.setThumb(huouDungIm);
        sbHeo.setThumb(heoDungIm);
        sbCho.setThumb(choDungIm);
        huouDungIm.start();
        heoDungIm.start();
        choDungIm.start();
    }

    @SuppressLint("UseCompatLoadingForDrawables")
    private void initAnimation() {
        // huou
        huouDungIm = (AnimationDrawable) getDrawable(R.drawable.drawable_huou_dung_im);
        huouChay = (AnimationDrawable) getDrawable(R.drawable.drawable_huou_chay);
        // heo
        heoDungIm = (AnimationDrawable) getDrawable(R.drawable.drawable_heo_dung_im);
        heoChay = (AnimationDrawable) getDrawable(R.drawable.drawable_heo_chay);
        // cho
        choDungIm = (AnimationDrawable) getDrawable(R.drawable.drawable_cho_dung_im);
        choChay = (AnimationDrawable) getDrawable(R.drawable.drawable_cho_chay);
        // button
        btPlayHidden = AnimationUtils.loadAnimation(MainActivity.this, R.anim.anim_button_play_hidden);
        btPlayShow = AnimationUtils.loadAnimation(MainActivity.this, R.anim.anim_button_play_show);
        // textView background
        tvBackGroundHidden = AnimationUtils.loadAnimation(MainActivity.this, R.anim.anim_text_view_hidden);
        tvBackGroundShow = AnimationUtils.loadAnimation(MainActivity.this, R.anim.anim_text_view_show);
        // imageView logo
        ivLogoHidden = AnimationUtils.loadAnimation(MainActivity.this, R.anim.anim_logo_hidden);
        ivLogoShow = AnimationUtils.loadAnimation(MainActivity.this, R.anim.anim_logo_show);
    }

    private void initView() {
        // SeekBar
        sbHuou = findViewById(R.id.main_seekBar_huou);
        sbHeo = findViewById(R.id.main_seekBar_heo);
        sbCho = findViewById(R.id.main_seekBar_cho);
        // button
        btPlay = findViewById(R.id.main_buttonPlay);
        // checkbox
        cbHuou = findViewById(R.id.main_checkBox_huu);
        cbHeo = findViewById(R.id.main_checkBox_heo);
        cbCho = findViewById(R.id.main_checkBox_cho);
        // imageView
        ivLogo = findViewById(R.id.main_logo);
        // textView
        tvBackGround = findViewById(R.id.main_textViewBackGround);
    }

}