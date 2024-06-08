package com.example.du_an_mau.adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.example.du_an_mau.ChitietphieumuonActivity;
import com.example.du_an_mau.R;
import com.example.du_an_mau.model.PhieuMuon;


import java.util.List;

public class PhieuMuonAdapter extends RecyclerView.Adapter<PhieuMuonAdapter.ViewHolder> {
    private List<PhieuMuon> phieuMuonList;
    private Context context;

    public PhieuMuonAdapter(List<PhieuMuon> phieuMuonList, Context context) {
        this.phieuMuonList = phieuMuonList;
        this.context = context;
    }

    @NonNull
    @Override
    public PhieuMuonAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.item_listview_phieumuon, parent, false);
        return new PhieuMuonAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PhieuMuonAdapter.ViewHolder holder, int position) {
        PhieuMuon phieuMuon = phieuMuonList.get(position);
        holder.txtIdPhieuMuon.setText("Phiếu Số: " + phieuMuon.getIdPhieuMuon());
        holder.txtTenNguoiMuon.setText("Người Mượn: " + phieuMuon.getNguoiMuon());
        holder.txtNgayMuon.setText("Ngày Mượn: " + phieuMuon.getNgayMuon());
        holder.txtNgayTra.setText("Ngày Trả: " + phieuMuon.getNgayTra());
        holder.txtTrangThai.setText(phieuMuon.getTrangThai());


        // Thay đổi màu nền của txtTrangThai dựa trên trạng thái hoặc bất kỳ điều kiện nào

        if (phieuMuon.getTrangThai().equals("Chưa Trả") || phieuMuon.getTrangThai().equals("chưa trả") || phieuMuon.getTrangThai().equals("chưa") || phieuMuon.getTrangThai().equals("Chưa") || phieuMuon.getTrangThai().equals("chua")) {
            holder.txtTrangThai.setBackgroundDrawable(ContextCompat.getDrawable(context, R.drawable.bogocred));
        } else if (phieuMuon.getTrangThai().equals("Đã Trả") || phieuMuon.getTrangThai().equals("đã trả") || phieuMuon.getTrangThai().equals("Trả") || phieuMuon.getTrangThai().equals("trả") || phieuMuon.getTrangThai().equals("tra")) {
            holder.txtTrangThai.setBackgroundDrawable(ContextCompat.getDrawable(context, R.drawable.bogocgreen));

        } else {
            holder.txtTrangThai.setBackgroundColor(ContextCompat.getColor(context, R.color.background_color_3));
        }

        holder.llItem.setOnClickListener(view -> {
            Intent intent = new Intent(context, ChitietphieumuonActivity.class);
            intent.putExtra("idPhieuMuon", phieuMuon.getIdPhieuMuon());
            intent.putExtra("sodienthoai", phieuMuon.getSoDienThoai());
            intent.putExtra("nguoiMuon", phieuMuon.getNguoiMuon());
            intent.putExtra("ngayMuon", phieuMuon.getNgayMuon());
            intent.putExtra("ngayTra", phieuMuon.getNgayTra());
            intent.putExtra("trangThai", phieuMuon.getTrangThai());
            intent.putExtra("sachMuon", phieuMuon.getSachMuon());
            intent.putExtra("ghiChu", phieuMuon.getGhiChu());
            context.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return phieuMuonList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView txtIdPhieuMuon, txtTenNguoiMuon, txtNgayMuon, txtNgayTra, txtTrangThai;
        LinearLayout llItem;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtIdPhieuMuon = itemView.findViewById(R.id.txtIdPhieuMuon);
            txtTenNguoiMuon = itemView.findViewById(R.id.txtTenNguoiMuon);
            txtNgayMuon = itemView.findViewById(R.id.txtNgayMuon);
            txtNgayTra = itemView.findViewById(R.id.txtNgayTra);
            txtTrangThai = itemView.findViewById(R.id.txtTrangThai);
            llItem = itemView.findViewById(R.id.llItem);
        }
    }
}
