package com.vientamthuong.learning_20;

import androidx.appcompat.app.AppCompatActivity;

import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);

        // Ánh xạ view
        TextView textView = findViewById(R.id.textView_1);
        textView.setOnClickListener(v -> {
            TimePickerDialog timePickerDialog = new TimePickerDialog(MainActivity.this, (view, hourOfDay, minute) -> {
                textView.setText(hourOfDay+":"+minute);
            }, 14, 30, false);
            timePickerDialog.show();
        });

    }
}