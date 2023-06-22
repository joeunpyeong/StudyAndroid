package com.example.and09_fragmentadapter.practice;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.and09_fragmentadapter.R;
import com.example.and09_fragmentadapter.recycler.AdapterRecv;
import com.example.and09_fragmentadapter.recycler.RecvDTO;

import java.util.ArrayList;

public class PracticeFragment extends Fragment {
    RecyclerView recv;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_practice, container, false);
        recv = v.findViewById(R.id.recv);
        ArrayList<PracticeDTO> list = getList();

        return v;
    }
    int[] imgs={
            R.drawable.chart_img1,
            R.drawable.chart_img2,
            R.drawable.chart_img3,
            R.drawable.chart_img4,
            R.drawable.chart_img5,
            R.drawable.chart_img6,
            R.drawable.chart_img7
    };
    String[] name={
            "퀸카(Qyeencard)",
            "I AM",
            "Spicy",
            "이브, 프시케 긜고 푸른 수수깡",
            "UNFORGIVEN (feat.Nile Rodelf)",
            "Kitsch",
            "사랑은 늘 도망가",
            "모래 알갱이"
    };
    String[] singer={
            "(여자)아이들",
            "IVE(아이브)",
            "aespa",
            "LE SSERAFIM(르세라핌)",
            "LE SSERAFIM(르세라핌)",
            "IVE(아이브)",
            "임영웅",
            "임영웅"
    };


    ArrayList<PracticeDTO> getList(){
        ArrayList<PracticeDTO> list= new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(new PracticeDTO(imgs[i],i,name[i], singer[i]));
        }
        return list;
    }
}