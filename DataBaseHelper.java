package com.example.gagan.quizapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DataBaseHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME="user2.db";
    private static final String TABLE_NAME="user2";
    public DataBaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE "+TABLE_NAME+"(ID INTEGER PRIMARY KEY AUTOINCREMENT,USERNAME TEXT,PASSWORD TEXT,MOBILE TEXT,EMAIL TEXT)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
        onCreate(sqLiteDatabase);
    }
    public boolean insertData(String username,String password,String mobile,String email){
        SQLiteDatabase db =this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put("USERNAME",username);
        contentValues.put("PASSWORD",password);
        contentValues.put("MOBILE",mobile);
        contentValues.put("EMAIL",email);
        long result=db.insert(TABLE_NAME,null,contentValues);
        if(result!=-1){
            return true;
        }
        else {
            return false;
        }


    }
    public Cursor getData(String username,String password){
        SQLiteDatabase db=this.getWritableDatabase();
        String query="SELECT * FROM "+TABLE_NAME+" WHERE USERNAME= '"+username+"' AND PASSWORD= '"+password+"'";
        Cursor cursor =db.rawQuery(query,null);
        return cursor;

    }
    public int updateRecords(String mobile,String username,String email){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();

        contentValues.put("USERNAME",username);
        contentValues.put("EMAIL",email);
        int p=db.update(TABLE_NAME,contentValues,"MOBILE='"+mobile+"'",null);
        return p;
    }
}