package com.vientamthuong.learning_21;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);

        TextView textView = findViewById(R.id.textView_1);
        textView.setOnClickListener(v -> {
            Intent intent = new Intent();
            intent.setAction(Intent.ACTION_VIEW);
            intent.setData(Uri.parse("http://facebook.com/vientamthuong"));
            startActivity(intent);
        });

        TextView textView1 = findViewById(R.id.textView_2);
        textView1.setOnClickListener(v -> {
            Intent intent = new Intent();
            intent.setAction(Intent.ACTION_SENDTO);
            intent.setData(Uri.parse("sms:0971122209"));
            intent.putExtra("sms_body", "Hello ban yeu");
            startActivity(intent);
        });

        TextView textView2 = findViewById(R.id.textView_3);
        textView2.setOnClickListener(v -> {
            Intent i = new Intent();
            i.setAction(Intent.ACTION_DIAL);
            i.setData(Uri.parse("tel:0971122209"));
            startActivity(i);
        });

    }

}