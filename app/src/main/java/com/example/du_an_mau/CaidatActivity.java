package com.example.du_an_mau;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import org.w3c.dom.Text;

public class CaidatActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_caidat);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        ImageView imgBack = findViewById(R.id.imgBack);

        imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CaidatActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

        TextView txtDangXuat = findViewById(R.id.txtDangXuat);
        txtDangXuat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CaidatActivity.this, LoginActivity.class);
                startActivity(intent);
                finish();
            }
        });

        goBook();
        goPhieuMuon();
        goCaiDat();
        goTrangChu();
        back();
        goChangePass();

    }

    public void goBook(){
        ImageView imgSach = findViewById(R.id.imgSach);

        imgSach.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent( CaidatActivity.this, BookActivity.class);
                startActivity(intent);
                finish();            }
        });
    }
    public void goPhieuMuon(){
        ImageView imgPhieuMuon = findViewById(R.id.imgPhieuMuon);

        imgPhieuMuon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent( CaidatActivity.this, PhieuMuonActivity.class);
                startActivity(intent);
                finish();            }
        });
    }
    public void goCaiDat(){
        ImageView imgCaiDat = findViewById(R.id.imgNguoiDung);

        imgCaiDat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent( CaidatActivity.this,  ThongkeActivity.class);
                startActivity(intent);
                finish();            }
        });
    }
    public void goTrangChu(){
        ImageView imgCaiDat = findViewById(R.id.imgTrangChu);

        imgCaiDat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent( CaidatActivity.this,   MainActivity.class);
                startActivity(intent);
                finish();            }
        });
    }
    public void back(){
        ImageView imgCaiDat = findViewById(R.id.imgBack);

        imgCaiDat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent( CaidatActivity.this,   MainActivity.class);
                startActivity(intent);
                finish();            }
        });
    }

    public void goChangePass(){
        TextView txtChangePass = findViewById(R.id.txtChangePass);

        txtChangePass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CaidatActivity.this, ChangePasswordActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}