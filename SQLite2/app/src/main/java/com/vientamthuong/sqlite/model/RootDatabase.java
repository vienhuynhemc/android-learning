package com.vientamthuong.sqlite.model;

import android.content.Context;
import android.database.Cursor;
import android.widget.Toast;

import com.vientamthuong.sqlite.Configuration;
import com.vientamthuong.sqlite.MainActivity;
import com.vientamthuong.sqlite.database.DatabaseOpenHelper;
import com.vientamthuong.sqlite.database.DatabaseSingleton;
import com.vientamthuong.sqlite.date.DateManager;

import java.util.ArrayList;
import java.util.List;

public class RootDatabase {

    private DatabaseOpenHelper databaseOpenHelper;
    private MainActivity mainActivity;

    public RootDatabase(MainActivity mainActivity) {
        this.mainActivity = mainActivity;
        init();
    }

    private void init() {
        databaseOpenHelper = new DatabaseOpenHelper(mainActivity, Configuration.name_database_root, null, 1);
        databaseOpenHelper.queryData("CREATE TABLE IF NOT EXISTS " + Configuration.name_table_root_database_root +
                "(id_database INTEGER PRIMARY KEY AUTOINCREMENT,name_database VARCHAR(500),time_create INTEGER)");
        databaseOpenHelper.queryData("CREATE TABLE IF NOT EXISTS " + Configuration.detail_database +
                "(id_database INTEGER, id_table INTEGER, PRIMARY KEY (id_database,id_table))");
        databaseOpenHelper.queryData("CREATE TABLE IF NOT EXISTS " + Configuration.list_table +
                "(id_table INTEGER PRIMARY KEY AUTOINCREMENT,name_table VARCHAR(500))");
        databaseOpenHelper.queryData("CREATE TABLE IF NOT EXISTS " + Configuration.detail_table +
                "(id_table INTEGER,name_col VARCHAR(500),type VARCHAR(100),length INTEGER,PRIMARY KEY (id_table,name_col))");
    }

    public int getNumbsTableNowDatabase() {
        int idNowDatabase = DatabaseSingleton.getInstance().getNowDatabase().getDatabase().getId();
        Cursor cursor = databaseOpenHelper.getData("SELECT COUNT(id_table) FROM " + Configuration.detail_database + " WHERE id_database = " + idNowDatabase);
        cursor.moveToNext();
        return cursor.getInt(0);
    }

    public int getNumbsTable() {
        Cursor cursor = databaseOpenHelper.getData("SELECT COUNT(id_table) FROM " + Configuration.detail_database);
        cursor.moveToNext();
        return cursor.getInt(0);
    }

    public void removeDatabase(int id) {
        databaseOpenHelper.queryData("DELETE FROM " + Configuration.name_table_root_database_root + " WHERE id_database = " + id);
        databaseOpenHelper.queryData("DELETE FROM " + Configuration.list_table + " WHERE id_table IN (SELECT id_table FROM " + Configuration.detail_database + " WHERE id_database = " + id + ")");
        databaseOpenHelper.queryData("DELETE FROM " + Configuration.detail_table + " WHERE id_table IN (SELECT id_table FROM " + Configuration.detail_database + " WHERE id_database = " + id + ")");
        databaseOpenHelper.queryData("DELETE FROM " + Configuration.detail_database + " WHERE id_database = " + id);
        mainActivity.updateView();
    }

    public int getNumbsDatabase() {
        Cursor cursor = databaseOpenHelper.getData("SELECT COUNT(id_database) FROM " + Configuration.name_table_root_database_root);
        cursor.moveToNext();
        return cursor.getInt(0);
    }

    public int getNumbsRowForTable(int id_table) {
        Cursor cursor = databaseOpenHelper.getData("SELECT COUNT(name_col) FROM " + Configuration.detail_table + " WHERE id_table = " + id_table);
        cursor.moveToNext();
        return cursor.getInt(0);
    }

    public void addNewDatabase(String nameDatabase, long time) {
        databaseOpenHelper.queryData("INSERT INTO " + Configuration.name_table_root_database_root + " VALUES(null,'" + nameDatabase + "'," + time + ")");
    }

    public boolean isExistsDatabase(String nameDatabase) {
        Cursor cursor = databaseOpenHelper.getData("SELECT id_database FROM " + Configuration.name_table_root_database_root + " WHERE name_database = '" + nameDatabase + "'");
        return cursor.moveToNext();
    }

    public List<Database> getAll() {
        List<Database> result = new ArrayList<>();
        Cursor cursor = databaseOpenHelper.getData("SELECT * FROM " + Configuration.name_table_root_database_root);
        while (cursor.moveToNext()) {
            result.add(new Database(cursor.getInt(0), cursor.getString(1),
                    DateManager.getInstance().coverLongToString(cursor.getLong(2))));
        }
        return result;
    }

    public List<Attribute> getAllAttribute(int id_table) {
        List<Attribute> result = new ArrayList<>();
        Cursor cursor = databaseOpenHelper.getData("SELECT * FROM " + Configuration.detail_table + " WHERE id_table = " + id_table);
        while (cursor.moveToNext()) {
            result.add(new Attribute(cursor.getInt(0), cursor.getString(1), cursor.getInt(2), cursor.getInt(3)));
        }
        return result;
    }

    public boolean isExitsColumn(int id_table, String name_col) {
        if (name_col.equals("idtablexxxzzzyyy")) return true;
        Cursor cursor = databaseOpenHelper.getData("SELECT * FROM " + Configuration.detail_table + " WHERE id_table = " + id_table + " AND name_col = '" + name_col + "'");
        return cursor.moveToNext();
    }

    public List<Table> getAllTable() {
        List<Table> result = new ArrayList<>();
        Cursor cursor = databaseOpenHelper.getData("SELECT l.id_table,l.name_table FROM detail_database d JOIN list_table l ON d.id_table = l.id_table WHERE id_database = " + DatabaseSingleton.getInstance().getNowDatabase().getDatabase().getId() + " GROUP BY l.id_table");
        while (cursor.moveToNext()) {
            result.add(new Table(DatabaseSingleton.getInstance().getNowDatabase().getDatabase().getId(), cursor.getInt(0), cursor.getString(1)));
        }
        return result;
    }

    public void removeAttribute(String nameCol, int id_table) {
        databaseOpenHelper.queryData("DELETE FROM " + Configuration.detail_table + " WHERE name_col = '" + nameCol + "' AND id_table = " + id_table);
    }

    public void insertNewDataToDetailtable(Attribute attribute) {
        databaseOpenHelper.queryData("INSERT INTO " + Configuration.detail_table + " VALUES(" + attribute.getId_table() + ",'" + attribute.getName_col() + "'," +
                attribute.getType() + "," + attribute.getLegnth() + ")");
    }

    public void addNewTable(String nameDatabase) {
        int id_table = getNumbsTable();
        databaseOpenHelper.queryData("INSERT INTO detail_database VALUES(" + DatabaseSingleton.getInstance().getNowDatabase().getDatabase().getId() + "," + id_table + ")");
        databaseOpenHelper.queryData("INSERT INTO list_table VALUES(" + id_table + ",'" + nameDatabase + "')");
        mainActivity.updateView();
    }

    public boolean checkExistsTable(String nameTable) {
        Cursor cursor = databaseOpenHelper.getData("SELECT n.name_table FROM list_table n JOIN detail_database d ON n.id_table = d.id_table WHERE name_table = '" + nameTable + "' AND d.id_database = " + DatabaseSingleton.getInstance().getNowDatabase().getDatabase().getId());
        return cursor.moveToNext();
    }

    public void renameTable(String nameDatabase, int id_table) {
        databaseOpenHelper.queryData("UPDATE " + Configuration.list_table + " SET name_table = '" + nameDatabase + "' WHERE id_table = " + id_table);
    }

    public void removeTable(int id_table) {
        databaseOpenHelper.queryData("DELETE FROM " + Configuration.detail_database + " WHERE id_table = " + id_table);
        databaseOpenHelper.queryData("DELETE FROM " + Configuration.list_table + " WHERE id_table = " + id_table);
        databaseOpenHelper.queryData("DELETE FROM " + Configuration.detail_table + " WHERE id_table = " + id_table);
        mainActivity.updateView();
    }

    public List<ObjectInput> getAllObjectInputs(int id_table) {
        List<ObjectInput> result = new ArrayList<>();
        Cursor cursor = databaseOpenHelper.getData("SELECT * FROM " + Configuration.detail_table + " WHERE id_table = " + id_table);
        while (cursor.moveToNext()) {
            int type = cursor.getInt(2);
            int lenght = cursor.getInt(3);
            String typeS = type == 0 ? "VARCHAR(" + lenght + ")" : "INTEGER";
            ObjectInput objectInput = new ObjectInput(cursor.getString(1), typeS);
            result.add(objectInput);
        }
        return result;
    }

    public int getNumAttFromtable(int id_table) {
        Cursor cursor = databaseOpenHelper.getData("SELECT COUNT(name_col) FROM detail_table WHERE id_table = "+id_table);
        cursor.moveToNext();
        return cursor.getInt(0);
    }
}
