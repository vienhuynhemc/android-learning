package com.vientamthuong.learning_4;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {

    private final String tag = "RUNNING_ACTIVITY";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_second);


        Button button = findViewById(R.id.button_2);
        button.setOnClickListener(v -> {
            setResultFirstActivity();
            Toast.makeText(getApplicationContext(), "Lưu dữ liệu thành công", Toast.LENGTH_SHORT).show();
            finish();
        });

        Log.i(tag, "activity 2 oncreate");
    }

    private void setResultFirstActivity() {
        Intent intent = new Intent();
        EditText editText = findViewById(R.id.editText_1);
        intent.putExtra("data", editText.getText().toString().trim());
        setResult(FirstActivity.RESULT_SECOND_ACTIVITY, intent);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i(tag, "activity 2 onstart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(tag, "activity 2 onresume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i(tag, "activity 2 onpause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i(tag, "activity 2 onstop");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i(tag, "activity 2 onrestart");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(tag, "activity 2 onDestroy");
    }

}
