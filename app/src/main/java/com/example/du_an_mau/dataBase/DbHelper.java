package com.example.du_an_mau.dataBase;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class DbHelper extends SQLiteOpenHelper {
    public DbHelper( Context context){
        super(context, "DuAnMau", null, 1);
    }


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE userADMIN (idAdmin INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT, user TEXT, pass TEXT)");

        sqLiteDatabase.execSQL("INSERT INTO userADMIN (name, user, pass) VALUES ('Nguyen Hong Phong', 'phongnh10', '10')");

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
