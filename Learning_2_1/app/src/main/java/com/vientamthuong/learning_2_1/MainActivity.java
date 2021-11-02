package com.vientamthuong.learning_2_1;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //  Set contentView
        setContentView(R.layout.activity_main);

        //  Lấy các đối tượng ra
        //  1. EditText
        EditText editTextCongViec = findViewById(R.id.editText_1);
        EditText editTextGio = findViewById(R.id.editText_2);
        EditText editTextPhut = findViewById(R.id.editText_3);
        //  2. Button
        Button buttonThemCongViec = findViewById(R.id.button_1);
        //  3. ListView
        ListView listView = findViewById(R.id.listView_1);

        //  Khởi tạo list công việc và kết nối nó với listView thông qua ArrayAdapter
        List<String> listCongViec = new ArrayList<>();
        ArrayAdapter<String> arrayAdapterListCongViec = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, listCongViec);

        //  Kết nối arrayAdapter với listView
        listView.setAdapter(arrayAdapterListCongViec);

        //  Xử lý sự kiện cho button
        buttonThemCongViec.setOnClickListener(v -> {

            //  Lấy dữ liệu từ editText
            String gio = editTextGio.getText().toString().trim();
            String phut = editTextPhut.getText().toString().trim();
            String congViec = editTextCongViec.getText().toString().trim();

            //  Nếu có trường nào đó rỗng thì thông báo
            if (gio.length() == 0 || phut.length() == 0 || congViec.length() == 0) {
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setTitle("Thiếu dữ liệu");
                builder.setMessage("Vui lòng điền đầy đủ dữ liệu trước khi nhấn \"Thêm công việc\"");
                builder.setPositiveButton("Biết rồi", (dialog, which) -> {
                });
                builder.show();
            } else {

                //  Nếu oke hết thì thêm vô list công việc thôi
                String congViecMoi = congViec + " - " + gio + ":" + phut;
                listCongViec.add(0,congViecMoi);

                //  Thông báo có dữ liệu mới cho list view
                arrayAdapterListCongViec.notifyDataSetChanged();

                //  Xóa các trường nhập
                editTextCongViec.setText("");
                editTextGio.setText("");
                editTextPhut.setText("");

            }
        });
    }
}