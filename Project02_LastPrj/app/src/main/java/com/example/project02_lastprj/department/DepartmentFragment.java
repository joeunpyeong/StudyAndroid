package com.example.project02_lastprj.department;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.project02_lastprj.common.CommonConn;
import com.example.project02_lastprj.customer.CustomerAdapter;
import com.example.project02_lastprj.customer.CustomerVO;
import com.example.project02_lastprj.databinding.FragmentDepartmentBinding;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;

public class DepartmentFragment extends Fragment {
    FragmentDepartmentBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentDepartmentBinding.inflate(inflater, container, false);

        CommonConn conn = new CommonConn(getContext() , "select.cu");
        conn.onExcute((isResult, data) -> {
            ArrayList<DepartmentVO> list = new Gson().fromJson(data , new TypeToken<ArrayList<DepartmentVO>>(){}.getType());
            //if문으로 list의 사이즈처리 , 해야함.
            DepartmentAdapter adapter = new DepartmentAdapter(list);
            binding.recvDepartment.setAdapter(adapter);
            binding.recvDepartment.setLayoutManager(new LinearLayoutManager(getContext()));
        });

        return binding.getRoot();
    }

}