package com.vientamthuong.sqlite;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.vientamthuong.sqlite.activity.ManagerTableActitvity;
import com.vientamthuong.sqlite.activity.QuanLyDuLieuActivity;
import com.vientamthuong.sqlite.activity.RemoveActivity;
import com.vientamthuong.sqlite.database.DatabaseSingleton;
import com.vientamthuong.sqlite.dialog.DiaLogCreateDatabase;
import com.vientamthuong.sqlite.dialog.DiaLogSelectDatabase;

public class MainActivity extends AppCompatActivity {

    private TextView textViewShowNumbsDatabase;
    private TextView textViewShowSelectDatabase;
    private TextView textViewShowNumbsTable;
    private Button buttonSelectDatabase;
    private Button buttonCreateDatabase;
    private Button buttonRemoveDatabase;
    private Button buttonCreateTable;
    private Button buttonQuanLyDuLieu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);
        // Ánh xạ view
        getView();
        // Khởi tạo
        init();
        // action
        action();
    }

    private void action() {
        actionForButtonCreateDatabase();
        actionForButtonRemoveDatabase();
        actionForButtonCreateTable();
    }

    private void actionForButtonCreateTable() {
        buttonCreateTable.setOnClickListener(v -> {
            Intent intent = new Intent();
            intent.setClass(MainActivity.this, ManagerTableActitvity.class);
            startActivity(intent);
        });
    }

    private void actionForButtonRemoveDatabase() {
        buttonRemoveDatabase.setOnClickListener(v -> {
            Intent intent = new Intent();
            intent.setClass(MainActivity.this, RemoveActivity.class);
            startActivity(intent);
        });
    }

    private void actionForButtonCreateDatabase() {
        buttonCreateDatabase.setOnClickListener(v -> {
            DiaLogCreateDatabase diaLogCreateDatabase = new DiaLogCreateDatabase(MainActivity.this);
            diaLogCreateDatabase.show();
        });
        buttonSelectDatabase.setOnClickListener(v -> {
            DiaLogSelectDatabase diaLogSelectDatabase = new DiaLogSelectDatabase(MainActivity.this);
            diaLogSelectDatabase.show();
        });
        buttonQuanLyDuLieu.setOnClickListener(v -> {
            Intent intent = new Intent();
            intent.setClass(MainActivity.this, QuanLyDuLieuActivity.class);
            startActivity(intent);
        });
    }

    private void getView() {
        textViewShowNumbsDatabase = findViewById(R.id.textView_show_number_database);
        textViewShowSelectDatabase = findViewById(R.id.textView_show_select_database);
        textViewShowNumbsTable = findViewById(R.id.textView_show_number_table);
        buttonSelectDatabase = findViewById(R.id.button_select_database);
        buttonCreateDatabase = findViewById(R.id.button_create_database);
        buttonRemoveDatabase = findViewById(R.id.button_remove_databse);
        buttonCreateTable = findViewById(R.id.button_create_table);
        buttonQuanLyDuLieu = findViewById(R.id.button_quan_ly_du_lieu);
    }

    private void init() {
        // database
        DatabaseSingleton.getInstance().init(MainActivity.this);
        updateView();
    }

    @SuppressLint("SetTextI18n")
    public void updateView() {
        int numbsDatabase = DatabaseSingleton.getInstance().getRootDatabase().getNumbsDatabase();
        textViewShowNumbsDatabase.setText("Số Database hiện tại: " + numbsDatabase);
        if (numbsDatabase == 0) {
            buttonSelectDatabase.setEnabled(false);
            buttonRemoveDatabase.setEnabled(false);
        } else {
            buttonRemoveDatabase.setEnabled(true);
            buttonSelectDatabase.setEnabled(true);
        }
        if (DatabaseSingleton.getInstance().getNowDatabase() != null) {
            int numbsTableNow = DatabaseSingleton.getInstance().getRootDatabase().getNumbsTableNowDatabase();
            buttonQuanLyDuLieu.setEnabled(numbsTableNow != 0);
            textViewShowSelectDatabase.setText("Database đang sử dụng: " + DatabaseSingleton.getInstance().getNowDatabase().getDatabase().getName());
            buttonCreateTable.setEnabled(true);
            textViewShowNumbsTable.setText("Số Table hiện tại: " + DatabaseSingleton.getInstance().getRootDatabase().getNumbsTableNowDatabase());
        } else {
            buttonQuanLyDuLieu.setEnabled(false);
            textViewShowSelectDatabase.setText("Database đang sử dụng: Chưa chọn");
            buttonCreateTable.setEnabled(false);
            textViewShowNumbsTable.setText("Số Table hiện tại: Chưa chọn Database");
        }
    }


}