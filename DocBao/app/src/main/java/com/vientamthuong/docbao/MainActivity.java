package com.vientamthuong.docbao;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Date;

public class MainActivity extends AppCompatActivity {

    // Khai báo các thuộc tính
    private WebView webViewHienThi;
    private EditText editTextURL;
    private Button buttonOk;
    private TextView textViewBack;
    private TextView textViewForward;
    private TextView textViewRefresh;
    private long lastTimeBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Xóa status bar
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);
        // ÁNh xạ view
        getView();
        // Khởi tạo
        init();
        // action
        action();
    }

    @Override
    public void onBackPressed() {
        if (webViewHienThi.canGoBack()) {
            webViewHienThi.goBack();
            editTextURL.setText(webViewHienThi.getUrl());
        } else {
            Date date = new Date();
            if (date.getTime() - lastTimeBack < 1500) {
                finish();
            } else {
                lastTimeBack = date.getTime();
                Toast.makeText(MainActivity.this, "Nhấn lần nữa để thoát", Toast.LENGTH_SHORT).show();
            }
        }
    }

    private void action() {
        // button OK
        actionButtonOK();
        // action refresh
        actionRefresh();
        // action back
        actionGoBack();
        // action forward
        actionFoward();
    }

    private void actionFoward() {
        textViewForward.setOnClickListener(v -> {
            if (webViewHienThi.canGoForward()) {
                webViewHienThi.goForward();
                editTextURL.setText(webViewHienThi.getUrl());
            } else {
                Toast.makeText(MainActivity.this, "Không có trang ở sau", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void actionGoBack() {
        textViewBack.setOnClickListener(v -> {
            if (webViewHienThi.canGoBack()) {
                webViewHienThi.goBack();
                editTextURL.setText(webViewHienThi.getUrl());
            } else {
                Toast.makeText(MainActivity.this, "Không có trang ở trước", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void actionRefresh() {
        textViewRefresh.setOnClickListener(v -> webViewHienThi.reload());
    }

    private void actionButtonOK() {
        buttonOk.setOnClickListener(v -> {
            String url = editTextURL.getText().toString();
            if (url.startsWith("https://")) {
                webViewHienThi.loadUrl(url);
            } else {
                webViewHienThi.loadUrl("https:" + url);
            }
            editTextURL.setText(webViewHienThi.getUrl());
        });
    }

    @SuppressLint("SetJavaScriptEnabled")
    private void initWebView() {
        // Không cho out khỏi app khi click link
        webViewHienThi.setWebViewClient(new WebViewClient());
        // applay zoom và tắt bộ công cụ zoom
        webViewHienThi.getSettings().setBuiltInZoomControls(true);
        webViewHienThi.getSettings().setDisplayZoomControls(false);
        // apply js
        webViewHienThi.getSettings().setJavaScriptEnabled(true);
    }

    private void init() {
        // web view
        initWebView();
    }

    private void getView() {
        webViewHienThi = findViewById(R.id.webView_1);
        editTextURL = findViewById(R.id.editText_1);
        buttonOk = findViewById(R.id.button_1);
        textViewBack = findViewById(R.id.textView_1);
        textViewForward = findViewById(R.id.textView_2);
        textViewRefresh = findViewById(R.id.textView_3);
    }


}