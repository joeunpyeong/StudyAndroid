package com.example.and09_fragmentadapter.melon;

import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.and09_fragmentadapter.R;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class AdapterMelon extends RecyclerView.Adapter<AdapterMelon.ViewHolder> {

    LayoutInflater inflater;
    ArrayList<MelonDTO> list ;

    public AdapterMelon(LayoutInflater inflater, ArrayList<MelonDTO> list) {
        this.inflater = inflater;
        this.list = list;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        return new ViewHolder(   inflater.inflate(R.layout.item_melon , parent , false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder h, int i) {
        h.imgv_chart.setImageResource(list.get(i).getImgChartRes());
        h.tv_title.setText(list.get(i).getTitle());
        h.tv_singer.setText(list.get(i).getSinger());
        h.tv_rank.setText(list.get(i).getRank()+"");
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imgv_chart;
        TextView tv_title, tv_singer, tv_rank;

        public ViewHolder(@NonNull View v) {
            super(v);
            imgv_chart = v.findViewById(R.id.imgv_chart);
            tv_title = v.findViewById(R.id.tv_title);
            tv_singer = v.findViewById(R.id.tv_singer);
            tv_rank = v.findViewById(R.id.tv_rank);
        }
    }
}
