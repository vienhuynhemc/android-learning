package com.vientamthuong.json_array;

import android.os.AsyncTask;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public class AsynTaskReadJSON extends AsyncTask<String, Void, String> {

    private MainActivity mainActivity;

    public AsynTaskReadJSON(MainActivity mainActivity) {
        this.mainActivity = mainActivity;
    }

    @Override
    protected String doInBackground(String... strings) {
        StringBuffer stringBuffer = new StringBuffer();
        try {
            URL url = new URL("https://khoapham.vn/KhoaPhamTraining/json/tien/demo4.json");
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(url.openConnection().getInputStream()));
            String line = null;
            while (true) {
                line = bufferedReader.readLine();
                if (line == null) break;
                stringBuffer.append(line);
            }
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return stringBuffer.toString();
    }

    @Override
    protected void onPostExecute(String s) {
        try {
            JSONArray jsonArray = new JSONArray(s);
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                mainActivity.getListObject().add(jsonObject.getString("khoahoc") + " - " + jsonObject.getString("hocphi"));
            }
            mainActivity.getArrayAdapter().notifyDataSetChanged();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        super.onPostExecute(s);
    }
}
