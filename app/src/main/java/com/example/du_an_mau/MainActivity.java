package com.example.du_an_mau;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.du_an_mau.adapter.SachMainAdapter;
import com.example.du_an_mau.dao.PhieuMuonDAO;
import com.example.du_an_mau.dao.SachDAO;
import com.example.du_an_mau.model.Sach;

import org.w3c.dom.Text;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private SachDAO sachDAO;
    private SachMainAdapter sachMainAdapter;
    private PhieuMuonDAO phieuMuonDAO;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        goBook();
        goPhieuMuon();
        goCaiDat();
        hienThi();
        goThongKe();
    }

    @Override
    protected void onResume() {
        super.onResume();
        litsViewMain();
        hienThi();
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
                Intent intent = new Intent( MainActivity.this, PhieuMuonActivity.class);
                startActivity(intent);
                finish();            }
        });
    }
    public void goCaiDat(){
        ImageView imgCaiDat = findViewById(R.id.imgCaiDat);

        imgCaiDat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent( MainActivity.this, CaidatActivity.class);
                startActivity(intent);
                finish();            }
        });
    }

    public void goThongKe(){
        ImageView imgCaiDat = findViewById(R.id.imgNguoiDung);

        imgCaiDat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent( MainActivity.this, ThongkeActivity.class);
                startActivity(intent);
                finish();            }
        });
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

}




