package com.example.taskmanager.modules;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.time.LocalDateTime;
import java.util.ArrayList;


public class SQLHandler extends SQLiteOpenHelper {

    public SQLHandler(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS Notes(Title var_char(100) NOT NULL, Description Text, Last_Modified Datetime NOT NULL)");
    }

    public void Insert(String title, String description) {
        getWritableDatabase().execSQL(String.format("INSERT INTO Notes VALUES( '%s', '%s', '%s')", title, (description.isEmpty())? " ": description, LocalDateTime.now() ));
    }

    public void Edit(String title, String oldTitle ,String description, String oldDescription, String oldDate) {
        getWritableDatabase().execSQL(String.format("UPDATE Notes SET Title = '%s', Description  = '%s', Last_Modified = '%s' where Title = '%s' and Description  = '%s' and Last_Modified = '%s'", title, description, LocalDateTime.now(), oldTitle, oldDescription, LocalDateTime.parse(oldDate)));
    }

    public void Delete(String title, String description) {
        getWritableDatabase().execSQL(String.format("DELETE FROM Notes WHERE Title= '%s' and Description = '%s'", title, description));
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {}

    public void fetch(ArrayList<Note> arrayList) {
        Cursor cursor = getReadableDatabase().rawQuery("SELECT * FROM Notes", null);
        cursor.moveToFirst();
        arrayList.clear();
        if(cursor.getCount() == 0) {
            return;
        } else {
            for (int i = 0; i < cursor.getCount(); i++) {
                arrayList.add(new Note(cursor.getString(0), cursor.getString(1), LocalDateTime.parse(cursor.getString(2))));
                cursor.moveToNext();
            }
        }
    }
}
