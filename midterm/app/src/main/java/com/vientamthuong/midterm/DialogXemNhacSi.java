package com.vientamthuong.midterm;

import android.app.Dialog;
import android.content.Context;
import android.database.Cursor;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class DialogXemNhacSi extends Dialog {

    private RecyclerView recyclerView;
    private ViewAdapter viewAdapter;
    private List<NhacSi> nss;

    public DialogXemNhacSi(@NonNull MainActivity mainActivity) {
        super(mainActivity);
        setContentView(R.layout.dialog_xem_nhac_si);
        nss = new ArrayList<>();
        Cursor cursor = mainActivity.getDatabase().getData("SELECT * FROM ns");
        while (cursor.moveToNext()) {
            int id = cursor.getInt(0);
            String mns = cursor.getString(1);
            String tns = cursor.getString(2);
            nss.add(new NhacSi(mns, tns, id));
        }
        recyclerView = findViewById(R.id.l1);
        viewAdapter = new ViewAdapter(nss, R.layout.view_holder);
        recyclerView.setAdapter(viewAdapter);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(mainActivity);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);
    }

}
