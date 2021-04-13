package com.vientamthuong.nghenhac.viewDanhSachNhac;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.vientamthuong.nghenhac.MainActivity;
import com.vientamthuong.nghenhac.R;
import com.vientamthuong.nghenhac.model.Music;

public class ViewDanhSachNhacAdpater extends RecyclerView.Adapter<ViewDanhSachNhacViewHolder> {

    private MainActivity mainActivity;

    public ViewDanhSachNhacAdpater(MainActivity mainActivity) {
        this.mainActivity = mainActivity;
    }

    @NonNull
    @Override
    public ViewDanhSachNhacViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewDanhSachNhacViewHolder(LayoutInflater.from(mainActivity).inflate(R.layout.custom_view_holder, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewDanhSachNhacViewHolder holder, int position) {
        Music music = mainActivity.getDanhSachNhac().get(position);
        if (music.isSelect()) {
            holder.getLayout().setBackgroundColor(mainActivity.getColor(R.color.select));
            holder.getButtonPlay().setVisibility(View.VISIBLE);
        } else {
            holder.getLayout().setBackgroundColor(mainActivity.getColor(R.color.dontSelect));
            holder.getButtonPlay().setVisibility(View.INVISIBLE);
        }
        if (music.isPlay()) {
            holder.getButtonPlay().setImageResource(R.drawable.ic_baseline_pause_24);
        } else {
            holder.getButtonPlay().setImageResource(R.drawable.ic_baseline_play_arrow_24);
        }
        holder.getTextViewTenBaiHat().setText(music.getName());
        holder.getTextViewTenCaSy().setText(music.getTenCaSi());
        holder.getTextViewThoiGian().setText(music.getTime());
        holder.getImageViewHinhNhac().setImageResource(music.getIdImage());
    }

    @Override
    public int getItemCount() {
        return mainActivity.getDanhSachNhac().size();
    }
}
