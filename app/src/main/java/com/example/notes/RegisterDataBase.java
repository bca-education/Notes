package com.example.notes;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class RegisterDataBase extends SQLiteOpenHelper
{

    public RegisterDataBase(Context context) {
        super(context, "BCA.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE  BCA_Six (enrollment TEXT PRIMARY KEY NOT NULL UNIQUE, user_Name TEXT NOT NULL)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS BCA_Six");
    }

    public boolean insertStudentData(String enrollment, String name)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("Enrollment ",enrollment);
        values.put("User_Name ",name);

        long result = db.insert("BCA_Six",null,values);
        if (result == -1) {
            return false;
        }
        else {
            return true;
        }
    }

    public boolean deleteStudentData(String enrollment)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM BCA_Six WHERE enrollment = ?",new String[]{enrollment});
        if (cursor.getCount() > 0)
        {
            long result = db.delete("BCA_Six ","enrollment = ?", new String[] {enrollment});

            if(result == -1)
            {
                return false;
            }
            else{
                return true;
            }
        }
        else{
            return false;
        }
    }

    public Cursor getData()
    {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM BCA_Six",null);
        return cursor;
    }

    public boolean checkEnroll(String enrollment){
        SQLiteDatabase mydb = this.getWritableDatabase();
        Cursor cursor = mydb.rawQuery("SELECT * FROM BCA_Six WHERE enrollment = ?",new String[] {enrollment});
        if(cursor.getCount()>0){
            return true;
        }
        else{
            return false;
        }
    }

    public boolean checkUserDetails(String enrollment, String name)
    {
        SQLiteDatabase mydb = this.getWritableDatabase();
        Cursor cursor = mydb.rawQuery("SELECT * FROM BCA_Six WHERE enrollment = ? AND user_Name = ?",new String[]{enrollment, name});
        if(cursor.getCount()>0)
            return true;
        else
            return false;
    }
}