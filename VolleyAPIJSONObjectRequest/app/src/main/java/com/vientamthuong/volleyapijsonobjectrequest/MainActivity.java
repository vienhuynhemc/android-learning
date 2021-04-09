package com.vientamthuong.volleyapijsonobjectrequest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);

        TextView textView = findViewById(R.id.textView);
        RequestQueue requestQueue = Volley.newRequestQueue(MainActivity.this);
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, "https://khoapham.vn/KhoaPhamTraining/json/tien/demo3.json", null,
                response -> {
                    try {
                        String text = "";
                        JSONObject jsonObject = response.getJSONObject("language");
                        JSONObject jsonObject1 = jsonObject.getJSONObject("en");
                        text += jsonObject1.getString("name") + "\n";
                        text += jsonObject1.getString("address") + "\n";
                        text += jsonObject1.getString("course1") + "\n";
                        text += jsonObject1.getString("course2") + "\n";
                        text += jsonObject1.getString("course3") + "\n";
                        JSONObject jsonObject2 = jsonObject.getJSONObject("vn");
                        text += jsonObject2.getString("name") + "\n";
                        text += jsonObject2.getString("address") + "\n";
                        text += jsonObject2.getString("course1") + "\n";
                        text += jsonObject2.getString("course2") + "\n";
                        text += jsonObject2.getString("course3") + "\n";
                        textView.setText(text);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                },
                error -> textView.setText(error.toString())
        );
        requestQueue.add(jsonObjectRequest);

    }
}