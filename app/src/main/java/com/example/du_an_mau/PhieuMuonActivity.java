package com.example.du_an_mau;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.du_an_mau.adapter.PhieuMuonAdapter;
import com.example.du_an_mau.dao.PhieuMuonDAO;
import com.example.du_an_mau.model.PhieuMuon;

import java.util.List;

public class PhieuMuonActivity extends AppCompatActivity {
    private PhieuMuonDAO phieuMuonDAO;
    private PhieuMuonAdapter phieuMuonAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phieu_muon);

        goHome();
        goCaiDat();
        goSach();
        addPhieuMuon();
        back();
        goThongKe();
    }

    @Override
    protected void onResume() {
        super.onResume();
        listViewSach();
    }

    public void listViewSach() {
        phieuMuonDAO = new PhieuMuonDAO(this);

        RecyclerView recyclerView = findViewById(R.id.rcvPhieuMuon);
        List<PhieuMuon> phieuMuonList = phieuMuonDAO.getPhieuMuon();

        // Khởi tạo và thiết lập adapter
        phieuMuonAdapter = new PhieuMuonAdapter(phieuMuonList, this);

        // Thiết lập layout manager cho RecyclerView
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL); // Chọn chiều ngang hoặc dọc
        recyclerView.setLayoutManager(layoutManager);

        // Gán adapter cho RecyclerView
        recyclerView.setAdapter(phieuMuonAdapter);
    }
    public void goThongKe(){
        ImageView imgCaiDat = findViewById(R.id.imgNguoiDung);

        imgCaiDat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent( PhieuMuonActivity.this, ThongkeActivity.class);
                startActivity(intent);
                finish();            }
        });
    }
    public void goHome() {
        ImageView imgHome = findViewById(R.id.imgTrangChu);

        imgHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(PhieuMuonActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }

    public void goSach() {
        ImageView imgPhieuMuon = findViewById(R.id.imgSach);

        imgPhieuMuon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(PhieuMuonActivity.this, BookActivity.class);
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
                Intent intent = new Intent(PhieuMuonActivity.this, CaidatActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }

    public void addPhieuMuon() {
        Button btnAddPhieuMuon = findViewById(R.id.btnAddPhieuMuon);

        btnAddPhieuMuon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(PhieuMuonActivity.this, AddphieumuonActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }

    public void back() {
        ImageView imgBack = findViewById(R.id.imgBack);
        imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(PhieuMuonActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
