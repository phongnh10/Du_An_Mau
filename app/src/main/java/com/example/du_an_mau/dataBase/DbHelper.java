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
        sqLiteDatabase.execSQL("CREATE TABLE Sach (idSach INTEGER PRIMARY KEY AUTOINCREMENT, tensach TEXT, tacgia TEXT, theloai TEXT, nhaxuatban TEXT, namxuatban TEXT, soluong INTEGER)");

        sqLiteDatabase.execSQL("INSERT INTO userADMIN (name, user, pass) VALUES ('Nguyen Hong Phong', 'phongnh10', '10')");
        sqLiteDatabase.execSQL("INSERT INTO userADMIN (name, user, pass) VALUES ('admin', 'admin', '1')");

        sqLiteDatabase.execSQL("INSERT INTO Sach (tensach, tacgia, theloai, nhaxuatban, namxuatban,soluong) VALUES ('Cổ Chân Nhân', 'Chân Nhân', 'Tiên Hiệp','TenCen','2018',100)");
        sqLiteDatabase.execSQL("INSERT INTO Sach (tensach, tacgia, theloai, nhaxuatban, namxuatban,soluong) VALUES ('Tiên Nghịch', 'Nhĩ Căn', 'Tiên Hiệp','TenCen','2014',99)");
        sqLiteDatabase.execSQL("INSERT INTO Sach (tensach, tacgia, theloai, nhaxuatban, namxuatban,soluong) VALUES ('Khủng Bố Sống Lại', 'Ma Niệm', 'Linh Dị','TenCen','2014',99)");
        sqLiteDatabase.execSQL("INSERT INTO Sach (tensach, tacgia, theloai, nhaxuatban, namxuatban,soluong) VALUES ('Trạch Nhật Phi Thăng', 'Nhĩ Căn', 'Tiên Hiệp','TenCen','2014',99)");
        sqLiteDatabase.execSQL("INSERT INTO Sach (tensach, tacgia, theloai, nhaxuatban, namxuatban,soluong) VALUES ('Cổ Chân Nhân', 'Chân Nhân', 'Tiên Hiệp','TenCen','2018',100)");
        sqLiteDatabase.execSQL("INSERT INTO Sach (tensach, tacgia, theloai, nhaxuatban, namxuatban,soluong) VALUES ('Tiên Nghịch', 'Nhĩ Căn', 'Tiên Hiệp','TenCen','2014',99)");
        sqLiteDatabase.execSQL("INSERT INTO Sach (tensach, tacgia, theloai, nhaxuatban, namxuatban,soluong) VALUES ('Khủng Bố Sống Lại', 'Ma Niệm', 'Linh Dị','TenCen','2014',99)");
        sqLiteDatabase.execSQL("INSERT INTO Sach (tensach, tacgia, theloai, nhaxuatban, namxuatban,soluong) VALUES ('Trạch Nhật Phi Thăng', 'Nhĩ Căn', 'Tiên Hiệp','TenCen','2014',99)");
        sqLiteDatabase.execSQL("INSERT INTO Sach (tensach, tacgia, theloai, nhaxuatban, namxuatban,soluong) VALUES ('Cổ Chân Nhân', 'Chân Nhân', 'Tiên Hiệp','TenCen','2018',100)");
        sqLiteDatabase.execSQL("INSERT INTO Sach (tensach, tacgia, theloai, nhaxuatban, namxuatban,soluong) VALUES ('Tiên Nghịch', 'Nhĩ Căn', 'Tiên Hiệp','TenCen','2014',99)");
        sqLiteDatabase.execSQL("INSERT INTO Sach (tensach, tacgia, theloai, nhaxuatban, namxuatban,soluong) VALUES ('Khủng Bố Sống Lại', 'Ma Niệm', 'Linh Dị','TenCen','2014',99)");
        sqLiteDatabase.execSQL("INSERT INTO Sach (tensach, tacgia, theloai, nhaxuatban, namxuatban,soluong) VALUES ('Trạch Nhật Phi Thăng', 'Nhĩ Căn', 'Tiên Hiệp','TenCen','2014',99)");
        sqLiteDatabase.execSQL("INSERT INTO Sach (tensach, tacgia, theloai, nhaxuatban, namxuatban,soluong) VALUES ('Cổ Chân Nhân', 'Chân Nhân', 'Tiên Hiệp','TenCen','2018',100)");
        sqLiteDatabase.execSQL("INSERT INTO Sach (tensach, tacgia, theloai, nhaxuatban, namxuatban,soluong) VALUES ('Tiên Nghịch', 'Nhĩ Căn', 'Tiên Hiệp','TenCen','2014',99)");
        sqLiteDatabase.execSQL("INSERT INTO Sach (tensach, tacgia, theloai, nhaxuatban, namxuatban,soluong) VALUES ('Khủng Bố Sống Lại', 'Ma Niệm', 'Linh Dị','TenCen','2014',99)");
        sqLiteDatabase.execSQL("INSERT INTO Sach (tensach, tacgia, theloai, nhaxuatban, namxuatban,soluong) VALUES ('Trạch Nhật Phi Thăng', 'Nhĩ Căn', 'Tiên Hiệp','TenCen','2014',99)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
