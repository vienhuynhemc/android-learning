package com.vientamthuong.soundonline;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    private EditText editText;
    private ProgressBar progressBar;
    private MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_FULLSCREEN);
        editText = findViewById(R.id.editText);
        Button button = findViewById(R.id.button);
        progressBar = findViewById(R.id.progressbar);
        mediaPlayer = new MediaPlayer();
        mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
        button.setOnClickListener(v -> {
            if(mediaPlayer.isPlaying()){
                mediaPlayer.stop();
                mediaPlayer.release();
            }
            mediaPlayer = new MediaPlayer();
            mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
            try {
                progressBar.setVisibility(View.VISIBLE);
                mediaPlayer.setDataSource(editText.getText().toString().trim());
                mediaPlayer.prepareAsync();
                mediaPlayer.setOnPreparedListener(mp -> {
                    progressBar.setVisibility(View.GONE);
                    mp.start();
                });
            } catch (IOException e) {
                progressBar.setVisibility(View.GONE);
                Toast.makeText(MainActivity.this, "Lỗi", Toast.LENGTH_SHORT).show();
                e.printStackTrace();
            }
        });
    }
}