package com.example.clonecoding_discord.main.setting;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.clonecoding_discord.R;
import com.example.clonecoding_discord.cmmon.CommonVar;
import com.example.clonecoding_discord.databinding.FragmentSettingBinding;
import com.example.clonecoding_discord.main.MainActivity;
import com.example.clonecoding_discord.start.LoginActivity;
import com.example.clonecoding_discord.start.WellcomActivity;

import java.util.Random;

public class SettingFragment extends Fragment {
    FragmentSettingBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentSettingBinding.inflate(inflater, container, false);

        if (CommonVar.loginInfo.getProfile_banner() == null) {
            binding.layoutProfilebanner.setBackgroundColor(Color.parseColor(convertBytesToHex()));
        } else {
            binding.layoutProfilebanner.setBackgroundColor(Color.parseColor(CommonVar.loginInfo.getProfile_banner()));
        }

        int profileResourceId;
        if (CommonVar.loginInfo.getProfile_img() == null) {
            profileResourceId = getResources().getIdentifier("img_profile"+new Random().nextInt(9), "drawable", requireContext().getPackageName());
        } else {
            profileResourceId = getResources().getIdentifier(CommonVar.loginInfo.getProfile_img(), "drawable", requireContext().getPackageName());
        }
        binding.profileImg.setBackgroundResource(profileResourceId);

        binding.userTag.setText(CommonVar.loginInfo.getUser_tag());
        binding.userNickName.setText(CommonVar.loginInfo.getNick_name());

        binding.btnLogout.setOnClickListener(v -> {
            Intent intent = new Intent(requireContext(), LoginActivity.class);
            startActivity(intent);
        });

        return binding.getRoot();
    }
//
    private static String convertBytesToHex() {
        byte[] bytes = new byte[3];
        new Random().nextBytes(bytes);
        StringBuilder result = new StringBuilder();
        for (byte temp : bytes) {
            result.append(String.format("%02x", temp));
        }
        return "#"+result.toString();
    }
}
