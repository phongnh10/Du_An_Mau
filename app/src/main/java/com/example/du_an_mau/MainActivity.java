package com.example.du_an_mau;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.du_an_mau.adapter.SachMainAdapter;
import com.example.du_an_mau.dao.SachDAO;
import com.example.du_an_mau.model.Sach;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private SachDAO sachDAO;
    private SachMainAdapter sachMainAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        goBook();
        goPhieuMuon();
        goCaiDat();

        litsViewMain();
    }


    public void litsViewMain(){
        sachDAO = new SachDAO(this);

        RecyclerView recyclerView = findViewById(R.id.lvMuonNhieu);
        List<Sach> sachList = sachDAO.getTopSach();

        // Khởi tạo và thiết lập adapter
        sachMainAdapter = new SachMainAdapter(sachList, this);

        // Thiết lập layout manager cho RecyclerView
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL); // Chọn chiều ngang hoặc dọc
        recyclerView.setLayoutManager(layoutManager);

        // Gán adapter cho RecyclerView
        recyclerView.setAdapter(sachMainAdapter);
    }

    public void goBook(){
        ImageView imgSach = findViewById(R.id.imgSach);

        imgSach.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent( MainActivity.this, BookActivity.class);
                startActivity(intent);
                finish();            }
        });
    }
    public void goPhieuMuon(){
        ImageView imgPhieuMuon = findViewById(R.id.imgPhieuMuon);

        imgPhieuMuon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent( MainActivity.this, InformationActivity.class);
                startActivity(intent);
                finish();            }
        });
    }
    public void goCaiDat(){
        ImageView imgCaiDat = findViewById(R.id.imgCaiDat);

        imgCaiDat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent( MainActivity.this, BookActivity.class);
                startActivity(intent);
                finish();            }
        });
    }


}




