package com.vientamthuong.json_vn_en;

import org.json.JSONObject;

public class ObjectLanguage {

    private JSONObject jsonObject;

    public ObjectLanguage(JSONObject jsonObject) {
        this.jsonObject = jsonObject;
    }

    public JSONObject getJsonObject() {
        return jsonObject;
    }

    public void setJsonObject(JSONObject jsonObject) {
        this.jsonObject = jsonObject;
    }
}
