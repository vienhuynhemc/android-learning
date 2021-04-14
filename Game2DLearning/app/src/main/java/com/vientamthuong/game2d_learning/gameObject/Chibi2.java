package com.vientamthuong.game2d_learning.gameObject;

import android.graphics.Canvas;

import com.vientamthuong.game2d_learning.gameEffect.Animation;
import com.vientamthuong.game2d_learning.gameWorld.GameSurface;
import com.vientamthuong.game2d_learning.gameWorld.GameWorld;

public class Chibi2 extends GameObject {

    private int moving;
    public static final int MOVING_LEFT_TO_RIGHT = 0;
    public static final int MOVING_RIGHT_TO_LEFT = 1;
    public static final int MOVING_TOP_TO_BOTTOM = 2;
    public static final int MOVING_BOTTOM_TO_TOP = 3;

    private Animation leftToRight;
    private Animation rightToLeft;
    private Animation topToBottom;
    private Animation bottomToTop;
    private GameSurface gameSurface;

    private float speed = 3f;

    // Di chuyển xéo
    private int movingX;
    private int movingY;

    public Chibi2(int x, int y, int width, int height, GameSurface gameSurface) {
        super(x, y, width, height, gameSurface);
        this.gameSurface = gameSurface;
        leftToRight = gameSurface.getLoadAnimation().getListAnimation().get("chibi2_right");
        rightToLeft = gameSurface.getLoadAnimation().getListAnimation().get("chibi2_left");
        topToBottom = gameSurface.getLoadAnimation().getListAnimation().get("chibi2_bottom");
        bottomToTop = gameSurface.getLoadAnimation().getListAnimation().get("chibi2_top");
        moving = MOVING_LEFT_TO_RIGHT;
    }

    @Override
    public void update() {

        // time update
        if (getLastTimeUpdate() == -1) {
            setLastTimeUpdate(System.currentTimeMillis());
        }

        if (getX() != movingX) {
            if (movingX > getX()) setX(getX() + 1);
            else setX(getX() - 1);
        }

        if (getY() != movingY) {
            if (movingY > getY()) setY(getY() + 1);
            else setY(getY() - 1);
        }

        int spaceX = movingX - getX();
        int spaceY = movingY - getY();
        if (spaceX > 0) {
            if (spaceY > 0) {
                if (Math.abs(spaceX) > Math.abs(spaceY)) {
                    moving = MOVING_LEFT_TO_RIGHT;
                } else {
                    moving = MOVING_TOP_TO_BOTTOM;
                }
            } else {
                if (Math.abs(spaceX) > Math.abs(spaceY)) {
                    moving = MOVING_LEFT_TO_RIGHT;
                } else {
                    moving = MOVING_BOTTOM_TO_TOP;
                }
            }
        } else {
            if (spaceY > 0) {
                if (Math.abs(spaceX) > Math.abs(spaceY)) {
                    moving = MOVING_RIGHT_TO_LEFT;
                } else {
                    moving = MOVING_TOP_TO_BOTTOM;
                }
            } else {
                if (Math.abs(spaceX) > Math.abs(spaceY)) {
                    moving = MOVING_RIGHT_TO_LEFT;
                } else {
                    moving = MOVING_BOTTOM_TO_TOP;
                }
            }
        }

    }

    @Override
    public void draw(Canvas canvas) {
        switch (moving) {
            case MOVING_LEFT_TO_RIGHT:
                leftToRight.update(System.currentTimeMillis());
                leftToRight.draw(canvas, getX(), getY());
                break;
            case MOVING_RIGHT_TO_LEFT:
                rightToLeft.update(System.currentTimeMillis());
                rightToLeft.draw(canvas, getX(), getY());
                break;
            case MOVING_BOTTOM_TO_TOP:
                bottomToTop.update(System.currentTimeMillis());
                bottomToTop.draw(canvas, getX(), getY());
                break;
            case MOVING_TOP_TO_BOTTOM:
                topToBottom.update(System.currentTimeMillis());
                topToBottom.draw(canvas, getX(), getY());
                break;
        }
    }

    public int getMovingX() {
        return movingX;
    }

    public void setMovingX(int movingX) {
        this.movingX = movingX;
    }

    public int getMovingY() {
        return movingY;
    }

    public void setMovingY(int movingY) {
        this.movingY = movingY;
    }
}
