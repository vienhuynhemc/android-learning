package com.vientamthuong.mediavideo;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);
        Button button = findViewById(R.id.button_1);
        VideoView videoView = findViewById(R.id.videoView_1);
        videoView.setVideoURI(Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.aa));
        MediaController mediaController = new MediaController(MainActivity.this);
        videoView.setMediaController(mediaController);
        mediaController.setMediaPlayer(videoView);
        button.setOnClickListener(v -> videoView.start());
    }
}