package com.vientamthuong.learning_2;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // set main layout activity cho setContentView
        setContentView(R.layout.activity_main);

        //  Lấy các đối tượng cần sử lý ra
        //  1.Edit text
        EditText editTextCongViec = findViewById(R.id.editText_1);
        EditText editTextGio = findViewById(R.id.editText_2);
        EditText editTextPhut = findViewById(R.id.editText_3);
        //  2.Button
        Button buttonThemCongViec = findViewById(R.id.button_1);
        //  3.ListView
        ListView listViewCongViec = findViewById(R.id.listView_1);

        // Tạo mạng chứa nội dung công việc
        List<String> listCongViec = new ArrayList<>();

        //  Taọ adapter để kết nối mảng công việc với listView
        ArrayAdapter<String> adapterListCongViec = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, listCongViec);

        // set adapter cho list view để nó lấy dữ liệu từ list công việc
        listViewCongViec.setAdapter(adapterListCongViec);

        //  Set action cho button
        buttonThemCongViec.setOnClickListener(v -> {
            String noiDungCongViec = editTextCongViec.getText().toString().trim();
            String gio = editTextGio.getText().toString().trim();
            String phut = editTextPhut.getText().toString().trim();

            //  Có nội dung nào đó rỗng thì thông báo cho người ta biết
            if (noiDungCongViec.length() == 0 || gio.length() == 0 || phut.length() == 0) {
                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(v.getContext());
                alertDialogBuilder.setTitle("Thiếu thông tin");
                alertDialogBuilder.setMessage("Vui lòng điền đầy đủ thông tin trước khi nhấn nút \"Thêm công việc \"");
                alertDialogBuilder.setPositiveButton("Biết rồi", (dialog, which) -> {
                });
                alertDialogBuilder.show();
            } else {

                //  Không có thì thêm vô list nếu như công việc và thời gian chưa tồn tại trong list
                String congViec = noiDungCongViec + " - " + gio + ":" + phut;
                listCongViec.add(0, congViec);

                //  Kêu list view cập nhật thông tin mới nhất thông qua adapter
                adapterListCongViec.notifyDataSetChanged();

                //  Xóa hết nội dung của các edit text
                editTextCongViec.setText("");
                editTextGio.setText("");
                editTextPhut.setText("");
            }
        });
    }
}