package com.vientamthuong.docfilejson;

import android.os.AsyncTask;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

public class LoadFileJSONArray extends AsyncTask<String, Void, String> {

    private TextView textView;

    public LoadFileJSONArray(TextView textView) {
        this.textView = textView;
    }

    @Override
    protected String doInBackground(String... strings) {
        StringBuffer stringBuffer = new StringBuffer();
        try {
            URL url = new URL(strings[0]);
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
            JSONObject json = new JSONObject(s);
            JSONArray jsonArray = json.getJSONArray("danhsach");
            System.out.println(jsonArray.toString());
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                System.out.println(jsonObject.toString());
                textView.setText(textView.getText().toString() + "\n" + jsonObject.get("khoahoc"));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
