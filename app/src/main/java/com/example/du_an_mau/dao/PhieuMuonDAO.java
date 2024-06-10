package com.example.du_an_mau.dao;

import static android.content.ContentValues.TAG;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.du_an_mau.dataBase.DbHelper;
import com.example.du_an_mau.model.PhieuMuon;

import java.util.ArrayList;

public class PhieuMuonDAO {
    private DbHelper dbHelper;

    public PhieuMuonDAO(Context context) {
        dbHelper = new DbHelper(context);
    }

    public ArrayList<PhieuMuon> getPhieuMuon() {
        ArrayList<PhieuMuon> phieuMuonList = new ArrayList<>();
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT idPhieuMuon, nguoimuon, sodienthoai, sachmuon, ngaymuon, ngaytra, ghichu, trangthai FROM PhieuMuon", null);

        if (cursor.getCount() > 0) {
            cursor.moveToFirst();

            do {
                phieuMuonList.add(new PhieuMuon(
                        cursor.getInt(0),
                        cursor.getString(1),
                        cursor.getString(2),
                        cursor.getString(3),
                        cursor.getString(4),
                        cursor.getString(5),
                        cursor.getString(6),
                        cursor.getString(7)
                ));
            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return phieuMuonList;
    }

    public boolean themPhieuMuon(PhieuMuon phieuMuon) {
        SQLiteDatabase sqLiteDatabase = dbHelper.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put("nguoimuon", phieuMuon.getNguoiMuon());
        contentValues.put("sodienthoai", phieuMuon.getSoDienThoai());
        contentValues.put("sachmuon", phieuMuon.getSachMuon());
        contentValues.put("ngaymuon", phieuMuon.getNgayMuon());
        contentValues.put("ngaytra", phieuMuon.getNgayTra());
        contentValues.put("ghichu", phieuMuon.getGhiChu());
        contentValues.put("trangthai", phieuMuon.getTrangThai());

        long check = sqLiteDatabase.insert("PhieuMuon", null, contentValues);
        sqLiteDatabase.close();
        return check != -1;
    }

    public boolean suaPhieuMuon(PhieuMuon phieuMuon) {
        SQLiteDatabase sqLiteDatabase = dbHelper.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put("nguoimuon", phieuMuon.getNguoiMuon());
        contentValues.put("sodienthoai", phieuMuon.getSoDienThoai());
        contentValues.put("sachmuon", phieuMuon.getSachMuon());
        contentValues.put("ngaymuon", phieuMuon.getNgayMuon());
        contentValues.put("ngaytra", phieuMuon.getNgayTra());
        contentValues.put("ghichu", phieuMuon.getGhiChu());
        contentValues.put("trangthai", phieuMuon.getTrangThai());

        int check = sqLiteDatabase.update("PhieuMuon", contentValues, "idPhieuMuon=?", new String[]{String.valueOf(phieuMuon.getIdPhieuMuon())});
        sqLiteDatabase.close();
        return check > 0;
    }

    public boolean xoaPhieuMuon(int idPhieuMuon) {
        SQLiteDatabase sqLiteDatabase = dbHelper.getWritableDatabase();
        int check = sqLiteDatabase.delete("PhieuMuon", "idPhieuMuon=?", new String[]{String.valueOf(idPhieuMuon)});
        sqLiteDatabase.close();
        return check > 0;
    }

    public int demLuotMuonSach() {
        int count = 0;
        SQLiteDatabase sqLiteDatabase = dbHelper.getReadableDatabase();

        try {
            Cursor cursor = sqLiteDatabase.rawQuery("SELECT COUNT(*) FROM PhieuMuon", null);
            if (cursor != null && cursor.moveToFirst()) {
                count = cursor.getInt(0);
            }
            if (cursor != null) {
                cursor.close();
            }
        } catch (Exception e) {
            Log.e((String) TAG, "Error while counting PhieuMuon: " + e.getMessage());
        } finally {
            sqLiteDatabase.close();
        }

        return count;
    }

    public int demLuotTraSach() {
        int count = 0;
        SQLiteDatabase sqLiteDatabase = dbHelper.getReadableDatabase();

        try {
            String[] projection = {"COUNT(*)"};
            String selection = "trangthai = ? OR trangthai = ? OR trangthai = ? OR trangthai = ? OR trangthai = ?";
            String[] selectionArgs = {"Đã Trả", "Tra", "tra", "trả" ,"Trả"};

            Cursor cursor = sqLiteDatabase.query(
                    "PhieuMuon",
                    projection,
                    selection,
                    selectionArgs,
                    null,
                    null,
                    null
            );

            // Xử lý Cursor để lấy kết quả
            if (cursor != null) {
                cursor.moveToFirst();
                 count = cursor.getInt(0); // Lấy giá trị COUNT(*) từ cột đầu tiên của kết quả truy vấn
                cursor.close();


                Log.d("MainActivity", "Số lượng phiếu mượn: " + count);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            sqLiteDatabase.close();
        }
        return count;
    }
}
