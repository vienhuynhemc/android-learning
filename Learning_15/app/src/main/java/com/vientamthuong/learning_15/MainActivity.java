package com.vientamthuong.learning_15;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearSnapHelper;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SnapHelper;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private StudentAdapter studentAdapter;
    private List<Student> danhSachSinhVien;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Lấy view
        recyclerView = findViewById(R.id.recyclerView_1);
        FloatingActionButton floatingActionButton = findViewById(R.id.floatActionButton_1);

        //  init list Sinh Vien
        danhSachSinhVien = new ArrayList<>();
        for (int i = 0; i < 100; i++)
            danhSachSinhVien.add(new Student("Sinh viên " + i, "Mã số sinh viên: " + i, false));

        danhSachSinhVien.add(0, new Student("Sinh viên adfa", "Mã số sinh viên: adsfadsfasdfasdfasdfasdfasdf", false));

        //  Tạo RecyclerView.Adapter
        studentAdapter = new StudentAdapter(danhSachSinhVien);

        //  Taoj layoutManager cho recyclerView
        //  1 .linear layout như linearlayout thông thường
//        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(MainActivity.this);
//        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
//        linearLayoutManager.setReverseLayout(true);
//        linearLayoutManager.scrollToPosition(10);
//        recyclerView.setLayoutManager(linearLayoutManager);
        // 2. GridLaout cũng khá giống linear layout nhưng thếm số cột/dòng cố định
        // hay nói cách khác linear layout là grid layout có số cột/ dong = 1
        StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(staggeredGridLayoutManager);

        //  Kết nối RecyclerView với danh sach sinh viên và layoutmanager
        recyclerView.setAdapter(studentAdapter);

        //  Trang tri cho recycker view
//        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(MainActivity.this,DividerItemDecoration.VERTICAL);
//        dividerItemDecoration.setDrawable(getDrawable(R.drawable.ic_baseline_perm_identity_24));
//        recyclerView.addItemDecoration(dividerItemDecoration);
        recyclerView.addItemDecoration(new SpaceItemDecoration(10));

        //  Căn lề khi cuộn cho view được hiển thị toàn ven
        SnapHelper s = new LinearSnapHelper();
        s.attachToRecyclerView(recyclerView);

        // action for fab
        Snackbar snackbar = Snackbar.make(recyclerView, "", Snackbar.LENGTH_SHORT);
        snackbar.setTextColor(getColor(R.color.teal_200));
        snackbar.setBackgroundTint(getColor(R.color.white));

        floatingActionButton.setOnClickListener(v -> {

            int count = 0;
            for (int i = 0; i < danhSachSinhVien.size(); i++) {
                if (danhSachSinhVien.get(i).isChecked()) {
                    count = 1;
                    break;
                }
            }

            if (count == 1) {

                count = 0;
                int numberRemoved = 0;
                while (count < danhSachSinhVien.size()) {
                    if (danhSachSinhVien.get(count).isChecked()) {
                        danhSachSinhVien.remove(count);
                        numberRemoved++;
                    } else {
                        count++;
                    }
                }

                studentAdapter.notifyDataSetChanged();

                snackbar.setText("Bạn đã xóa " + numberRemoved + " sinh viên");
                snackbar.show();

            } else {
                Toast.makeText(MainActivity.this, "Vui lòng chọn sinh viên muốn xóa", Toast.LENGTH_SHORT).show();
            }

        });

        //   gán lại support actionbar
        Toolbar toolbar = findViewById(R.id.toolbar_1);
        setSupportActionBar(toolbar);

        //   Thiết lập danh sách cố định
        recyclerView.setHasFixedSize(true);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_1:
                Student student = danhSachSinhVien.get(2);
                student.setTenSinhVien(student.getTenSinhVien() + " [ Đã thay đổi ]");
                studentAdapter.notifyItemChanged(2);
                break;
            case R.id.menu_2:
                Student newStudent = new Student("Sinh viên mới", "Mã sinh viên mới", false);
                danhSachSinhVien.add(2, newStudent);
                studentAdapter.notifyItemInserted(2);
                break;
            case R.id.menu_3:
                danhSachSinhVien.remove(0);
                studentAdapter.notifyItemRemoved(0);
                break;
            case R.id.menu_4:
                for (int i = 0; i < 7; i++) {
                    newStudent = new Student("Sinh viên mới", "Mã sinh viên mới", false);
                    danhSachSinhVien.add(0, newStudent);
                }
                studentAdapter.notifyItemRangeInserted(0, 7);
                break;

            case R.id.menu_5:
                recyclerView.smoothScrollToPosition(danhSachSinhVien.size() - 1);
                break;
            case R.id.menu_6:
                recyclerView.scrollTo(200, 200);
                break;
            default:
                break;
        }
        return true;
    }

}