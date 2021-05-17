package com.vientamthuong.sqlite.dialog;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.vientamthuong.sqlite.MainActivity;
import com.vientamthuong.sqlite.R;
import com.vientamthuong.sqlite.customViewRemoveDatabse.AdapterSelectDatabase;
import com.vientamthuong.sqlite.database.DatabaseSingleton;
import com.vientamthuong.sqlite.model.Database;

import java.util.ArrayList;
import java.util.List;

public class DiaLogSelectDatabase extends Dialog {

    private EditText editTextFind;
    private Button buttonBack;
    private RecyclerView recyclerViewDanhSachDatabase;
    private MainActivity mainActivity;
    private List<Database> databasesRoot;
    private List<Database> databasesFind;
    private AdapterSelectDatabase adapterSelectDatabase;
    private TextView textViewNotFound;

    public DiaLogSelectDatabase(@NonNull MainActivity mainActivity) {
        super(mainActivity);
        this.mainActivity = mainActivity;
        setCanceledOnTouchOutside(false);
        setContentView(R.layout.dialog_select_databse);
        getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        getView();
        init();
        action();
    }

    private void init() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(mainActivity);
        linearLayoutManager.setSmoothScrollbarEnabled(true);
        linearLayoutManager.setOrientation(RecyclerView.VERTICAL);
        recyclerViewDanhSachDatabase.setLayoutManager(linearLayoutManager);
        databasesRoot = DatabaseSingleton.getInstance().getRootDatabase().getAll();
        databasesFind = new ArrayList<>(databasesRoot);
        adapterSelectDatabase = new AdapterSelectDatabase(databasesFind, mainActivity, R.layout.holder_select_database, DiaLogSelectDatabase.this);
        recyclerViewDanhSachDatabase.setAdapter(adapterSelectDatabase);
        updateView();
    }

    private void getView() {
        editTextFind = findViewById(R.id.editText_find);
        buttonBack = findViewById(R.id.button_back);
        recyclerViewDanhSachDatabase = findViewById(R.id.danh_sach_database);
        textViewNotFound = findViewById(R.id.text_view_not_found);
    }

    private void action() {
        buttonBack.setOnClickListener(v -> dismiss());
        editTextFind.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                String nowText = s.toString().trim().toLowerCase();
                databasesFind.clear();
                if (nowText.length() == 0) {
                    for (Database database : databasesRoot) {
                        databasesFind.add(new Database(database));
                    }
                } else {
                    for (Database database : databasesRoot) {
                        if (database.getName().toLowerCase().contains(nowText)) {
                            databasesFind.add(new Database(database));
                        }
                    }
                }
                adapterSelectDatabase.notifyDataSetChanged();
                updateView();
            }
        });
    }

    private void updateView() {
        if (databasesFind.size() == 0) {
            textViewNotFound.setVisibility(View.VISIBLE);
        } else {
            textViewNotFound.setVisibility(View.GONE);
        }
    }

    @Override
    public void onBackPressed() {
    }

    public void complete() {
        mainActivity.updateView();
        dismiss();
    }
}
