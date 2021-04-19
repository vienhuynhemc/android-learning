package com.vientamthuong.sqlite;

import android.app.Dialog;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ViewAdapter viewAdapter;
    private List<CongViec> danhSachCongViec;
    private DAO dao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);
        danhSachCongViec = new ArrayList<>();
        dao = new DAO(MainActivity.this, "CongViec.sqlite", null, 1);
        loadData();
        Button buttonThemCongViec = findViewById(R.id.buttonThemCongViec);
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        viewAdapter = new ViewAdapter(danhSachCongViec, R.layout.activity_line, MainActivity.this);
        recyclerView.setAdapter(viewAdapter);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(MainActivity.this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);
        buttonThemCongViec.setOnClickListener(v -> themCongViec());
    }

    public void remove(int id) {
        dao.updateData("DELETE FROM cong_viec WHERE ma_cong_viec = " + id);
    }

    private void loadData() {
        Cursor cursor = dao.getData("SELECT * FROM cong_viec");
        while (cursor.moveToNext()) {
            int ma_cong_viec = cursor.getInt(0);
            String ten_cong_viec = cursor.getString(1);
            CongViec congViec = new CongViec(ma_cong_viec, ten_cong_viec);
            danhSachCongViec.add(congViec);
        }
    }

    private void themCongViec() {
        Dialog dialog = new Dialog(MainActivity.this);
        dialog.setContentView(R.layout.activity_add);
        dialog.setCanceledOnTouchOutside(false);
        Button buttonThem = dialog.findViewById(R.id.button);
        EditText editText = dialog.findViewById(R.id.editText);
        Button buttonTroLai = dialog.findViewById(R.id.buttonTroLai);
        buttonTroLai.setOnClickListener(v -> dialog.cancel());
        buttonThem.setOnClickListener(v -> {
            String tenCongViec = editText.getText().toString().trim();
            if (tenCongViec.length() == 0) {
                Toast.makeText(dialog.getContext(), "Công việc không thể để trống", Toast.LENGTH_SHORT).show();
            } else {
                dao.updateData("INSERT INTO cong_viec VALUES(null,'" + tenCongViec + "')");
                Cursor cursor = dao.getData("SELECT * FROM cong_viec ORDER BY ma_cong_viec DESC LIMIT 1");
                if (cursor.moveToNext()) {
                    int ma_cong_viec = cursor.getInt(0);
                    String ten_cong_viec = cursor.getString(1);
                    danhSachCongViec.add(new CongViec(ma_cong_viec, ten_cong_viec));
                    viewAdapter.notifyDataSetChanged();
                }
                dialog.cancel();
            }
        });
        dialog.show();
    }

    public void editCongViec(int id, String text) {
        Dialog dialog = new Dialog(MainActivity.this);
        dialog.setContentView(R.layout.activity_edit);
        dialog.setCanceledOnTouchOutside(false);
        Button buttonLuu = dialog.findViewById(R.id.button);
        EditText editText = dialog.findViewById(R.id.editText);
        editText.setText(text);
        Button buttonTroLai = dialog.findViewById(R.id.buttonTroLai);
        buttonTroLai.setOnClickListener(v -> dialog.cancel());
        buttonLuu.setOnClickListener(v -> {
            String tenCongViec = editText.getText().toString().trim();
            if (tenCongViec.length() == 0) {
                Toast.makeText(dialog.getContext(), "Công việc không thể để trống", Toast.LENGTH_SHORT).show();
            } else {
                dao.updateData("UPDATE cong_viec SET ten_cong_viec = '" + tenCongViec + "'  WHERE ma_cong_viec = " + id);
                for (CongViec congViec : danhSachCongViec) {
                    if (congViec.getId() == id) {
                        congViec.setTenCongViec(tenCongViec);
                        viewAdapter.notifyDataSetChanged();
                        break;
                    }
                }
                dialog.cancel();
            }
        });
        dialog.show();
    }
}