package com.vientamthuong.game2d_learning.gameObject;

import android.graphics.Canvas;

import com.vientamthuong.game2d_learning.gameWorld.GameSurface;
import com.vientamthuong.game2d_learning.gameWorld.GameWorld;

public abstract class GameObject {

    private int x;
    private int y;
    private int width;
    private int height;
    private long lastTimeUpdate;
    private GameSurface gameSurface;

    public GameObject(int x, int y, int width, int height, GameSurface gameSurface) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.gameSurface = gameSurface;
        lastTimeUpdate = -1;
    }

    public abstract void update();

    public abstract void draw(Canvas canvas);

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

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public long getLastTimeUpdate() {
        return lastTimeUpdate;
    }

    public void setLastTimeUpdate(long lastTimeUpdate) {
        this.lastTimeUpdate = lastTimeUpdate;
    }

    public GameSurface getGameSurface() {
        return gameSurface;
    }

    public abstract void setMovingX(int x);

    public abstract void setMovingY(int y);

    public void setGameSurface(GameSurface gameSurface) {
        this.gameSurface = gameSurface;
    }
}
