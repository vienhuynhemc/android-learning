package com.vientamthuong.nghenhac.viewDanhSachNhac;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.vientamthuong.nghenhac.R;

public class ViewDanhSachNhacViewHolder extends RecyclerView.ViewHolder {

    private ImageView imageViewHinhNhac;
    private TextView textViewTenCaSy;
    private TextView textViewTenBaiHat;
    private TextView textViewThoiGian;
    private ConstraintLayout layout;
    private View view;
    private AppCompatImageButton buttonPlay;

    public ViewDanhSachNhacViewHolder(@NonNull View itemView) {
        super(itemView);
        this.view = itemView;
        getView(itemView);
    }

    private void getView(View view) {
        imageViewHinhNhac = view.findViewById(R.id.viewHolder_imageView);
        textViewTenBaiHat = view.findViewById(R.id.viewHolder_name);
        textViewTenCaSy = view.findViewById(R.id.viewHolder_tenCaSy);
        buttonPlay = view.findViewById(R.id.viewHolder_buttonPlay);
        textViewThoiGian = view.findViewById(R.id.viewHolder_thoiGian);
        layout = view.findViewById(R.id.layoutViewHolder);
    }

    public ImageView getImageViewHinhNhac() {
        return imageViewHinhNhac;
    }

    public void setImageViewHinhNhac(ImageView imageViewHinhNhac) {
        this.imageViewHinhNhac = imageViewHinhNhac;
    }

    public TextView getTextViewTenCaSy() {
        return textViewTenCaSy;
    }

    public void setTextViewTenCaSy(TextView textViewTenCaSy) {
        this.textViewTenCaSy = textViewTenCaSy;
    }

    public TextView getTextViewTenBaiHat() {
        return textViewTenBaiHat;
    }

    public void setTextViewTenBaiHat(TextView textViewTenBaiHat) {
        this.textViewTenBaiHat = textViewTenBaiHat;
    }

    public TextView getTextViewThoiGian() {
        return textViewThoiGian;
    }

    public void setTextViewThoiGian(TextView textViewThoiGian) {
        this.textViewThoiGian = textViewThoiGian;
    }

    public AppCompatImageButton getButtonPlay() {
        return buttonPlay;
    }

    public void setButtonPlay(AppCompatImageButton buttonPlay) {
        this.buttonPlay = buttonPlay;
    }

    public ConstraintLayout getLayout() {
        return layout;
    }

    public void setLayout(ConstraintLayout layout) {
        this.layout = layout;
    }

    public View getView() {
        return view;
    }
}
