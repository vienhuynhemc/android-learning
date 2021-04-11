package com.vientamthuong.mediasound;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);

        Button button = findViewById(R.id.button_1);
        Button button1 = findViewById(R.id.button_2);
        MediaPlayer mediaPlayer = MediaPlayer.create(MainActivity.this, R.raw.sound);
        button.setOnClickListener(v -> {
            mediaPlayer.start();
        });
        button1.setOnClickListener(v -> {
            mediaPlayer.stop();
        });
    }
}