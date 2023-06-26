package com.example.clonecoding_discord;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.clonecoding_discord.databinding.ActivityWellcomBinding;

public class WellcomActivity extends AppCompatActivity {

    ActivityWellcomBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding=ActivityWellcomBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.btnJoin.setOnClickListener(v -> {
            Intent intent =new Intent(this, MainActivity.class);
            startActivity(intent);
        });

        binding.btnLogin.setOnClickListener(v -> {
            Intent intent =new Intent(this,JoinIdActivity.class);
            startActivity(intent);
        });
    }
}