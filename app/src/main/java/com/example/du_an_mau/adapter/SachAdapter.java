package com.example.du_an_mau.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

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

        holder.txtIdSach.setText("Id Sách: " + String.valueOf(sachList.get(position).getIdSach()));
        holder.txtTenSach.setText(sachList.get(position).getTenSach());
        holder.txtTheLoai.setText("Thể Loại: "+sachList.get(position).getTheLoai());
        holder.txtSoluong.setText("Số Lượng: "+String.valueOf(sachList.get(position).getSoLuong()));
        holder.txtTacGia.setText("Tác Giả: "+sachList.get(position).getTacGia());
    }

    @Override
    public int getItemCount() {
        return sachList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView txtIdSach, txtTenSach, txtTheLoai, txtSoluong, txtTacGia;

        public ViewHolder(View view) {
            super(view);
            txtIdSach = view.findViewById(R.id.txtIdSach);
            txtTenSach = view.findViewById(R.id.txtTenSach);
            txtTheLoai = view.findViewById(R.id.txtTheLoai);
            txtSoluong = view.findViewById(R.id.txtSoluong);
            txtTacGia = view.findViewById(R.id.txtTacGia);
        }
    }
}
