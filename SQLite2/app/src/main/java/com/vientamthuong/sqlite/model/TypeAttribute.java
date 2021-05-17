package com.vientamthuong.sqlite.model;

public class TypeAttribute {

    private int type;
    private String name;

    public TypeAttribute(int type, String name) {
        this.type = type;
        this.name = name;
    }

    public String toString(){
        return name;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
