package com.vientamthuong.volleyjsonarray;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);

        TextView textView = findViewById(R.id.textView);

        RequestQueue requestQueue = Volley.newRequestQueue(MainActivity.this);
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, "https://khoapham.vn/KhoaPhamTraining/json/tien/demo4.json", null,
                respone -> {
                    String text = "";
                    try {
                        for (int i = 0; i < respone.length(); i++) {
                            text += respone.getJSONObject(i).getString("khoahoc") + "\n";
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    textView.setText(text);
                },
                error -> textView.setText(error.toString())
        );
        requestQueue.add(jsonArrayRequest);

    }
}