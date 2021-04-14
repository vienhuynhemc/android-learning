package com.vientamthuong.game2d_learning.gameWorld;

import android.graphics.Canvas;
import android.util.Log;
import android.view.SurfaceHolder;

import com.vientamthuong.game2d_learning.MainActivity;
import com.vientamthuong.game2d_learning.loadData.LoadAnimation;

public class GameWorld extends Thread {

    private boolean isRunning;
    private GameSurface gameSurface;
    private SurfaceHolder surfaceHolder;

    public GameWorld(GameSurface gameSurface, SurfaceHolder surfaceHolder) {
        this.gameSurface = gameSurface;
        this.surfaceHolder = surfaceHolder;
        isRunning = true;
        Log.i("adsfasd", "aa");
    }

    @Override
    public void run() {
        int FPS = 80;
        long beginTime = System.nanoTime();
        long timeForOneFrame = 1000000000 / FPS;
        int count = 0;
        while (isRunning) {
            long timeSleep = timeForOneFrame - (System.nanoTime() - beginTime);
            Canvas canvas = null;
            try {
                // Get Canvas from Holder and lock it.
                canvas = surfaceHolder.lockCanvas();
                // Synchronized
                synchronized (canvas) {
                    gameSurface.update();
                    gameSurface.draw(canvas);
                }
            } catch (Exception e) {
                // Do nothing.
            } finally {
                if (canvas != null) {
                    // Unlock Canvas.
                    surfaceHolder.unlockCanvasAndPost(canvas);
                }
            }
            try {
                if (timeSleep > 0) {
                    Thread.sleep(timeSleep / 1000000);
                } else
                    Thread.sleep(timeForOneFrame / 2000000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            beginTime = System.nanoTime();
        }
    }

    public void setRunning(boolean b) {
        isRunning = b;
    }
}
