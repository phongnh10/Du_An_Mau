package com.example.du_an_mau.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.du_an_mau.dataBase.DbHelper;
import com.example.du_an_mau.model.User;

public class UserDAO {
    private static DbHelper dbHelper;

    public UserDAO(Context context) {
        dbHelper = new DbHelper(context);
    }

    //dangnhap
    public int dangnhap(String user, String pass) {
        SQLiteDatabase sqLiteDatabase = dbHelper.getWritableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM userAdmin WHERE user = ? AND pass = ?", new String[]{user, pass});

        int check;
        if (cursor.getCount() > 0) {
            // Đóng cursor và database khi không cần thiết
            cursor.close();
            sqLiteDatabase.close();
            check = 0; // Đăng nhập thành công
        } else {
            // Đóng cursor và database khi không cần thiết
            cursor.close();
            sqLiteDatabase.close();
            check = 1; // Đăng nhập thất bại
        }
        return check;
    }


    public int updatePass(String user, String pass, String newPass) {
        SQLiteDatabase sqLiteDatabase = dbHelper.getWritableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM userAdmin WHERE user = ? AND pass = ?", new String[]{user, pass});

        int check;
        if (cursor.getCount() > 0) {
            // Tài khoản và mật khẩu hiện tại đúng, thực hiện cập nhật mật khẩu mới
            ContentValues contentValues = new ContentValues();
            contentValues.put("pass", newPass);

            // Thực hiện cập nhật
            sqLiteDatabase.update("userAdmin", contentValues, "user = ? AND pass = ?", new String[]{user, pass});

            check = 0; // Đổi mật khẩu thành công
        } else {
            check = 1; // Tài khoản hoặc mật khẩu không đúng
        }

        // Đóng cursor và database khi không cần thiết
        cursor.close();
        sqLiteDatabase.close();

        return check;
    }
}
