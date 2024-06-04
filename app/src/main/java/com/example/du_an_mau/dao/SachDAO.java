package com.example.du_an_mau.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.du_an_mau.dataBase.DbHelper;
import com.example.du_an_mau.model.Sach;

import java.util.ArrayList;
import java.util.List;

public class SachDAO {
    private DbHelper dbHelper;

    public SachDAO(Context context) {
        dbHelper = new DbHelper(context);
    }

    public ArrayList<Sach> getTopSach() {
        ArrayList<Sach> sachList = new ArrayList<>();
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT idSach, tenSach, tacGia FROM Sach WHERE soluong < 100", null);

        if (cursor.getCount() > 0) {
            cursor.moveToFirst();

            do {
                sachList.add(new Sach(cursor.getInt(0), cursor.getString(1), cursor.getString(2)));
            } while (cursor.moveToNext());

        }
        cursor.close();
        db.close();
        return sachList;
    }

    public ArrayList<Sach> getAllSach() {
        ArrayList<Sach> sachList = new ArrayList<>();
        SQLiteDatabase db = dbHelper.getReadableDatabase();
//        public Sach(String tenSach, String tacGia, String theLoai, String nhaXuatBan, String namXuatBan, int soLuong) {

        Cursor cursor = db.rawQuery("SELECT  idSach, tenSach, tacGia ,theLoai, nhaXuatBan, namXuatBan, soLuong FROM Sach", null);

        if (cursor.getCount() > 0) {
            cursor.moveToFirst();

            do {
                sachList.add(new Sach(cursor.getInt(0), cursor.getString(1), cursor.getString(2), cursor.getString(3), cursor.getString(4), cursor.getString(5), cursor.getInt(6)));
            } while (cursor.moveToNext());

        }
        cursor.close();
        db.close();
        return sachList;
    }

    public boolean themSach(Sach sach) {
        SQLiteDatabase sqLiteDatabase = dbHelper.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put("tensach", sach.getTenSach());
        contentValues.put("tacgia", sach.getTacGia());
        contentValues.put("theloai", sach.getTheLoai());
        contentValues.put("nhaxuatban", sach.getNhaXuatBan());
        contentValues.put("namxuatban", sach.getNamXuatBan());
        contentValues.put("soluong", sach.getSoLuong());

        long check = sqLiteDatabase.insert("sach", null, contentValues);
        if (check == -1) return false;
        return true;
    }

    public boolean suaSach(Sach sach) {
        SQLiteDatabase sqLiteDatabase = dbHelper.getWritableDatabase();
//        Sach(newTenSach, newTacGia, newTheLoai, newNhaXuatBan, newNamXuatBan, newSoLuong)
        ContentValues contentValues = new ContentValues();
        contentValues.put("idSach", sach.getIdSach());
        contentValues.put("tensach", sach.getTenSach());
        contentValues.put("tacgia", sach.getTacGia());
        contentValues.put("theloai", sach.getTheLoai());
        contentValues.put("nhaxuatban", sach.getNhaXuatBan());
        contentValues.put("namxuatban", sach.getNamXuatBan());
        contentValues.put("soluong", sach.getSoLuong());

        int check = sqLiteDatabase.update("Sach", contentValues, "idSach=?", new String[]{String.valueOf(sach.getIdSach())});
        if (check <= 0) return false;
        return true;
    }




    public boolean xoaSach(int idSach) {
        SQLiteDatabase sqLiteDatabase = dbHelper.getWritableDatabase();
        int check = sqLiteDatabase.delete("sach", "idSach=?", new String[]{String.valueOf(idSach)});

        if (check <= 0) return false;
        return true;

    }


}
