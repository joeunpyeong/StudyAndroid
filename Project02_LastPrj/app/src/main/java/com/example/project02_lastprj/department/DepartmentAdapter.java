package com.example.project02_lastprj.department;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.project02_lastprj.databinding.ItemRecvDepartmentBinding;

import java.util.ArrayList;

public class DepartmentAdapter extends RecyclerView.Adapter<DepartmentAdapter.ViewHolder> {
    ArrayList<DepartmentVO> list;
    public DepartmentAdapter(ArrayList<DepartmentVO> list){
        this.list=list;
    }
    Context context;
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        ItemRecvDepartmentBinding binding = ItemRecvDepartmentBinding.inflate(LayoutInflater.from(parent.getContext()) , parent,false );
        return new DepartmentAdapter.ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder h, int i) {
        h.binding.tvName.setText(list.get(i).getEmp_name());
        h.binding.tvEmail.setText(list.get(i).getEmail());
        h.binding.tvJob.setText(list.get(i).getJob_title());
        h.binding.tvNum.setText(String.valueOf(list.get(i).getEmployee_id()));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ItemRecvDepartmentBinding binding;
        public ViewHolder(@NonNull ItemRecvDepartmentBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
