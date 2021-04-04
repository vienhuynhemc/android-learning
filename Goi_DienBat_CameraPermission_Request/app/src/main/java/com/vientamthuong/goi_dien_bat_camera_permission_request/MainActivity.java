package com.vientamthuong.goi_dien_bat_camera_permission_request;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

public class MainActivity extends AppCompatActivity {

    // Khai báo các thuộc tính
    private Button buttonGoi;
    private Button buttonChupHinh;
    private EditText editTextTel;
    private ImageView imageViewHienThi;
    private Toast toast;
    private boolean isAcceptCall;
    private boolean isAcceptCamera;
    public static final int REQUEST_CODE_CAMERA = 0;
    public static final int REQUEST_CODE_CALL = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Ánh xạ view
        getView();
        // init
        init();
        // action
        action();
    }

    @SuppressLint("ShowToast")
    private void init() {
        toast = Toast.makeText(MainActivity.this, "", Toast.LENGTH_SHORT);
    }

    private void action() {
        // action goi
        actionGoi();
        // action camera
        actionCamera();
    }

    private void actionCamera() {
        buttonChupHinh.setOnClickListener(v -> {
            if (!isAcceptCamera) {
                ActivityCompat.requestPermissions(MainActivity.this, new String[]{Manifest.permission.CAMERA}, REQUEST_CODE_CAMERA);
            } else {
                startCamera();
            }
        });
    }

    private void startCamera() {
        Intent intent = new Intent();
        intent.setAction(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(intent, REQUEST_CODE_CAMERA);
    }

    private void actionGoi() {
        buttonGoi.setOnClickListener(v -> {
            String numberPhone = editTextTel.getText().toString();
            if (numberPhone.length() != 10) {
                toast.setText("Vui lòng điền đủ 10 số");
                toast.show();
            } else {
                if (!isAcceptCall) {
                    ActivityCompat.requestPermissions(MainActivity.this, new String[]{Manifest.permission.CALL_PHONE}, REQUEST_CODE_CALL);
                } else {
                    startCall();
                }
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (requestCode == REQUEST_CODE_CAMERA && resultCode == RESULT_OK && data != null) {
            Bitmap bitmap = (Bitmap) data.getExtras().get("data");
            imageViewHienThi.setImageBitmap(bitmap);
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

    private void startCall() {
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_DIAL);
        intent.setData(Uri.parse("tel:" + editTextTel.getText().toString()));
        startActivity(intent);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
            switch (requestCode) {
                case REQUEST_CODE_CALL:
                    isAcceptCall = true;
                    startCall();
                    break;
                case REQUEST_CODE_CAMERA:
                    isAcceptCamera = true;
                    startCamera();
                    break;
            }
        }
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }

    private void getView() {
        buttonGoi = findViewById(R.id.main_button_1);
        buttonChupHinh = findViewById(R.id.main_button_2);
        editTextTel = findViewById(R.id.main_editText_1);
        imageViewHienThi = findViewById(R.id.main_imageView_1);
    }
}