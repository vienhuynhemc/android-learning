package com.vientamthuong.intent_bai_tap.selectHinh;

import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.vientamthuong.intent_bai_tap.idImg.IdImg;

import java.util.List;

public class SelectHinhAdapter extends RecyclerView.Adapter<SelectHinhViewHolder> {

    // Khai báo các thuộc tính
    private final List<Integer> listIdImg;
    private final int resource;
    private final Context context;
    private final IdImg idImg;
    private final Dialog dialog;

    public SelectHinhAdapter(List<Integer> listIdImg, int resource, Context context, IdImg idImg, Dialog dialog) {
        this.listIdImg = listIdImg;
        this.resource = resource;
        this.context = context;
        this.idImg = idImg;
        this.dialog = dialog;
    }

    @NonNull
    @Override
    public SelectHinhViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new SelectHinhViewHolder(LayoutInflater.from(context).inflate(resource, parent, false), 0, idImg, dialog);
    }

    @Override
    public void onBindViewHolder(@NonNull SelectHinhViewHolder holder, int position) {
        holder.setIndex(position);
        holder.getImageViewHienThi().setImageResource(listIdImg.get(position));
    }

    @Override
    public int getItemCount() {
        return listIdImg.size();
    }
}
