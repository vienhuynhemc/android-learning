package com.vientamthuong.game2d_learning.loadData;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.util.TypedValue;

import com.vientamthuong.game2d_learning.MainActivity;
import com.vientamthuong.game2d_learning.R;
import com.vientamthuong.game2d_learning.gameEffect.Animation;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LoadAnimation {

    private Map<String, Animation> listAnimation;
    private MainActivity mainActivity;

    public LoadAnimation(MainActivity mainActivity) {
        listAnimation = new HashMap<>();
        this.mainActivity = mainActivity;
    }

    public void loadAnimation() {
        try {
            InputStream inputStream = mainActivity.getResources().openRawResource(R.raw.data_animation);
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            String line = null;
            Bitmap nowBitMap = null;
            List<Bitmap> listBitmap = null;
            List<Long> listDuration = null;
            String nameAnimation = null;
            while (true) {
                line = bufferedReader.readLine();
                if (line == null) {
                    break;
                }
                String[] array = line.split(" ");
                if (array[0].equals("image")) {
                    String nameImage = array[1];
                    int idImage = mainActivity.getResources().getIdentifier(nameImage, "drawable", mainActivity.getPackageName());
                    nowBitMap = BitmapFactory.decodeResource(mainActivity.getResources(), idImage);
                } else if (array[0].equals("animation")) {
                    if (listBitmap != null) {
                        Animation animation = new Animation(listBitmap, listDuration);
                        listAnimation.put(nameAnimation, animation);
                    }
                    listBitmap = new ArrayList<>();
                    listDuration = new ArrayList<>();
                    nameAnimation = array[1];
                } else {
                    int x = Integer.parseInt(array[0]);
                    int y = Integer.parseInt(array[1]);
                    int width = Integer.parseInt(array[2]);
                    int height = Integer.parseInt(array[3]);
                    long duration = Long.parseLong(array[4]);
                    Bitmap bitmap = Bitmap.createBitmap(nowBitMap, getPx(x), getPx(y), getPx(width), getPx(height));
                    listBitmap.add(bitmap);
                    listDuration.add(duration);
                }
            }
            Animation animation = new Animation(listBitmap, listDuration);
            listAnimation.put(nameAnimation, animation);
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Map<String, Animation> getListAnimation() {
        return listAnimation;
    }

    public void setListAnimation(Map<String, Animation> listAnimation) {
        this.listAnimation = listAnimation;
    }

    public int getPx(int dp) {
        return (int) TypedValue.applyDimension(
                TypedValue.COMPLEX_UNIT_DIP,
                dp,
                mainActivity.getResources().getDisplayMetrics()
        );
    }
}
