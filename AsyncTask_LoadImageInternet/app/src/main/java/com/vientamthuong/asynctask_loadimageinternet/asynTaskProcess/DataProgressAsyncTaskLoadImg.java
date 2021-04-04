package com.vientamthuong.asynctask_loadimageinternet.asynTaskProcess;

import android.graphics.Bitmap;

public class DataProgressAsyncTaskLoadImg {

    private int index;
    private Bitmap bitmap;

    public DataProgressAsyncTaskLoadImg(int index, Bitmap bitmap) {
        this.index = index;
        this.bitmap = bitmap;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public Bitmap getBitmap() {
        return bitmap;
    }

    public void setBitmap(Bitmap bitmap) {
        this.bitmap = bitmap;
    }
}
