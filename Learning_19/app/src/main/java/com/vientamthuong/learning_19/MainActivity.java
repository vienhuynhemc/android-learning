package com.vientamthuong.learning_19;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);

        Button button_1 = findViewById(R.id.button_1);
        Button button_2 = findViewById(R.id.button_2);

        button_1.setOnClickListener(v -> {
            AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
            builder.setTitle("Tiêu đề");
            builder.setIcon(R.drawable.ic_launcher_foreground);
            builder.setMessage("Nội dungNội dungNội dungNội dungNội dungNội dungNội dungNội dungNội dungNội dungNội dungNội dungNội dungNội dungNội dungNội dungNội dungNội dungNội dungNội dungNội dungNội dungNội dungNội dungNội dungNội dungNội dungNội dungNội dungNội dungNội dungNội dungNội dungNội dungNội dungNội dungNội dungNội dungNội dungNội dungNội dungNội dungNội dungNội dungNội dungNội dungNội dungNội dungNội dungNội dungNội dungNội dungNội dungNội dung");
            builder.setPositiveButton("Positive", (dialog, which) -> {
            });
            builder.setNegativeButton("Negative", (dialog, which) -> {
            });
            builder.setNeutralButton("Neutra", (dialog, which) -> {
            });
            builder.show();
        });

        button_2.setOnClickListener(v -> {
            Dialog dialog = new Dialog(MainActivity.this);
            dialog.setCanceledOnTouchOutside(false);
            dialog.setContentView(R.layout.dialog_main);
            Button b = dialog.findViewById(R.id.button);
            b.setOnClickListener(v1 -> {
            dialog.dismiss();
            });
            dialog.show();
        });

    }
}