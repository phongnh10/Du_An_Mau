package com.example.du_an_mau;

import static java.security.AccessController.getContext;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.du_an_mau.dao.SachDAO;
import com.example.du_an_mau.model.Sach;

import java.util.ArrayList;

public class AddbookActivity extends AppCompatActivity {
    private ArrayList<Sach> list;
    private SachDAO sachDAO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_addbook);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        themSach();
        back();
        goBook();
        goCaiDat();
        goPhieuMuon();
        goSach();
    }


    public void themSach() {
        sachDAO = new SachDAO(this);
        EditText edtTenSach = findViewById(R.id.edtTenSach);
        EditText edtSoLuong = findViewById(R.id.edtSoLuong);
        EditText edtTacGia = findViewById(R.id.edtTenTacGia);
        EditText edtTheLoai = findViewById(R.id.edtTheLoai);
        EditText edtNhaXuatBan = findViewById(R.id.edtNhaXuatBan);
        EditText edtNamXuatBan = findViewById(R.id.edtNamXuatBan);

        Button btnAdd = findViewById(R.id.btnThemSach);

//        // dau du lieu len sp can sua
//        edtTenSach.setText(sach.getTenSach());
//        edtSoLuong.setText(sach.getSoLuong());
//        edtTheLoai.setText(sach.getTheLoai());
//        edtNhaXuatBan.setText(sach.getNhaXuatBan());
//        edtNamXuatBan.setText(sach.getNamXuatBan());
//        edtTacGia.setText(sach.getTacGia());

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String tenSach = edtTenSach.getText().toString();
                String soLuongString = edtSoLuong.getText().toString();
                int soLuong = Integer.parseInt(soLuongString);

                String theLoai = edtTheLoai.getText().toString();
                String nhaXuatBan = edtNhaXuatBan.getText().toString();
                String namXuatBan = edtNamXuatBan.getText().toString();
                String tacGia = edtTacGia.getText().toString();
//    public Sach(int idSach, String tenSach, String tacGia, String theLoai, String nhaXuatBan, String namXuatBan, int soLuong) {

                if (tenSach.length() == 0 || soLuongString.length() == 0 || theLoai.length() == 0 || nhaXuatBan.length() == 0 || namXuatBan.length() == 0 || tacGia.length() == 0) {
                    Toast.makeText(AddbookActivity.this, "Nhập đầy đủ thông tin", Toast.LENGTH_SHORT).show();
                } else {
                    Sach sach = new Sach(tenSach, tacGia, theLoai, nhaXuatBan, namXuatBan, soLuong);
                    boolean check = sachDAO.themSach(sach);
                    if (check) {
                        Toast.makeText(AddbookActivity.this, "Thêm sản phẩm thành công", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(AddbookActivity.this,BookActivity.class);
                        startActivity(intent);
                    } else {
                        Toast.makeText(AddbookActivity.this, "Thêm sản phẩm thất bại", Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });
    }

    public void back() {
        ImageView imgBack = findViewById(R.id.imgBack);

        imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AddbookActivity.this, BookActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }

    public void goBook() {
        ImageView imgSach = findViewById(R.id.imgTrangChu);

        imgSach.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AddbookActivity.this, BookActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }

    public void goPhieuMuon() {
        ImageView imgPhieuMuon = findViewById(R.id.imgPhieuMuon);

        imgPhieuMuon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AddbookActivity.this,PhieuMuonActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }

    public void goCaiDat() {
        ImageView imgCaiDat = findViewById(R.id.imgCaiDat);

        imgCaiDat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AddbookActivity.this, CaidatActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
    public void goSach() {
        ImageView imgCaiDat = findViewById(R.id.imgSach);

        imgCaiDat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AddbookActivity.this, BookActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}