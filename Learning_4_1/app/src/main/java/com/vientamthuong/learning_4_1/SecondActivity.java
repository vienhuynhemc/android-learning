package com.vientamthuong.learning_4_1;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        //  Lấy view
        EditText editText = findViewById(R.id.editText_1);
        Button button = findViewById(R.id.button_4);

        // action cho button
        button.setOnClickListener(v -> {

            String noiDung = editText.getText().toString().trim();
            if (noiDung.length() == 0) {
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setTitle("Thiếu thông tin");
                builder.setMessage("Vui lòng điền thông tin vô editText");
                builder.setPositiveButton("OK", (dialog, which) -> {
                });
                builder.show();
            } else {
                Intent intent = new Intent();
                intent.putExtra("data", noiDung);
                setResult(MainActivity.RESULT_FROM_ACTIVITY_2, intent);
                Toast.makeText(getApplicationContext(), "Lưu thành công", Toast.LENGTH_SHORT).show();
                finish();
            }
        });
    }
}
