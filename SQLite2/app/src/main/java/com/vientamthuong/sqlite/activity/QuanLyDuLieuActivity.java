package com.vientamthuong.sqlite.activity;

import android.app.AlertDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.vientamthuong.sqlite.R;
import com.vientamthuong.sqlite.customViewRemoveDatabse.AdapterInput;
import com.vientamthuong.sqlite.customViewRemoveDatabse.AdapterShowData;
import com.vientamthuong.sqlite.database.DatabaseSingleton;
import com.vientamthuong.sqlite.model.Attribute;
import com.vientamthuong.sqlite.model.Database;
import com.vientamthuong.sqlite.model.ObjectInput;
import com.vientamthuong.sqlite.model.ObjectShowData;
import com.vientamthuong.sqlite.model.Table;

import java.util.List;

public class QuanLyDuLieuActivity extends AppCompatActivity {

    private Button buttonTroLai;
    private Spinner spinner;
    private List<Table> tableList;
    private RecyclerView input;
    private List<ObjectInput> objectInputs;
    private AdapterInput adapterInput;
    private Button buttonThemDuLieu;
    private RecyclerView recyclerViewShowData;
    private List<ObjectShowData> objectShowDatas;
    private AdapterShowData adapterShowData;
    private Table nowTable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_FULLSCREEN);
        setContentView(R.layout.activity_quan_ly_du_lieu);
        getView();
        init();
        action();
    }

    private void getView() {
        buttonTroLai = findViewById(R.id.button_back);
        spinner = findViewById(R.id.select_table);
        buttonThemDuLieu = findViewById(R.id.button_them_du_lieu);
        input = findViewById(R.id.input);
        recyclerViewShowData = findViewById(R.id.showData);
    }

    private void init() {
        tableList = DatabaseSingleton.getInstance().getRootDatabase().getAllTable();
        ArrayAdapter<Table> arrayAdapter = new ArrayAdapter<>(QuanLyDuLieuActivity.this, android.R.layout.simple_list_item_1, tableList);
        spinner.setAdapter(arrayAdapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Table table = tableList.get(position);
                nowTable = new Table(table);
                List<ObjectInput> new_list = DatabaseSingleton.getInstance().getRootDatabase().getAllObjectInputs(table.getId_table());
                objectInputs.clear();
                objectInputs.addAll(new_list);
                adapterInput.notifyDataSetChanged();
                List<ObjectShowData> objectShowDatas_new = DatabaseSingleton.getInstance().getNowDatabase().getData(nowTable);
                objectShowDatas.clear();
                objectShowDatas.addAll(objectShowDatas_new);
                adapterShowData.notifyDataSetChanged();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(QuanLyDuLieuActivity.this);
        linearLayoutManager.setSmoothScrollbarEnabled(true);
        linearLayoutManager.setOrientation(RecyclerView.HORIZONTAL);
        input.setLayoutManager(linearLayoutManager);
        objectInputs = DatabaseSingleton.getInstance().getRootDatabase().getAllObjectInputs(tableList.get(0).getId_table());
        adapterInput = new AdapterInput(objectInputs, R.layout.holder_input, QuanLyDuLieuActivity.this);
        input.setAdapter(adapterInput);
        LinearLayoutManager linearLayoutManager1 = new LinearLayoutManager(QuanLyDuLieuActivity.this);
        linearLayoutManager1.setSmoothScrollbarEnabled(true);
        linearLayoutManager1.setOrientation(RecyclerView.VERTICAL);
        recyclerViewShowData.setLayoutManager(linearLayoutManager1);
        objectShowDatas = DatabaseSingleton.getInstance().getNowDatabase().getData(tableList.get(0));
        adapterShowData = new AdapterShowData(R.layout.holder_show_data, QuanLyDuLieuActivity.this, objectShowDatas);
        recyclerViewShowData.setAdapter(adapterShowData);
        updateView();
    }

    private void updateView() {

    }

    private void action() {
        buttonTroLai.setOnClickListener(v -> {
            onBackPressed();
        });
        buttonThemDuLieu.setOnClickListener(v -> {
            try {
                AlertDialog.Builder builder = new AlertDialog.Builder(QuanLyDuLieuActivity.this);
                builder.setTitle("Thêm dữ liêu mới?");
                builder.setMessage("Thêm phát là vô Database luôn đấy :v");
                builder.setPositiveButton("Không", (dialog, which) -> {
                });
                builder.setNegativeButton("Thêm", (dialog, which) -> {
                    String data = "";
                    for (ObjectInput objectInput : objectInputs) {
                        if (objectInput.getType().equals("INTEGER")) {
                            int number = Integer.parseInt(objectInput.getData());
                            data += number + ",";
                        } else {
                            data += "'" + objectInput.getData() + "',";
                        }
                    }
                    data = data.substring(0, data.length() - 1);
                    DatabaseSingleton.getInstance().getNowDatabase().addNewRow(data, nowTable);
                    List<ObjectShowData> objectShowDatas_new = DatabaseSingleton.getInstance().getNowDatabase().getData(nowTable);
                    objectShowDatas.clear();
                    objectShowDatas.addAll(objectShowDatas_new);
                    adapterShowData.notifyDataSetChanged();
                    Toast.makeText(QuanLyDuLieuActivity.this, "Thêm dữ liệu thành công", Toast.LENGTH_SHORT).show();
                });
                builder.show();
            } catch (Exception e) {
                Toast.makeText(QuanLyDuLieuActivity.this, "Lỗi nhập liệu", Toast.LENGTH_SHORT).show();
            }
        });
    }


    public void remove(int id){
        DatabaseSingleton.getInstance().getNowDatabase().removeRow(id, nowTable);
    }
}
