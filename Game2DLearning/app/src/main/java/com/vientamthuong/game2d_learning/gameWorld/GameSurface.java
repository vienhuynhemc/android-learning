package com.vientamthuong.game2d_learning.gameWorld;

import android.content.Context;
import android.graphics.Canvas;
import android.media.AudioAttributes;
import android.media.SoundPool;
import android.os.Build;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import androidx.annotation.NonNull;

import com.vientamthuong.game2d_learning.MainActivity;
import com.vientamthuong.game2d_learning.R;
import com.vientamthuong.game2d_learning.gameObject.Chibi1;
import com.vientamthuong.game2d_learning.gameObject.Chibi2;
import com.vientamthuong.game2d_learning.gameObject.Explosion;
import com.vientamthuong.game2d_learning.gameObject.GameObject;
import com.vientamthuong.game2d_learning.loadData.LoadAnimation;

import java.util.ArrayList;
import java.util.List;

public class GameSurface extends SurfaceView implements SurfaceHolder.Callback {

    private LoadAnimation loadAnimation;
    private MainActivity mainActivity;
    private GameWorld gameWorld;
    private List<GameObject> listObjects;
    private List<Explosion> explosions;

    private static final int MAX_STREAMS = 100;
    private int soundIdExplosion;
    private int soundIdBackground;
    private SoundPool soundPool;
    private boolean soundPoolLoaded;

    public GameSurface(Context context, MainActivity mainActivity) {
        super(context);

        this.mainActivity = mainActivity;
        // có thể nhận tương tác
        setFocusable(true);
        getHolder().addCallback(this);
        initSoundPool();
    }

    public void update() {
        for (GameObject gameObject : listObjects) {
            gameObject.update();
        }
        for (Explosion explosion : explosions) {
            explosion.update();
            if (explosion.isFinish()) {
                explosions.remove(explosion);
            }
        }
    }

    @Override
    public void draw(Canvas canvas) {
        super.draw(canvas);
        for (GameObject gameObject : listObjects) {
            gameObject.draw(canvas);
        }
        System.out.println(explosions.size());
        for (Explosion explosion : explosions) {
            explosion.draw(canvas);
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_DOWN) {
            int x = (int) event.getX();
            int y = (int) event.getY();

            int count = 0;
            while (count < listObjects.size()) {
                GameObject gameObject = listObjects.get(count);
                if (x > gameObject.getX() && x < (gameObject.getX() + gameObject.getWidth()) && y > gameObject.getY() && y < (gameObject.getY() + gameObject.getHeight())) {
                    explosions.add(new Explosion(gameObject.getX(), gameObject.getY(), getPx(59), getPx(61), loadAnimation));
                    playSoundExplosion();
                    listObjects.remove(gameObject);
                } else {
                    count++;
                }
            }

            for (GameObject gameObject : listObjects) {
                gameObject.setMovingY(y);
                gameObject.setMovingX(x);
            }
            System.out.println(getWidth() + " " + getHeight() + " " + x + " " + y);
        }
        return false;
    }

    private void initSoundPool() {
        // With Android API >= 21.
        if (Build.VERSION.SDK_INT >= 21) {

            AudioAttributes audioAttrib = new AudioAttributes.Builder()
                    .setUsage(AudioAttributes.USAGE_GAME)
                    .setContentType(AudioAttributes.CONTENT_TYPE_SONIFICATION)
                    .build();

            SoundPool.Builder builder = new SoundPool.Builder();
            builder.setAudioAttributes(audioAttrib).setMaxStreams(MAX_STREAMS);

            this.soundPool = builder.build();
        }

        // When SoundPool load complete.
        this.soundPool.setOnLoadCompleteListener(new SoundPool.OnLoadCompleteListener() {
            @Override
            public void onLoadComplete(SoundPool soundPool, int sampleId, int status) {
                soundPoolLoaded = true;

                // Playing background sound.
                playSoundBackground();
            }
        });

        // Load the sound background.mp3 into SoundPool
        this.soundIdBackground = this.soundPool.load(this.getContext(), R.raw.background, 1);

        // Load the sound explosion.wav into SoundPool
        this.soundIdExplosion = this.soundPool.load(this.getContext(), R.raw.explosion, 1);
    }

    public void playSoundExplosion() {
        if (this.soundPoolLoaded) {
            float leftVolumn = 0.8f;
            float rightVolumn = 0.8f;
            // Play sound explosion.wav
            int streamId = this.soundPool.play(this.soundIdExplosion, leftVolumn, rightVolumn, 1, 0, 1f);
        }
    }

    public void playSoundBackground() {
        if (this.soundPoolLoaded) {
            float leftVolumn = 0.8f;
            float rightVolumn = 0.8f;
            // Play sound background.mp3
            int streamId = this.soundPool.play(this.soundIdBackground, leftVolumn, rightVolumn, 1, -1, 1f);
        }
    }


    @Override
    public void surfaceCreated(@NonNull SurfaceHolder holder) {
        loadAnimation = new LoadAnimation(mainActivity);
        loadAnimation.loadAnimation();
        listObjects = new ArrayList<>();
        explosions = new ArrayList<>();
        Chibi1 chibi1 = new Chibi1(100, 50, getPx(25), getPx(32), this);
        Chibi2 chibi2 = new Chibi2(500, 50, getPx(30), getPx(32), this);
        listObjects.add(chibi1);
        listObjects.add(chibi2);
        gameWorld = new GameWorld(this, holder);
        gameWorld.setRunning(true);
        gameWorld.start();
    }

    public int getPx(int dp) {
        return (int) TypedValue.applyDimension(
                TypedValue.COMPLEX_UNIT_DIP,
                dp,
                mainActivity.getResources().getDisplayMetrics()
        );
    }

    @Override
    public void surfaceChanged(@NonNull SurfaceHolder holder, int format, int width, int height) {

    }

    @Override
    public void surfaceDestroyed(@NonNull SurfaceHolder holder) {
        boolean retry = true;
        while (retry) {
            try {
                gameWorld.setRunning(false);
                gameWorld.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            retry = true;
        }
    }

    public LoadAnimation getLoadAnimation() {
        return loadAnimation;
    }

    public void setLoadAnimation(LoadAnimation loadAnimation) {
        this.loadAnimation = loadAnimation;
    }
}
