package com.vientamthuong.learning_4_1;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    public static final int RESULT_FROM_ACTIVITY_2 = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_1);
        
        //  Lấy view
        TextView textView = findViewById(R.id.textView_1);
        Button denActivity2 = findViewById(R.id.button_1);
        Button denActivity3 = findViewById(R.id.button_2);

        //  action cho button denActivity3
        denActivity3.setOnClickListener(v -> {
            Intent intent = new Intent();
            intent.setClass(this, DisplayActivity.class);
            intent.putExtra("data", textView.getText().toString().trim());
            startActivity(intent);
            Toast.makeText(getApplicationContext(), "Đến Activity 3", Toast.LENGTH_SHORT).show();
        });

        //  action cho button denActivity2
        denActivity2.setOnClickListener(v -> {
            Intent intent = new Intent();
            intent.setClass(this, SecondActivity.class);
            startActivityForResult(intent, RESULT_FROM_ACTIVITY_2);
            Toast.makeText(getApplicationContext(), "Đến Activity 2", Toast.LENGTH_SHORT).show();
        });
    }

    //  Lấy dữ liệu trả về từ activity2
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (data != null) {
            TextView textView = findViewById(R.id.textView_1);
            textView.setText(data.getStringExtra("data"));
        }
    }
}
