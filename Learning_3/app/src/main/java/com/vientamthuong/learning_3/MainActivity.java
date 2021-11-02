package com.vientamthuong.learning_3;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    //  List công việc
    private List<Work> listCongViec;

    //  Adapter kết nối listCongViec với listView
    private ListWorkAdapter listWorkAdapter;

    //  Các hằng để tạo option menu
    public static final int DELETE = Menu.FIRST;
    public static final int ABOUT = Menu.FIRST + 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //  Lấy các View về;
        EditText editTextCongViec = findViewById(R.id.editText_1);
        EditText editTextGio = findViewById(R.id.editText_2);
        EditText editTextPhut = findViewById(R.id.editText_3);
        Button buttonThemCongViec = findViewById(R.id.button_1);
        ListView listView = findViewById(R.id.listView_1);

        //  Khởi tạo listCongViec và kết nối nó với listView
        listCongViec = new ArrayList<>();
        listWorkAdapter = new ListWorkAdapter(this, R.layout.list, listCongViec);
        listView.setAdapter(listWorkAdapter);

        //  action cho button
        buttonThemCongViec.setOnClickListener(v -> {

            String noiDungCongViec = editTextCongViec.getText().toString().trim();
            String gio = editTextGio.getText().toString().trim();
            String phut = editTextPhut.getText().toString().trim();

            //  Kiểm tra 1 trong 3 null thì hiển thị alertDialog.Builder
            if (noiDungCongViec.length() == 0 || gio.length() == 0 || phut.length() == 0) {

                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setTitle("Thiếu thông tin");
                builder.setMessage("Vui lòng điền đẩy đủ thông tin trước khi nhấn \"Thêm công việc\"");
                builder.setPositiveButton("Biết rồi", (dialog, which) -> {
                });
                builder.show();

            } else {

                Work work = new Work(noiDungCongViec, gio + ":" + phut);
                listCongViec.add(0, work);

                // Thông báo cho listview
                listWorkAdapter.notifyDataSetChanged();

                //  Làm trống các editText
                editTextCongViec.setText("");
                editTextGio.setText("");
                editTextPhut.setText("");
            }
        });
    }

    //  Tạo menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        menu.add(0, DELETE, 0, "Xóa").setIcon(android.R.drawable.ic_delete);
        menu.add(0, ABOUT, 0, "Thông tin").setIcon(android.R.drawable.ic_menu_info_details);
        return true;
    }

    //  Xử lý sự kiện thao tác với menu
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (item.getItemId() == DELETE) {
            int count = 0;
            while (count < listCongViec.size()) {
                if (listCongViec.get(count).isCheck()) {
                    listCongViec.remove(count);
                    listWorkAdapter.notifyDataSetChanged();
                } else {
                    count++;
                }
            }
        } else if (item.getItemId() == ABOUT) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("Thông tin");
            builder.setMessage("Được tạo vào ngày 16-2-2021");
            builder.setPositiveButton("Biết rồi", (dialog, which) -> {
            });
            builder.show();
        }

        return true;
    }

}