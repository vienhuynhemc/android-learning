package com.vientamthuong.sqlite.model;

public class Attribute {

    private int id_table;
    private String name_col;
    private int type;
    private int legnth;

    public Attribute(int id_table, String name_col, int type, int legnth) {
        this.id_table = id_table;
        this.name_col = name_col;
        this.type = type;
        this.legnth = legnth;
    }

    public String toString() {
        return id_table + " " + name_col + " " + type + " " + legnth;
    }

    public int getId_table() {
        return id_table;
    }

    public void setId_table(int id_table) {
        this.id_table = id_table;
    }

    public String getName_col() {
        return name_col;
    }

    public void setName_col(String name_col) {
        this.name_col = name_col;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getLegnth() {
        return legnth;
    }

    public void setLegnth(int legnth) {
        this.legnth = legnth;
    }
}
