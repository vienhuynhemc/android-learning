package com.vientamthuong.mediaonlinevideo;

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
        VideoView videoView = findViewById(R.id.videoView);
        Button button = findViewById(R.id.button);
        button.setOnClickListener(v -> {
            videoView.setVideoURI(Uri.parse("http://khoapham.vn/download/vuoncaovietnam.mp4"));
            videoView.setMediaController(new MediaController(MainActivity.this));
            videoView.start();
        });
    }
}