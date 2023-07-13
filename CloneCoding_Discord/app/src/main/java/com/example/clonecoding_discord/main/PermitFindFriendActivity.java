package com.example.clonecoding_discord.main;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.clonecoding_discord.cmmon.DuplicateCode;
import com.example.clonecoding_discord.databinding.ActivityPermitFindFriendBinding;

public class PermitFindFriendActivity extends AppCompatActivity {
    ActivityPermitFindFriendBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityPermitFindFriendBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        DuplicateCode.BackButton(binding.btnBack,this);
    }
}