package com.example.practical15;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class OrderDatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "order.db";
    private static final int DATABASE_VERSION = 1;

    private static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE " + OrderContract.OrderEntry.TABLE_NAME + " (" +
                    OrderContract.OrderEntry._ID + " INTEGER PRIMARY KEY," +
                    OrderContract.OrderEntry.COLUMN_PHONE + " TEXT," +
                    OrderContract.OrderEntry.COLUMN_ITEM_NAME + " TEXT," +
                    OrderContract.OrderEntry.COLUMN_QUANTITY + " INTEGER)";

    private static final String SQL_DELETE_ENTRIES =
            "DROP TABLE IF EXISTS " + OrderContract.OrderEntry.TABLE_NAME;

    public OrderDatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_ENTRIES);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(SQL_DELETE_ENTRIES);
        onCreate(db);
    }
}