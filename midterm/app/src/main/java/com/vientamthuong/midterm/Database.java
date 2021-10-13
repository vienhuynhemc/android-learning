package com.vientamthuong.midterm;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class Database extends SQLiteOpenHelper {

    public Database(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
        updateData("CREATE TABLE IF NOT EXISTS ns(id INTEGER PRIMARY KEY AUTOINCREMENT,ma_nhac_si VARCHAR(300), ten_nhac_si VARCHAR(300))");
        updateData("CREATE TABLE IF NOT EXISTS bh(id INTEGER PRIMARY KEY AUTOINCREMENT,ma_bai_hat VARCHAR(300), ten_bai_hat VARCHAR(300), ngay_xuat_ban DATETIME)");
    }

    public void updateData(String sql) {
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        sqLiteDatabase.execSQL(sql);
    }

    public Cursor getData(String sql) {
        SQLiteDatabase sqLiteDatabase = getReadableDatabase();
        return sqLiteDatabase.rawQuery(sql, null);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}