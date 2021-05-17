package com.vientamthuong.sqlite.customViewRemoveDatabse;

import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.vientamthuong.sqlite.R;

public class ViewHolderInput extends RecyclerView.ViewHolder {

    private TextView textViewTenThuocTinh;
    private TextView textViewLoaiThuocTinh;
    private EditText editTextData;


    public ViewHolderInput(@NonNull View itemView) {
        super(itemView);
        textViewTenThuocTinh = itemView.findViewById(R.id.ten_thuoc_tinh);
        textViewLoaiThuocTinh = itemView.findViewById(R.id.loai_thuoc_tinh);
        editTextData = itemView.findViewById(R.id.oNhap);
    }

    public TextView getTextViewTenThuocTinh() {
        return textViewTenThuocTinh;
    }

    public void setTextViewTenThuocTinh(TextView textViewTenThuocTinh) {
        this.textViewTenThuocTinh = textViewTenThuocTinh;
    }

    public TextView getTextViewLoaiThuocTinh() {
        return textViewLoaiThuocTinh;
    }

    public void setTextViewLoaiThuocTinh(TextView textViewLoaiThuocTinh) {
        this.textViewLoaiThuocTinh = textViewLoaiThuocTinh;
    }

    public EditText getEditTextData() {
        return editTextData;
    }

    public void setEditTextData(EditText editTextData) {
        this.editTextData = editTextData;
    }
}
