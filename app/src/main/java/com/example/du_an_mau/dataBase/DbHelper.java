package com.example.du_an_mau.dataBase;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class DbHelper extends SQLiteOpenHelper {
    public DbHelper(Context context) {
        super(context, "DuAnMau", null, 1);
    }


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE userADMIN (idAdmin INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT, user TEXT, pass TEXT)");

        sqLiteDatabase.execSQL("CREATE TABLE Sach (idSach INTEGER PRIMARY KEY AUTOINCREMENT, tensach TEXT, tacgia TEXT, theloai TEXT, nhaxuatban TEXT, namxuatban TEXT, soluong INTEGER)");

        sqLiteDatabase.execSQL("CREATE TABLE PhieuMuon (idPhieuMuon INTEGER PRIMARY KEY AUTOINCREMENT, nguoimuon TEXT, sodienthoai TEXT, sachmuon TEXT, ghichu TEXT, ngaymuon TEXT, ngaytra TEXT, trangthai TEXT)");

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

        sqLiteDatabase.execSQL("INSERT INTO PhieuMuon (nguoimuon,sodienthoai, sachmuon, ghichu, ngaymuon, ngaytra,trangthai) VALUES ('Nguyễn Văn A', '0123456789', 'Tiên nghịch, Cổ chân nhân','Người này đã mượn nhiều lần','20/11/2022','20/12/2022','Chưa Trả')");
        sqLiteDatabase.execSQL("INSERT INTO PhieuMuon (nguoimuon,sodienthoai, sachmuon, ghichu, ngaymuon, ngaytra,trangthai) VALUES ('Nguyễn Văn A', '0123456789', 'Tiên nghịch, Cổ chân nhân','Người này đã mượn nhiều lần','20/11/2022','20/12/2022','Chưa Trả')");
        sqLiteDatabase.execSQL("INSERT INTO PhieuMuon (nguoimuon,sodienthoai, sachmuon, ghichu, ngaymuon, ngaytra,trangthai) VALUES ('Nguyễn Văn A', '0123456789', 'Tiên nghịch, Cổ chân nhân','Người này đã mượn nhiều lần','20/11/2022','20/12/2022','Chưa Trả')");
        sqLiteDatabase.execSQL("INSERT INTO PhieuMuon (nguoimuon,sodienthoai, sachmuon, ghichu, ngaymuon, ngaytra,trangthai) VALUES ('Nguyễn Văn A', '0123456789', 'Tiên nghịch, Cổ chân nhân','Người này đã mượn nhiều lần','20/11/2022','20/12/2022','Chưa Trả')");
        sqLiteDatabase.execSQL("INSERT INTO PhieuMuon (nguoimuon,sodienthoai, sachmuon, ghichu, ngaymuon, ngaytra,trangthai) VALUES ('Nguyễn Văn A', '0123456789', 'Tiên nghịch, Cổ chân nhân','Người này đã mượn nhiều lần','20/11/2022','20/12/2022','Chưa Trả')");
        sqLiteDatabase.execSQL("INSERT INTO PhieuMuon (nguoimuon,sodienthoai, sachmuon, ghichu, ngaymuon, ngaytra,trangthai) VALUES ('Nguyễn Văn A', '0123456789', 'Tiên nghịch, Cổ chân nhân','Người này đã mượn nhiều lần','20/11/2022','20/12/2022','Chưa Trả')");
        sqLiteDatabase.execSQL("INSERT INTO PhieuMuon (nguoimuon,sodienthoai, sachmuon, ghichu, ngaymuon, ngaytra,trangthai) VALUES ('Nguyễn Văn A', '0123456789', 'Tiên nghịch, Cổ chân nhân','Người này đã mượn nhiều lần','20/11/2022','20/12/2022','Chưa Trả')");
        sqLiteDatabase.execSQL("INSERT INTO PhieuMuon (nguoimuon,sodienthoai, sachmuon, ghichu, ngaymuon, ngaytra,trangthai) VALUES ('Nguyễn Văn A', '0123456789', 'Tiên nghịch, Cổ chân nhân','Người này đã mượn nhiều lần','20/11/2022','20/12/2022','Chưa Trả')");
        sqLiteDatabase.execSQL("INSERT INTO PhieuMuon (nguoimuon,sodienthoai, sachmuon, ghichu, ngaymuon, ngaytra,trangthai) VALUES ('Nguyễn Văn A', '0123456789', 'Tiên nghịch, Cổ chân nhân','Người này đã mượn nhiều lần','20/11/2022','20/12/2022','Chưa Trả')");
        sqLiteDatabase.execSQL("INSERT INTO PhieuMuon (nguoimuon,sodienthoai, sachmuon, ghichu, ngaymuon, ngaytra,trangthai) VALUES ('Nguyễn Văn A', '0123456789', 'Tiên nghịch, Cổ chân nhân','Người này đã mượn nhiều lần','20/11/2022','20/12/2022','Chưa Trả')");
// Chuỗi chứa các giá trị sách được phân tách bằng dấu phẩy
        String sachMuon = "Tiên nghịch, Cổ chân nhân";

// Chèn dữ liệu vào bảng PhieuMuon
        sqLiteDatabase.execSQL("INSERT INTO PhieuMuon (nguoimuon, sodienthoai, sachmuon, ghichu, ngaymuon, ngaytra, trangthai) " + "VALUES ('Nguyễn Văn A', '0123456789', ?, 'Người này đã mượn nhiều lần', '20/11/2022', '20/12/2022', 'Chưa')", new String[]{sachMuon});

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
