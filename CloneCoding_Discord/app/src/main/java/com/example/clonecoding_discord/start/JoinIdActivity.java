package com.example.clonecoding_discord.start;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.clonecoding_discord.cmmon.DuplicateCode;
import com.example.clonecoding_discord.databinding.ActivityJoinIdBinding;

public class JoinIdActivity extends AppCompatActivity {

    ActivityJoinIdBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityJoinIdBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        DuplicateCode.BackButton(binding.btnBack,this);
    }
}