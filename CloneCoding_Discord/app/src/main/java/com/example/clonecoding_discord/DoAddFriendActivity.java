package com.example.clonecoding_discord;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.clonecoding_discord.databinding.ActivityDoAddFriendBinding;
import com.example.clonecoding_discord.databinding.ActivityWellcomBinding;

public class DoAddFriendActivity extends AppCompatActivity {
    ActivityDoAddFriendBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding= ActivityDoAddFriendBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        DuplicateCode.BackButton(binding.btnBack,this);


    }
}