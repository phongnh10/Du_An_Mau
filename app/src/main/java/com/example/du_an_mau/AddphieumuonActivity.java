package com.example.du_an_mau;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.du_an_mau.dao.PhieuMuonDAO;
import com.example.du_an_mau.model.PhieuMuon;

public class AddphieumuonActivity extends AppCompatActivity {
    private PhieuMuonDAO phieuMuonDAO;

    private EditText edtTenNguoiMuon, edtSoDienThoai, edtSachMuon, edtNgayMuon, edtNgayTra, edtGhiChu, edtTrangThai;
    private Button btnThem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_addphieumuon);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Ánh xạ các view từ layout XML
        edtTenNguoiMuon = findViewById(R.id.edtTenNguoiMuon);
        edtSoDienThoai = findViewById(R.id.edtSoDienThoai);
        edtSachMuon = findViewById(R.id.edtSachMuon);
        edtNgayMuon = findViewById(R.id.edtNgayMuon);
        edtNgayTra = findViewById(R.id.edtNgayTra);
        edtGhiChu = findViewById(R.id.edtGhiChu);
        edtTrangThai = findViewById(R.id.edtTrangThai);
        btnThem = findViewById(R.id.buttonThem);

        themPhieuMuon();

        back();
        goBook();
        goCaiDat();
        goPhieuMuon();
        goSach();
    }




    public  void themPhieuMuon(){
        phieuMuonDAO = new PhieuMuonDAO(this);
        btnThem.setOnClickListener(v -> {
            String tenNguoiMuon = edtTenNguoiMuon.getText().toString().trim();
            String soDienThoai = edtSoDienThoai.getText().toString().trim();
            String sachMuon = edtSachMuon.getText().toString().trim();
            String ngayMuon = edtNgayMuon.getText().toString().trim();
            String ngayTra = edtNgayTra.getText().toString().trim();
            String ghiChu = edtGhiChu.getText().toString().trim();
            String trangThai = edtTrangThai.getText().toString().trim();

            if (tenNguoiMuon.isEmpty() || soDienThoai.isEmpty() || sachMuon.isEmpty() || ngayMuon.isEmpty() || ngayTra.isEmpty() || ghiChu.isEmpty()|| trangThai.isEmpty()) {
                Toast.makeText(AddphieumuonActivity.this, "Nhập đầy đủ thông tin", Toast.LENGTH_SHORT).show();
            } else {
                PhieuMuon phieuMuon;
                phieuMuon = new PhieuMuon(tenNguoiMuon, soDienThoai, sachMuon, ngayMuon, ngayTra, ghiChu,trangThai);
                boolean check = phieuMuonDAO.themPhieuMuon(phieuMuon);
                if (check) {
                    Intent intent = new Intent(AddphieumuonActivity.this, PhieuMuonActivity.class);
                    startActivity(intent);
                    finish();
                    Toast.makeText(AddphieumuonActivity.this, "Thêm sản phẩm thành công", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(AddphieumuonActivity.this, "Thêm sản phẩm thất bại", Toast.LENGTH_SHORT).show();
                }
            }

        });
    }
    public void back() {
        ImageView imgBack = findViewById(R.id.imgBack);

        imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AddphieumuonActivity.this, PhieuMuonActivity.class);
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
                Intent intent = new Intent(AddphieumuonActivity.this, BookActivity.class);
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
                Intent intent = new Intent(AddphieumuonActivity.this,PhieuMuonActivity.class);
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
                Intent intent = new Intent(AddphieumuonActivity.this, CaidatActivity.class);
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
                Intent intent = new Intent(AddphieumuonActivity.this, BookActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }


}
