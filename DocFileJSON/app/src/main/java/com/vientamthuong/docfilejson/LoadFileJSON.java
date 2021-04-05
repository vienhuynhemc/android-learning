package com.vientamthuong.docfilejson;

import android.annotation.SuppressLint;
import android.os.AsyncTask;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Text;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public class LoadFileJSON extends AsyncTask<String, Void, JSONObject> {

    private TextView textView;

    public LoadFileJSON(TextView textView) {
        this.textView = textView;
    }


    @Override
    protected JSONObject doInBackground(String... strings) {
        JSONObject jsonObject = null;
        try {
            URL url = new URL(strings[0]);
            InputStream inputStream = url.openConnection().getInputStream();
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            StringBuffer s = new StringBuffer();
            String line = null;
            while (true) {
                line = bufferedReader.readLine();
                if (line == null) {
                    break;
                }
                s.append(line);
            }
            jsonObject = new JSONObject(s.toString());
        } catch (JSONException | IOException e) {
            e.printStackTrace();
        }
        return jsonObject;
    }

    @SuppressLint("SetTextI18n")
    @Override
    protected void onPostExecute(JSONObject jsonObject) {
        super.onPostExecute(jsonObject);
        try {
            textView.setText(jsonObject.getString("monhoc") + "\n" + jsonObject.getString("noihoc") + "\n" + jsonObject.getString("website") + "\n" + jsonObject.getString("fanpage") + "\n" + jsonObject.getString("logo"));
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
