package com.vientamthuong.json_vn_en;

import android.os.AsyncTask;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

public class LoadJSONFile extends AsyncTask<String, Void, String> {

    private ObjectLanguage objectLanguage;

    public LoadJSONFile(ObjectLanguage objectLanguage) {
       this.objectLanguage = objectLanguage;
    }

    @Override
    protected String doInBackground(String... strings) {
        StringBuffer stringBuffer = new StringBuffer();
        URL url = null;
        try {
            url = new URL(strings[0]);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(url.openConnection().getInputStream()));
            String line = null;
            while (true) {
                line = bufferedReader.readLine();
                if (line == null) {
                    break;
                }
                stringBuffer.append(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return stringBuffer.toString();
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        try {
            objectLanguage.setJsonObject(new JSONObject(s).getJSONObject("language"));
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
