package com.example.clonecoding_discord.start;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.clonecoding_discord.databinding.ActivityWellcomBinding;
import com.example.clonecoding_discord.main.MainActivity;
import com.example.clonecoding_discord.start.JoinIdActivity;

public class WellcomActivity extends AppCompatActivity {

    ActivityWellcomBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding=ActivityWellcomBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.btnJoin.setOnClickListener(v -> {
            Intent intent =new Intent(this, JoinIdActivity.class);
            startActivity(intent);
        });

        binding.btnLogin.setOnClickListener(v -> {
            Intent intent =new Intent(this, LoginActivity.class);
            startActivity(intent);
        });
    }
}