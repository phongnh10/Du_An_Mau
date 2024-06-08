package com.example.du_an_mau;

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

import com.example.du_an_mau.dao.PhieuMuonDAO;
import com.example.du_an_mau.model.PhieuMuon;
import com.example.du_an_mau.model.Sach;

public class ChitietphieumuonActivity extends AppCompatActivity {

    private PhieuMuonDAO phieuMuonDAO;
    private ImageView imgBack;
    private int idPhieuMuon;
    private EditText edtTenNguoiMuon, edtSoDienThoai, edtSachMuon, edtNgayMuon, edtNgayTra, edtGhiChu, edtTrangThai;
    private Button btnCapNhat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_chitietphieumuon);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        phieuMuonDAO = new PhieuMuonDAO(this);
        imgBack = findViewById(R.id.imgBack);

        edtTenNguoiMuon = findViewById(R.id.edtTenNguoiMuon);
        edtSoDienThoai = findViewById(R.id.edtSoDienThoai);
        edtSachMuon = findViewById(R.id.edtSachMuon);
        edtNgayMuon = findViewById(R.id.edtNgayMuon);
        edtNgayTra = findViewById(R.id.edtNgayTra);
        edtGhiChu = findViewById(R.id.edtGhiChu);
        edtTrangThai = findViewById(R.id.edtTrangThai);
        btnCapNhat = findViewById(R.id.buttonCapNhat);

        Intent intent = getIntent();
        if (intent != null) {
            idPhieuMuon = intent.getIntExtra("idPhieuMuon", 0);
            String soDienThoai = intent.getStringExtra("sodienthoai");
            String nguoiMuon = intent.getStringExtra("nguoiMuon");
            String ngayMuon = intent.getStringExtra("ngayMuon");
            String ngayTra = intent.getStringExtra("ngayTra");
            String trangThai = intent.getStringExtra("trangThai");
            String sachMuon = intent.getStringExtra("sachMuon");
            String ghiChu = intent.getStringExtra("ghiChu");

            // Hiển thị dữ liệu lên các EditText
            edtTenNguoiMuon.setText(nguoiMuon);
            edtSoDienThoai.setText(soDienThoai);
            edtSachMuon.setText(sachMuon);
            edtNgayMuon.setText(ngayMuon);
            edtNgayTra.setText(ngayTra);
            edtGhiChu.setText(ghiChu);
            edtTrangThai.setText(trangThai);
        }

        imgBack.setOnClickListener(v -> onBackPressed());
        update();

        back();
        goBook();
        goPhieuMuon();
        goSach();
        goCaiDat();
        goThongKe();


    }

    public void update() {
        btnCapNhat.setOnClickListener(v -> {
            phieuMuonDAO = new PhieuMuonDAO(this);
            String tenNguoiMuon = edtTenNguoiMuon.getText().toString().trim();
            String soDienThoai = edtSoDienThoai.getText().toString().trim();
            String sachMuon = edtSachMuon.getText().toString().trim();
            String ngayMuon = edtNgayMuon.getText().toString().trim();
            String ngayTra = edtNgayTra.getText().toString().trim();
            String ghiChu = edtGhiChu.getText().toString().trim();
            String trangThai = edtTrangThai.getText().toString().trim();


            if (tenNguoiMuon.isEmpty() || soDienThoai.isEmpty() || sachMuon.isEmpty() || ngayMuon.isEmpty() || ngayTra.isEmpty() || ghiChu.isEmpty()|| trangThai.isEmpty()) {
                Toast.makeText(ChitietphieumuonActivity.this, "Nhập đầy đủ thông tin", Toast.LENGTH_SHORT).show();
            } else {
                PhieuMuon phieuMuon = new PhieuMuon(idPhieuMuon, tenNguoiMuon, soDienThoai, sachMuon, ngayMuon, ngayTra, ghiChu,trangThai);
                boolean check = phieuMuonDAO.suaPhieuMuon(phieuMuon);
                if (check) {
                    //  Intent intent = new Intent(InformationActivity.this,BookActivity.class);
                    finish();
                    Toast.makeText(ChitietphieumuonActivity.this, "Chỉnh sửa thành công", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(ChitietphieumuonActivity.this, "Chỉnh sửa thất bại", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    public void back() {
        ImageView imgBack = findViewById(R.id.imgBack);

        imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ChitietphieumuonActivity.this, PhieuMuonActivity.class);
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
                Intent intent = new Intent(ChitietphieumuonActivity.this, MainActivity.class);
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
                Intent intent = new Intent(ChitietphieumuonActivity.this,PhieuMuonActivity.class);
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
                Intent intent = new Intent(ChitietphieumuonActivity.this, CaidatActivity.class);
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
                Intent intent = new Intent(ChitietphieumuonActivity.this,BookActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
    public void goThongKe() {
        ImageView imgCaiDat = findViewById(R.id.imgNguoiDung);

        imgCaiDat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ChitietphieumuonActivity.this,ThongkeActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }

}