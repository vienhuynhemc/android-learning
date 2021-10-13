package com.vientamthuong.midterm;

import android.app.Dialog;
import android.content.Context;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatButton;

public class DialogThemNhacSi extends Dialog {

    private EditText e1;
    private EditText e2;
    private AppCompatButton b1;
    private AppCompatButton b2;
    private MainActivity mainActivity;

    public DialogThemNhacSi(@NonNull MainActivity mainActivity) {
        super(mainActivity);
        setContentView(R.layout.dialog_them_nhac_si);
        this.mainActivity = mainActivity;
        e1 = findViewById(R.id.e1);
        e2 = findViewById(R.id.e2);
        b1 = findViewById(R.id.b1);
        b2 = findViewById(R.id.b2);
        b2.setOnClickListener(v -> {
            String ma_nhac_si = e1.getText().toString();
            String ten_nhac_si = e2.getText().toString();
            this.mainActivity.getDatabase().updateData("INSERT INTO ns VALUES(null,'" + ma_nhac_si + "','" + ten_nhac_si + "')");
            e1.setText("");
            e2.setText("");
        });
        b1.setOnClickListener(v -> {
            String ma_nhac_si = e1.getText().toString();
            this.mainActivity.getDatabase().updateData("DELETE FROM ns WHERE ma_nhac_si = '" + ma_nhac_si + "'");
            e1.setText("");
            e2.setText("");
        });
    }

}
