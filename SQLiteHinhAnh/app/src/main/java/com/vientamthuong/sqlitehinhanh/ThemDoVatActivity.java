package com.vientamthuong.sqlitehinhanh;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class ThemDoVatActivity extends AppCompatActivity {

    private Button btCamera, btThem, btHuy, btFolder;
    private EditText editTextTenDovat;
    private EditText editTextMota;
    private ImageView imageView;
    public static final int REQUEST_CODE_CAMERA = 0;
    public static final int REQUEST_CODE_FOLDER = 1;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_FULLSCREEN);
        setContentView(R.layout.activity_them_do_vat);
        getView();
        action();
    }

    private void action() {
        btHuy.setOnClickListener(v -> finish());
        btCamera.setOnClickListener(v -> {
            Intent intent = new Intent();
            intent.setAction(MediaStore.ACTION_IMAGE_CAPTURE);
            startActivityForResult(intent, REQUEST_CODE_CAMERA);
        });
        btFolder.setOnClickListener(v -> {
            Intent intent = new Intent();
            intent.setAction(Intent.ACTION_PICK);
            intent.setType("image/*");
            startActivityForResult(intent, REQUEST_CODE_FOLDER);
        });
        btThem.setOnClickListener(v -> {
            String ten = editTextTenDovat.getText().toString().trim();
            String mo_ta = editTextMota.getText().toString().trim();
            BitmapDrawable bitmapDrawable = (BitmapDrawable) imageView.getDrawable();
            Bitmap bitmap = bitmapDrawable.getBitmap();
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
            byte[] array = byteArrayOutputStream.toByteArray();
            MainActivity.database.addToDatabase(ten, mo_ta, array);
            MainActivity.list.add(new DoVat(ten, mo_ta, array));
            MainActivity.adapterView.notifyDataSetChanged();
            finish();
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK && data != null) {
            if (requestCode == REQUEST_CODE_CAMERA) {
                Bitmap bitmap = (Bitmap) data.getExtras().get("data");
                imageView.setImageBitmap(bitmap);
            } else if (requestCode == REQUEST_CODE_FOLDER) {
                Uri uri = data.getData();
                try {
                    InputStream inputStream = getContentResolver().openInputStream(uri);
                    Bitmap bitmap = BitmapFactory.decodeStream(inputStream);
                    imageView.setImageBitmap(bitmap);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private void getView() {
        btCamera = findViewById(R.id.button_1);
        btFolder = findViewById(R.id.button_2);
        btThem = findViewById(R.id.button_3);
        btHuy = findViewById(R.id.button_4);
        editTextTenDovat = findViewById(R.id.editText_1);
        editTextMota = findViewById(R.id.editText_2);
        imageView = findViewById(R.id.imageView_1);
    }
}
