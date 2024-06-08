package com.example.du_an_mau;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.du_an_mau.dao.SachDAO;
import com.example.du_an_mau.model.Sach;

public class InformationActivity extends AppCompatActivity {

    private SachDAO sachDAO;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_information);

        sachDAO = new SachDAO(this);

        EditText edtTenSach = findViewById(R.id.edtTenSach);
        EditText edtSoLuong = findViewById(R.id.edtSoLuong);
        EditText edtTacGia = findViewById(R.id.edtTenTacGia);
        EditText edtTheLoai = findViewById(R.id.edtTheLoai);
        EditText edtNhaXuatBan = findViewById(R.id.edtNhaXuatBan);
        EditText edtNamXuatBan = findViewById(R.id.edtNamXuatBan);

        ImageView imgBack = findViewById(R.id.imgBack);

        Button btnSua = findViewById(R.id.btnSuaSach);
        Button btnXoa = findViewById(R.id.btnXoaSach);

        // Nhận dữ liệu từ Intent
        int idSach = getIntent().getIntExtra("SACH_ID", -1);
        String tenSach = getIntent().getStringExtra("TEN_SACH");
        String theLoai = getIntent().getStringExtra("THE_LOAI");
        int soLuong = getIntent().getIntExtra("SO_LUONG", 0);
        String tacGia = getIntent().getStringExtra("TAC_GIA");
        String nhaXuatBan = getIntent().getStringExtra("NHA_XUAT_BAN");
        String namXuatBan = getIntent().getStringExtra("NAM_XUAT_BAN");

        // Đặt dữ liệu lên các EditText
        edtTenSach.setText(tenSach);
        edtSoLuong.setText(String.valueOf(soLuong));
        edtTacGia.setText(tacGia);
        edtTheLoai.setText(theLoai);
        edtNhaXuatBan.setText(nhaXuatBan);
        edtNamXuatBan.setText(namXuatBan);

        btnSua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String newTenSach = edtTenSach.getText().toString();
                String newSoLuongString = edtSoLuong.getText().toString();
                int newSoLuong = Integer.parseInt(newSoLuongString);
                String newTheLoai = edtTheLoai.getText().toString();
                String newNhaXuatBan = edtNhaXuatBan.getText().toString();
                String newNamXuatBan = edtNamXuatBan.getText().toString();
                String newTacGia = edtTacGia.getText().toString();

                if (newTenSach.isEmpty() || newSoLuongString.isEmpty() || newTheLoai.isEmpty() || newNhaXuatBan.isEmpty() || newNamXuatBan.isEmpty() || newTacGia.isEmpty()) {
                    Toast.makeText(InformationActivity.this, "Nhập đầy đủ thông tin", Toast.LENGTH_SHORT).show();
                } else {
                    Sach sach = new Sach(idSach, newTenSach, newTacGia, newTheLoai, newNhaXuatBan, newNamXuatBan, newSoLuong);
                    boolean check = sachDAO.suaSach(sach);
                    if (check) {
                      //  Intent intent = new Intent(InformationActivity.this,BookActivity.class);
                        finish();
                        Toast.makeText(InformationActivity.this, "Chỉnh sửa thành công", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(InformationActivity.this, "Chỉnh sửa thất bại", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        btnXoa.setOnClickListener(view -> xoa(tenSach, idSach));
        back();
        goBook();
        goPhieuMuon();
        goSach();
        goCaiDat();
        goThongKe();
    }

    private void xoa(String tenSach, int idSach) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Thông Báo");
        builder.setMessage("Bạn có muốn xoá sản phẩm \"" + tenSach + "\" không");

        builder.setPositiveButton("Xoá", (dialogInterface, i) -> {
            boolean check = sachDAO.xoaSach(idSach);
            if (check) {
                Toast.makeText(this, "Xoá thành công", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(InformationActivity.this,BookActivity.class);
                finish();
            }
        });

        builder.setNegativeButton("Hủy bỏ", (dialogInterface, i) -> {
        });

        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }

    private void back(){
        ImageView imgBach = findViewById(R.id.imgBack);
        imgBach.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(InformationActivity.this,BookActivity.class);
                finish();
            }
        });
    }
    public void goBook() {
        ImageView imgSach = findViewById(R.id.imgTrangChu);

        imgSach.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(InformationActivity.this, MainActivity.class);
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
                Intent intent = new Intent(InformationActivity.this,PhieuMuonActivity.class);
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
                Intent intent = new Intent(InformationActivity.this, CaidatActivity.class);
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
                Intent intent = new Intent(InformationActivity.this,BookActivity.class);
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
                Intent intent = new Intent(InformationActivity.this,ThongkeActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }

}
