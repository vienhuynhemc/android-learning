package com.vientamthuong.learning_4;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class FirstActivity extends AppCompatActivity {

    private final String tag = "RUNNING_ACTIVITY";
    public static final int RESULT_SECOND_ACTIVITY = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_first);

        Button button = findViewById(R.id.button_1);
        button.setOnClickListener(v -> {
            Intent intent = new Intent();
            intent.setClass(this, SecondActivity.class);
            startActivityForResult(intent, RESULT_SECOND_ACTIVITY);
        });

        Log.i(tag, "activity 1 oncreate");
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case RESULT_SECOND_ACTIVITY:
                if (data != null) {
                    TextView textView = findViewById(R.id.textView_1);
                    textView.setText(data.getStringExtra("data"));
                }
                break;
            default:
                break;
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i(tag, "activity 1 onstart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(tag, "activity 1 onresume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i(tag, "activity 1 onpause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i(tag, "activity 1 onstop");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i(tag, "activity 1 onrestart");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(tag, "activity 1 onDestroy");
    }

}
