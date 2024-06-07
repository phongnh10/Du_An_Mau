package com.example.du_an_mau;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.du_an_mau.dao.PhieuMuonDAO;
public class ThongkeActivity extends AppCompatActivity {
    private PhieuMuonDAO phieuMuonDAO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_thongke);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        goTrangChu();
        goBook();
        goPhieuMuon();
        goCaiDat();
        back();
    }

    @Override
    protected void onResume() {
        super.onResume();
        hienThi();
    }

    public void hienThi(){
        phieuMuonDAO = new PhieuMuonDAO(this);
        int soLuotMuon = phieuMuonDAO.demLuotMuonSach();
        int soLuotTra = phieuMuonDAO.demLuotTraSach();

        // Khởi tạo TextView và thiết lập giá trị
        TextView txtLuotMuon = findViewById(R.id.txtLuotMuon);
        TextView txtLuotTra = findViewById(R.id.txtLuotTra);

        // Chuyển đổi số nguyên thành chuỗi và thiết lập vào TextView
        txtLuotMuon.setText(String.valueOf(soLuotMuon));
        txtLuotTra.setText(String.valueOf(soLuotTra));


    }
    public void goTrangChu(){
        ImageView imgPhieuMuon = findViewById(R.id.imgTrangChu);

        imgPhieuMuon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent( ThongkeActivity.this, MainActivity.class);
                startActivity(intent);
                finish();            }
        });
    }
    public void goBook(){
        ImageView imgSach = findViewById(R.id.imgSach);

        imgSach.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent( ThongkeActivity.this, BookActivity.class);
                startActivity(intent);
                finish();            }
        });
    }
    public void goPhieuMuon(){
        ImageView imgPhieuMuon = findViewById(R.id.imgPhieuMuon);

        imgPhieuMuon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent( ThongkeActivity.this, PhieuMuonActivity.class);
                startActivity(intent);
                finish();            }
        });
    }
    public void goCaiDat(){
        ImageView imgCaiDat = findViewById(R.id.imgCaiDat);

        imgCaiDat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent( ThongkeActivity.this, CaidatActivity.class);
                startActivity(intent);
                finish();            }
        });
    }
    public void back(){
        ImageView imgCaiDat = findViewById(R.id.imgBack);

        imgCaiDat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent( ThongkeActivity.this, MainActivity.class);
                startActivity(intent);
                finish();            }
        });
    }
}