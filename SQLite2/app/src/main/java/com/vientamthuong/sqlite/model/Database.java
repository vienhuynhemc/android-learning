package com.vientamthuong.sqlite.model;

public class Database {

    private int id;
    private String name;
    private String dateCreate;
    private boolean isSelect;

    public Database(int id, String name, String dateCreate) {
        this.id = id;
        this.name = name;
        this.dateCreate = dateCreate;
        isSelect = false;
    }

    public Database(Database database) {
        this.id = database.getId();
        this.isSelect = database.isSelect();
        this.name = database.getName();
        this.dateCreate = database.getDateCreate();
    }

    public String toString() {
        return id + " " + name + " " + dateCreate + " " + isSelect;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDateCreate() {
        return dateCreate;
    }

    public void setDateCreate(String dateCreate) {
        this.dateCreate = dateCreate;
    }

    public boolean isSelect() {
        return isSelect;
    }

    public void setSelect(boolean select) {
        isSelect = select;
    }
}
