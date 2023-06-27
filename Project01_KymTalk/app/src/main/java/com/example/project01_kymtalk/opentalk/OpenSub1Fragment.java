package com.example.project01_kymtalk.opentalk;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.project01_kymtalk.R;
import com.example.project01_kymtalk.databinding.FragmentOpenSub1Binding;


public class OpenSub1Fragment extends Fragment {

    FragmentOpenSub1Binding binding;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentOpenSub1Binding.inflate(inflater,container,false);

        //LayoutManager manager = new LinearLayoutManager(getContext() , LinearLayoutManager.HORIZONTAL , false); //RecyclerView 가로로 넘기기
        binding.rcv1.setLayoutManager(new LinearLayoutManager(getContext() , LinearLayoutManager.HORIZONTAL , false));

        return binding.getRoot();
    }
}