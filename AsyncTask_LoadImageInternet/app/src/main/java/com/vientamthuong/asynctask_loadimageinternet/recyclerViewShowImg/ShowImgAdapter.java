package com.vientamthuong.asynctask_loadimageinternet.recyclerViewShowImg;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ShowImgAdapter extends RecyclerView.Adapter<ShowImgViewHolder> {

    private int resource;
    private Context context;
    private Bitmap[] bitmaps;

    public ShowImgAdapter(int resource, Context context, Bitmap[] bitmaps) {
        this.resource = resource;
        this.context = context;
        this.bitmaps = bitmaps;
    }

    @NonNull
    @Override
    public ShowImgViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ShowImgViewHolder(LayoutInflater.from(context).inflate(resource, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ShowImgViewHolder holder, int position) {
        if (bitmaps[position] != null) {
            holder.getImageView().setImageBitmap(bitmaps[position]);
        }
    }

    @Override
    public int getItemCount() {
        return bitmaps.length;
    }

}
