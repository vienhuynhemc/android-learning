package com.vientamthuong.intent_bai_tap.selectHinh;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.vientamthuong.intent_bai_tap.MainActivity;
import com.vientamthuong.intent_bai_tap.R;
import com.vientamthuong.intent_bai_tap.idImg.IdImg;

public class SelectHinhViewHolder extends RecyclerView.ViewHolder {

    // Khai báo các thuộc tính
    private ImageView imageViewHienThi;
    private int index;
    private IdImg idImg;
    private Dialog dialog;

    public SelectHinhViewHolder(@NonNull View itemView, int index, IdImg idImg, Dialog dialog) {
        super(itemView);
        this.index = index;
        this.idImg = idImg;
        this.dialog = dialog;
        // Ánh xạ view
        getView(itemView);
        // action to imageView
        actionImageView();
    }

    private void actionImageView() {
        imageViewHienThi.setOnClickListener(v -> {
            idImg.setIndex(index);
            dialog.cancel();
        });
    }

    private void getView(View view) {
        imageViewHienThi = view.findViewById(R.id.viewHolderOneImage_imageView_1);
    }

    public ImageView getImageViewHienThi() {
        return imageViewHienThi;
    }

    public void setImageViewHienThi(ImageView imageViewHienThi) {
        this.imageViewHienThi = imageViewHienThi;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public Dialog getDialog() {
        return dialog;
    }

    public void setDialog(Dialog dialog) {
        this.dialog = dialog;
    }
}
