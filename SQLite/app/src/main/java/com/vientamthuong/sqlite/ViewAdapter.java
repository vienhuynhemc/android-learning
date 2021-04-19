package com.vientamthuong.sqlite;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ViewAdapter extends RecyclerView.Adapter<ViewHolder> {

    private final List<CongViec> danhSachCongViec;
    private final int resoucre;
    private final MainActivity mainActivity;

    public ViewAdapter(List<CongViec> danhSachCongViec, int resource, MainActivity mainActivity) {
        this.danhSachCongViec = danhSachCongViec;
        this.resoucre = resource;
        this.mainActivity = mainActivity;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(mainActivity).inflate(resoucre, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        CongViec congViec = danhSachCongViec.get(position);
        holder.getTextView().setText(congViec.getTenCongViec());
        Button buttonXoa = holder.getButtonRemove();
        Button buttonEdit = holder.getButtonEdit();
        buttonXoa.setOnClickListener(v -> {
            mainActivity.remove(danhSachCongViec.get(position).getId());
            danhSachCongViec.remove(position);
            notifyDataSetChanged();
        });
        buttonEdit.setOnClickListener(v -> mainActivity.editCongViec(danhSachCongViec.get(position).getId(), danhSachCongViec.get(position).getTenCongViec()));
    }

    @Override
    public int getItemCount() {
        return danhSachCongViec.size();
    }
}
