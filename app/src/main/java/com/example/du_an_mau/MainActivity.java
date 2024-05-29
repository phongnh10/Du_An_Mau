package com.example.du_an_mau;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;

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

        litsViewMain();
    }


    public void litsViewMain(){
        sachDAO = new SachDAO(this);

        RecyclerView recyclerView = findViewById(R.id.lvMuonNhieu);
        List<Sach> sachList = sachDAO.getAllSach();

        // Khởi tạo và thiết lập adapter
        sachMainAdapter = new SachMainAdapter(sachList, this);

        // Thiết lập layout manager cho RecyclerView
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL); // Chọn chiều ngang hoặc dọc
        recyclerView.setLayoutManager(layoutManager);

        // Gán adapter cho RecyclerView
        recyclerView.setAdapter(sachMainAdapter);
    }


}




