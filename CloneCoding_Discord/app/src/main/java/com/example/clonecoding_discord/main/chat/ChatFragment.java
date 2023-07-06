package com.example.clonecoding_discord.main.chat;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.clonecoding_discord.main.MainActivity;
import com.example.clonecoding_discord.databinding.FragmentChatBinding;

public class ChatFragment extends Fragment {
    MainActivity nmk;
    FragmentChatBinding binding;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding=FragmentChatBinding.inflate(inflater,container,false);
        nmk=(MainActivity)getActivity();
        FragmentManager manager = nmk.getSupportFragmentManager();


        binding.btnGofriend.setOnClickListener(v -> {
            nmk.GoFriendFragment(manager);
        });
        binding.imbInviteSendMsg.setOnClickListener(v -> {

        });

        return binding.getRoot();
    }
}