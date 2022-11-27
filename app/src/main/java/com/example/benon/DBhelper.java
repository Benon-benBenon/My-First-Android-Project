package com.example.benon;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBhelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "EmployeeName.db";
    public static final String TABLE_NAME = "status";
    public static final String COL1 = "id";
    public static final String COL2 = "name";

    public DBhelper(Context context) {
        super(context, DATABASE_NAME , null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table status " + "(id integer primary key, name text)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS status");
        onCreate(db);

    }

    public boolean insertStatus (String iid, String nname) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("id", iid);
        contentValues.put("name", nname);


        db.insert("status", null, contentValues);
        int result = 0;
        if(result==-1) 
            return false;
        else 
            return true;
    }

    public Cursor getData() {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res =  db.rawQuery( "select * from status", null );
        return res;
    }
}
