package com.vientamthuong.learning_17;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ProgressBar progressBar2 = findViewById(R.id.progressBar_2);
        CountDownTimer countDownTimer = new CountDownTimer(10000,10) {
            @Override
            public void onTick(long millisUntilFinished) {
                int count = progressBar2.getProgress();
                if (count >= progressBar2.getMax()) {
                    count = 0;
                }
                progressBar2.setProgress(count + 10);
            }

            @Override
            public void onFinish() {
                start();
            }
        };
        countDownTimer.start();
        
        Button button = findViewById(R.id.button_1);
        button.setOnClickListener(v -> {
            Toast.makeText(MainActivity.this, "asdas", Toast.LENGTH_SHORT).show();
        });
                

    }
}