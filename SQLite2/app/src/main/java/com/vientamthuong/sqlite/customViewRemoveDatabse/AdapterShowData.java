package com.vientamthuong.sqlite.customViewRemoveDatabse;

import android.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.vientamthuong.sqlite.activity.QuanLyDuLieuActivity;
import com.vientamthuong.sqlite.database.DatabaseSingleton;
import com.vientamthuong.sqlite.model.ObjectInput;
import com.vientamthuong.sqlite.model.ObjectShowData;

import java.util.List;

public class AdapterShowData extends RecyclerView.Adapter<ViewHolderShowData> {

    private int resoucre;
    private QuanLyDuLieuActivity quanLyDuLieuActivity;
    private List<ObjectShowData> objectShowDatas;

    public AdapterShowData(int resoucre, QuanLyDuLieuActivity quanLyDuLieuActivity, List<ObjectShowData> objectShowDatas) {
        this.resoucre = resoucre;
        this.quanLyDuLieuActivity = quanLyDuLieuActivity;
        this.objectShowDatas = objectShowDatas;
    }

    @NonNull
    @Override
    public ViewHolderShowData onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolderShowData(LayoutInflater.from(quanLyDuLieuActivity).inflate(resoucre, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderShowData holder, int position) {
        ObjectShowData objectShowData = objectShowDatas.get(position);
        holder.getTextViewShowText().setText(objectShowData.getData());
        holder.getButtonRemove().setOnClickListener(v -> {
            AlertDialog.Builder builder = new AlertDialog.Builder(quanLyDuLieuActivity);
            builder.setTitle("Xóa ?");
            builder.setMessage("Xóa phát sửa không được đau :v");
            builder.setPositiveButton("Không", (dialog, which) -> {
            });
            builder.setNegativeButton("Xóa", (dialog, which) -> {
                objectShowDatas.remove(position);
                quanLyDuLieuActivity.remove(objectShowData.getId());
                notifyDataSetChanged();
                Toast.makeText(quanLyDuLieuActivity, "Xóa thành công", Toast.LENGTH_SHORT).show();
            });
            builder.show();
        });
    }

    @Override
    public int getItemCount() {
        return objectShowDatas.size();
    }
}
