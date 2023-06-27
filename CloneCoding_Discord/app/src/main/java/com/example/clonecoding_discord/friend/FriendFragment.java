package com.example.clonecoding_discord.friend;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.clonecoding_discord.R;
import com.example.clonecoding_discord.databinding.FragmentChatBinding;
import com.example.clonecoding_discord.databinding.FragmentFriendBinding;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class FriendFragment extends Fragment {

    FragmentFriendBinding binding;
    ArrayList<FriendDTO> list = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding= FragmentFriendBinding.inflate(inflater,container,false);

        binding.recvOnline.setAdapter(new FriendAdapter(getList(),getContext()));

        binding.imbSample.setOnClickListener(v1 -> {

            list.add(new FriendDTO("Hanul","한울","스테이터스 작성","프로필 작성",R.drawable.img_profile1));
            list.add(new FriendDTO("yeong","나 영균 아니다","롤 함 뜨자","프로필 칸 입니다.",R.drawable.img_profile2));
            list.add(new FriendDTO("Dog","땅강아지","왈왈","스테이터스 대충 밥 주라는 소리",R.drawable.img_profile3));
        });

        return binding.getRoot();
    }
    public ArrayList<FriendDTO> getList(){
        return list;
    }


}