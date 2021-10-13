package com.vientamthuong.midterm;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ViewAdapter extends RecyclerView.Adapter<ViewHolder> {

    private final List<NhacSi> nss;
    private final int resoucre;

    public ViewAdapter(List<NhacSi> nss, int resource) {
        this.nss = nss;
        this.resoucre = resource;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(resoucre, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        NhacSi nhacSi = nss.get(position);
        holder.getT1().setText(nhacSi.getId()+"");
        holder.getT2().setText(nhacSi.getMa_nhac_si());
        holder.getT3().setText(nhacSi.getTen_nhac_si());
    }

    @Override
    public int getItemCount() {
        return nss.size();
    }
}
