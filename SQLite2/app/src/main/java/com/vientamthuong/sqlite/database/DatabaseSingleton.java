package com.vientamthuong.sqlite.database;

import android.content.Context;

import com.vientamthuong.sqlite.MainActivity;
import com.vientamthuong.sqlite.model.RootDatabase;
import com.vientamthuong.sqlite.model.SelectDatabase;

public class DatabaseSingleton {

    private static DatabaseSingleton databaseSingleton;
    private MainActivity mainActivity;
    // Database root
    private RootDatabase rootDatabase;

    private SelectDatabase nowDatabase;

    private DatabaseSingleton() {

    }

    public static DatabaseSingleton getInstance() {
        if (databaseSingleton == null) {
            databaseSingleton = new DatabaseSingleton();
        }
        return databaseSingleton;
    }

    public void init(MainActivity mainActivity) {
        // Database root
        rootDatabase = new RootDatabase(mainActivity);
        this.mainActivity = mainActivity;
    }

    public SelectDatabase getNowDatabase() {
        return nowDatabase;
    }

    public void setNowDatabase(SelectDatabase selectDatabase){
        this.nowDatabase = selectDatabase;
    }

    public RootDatabase getRootDatabase() {
        return rootDatabase;
    }

    public void createNewDatabase(String nameDatabase) {
        DatabaseOpenHelper databaseOpenHelper = new DatabaseOpenHelper(mainActivity, nameDatabase + ".sqlite", null, 1);
        databaseOpenHelper.queryData("CREATE TABLE IF NOT EXISTS create_database(id INTEGER)");
    }

}
