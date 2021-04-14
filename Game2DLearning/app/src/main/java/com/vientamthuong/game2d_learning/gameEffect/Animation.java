package com.vientamthuong.game2d_learning.gameEffect;

import android.graphics.Bitmap;

import java.util.List;

public class Animation {

    // Khai báo các thuộc tính
    // 1. List ảnh của animation
    List<Bitmap> listImage;
    // 2. List thời gian tương ứng của animation
    List<Long> listDuration;

    public Animation(List<Bitmap> listImage, List<Long> listDuration) {
        this.listImage = listImage;
        this.listDuration = listDuration;
    }



}
