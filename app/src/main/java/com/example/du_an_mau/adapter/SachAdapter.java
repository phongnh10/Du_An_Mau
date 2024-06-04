package com.example.du_an_mau.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.du_an_mau.InformationActivity;
import com.example.du_an_mau.R;
import com.example.du_an_mau.model.Sach;

import java.util.List;

public class SachAdapter extends RecyclerView.Adapter<SachAdapter.ViewHolder> {

    private List<Sach> sachList;
    private Context context;

    public SachAdapter(List<Sach> sachList, Context context) {
        this.sachList = sachList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.item_listview_sach, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Sach sach = sachList.get(position);
        holder.txtIdSach.setText("Id Sách: " + sach.getIdSach());
        holder.txtTenSach.setText(sach.getTenSach());
        holder.txtTheLoai.setText("Thể Loại: " + sach.getTheLoai());
        holder.txtSoluong.setText("Số Lượng: " + sach.getSoLuong());
        holder.txtTacGia.setText("Tác Giả: " + sach.getTacGia());



        holder.llItem.setOnClickListener(view -> {
            Intent intent = new Intent(context, InformationActivity.class);
            intent.putExtra("SACH_ID", sach.getIdSach());
            intent.putExtra("TEN_SACH", sach.getTenSach());
            intent.putExtra("THE_LOAI", sach.getTheLoai());
            intent.putExtra("SO_LUONG", sach.getSoLuong());
            intent.putExtra("TAC_GIA", sach.getTacGia());
            intent.putExtra("NHA_XUAT_BAN", sach.getNhaXuatBan());
            intent.putExtra("NAM_XUAT_BAN", sach.getNamXuatBan());
            context.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return sachList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        TextView txtIdSach, txtTenSach, txtTheLoai, txtSoluong, txtTacGia;
        LinearLayout llItem;

        public ViewHolder(View view) {
            super(view);
            txtIdSach = view.findViewById(R.id.txtIdSach);
            txtTenSach = view.findViewById(R.id.txtTenSach);
            txtTheLoai = view.findViewById(R.id.txtTheLoai);
            txtSoluong = view.findViewById(R.id.txtSoluong);
            txtTacGia = view.findViewById(R.id.txtTacGia);
            llItem = view.findViewById(R.id.llItem);
        }
    }
}
