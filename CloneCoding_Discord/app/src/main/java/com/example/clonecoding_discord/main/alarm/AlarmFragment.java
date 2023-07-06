package com.example.clonecoding_discord.main.alarm;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.clonecoding_discord.R;
import com.example.clonecoding_discord.databinding.FragmentAlarmBinding;

import java.util.ArrayList;

public class AlarmFragment extends Fragment {

    FragmentAlarmBinding binding;
    ArrayList<AlarmDTO> list = new ArrayList<>();
    AlarmAdapter alarmAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding=FragmentAlarmBinding.inflate(inflater,container,false);
        alarmAdapter = new AlarmAdapter(getList(), getContext());
        binding.recvAlarm.setAdapter(alarmAdapter);
        binding.recvAlarm.setLayoutManager(new LinearLayoutManager(getContext()));




        return binding.getRoot();
    }

    public ArrayList<AlarmDTO> getList(){
        list.add(new AlarmDTO("아바타를 추가해 프로필을 업데이트하세요.","1일",R.drawable.img_profile2,false));
        return list;
    }

}