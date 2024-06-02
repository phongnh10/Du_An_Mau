package com.example.du_an_mau;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.du_an_mau.adapter.SachAdapter;
import com.example.du_an_mau.dao.SachDAO;
import com.example.du_an_mau.model.Sach;

import java.util.List;

public class BookActivity extends AppCompatActivity {

    private SachDAO sachDAO;
    private SachAdapter sachAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_book);

        goHome();
        goCaiDat();
        goPhieuMuon();

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        litsViewSach();
    }
    public void litsViewSach(){
        sachDAO = new SachDAO(this);

        RecyclerView recyclerView = findViewById(R.id.rcvSach);
        List<Sach> sachList = sachDAO.getSach();

        // Khởi tạo và thiết lập adapter
        sachAdapter = new SachAdapter(sachList, this);

        // Thiết lập layout manager cho RecyclerView
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL); // Chọn chiều ngang hoặc dọc
        recyclerView.setLayoutManager(layoutManager);

        // Gán adapter cho RecyclerView
        recyclerView.setAdapter(sachAdapter);
    }


    public void goHome(){
        ImageView imgHome = findViewById(R.id.imgTrangChu);

        imgHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent( BookActivity.this, MainActivity.class);
                startActivity(intent);
                finish();            }
        });
    }
    public void goPhieuMuon(){
        ImageView imgPhieuMuon = findViewById(R.id.imgPhieuMuon);

        imgPhieuMuon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent( BookActivity.this, InformationActivity.class);
                startActivity(intent);
                finish();            }
        });
    }
    public void goCaiDat(){
        ImageView imgCaiDat = findViewById(R.id.imgCaiDat);

        imgCaiDat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent( BookActivity.this, BookActivity.class);
                startActivity(intent);
                finish();            }
        });
    }


}