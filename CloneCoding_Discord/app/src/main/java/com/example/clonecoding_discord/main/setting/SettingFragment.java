package com.example.clonecoding_discord.main.setting;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.clonecoding_discord.R;
import com.example.clonecoding_discord.cmmon.CommonVar;
import com.example.clonecoding_discord.databinding.FragmentSettingBinding;

import java.util.Random;

public class SettingFragment extends Fragment {
    FragmentSettingBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentSettingBinding.inflate(inflater, container, false);

        int bannerResourceId;
        if (CommonVar.loginInfo.getProfile_banner() == null) {
            String randomBannerName = convertBytesToHex();
            bannerResourceId = getResources().getIdentifier(randomBannerName, "drawable", requireContext().getPackageName());
        } else {
            bannerResourceId = getResources().getIdentifier(CommonVar.loginInfo.getProfile_banner(), "drawable", requireContext().getPackageName());
        }
        binding.layoutProfilebanner.setBackgroundResource(bannerResourceId);

        int profileResourceId;
        if (CommonVar.loginInfo.getProfile_img() == null) {
            String randomProfileName = convertBytesToHex();
            profileResourceId = getResources().getIdentifier(randomProfileName, "drawable", requireContext().getPackageName());
        } else {
            profileResourceId = getResources().getIdentifier(CommonVar.loginInfo.getProfile_img(), "drawable", requireContext().getPackageName());
        }
        binding.profileImg.setBackgroundResource(profileResourceId);

        int nicknameResourceId = getResources().getIdentifier(CommonVar.loginInfo.getNick_name(), "drawable", requireContext().getPackageName());
        binding.userNickName.setBackgroundResource(nicknameResourceId);

        int userTagResourceId = getResources().getIdentifier(CommonVar.loginInfo.getUser_tag(), "drawable", requireContext().getPackageName());
        binding.userTag.setBackgroundResource(userTagResourceId);

        return binding.getRoot();
    }

    private static String convertBytesToHex() {
        byte[] bytes = new byte[3];
        new Random().nextBytes(bytes);
        StringBuilder result = new StringBuilder();
        for (byte temp : bytes) {
            result.append(String.format("%02x", temp));
        }
        return result.toString();
    }
}
