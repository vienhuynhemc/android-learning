package com.vientamthuong.learning_15;

import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class StudentViewHoler extends RecyclerView.ViewHolder {

    private TextView tenSinhVien;
    private TextView maSoSinhVien;
    private CheckBox isChecked;

    public StudentViewHoler(View itemView) {
        super(itemView);

        // Lấy view từ itemView
        tenSinhVien = itemView.findViewById(R.id.textView_1);
        maSoSinhVien = itemView.findViewById(R.id.textView_2);
        isChecked = itemView.findViewById(R.id.checkBox_1);

        itemView.setOnClickListener(v -> Toast.makeText(itemView.getContext(), tenSinhVien.getText() + " | " + maSoSinhVien.getText(), Toast.LENGTH_SHORT).show());

    }

    //  Getter and setter
    public TextView getTenSinhVien() {
        return tenSinhVien;
    }

    public void setTenSinhVien(TextView tenSinhVien) {
        this.tenSinhVien = tenSinhVien;
    }

    public TextView getMaSoSinhVien() {
        return maSoSinhVien;
    }

    public void setMaSoSinhVien(TextView maSoSinhVien) {
        this.maSoSinhVien = maSoSinhVien;
    }

    public CheckBox getIsChecked() {
        return isChecked;
    }

    public void setIsChecked(CheckBox isChecked) {
        this.isChecked = isChecked;
    }

}
