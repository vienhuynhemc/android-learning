package com.vientamthuong.baitaplinearlayout_dotplayscom_bai_2_lan_1;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<SubRecyclerViewViewHoler> {

    // Nhận vô list đối tượng và context cho dễ sử dụng
    private List<SubRecyclerViewObject> list;
    private Context context;

    public RecyclerViewAdapter(List<SubRecyclerViewObject> list, Context context) {
        this.list = list;
        this.context = context;
    }

    // Nạp view
    @NonNull
    @Override
    public SubRecyclerViewViewHoler onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        return new SubRecyclerViewViewHoler(layoutInflater.inflate(R.layout.activity_sub_recycler_view, parent, false));
    }

    // Gán dữ liêu vào view
    @SuppressLint("UseCompatLoadingForDrawables")
    @Override
    public void onBindViewHolder(@NonNull SubRecyclerViewViewHoler holder, int position) {
        SubRecyclerViewObject subRecyclerViewObject = list.get(position);
        holder.getLogo().setBackground(ContextCompat.getDrawable(context, subRecyclerViewObject.getResourceImg()));
        holder.getName().setText(subRecyclerViewObject.getName());
        holder.getPrice().setText(subRecyclerViewObject.getPrice());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }


}
