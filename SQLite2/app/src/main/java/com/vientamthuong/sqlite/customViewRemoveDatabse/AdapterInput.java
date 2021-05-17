package com.vientamthuong.sqlite.customViewRemoveDatabse;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.vientamthuong.sqlite.activity.QuanLyDuLieuActivity;
import com.vientamthuong.sqlite.model.ObjectInput;

import java.util.List;

public class AdapterInput extends RecyclerView.Adapter<ViewHolderInput> {

    private List<ObjectInput> objectInputs;
    private int resoucre;
    private QuanLyDuLieuActivity quanLyDuLieuActivity;

    public AdapterInput(List<ObjectInput> objectInputs, int resoucre, QuanLyDuLieuActivity quanLyDuLieuActivity) {
        this.objectInputs = objectInputs;
        this.resoucre = resoucre;
        this.quanLyDuLieuActivity = quanLyDuLieuActivity;
    }

    @NonNull
    @Override
    public ViewHolderInput onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolderInput(LayoutInflater.from(quanLyDuLieuActivity).inflate(resoucre, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderInput holder, int position) {
        ObjectInput objectInput = objectInputs.get(position);
        holder.getTextViewLoaiThuocTinh().setText(objectInput.getType());
        holder.getTextViewTenThuocTinh().setText(objectInput.getName_col());
        holder.getEditTextData().addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                objectInput.setData(s.toString());
            }
        });
    }

    @Override
    public int getItemCount() {
        return objectInputs.size();
    }
}
