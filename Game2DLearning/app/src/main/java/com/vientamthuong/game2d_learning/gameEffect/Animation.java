package com.vientamthuong.game2d_learning.gameEffect;

import android.graphics.Bitmap;
import android.graphics.Canvas;

import java.util.ArrayList;
import java.util.List;

public class Animation {

    // Khai báo các thuộc tính
    // 1. List ảnh của animation
    private List<Bitmap> listImage;
    // 2. List thời gian tương ứng của animation
    private List<Long> listDuration;
    private List<Boolean> listIgnore;
    private boolean isRepeat;

    private int currentImage;

    private long lastTimeUpdate;

    public Animation(List<Bitmap> listImage, List<Long> listDuration) {
        this.listImage = listImage;
        this.listDuration = listDuration;
        listIgnore = new ArrayList<>();
        isRepeat = true;
    }

    public void update(long time) {
        if (lastTimeUpdate == 0) {
            lastTimeUpdate = System.currentTimeMillis();
        } else {
            if (time - lastTimeUpdate > listDuration.get(currentImage)) {
                lastTimeUpdate = time;
                nextImage();
            }
        }
    }

    public void nextImage() {
        if (currentImage == listImage.size() - 1) {
            if (isRepeat) {
                currentImage = 0;
            }
        } else {
            currentImage++;
        }
        if (listIgnore.get(currentImage)) nextImage();
    }

    public void draw(Canvas canvas, int x, int y) {
        canvas.drawBitmap(listImage.get(currentImage), x, y, null);
    }

    public boolean isEndAnimation() {
        return currentImage == (listImage.size() - 1);
    }

    public void reset() {
        currentImage = 0;
        lastTimeUpdate = 0;
    }

    public List<Bitmap> getListImage() {
        return listImage;
    }

    public void setListImage(List<Bitmap> listImage) {
        this.listImage = listImage;
    }

    public List<Long> getListDuration() {
        return listDuration;
    }

    public void setListDuration(List<Long> listDuration) {
        this.listDuration = listDuration;
    }

    public List<Boolean> getListIgnore() {
        return listIgnore;
    }

    public void setListIgnore(List<Boolean> listIgnore) {
        this.listIgnore = listIgnore;
    }

    public boolean isRepeat() {
        return isRepeat;
    }

    public void setRepeat(boolean repeat) {
        isRepeat = repeat;
    }

    public int getCurrentImage() {
        return currentImage;
    }

    public void setCurrentImage(int currentImage) {
        this.currentImage = currentImage;
    }

    public long getLastTimeUpdate() {
        return lastTimeUpdate;
    }

    public void setLastTimeUpdate(long lastTimeUpdate) {
        this.lastTimeUpdate = lastTimeUpdate;
    }
}
