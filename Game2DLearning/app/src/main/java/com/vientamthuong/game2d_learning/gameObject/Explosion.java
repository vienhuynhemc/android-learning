package com.vientamthuong.game2d_learning.gameObject;

import android.graphics.Canvas;

import com.vientamthuong.game2d_learning.gameEffect.Animation;
import com.vientamthuong.game2d_learning.loadData.LoadAnimation;

public class Explosion {

    private boolean isFinish;
    private Animation animation;
    private int x;
    private int y;

    public Explosion(int x, int y, int width, int height, LoadAnimation loadAnimation) {
        animation = loadAnimation.getListAnimation().get("explosion");
        animation.reset();
        animation.setRepeat(false);
        this.x = x;
        this.y = y;
    }

    public void update() {
        if (!isFinish)
            if (animation.isEndAnimation()) isFinish = true;
    }

    public void draw(Canvas canvas) {
        animation.update(System.currentTimeMillis());
        animation.draw(canvas, x, y);
    }

    public boolean isFinish() {
        return isFinish;
    }

    public void setFinish(boolean finish) {
        isFinish = finish;
    }

    public Animation getAnimation() {
        return animation;
    }

    public void setAnimation(Animation animation) {
        this.animation = animation;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}
