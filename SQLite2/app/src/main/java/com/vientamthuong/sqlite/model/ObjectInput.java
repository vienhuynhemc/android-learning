package com.vientamthuong.sqlite.model;

public class ObjectInput {

    private String name_col;
    private String type;
    private String data;

    public ObjectInput(String name_col, String type) {
        this.name_col = name_col;
        this.type = type;
        data = "";
    }

    public String toString(){
        return name_col+" "+type+" "+data;
    }

    public String getName_col() {
        return name_col;
    }

    public void setName_col(String name_col) {
        this.name_col = name_col;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
