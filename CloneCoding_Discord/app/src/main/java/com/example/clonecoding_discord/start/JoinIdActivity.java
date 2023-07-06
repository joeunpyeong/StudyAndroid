package com.example.clonecoding_discord.start;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.clonecoding_discord.DuplicateCode;
import com.example.clonecoding_discord.databinding.ActivityJoinIdBinding;
import com.example.clonecoding_discord.databinding.ActivityLoginBinding;

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