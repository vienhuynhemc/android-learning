package com.vientamthuong.learning_3_1;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    //  Id của menu
    public static final int ABOUT = Menu.FIRST;
    public static final int REMOVE = Menu.FIRST + 1;

    //  Có list công việc và adapter kết nối với listview
    private List<Work> listCongViec;
    private CustomViewWorkAdapter adapterCongViec;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //  Lấy các đối tượng ra
        ListView listViewCongViec = findViewById(R.id.listView_1);
        Button buttonThemCongViec = findViewById(R.id.button_1);
        Button buttonChonTatCa = findViewById(R.id.button_2);
        EditText editTextTenCongViec = findViewById(R.id.editText_1);
        EditText editTextGio = findViewById(R.id.editText_2);
        EditText editTextPhut = findViewById(R.id.editText_3);

        //  Kết nối list công việc với listview thông qua adapter công việc
        listCongViec = new ArrayList<>();
        listCongViec.add(new Work("Xuống la hai chơi với em yêu", "8:49", false));
        listCongViec.add(new Work("Xuống la hai chơi với em yêu", "8:50", false));
        listCongViec.add(new Work("Xuống la hai chơi với em yêu", "8:51", false));
        listCongViec.add(new Work("Xuống la hai chơi với em yêu", "8:52", false));
        listCongViec.add(new Work("Xuống la hai chơi với em yêu", "8:53", false));
        adapterCongViec = new CustomViewWorkAdapter(this, R.layout.custom_view_work, listCongViec);
        listViewCongViec.setAdapter(adapterCongViec);

        //  Action cho button thêm công việc
        buttonThemCongViec.setOnClickListener(v -> {

            //  Lấy nội dung từ tụi editText ra
            String tenCongViec = editTextTenCongViec.getText().toString().trim();
            String gio = editTextGio.getText().toString().trim();
            String phut = editTextPhut.getText().toString().trim();

            //  Kiểm tra nếu có 1 trong 3 ô rỗng thì thông báo rằng thiếu thông tin
            if (tenCongViec.length() == 0 || gio.length() == 0 || phut.length() == 0) {
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setTitle("Thiếu thông tin");
                builder.setMessage("Vui lòng điền đầy đủ thông tin trước khi nhấn nút \"Thêm công việc\"");
                builder.setPositiveButton("Biết rồi", (dialog, which) -> Toast.makeText(getApplicationContext(), "Bạn vừa nhấn \"Biết rồi\"", Toast.LENGTH_SHORT).show());
                builder.show();
            } else {

                //  Thêm công việc mới
                listCongViec.add(0, new Work(tenCongViec, gio + ":" + phut, false));

                //  Thông báo từ adapter để listview cập nhật lại
                adapterCongViec.notifyDataSetChanged();

                //  Tạo thông báo nhỏ hiển thị lên màn hình
                Toast.makeText(getApplicationContext(), "Thêm một công việc thành công", Toast.LENGTH_SHORT).show();

                //  Làm trống các edit Text
                editTextTenCongViec.setText("");
                editTextPhut.setText("");
                editTextGio.setText("");

            }
        });

        //  action cho button chọn tất cả
        buttonChonTatCa.setOnClickListener(v -> {

            boolean check = false;
            for (Work work : listCongViec)
                if (work.isSelect()) {
                    check = true;
                    break;
                }

            if (!check)
                for (Work work : listCongViec)
                    work.setSelect(true);

            else
                for (Work work : listCongViec)
                    work.setSelect(false);

            adapterCongViec.notifyDataSetChanged();
        });
    }

    //  Tạo menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        menu.add(0, REMOVE, 0, "Xóa");
        menu.add(0, ABOUT, 0, "Thông tin ứng dụng");
        return true;
    }

    //  Xử lý các lựa chọn của menu
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case ABOUT:
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setTitle("Thông tin ứng dụng");
                builder.setMessage("Được tạo vào 18 tháng 2 năm 2021");
                builder.setPositiveButton("à", (dialog, which) -> Toast.makeText(getApplicationContext(), "Bạn vừa nhấn à", Toast.LENGTH_SHORT).show());
                builder.setNegativeButton("ừm", (dialog, which) -> Toast.makeText(getApplicationContext(), "Bạn vừa nhấn ừm", Toast.LENGTH_SHORT).show());
                builder.show();
                break;
            case REMOVE:
                int count = 0;
                while (count < listCongViec.size()) {
                    if (listCongViec.get(count).isSelect()) {
                        listCongViec.remove(count);
                        adapterCongViec.notifyDataSetChanged();
                    } else
                        count++;
                }
                break;
        }

        return true;
    }

}