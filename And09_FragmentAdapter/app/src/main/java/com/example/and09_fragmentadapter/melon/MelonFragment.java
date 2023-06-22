package com.example.and09_fragmentadapter.melon;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.and09_fragmentadapter.R;

import java.util.ArrayList;

public class MelonFragment extends Fragment {

    RecyclerView recv_melon ;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v  = inflater.inflate(R.layout.fragment_melon, container, false);
        recv_melon = v.findViewById(R.id.recv_melon);
        recv_melon.setLayoutManager(new LinearLayoutManager(getContext()));
        recv_melon.setAdapter(new AdapterMelon(inflater , getList()));

        return v;
    }

    ArrayList<MelonDTO> getList(){
        ArrayList<MelonDTO> list = new ArrayList<>();
        list.add(new MelonDTO(R.drawable.chart_img1 , 1 , "퀸카 ( Queencard )" , "(여자)아이들"));
        list.add(new MelonDTO(R.drawable.chart_img2 , 2 , "I AM" , "IVE (아이브)"));
        list.add(new MelonDTO(R.drawable.chart_img3 , 3 , "Spicy" , "aespa"));
        list.add(new MelonDTO(R.drawable.chart_img4 , 4 , "이브, 어쩌고저쩌고" , "르세라핌"));
        list.add(new MelonDTO(R.drawable.chart_img1 , 1 , "퀸카 ( Queencard )" , "(여자)아이들"));
        list.add(new MelonDTO(R.drawable.chart_img2 , 2 , "I AM" , "IVE (아이브)"));
        list.add(new MelonDTO(R.drawable.chart_img3 , 3 , "Spicy" , "aespa"));
        list.add(new MelonDTO(R.drawable.chart_img4 , 4 , "이브, 어쩌고저쩌고" , "르세라핌"));   list.add(new MelonDTO(R.drawable.chart_img1 , 1 , "퀸카 ( Queencard )" , "(여자)아이들"));
        list.add(new MelonDTO(R.drawable.chart_img2 , 2 , "I AM" , "IVE (아이브)"));
        list.add(new MelonDTO(R.drawable.chart_img3 , 3 , "Spicy" , "aespa"));
        list.add(new MelonDTO(R.drawable.chart_img4 , 4 , "이브, 어쩌고저쩌고" , "르세라핌"));

        return list;
    }
}