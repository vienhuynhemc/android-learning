package com.vientamthuong.sqlitehinhanh;

import android.annotation.SuppressLint;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class Database extends SQLiteOpenHelper {

    private SQLiteDatabase read;
    private SQLiteDatabase write;

    public Database(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
        this.read = getReadableDatabase();
        this.write = getWritableDatabase();
        init();
    }

    private void init() {
        String sql = "CREATE TABLE IF NOT EXISTS do_vat(id INTEGER PRIMARY KEY AUTOINCREMENT, ten VARCHAR(50), mo_ta VARCHAR(50), hinh_anh BLOD)";
        read.execSQL(sql);
    }

    public void addToDatabase(String ten, String mota, byte[] array) {
        String sql = "INSERT INTO do_vat VALUES(null,?,?,?)";
        SQLiteStatement sqLiteStatement = write.compileStatement(sql);
        sqLiteStatement.clearBindings();
        sqLiteStatement.bindString(1, ten);
        sqLiteStatement.bindString(2, mota);
        sqLiteStatement.bindBlob(3, array);
        sqLiteStatement.executeInsert();
        sqLiteStatement.close();
    }

    public List<DoVat> getListDoVat() {
        @SuppressLint("Recycle") Cursor cursor = read.rawQuery("SELECT ten,mo_ta FROM do_vat", null);
        System.out.println(cursor.toString());
        List<DoVat> list = new ArrayList<>();
        while (cursor.moveToNext()) {
            String ten = cursor.getString(0);
            String mota = cursor.getString(1);
            DoVat doVat = new DoVat(ten, mota, null);
            list.add(doVat);
        }
        return list;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
