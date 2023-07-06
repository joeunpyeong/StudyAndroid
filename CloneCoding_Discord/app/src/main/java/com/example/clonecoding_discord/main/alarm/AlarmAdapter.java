package com.example.clonecoding_discord.main.alarm;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.clonecoding_discord.databinding.ItemAlarmRecvBinding;

import java.util.ArrayList;

public class AlarmAdapter extends RecyclerView.Adapter<AlarmAdapter.ViewHolder> {
    ItemAlarmRecvBinding binding;
    ArrayList<AlarmDTO> list;
    Context context;

    public AlarmAdapter(ArrayList<AlarmDTO> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext())  ;
        binding = ItemAlarmRecvBinding.inflate( inflater , parent , false );
        return new AlarmAdapter.ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder h, int i) {
        h.binding.tvAlarmMain.setText(list.get(i).getTv_alarm_main());
        h.binding.tvAlarmTime.setText(list.get(i).getTv_alarm_time());
        h.binding.imgvAlarm.setImageResource(list.get(i).getImgv_alarm());
        if (list.get(i).isTogleChecked() == false) {
            h.binding.imvCheck.setVisibility(View.GONE);
        }else{
            h.binding.imvCheck.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder{
        ItemAlarmRecvBinding binding;
        public ViewHolder(@NonNull ItemAlarmRecvBinding binding) {
            super(binding.getRoot());
            this.binding=binding;
        }
    }
}
