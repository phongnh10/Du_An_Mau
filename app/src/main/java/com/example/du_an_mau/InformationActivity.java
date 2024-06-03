package com.example.du_an_mau;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.du_an_mau.dao.SachDAO;
import com.example.du_an_mau.model.Sach;

import java.util.ArrayList;

public class InformationActivity extends AppCompatActivity {

    private Context context;
    private SachDAO sachDAO;
    private ArrayList<Sach> sachList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_information);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


        settingSach();
    }

    public void settingSach() {
        sachDAO = new SachDAO(this);

        EditText edtTenSach = findViewById(R.id.edtTenSach);
        EditText edtSoLuong = findViewById(R.id.edtSoLuong);
        EditText edtTacGia = findViewById(R.id.edtTenTacGia);
        EditText edtTheLoai = findViewById(R.id.edtTheLoai);
        EditText edtNhaXuatBan = findViewById(R.id.edtNhaXuatBan);
        EditText edtNamXuatBan = findViewById(R.id.edtNamXuatBan);

        Button btnSua = findViewById(R.id.btnThemSach);
        Button btnXoa = findViewById(R.id.btnXoaSach);

        // Tạo một đối tượng Sach để sử dụng các phương thức getter
        Sach sach = new Sach();

        // Đặt dữ liệu lên các EditText nếu cần
        edtTenSach.setText(sach.getTenSach());
        edtSoLuong.setText(String.valueOf(sach.getSoLuong())); // Chuyển số lượng sang chuỗi
        edtTheLoai.setText(sach.getTheLoai());
        edtNhaXuatBan.setText(sach.getNhaXuatBan());
        edtNamXuatBan.setText(sach.getNamXuatBan());
        edtTacGia.setText(sach.getTacGia());

        btnSua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String tenSach = edtTenSach.getText().toString();
                String soLuongString = edtSoLuong.getText().toString();
                int soLuong = Integer.parseInt(soLuongString);

                String theLoai = edtTheLoai.getText().toString();
                String nhaXuatBan = edtNhaXuatBan.getText().toString();
                String namXuatBan = edtNamXuatBan.getText().toString();
                String tacGia = edtTacGia.getText().toString();

                if (tenSach.length() == 0 || soLuongString.length() == 0 || theLoai.length() == 0 || nhaXuatBan.length() == 0 || namXuatBan.length() == 0 || tacGia.length() == 0) {
                    Toast.makeText(InformationActivity.this, "Nhập đầy đủ thông tin", Toast.LENGTH_SHORT).show();
                } else {
                    Sach sach = new Sach(tenSach, tacGia, theLoai, nhaXuatBan, namXuatBan, soLuong);
                    boolean check = sachDAO.suaSach(sach);
                    if (check) {
                        Toast.makeText(InformationActivity.this, "Chỉnh sửa thành công", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(InformationActivity.this, "Chỉnh sửa thất bại", Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });

    }

    private void xoa (String tenSach,int idSach){

        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle("Thông Báo");
        builder.setMessage("Bạn có muốn xoá sản phẩm \"" + tenSach + "\" không");

        builder.setPositiveButton("Xoá", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                boolean check = sachDAO.xoaSach(idSach);
                if (check) {
                    Toast.makeText(context, "Xoá thành công", Toast.LENGTH_SHORT).show();

                }
            }
        });
        builder.setNegativeButton("Hủy bỏ", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                // Do nothing or handle cancel action
            }
        });

        AlertDialog alertDialog = builder.create();
        alertDialog.show();

    }
}