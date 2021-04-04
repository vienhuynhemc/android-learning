package com.vientamthuong.asynctask_loadimageinternet.asynTaskProcess;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.widget.Toast;

import com.vientamthuong.asynctask_loadimageinternet.MainActivity;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

public class AsyncTaskLoadImg extends AsyncTask<String, DataProgressAsyncTaskLoadImg, Bitmap[]> {

    // Khai báo các thuộc tính
    private MainActivity mainActivity;

    public AsyncTaskLoadImg(MainActivity mainActivity) {
        this.mainActivity = mainActivity;
    }

    @Override
    protected Bitmap[] doInBackground(String... strings) {
        Bitmap[] bitmaps = new Bitmap[strings.length];
        for (int i = 0; i < strings.length; i++) {
            Bitmap bitmap = null;
            try {
                URL url = new URL(strings[i]);
                InputStream inputStream = url.openConnection().getInputStream();
                bitmap = BitmapFactory.decodeStream(inputStream);
                bitmaps[i] = bitmap;
            } catch (IOException e) {
                e.printStackTrace();
            }
            publishProgress(new DataProgressAsyncTaskLoadImg(i, bitmap));
        }
        return bitmaps;
    }

    @Override
    protected void onProgressUpdate(DataProgressAsyncTaskLoadImg... values) {
        super.onProgressUpdate(values);
        mainActivity.getProgressBarTienTrinh().setProgress(mainActivity.getProgressBarTienTrinh().getProgress() + 10);
        if (values[0].getBitmap() != null) {
            mainActivity.getBitmaps()[values[0].getIndex()] = values[0].getBitmap();
            mainActivity.getShowImgAdapter().notifyItemChanged(values[0].getIndex());
        }
    }

    @Override
    protected void onPostExecute(Bitmap[] bitmaps) {
        super.onPostExecute(bitmaps);
        mainActivity.setTaiDuLieu(true);
        Toast.makeText(mainActivity, "Tải hình thành công", Toast.LENGTH_SHORT).show();
    }

}
