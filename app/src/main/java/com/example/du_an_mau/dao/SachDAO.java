package com.example.du_an_mau.dao;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.du_an_mau.dataBase.DbHelper;
import com.example.du_an_mau.model.Sach;

import java.util.ArrayList;
import java.util.List;

public class SachDAO {
    private DbHelper dbHelper;
    public SachDAO(Context context){
        dbHelper = new DbHelper(context);
    }

    public ArrayList<Sach> getTopSach() {
        ArrayList<Sach> sachList = new ArrayList<>();
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT idSach, tenSach, tacGia FROM Sach WHERE soluong < 100", null);

        if (cursor.getCount() > 0) {
            cursor.moveToFirst();

            do {
                sachList.add(new Sach(
                        cursor.getInt(0),
                        cursor.getString(1),
                        cursor.getString(2)));
            } while (cursor.moveToNext());

        }
        cursor.close();
        db.close();
        return sachList;
    }

}
