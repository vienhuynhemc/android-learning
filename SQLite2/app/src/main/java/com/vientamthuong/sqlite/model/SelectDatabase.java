package com.vientamthuong.sqlite.model;

import android.content.Context;
import android.database.Cursor;

import com.vientamthuong.sqlite.database.DatabaseOpenHelper;
import com.vientamthuong.sqlite.database.DatabaseSingleton;

import java.util.ArrayList;
import java.util.List;

public class SelectDatabase {

    private DatabaseOpenHelper databaseOpenHelper;
    private Database database;
    private Context context;

    public SelectDatabase(Database database, Context context) {
        this.context = context;
        this.database = database;
        this.databaseOpenHelper = new DatabaseOpenHelper(context, database.getName() + ".sqlite", null, 1);
    }

    public void renameTable(String new_name, String name_table) {
        databaseOpenHelper.queryData("ALTER TABLE " + name_table + " RENAME TO " + new_name);
    }

    public void addNewCol(String name_table, Attribute attribute) {
        String type = attribute.getType() == 0 ? "VARCHAR" : "INTEGER";
        if (attribute.getType() == 0) {
            type += "(" + attribute.getLegnth() + ")";
        }
        databaseOpenHelper.queryData("ALTER TABLE " + name_table + " ADD COLUMN " + attribute.getName_col() + " " + type);
    }

    public DatabaseOpenHelper getDatabaseOpenHelper() {
        return databaseOpenHelper;
    }

    public void setDatabaseOpenHelper(DatabaseOpenHelper databaseOpenHelper) {
        this.databaseOpenHelper = databaseOpenHelper;
    }

    public Database getDatabase() {
        return database;
    }

    public void setDatabase(Database database) {
        this.database = database;
    }

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public void addNewTable(String nameDatabase) {
        databaseOpenHelper.queryData("CREATE TABLE " + nameDatabase + "(idtablexxxzzzyyy INTEGER PRIMARY KEY AUTOINCREMENT)");
    }

    public void removeAttribute(String name_table, String name_col) {
        databaseOpenHelper.queryData("ALTER TABLE " + name_table + " DROP COLUMN " + name_col);
    }

    public void removeTable(String name_table) {
        databaseOpenHelper.queryData("DROP TABLE " + name_table);
    }

    public List<ObjectShowData> getData(Table table) {
        List<ObjectShowData> result = new ArrayList<>();
        int length = DatabaseSingleton.getInstance().getRootDatabase().getNumAttFromtable(table.getId_table());
        Cursor cursor = databaseOpenHelper.getData("SELECT * FROM " + table.getName_table());
        while (cursor.moveToNext()) {
            String text = "";
            for (int i = 0; i < length; i++) {
                text += cursor.getString(i + 1) + "  ";
            }
            result.add(new ObjectShowData(cursor.getInt(0), text));
        }
        return result;
    }

    public void addNewRow(String data, Table nowTable) {
        databaseOpenHelper.queryData("INSERT INTO " + nowTable.getName_table() + " VALUES(null," + data + ")");
    }

    public void removeRow(int id, Table nowTable) {
        databaseOpenHelper.queryData("DELETE FROM " + nowTable.getName_table() + " WHERE idtablexxxzzzyyy = " + id);
    }
}
