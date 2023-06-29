package com.example.clonecoding_discord.chat;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.clonecoding_discord.MainActivity;
import com.example.clonecoding_discord.R;
import com.example.clonecoding_discord.databinding.FragmentChatBinding;
import com.example.clonecoding_discord.friend.FriendFragment;
import com.example.clonecoding_discord.setting.SettingFragment;

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