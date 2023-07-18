package com.example.clonecoding_discord.main;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.clonecoding_discord.R;
import com.example.clonecoding_discord.databinding.ActivityAllowSearchBinding;

public class AllowSearchActivity extends AppCompatActivity {
    ActivityAllowSearchBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityAllowSearchBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.btnNext.setOnClickListener(v -> {
            Intent intent = new Intent(this , MainActivity.class);
            startActivity(intent);
        });
    }
}