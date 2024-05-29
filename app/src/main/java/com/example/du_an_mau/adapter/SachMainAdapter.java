package com.example.du_an_mau.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.du_an_mau.R;
import com.example.du_an_mau.dao.SachDAO;
import com.example.du_an_mau.model.Sach;

import java.util.List;

public class SachMainAdapter extends RecyclerView.Adapter<SachMainAdapter.ViewHolder>{


    private List<Sach> sachList;
    private Context context;
    private SachDAO sachDAO;


    public SachMainAdapter(List<Sach> sachList, Context context, SachDAO sachDAO) {
        this.sachList = sachList;
        this.context = context;
        this.sachDAO = sachDAO;
    }

    @NonNull
    @Override
    public SachMainAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(parent.getContext());

        View view = inflater.inflate(R.layout.item_listview_main, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SachMainAdapter.ViewHolder holder, int position) {
        holder.txtTenSach.setText(sachList.get(position).getTenSach());
        holder.txtTacGia.setText(sachList.get(position).getTacGia());
    }

    @Override
    public int getItemCount() {
        return sachList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView txtTenSach, txtTacGia;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtTenSach = itemView.findViewById(R.id.txtTenSach);
            txtTacGia = itemView.findViewById(R.id.txtTacGia);
        }
    }
}
