package com.vientamthuong.asynctask_loadimageinternet.recyclerViewShowImg;

import android.view.View;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.vientamthuong.asynctask_loadimageinternet.R;

public class ShowImgViewHolder extends RecyclerView.ViewHolder {

    // Khai báo các thuộc tính
    private ImageView imageView;

    public ShowImgViewHolder(@NonNull View itemView) {
        super(itemView);
        // Ánh xạ view
        getView(itemView);
    }

    private void getView(View view) {
        imageView = view.findViewById(R.id.imageView_1);
    }

    // Getter and setter
    public ImageView getImageView() {
        return imageView;
    }

    public void setImageView(ImageView imageView) {
        this.imageView = imageView;
    }

}
