package com.vientamthuong.sqlite.model;

public class Table {

    private int id_database;
    private int id_table;
    private String name_table;
    private boolean isSelect;
    private boolean isSelectManager;

    public Table(int id_database, int id_table, String name_table) {
        this.id_database = id_database;
        this.id_table = id_table;
        this.name_table = name_table;
    }

    public Table(Table table){
        this.id_database = table.getId_database();
        this.id_table = table.getId_table();
        this.name_table = table.getName_table();
        this.isSelect = table.isSelect();
        this.isSelectManager = table.isSelectManager();
    }

    public String toString(){
        return name_table;
    }

    public int getId_database() {
        return id_database;
    }

    public void setId_database(int id_database) {
        this.id_database = id_database;
    }

    public int getId_table() {
        return id_table;
    }

    public void setId_table(int id_table) {
        this.id_table = id_table;
    }

    public String getName_table() {
        return name_table;
    }

    public void setName_table(String name_table) {
        this.name_table = name_table;
    }

    public boolean isSelect() {
        return isSelect;
    }

    public void setSelect(boolean select) {
        isSelect = select;
    }

    public boolean isSelectManager() {
        return isSelectManager;
    }

    public void setSelectManager(boolean selectManager) {
        isSelectManager = selectManager;
    }
}
