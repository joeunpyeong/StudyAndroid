package com.example.project01_kymtalk;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;

import com.example.project01_kymtalk.databinding.ActivityMainBinding;
import com.example.project01_kymtalk.friend.FriendFragment;

public class MainActivity extends AppCompatActivity {
    // MainActivity 바인딩 (뷰결합) 처리하기.

    ActivityMainBinding binding;
    ActionBar actionBar ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        actionBar = getSupportActionBar();
        actionBar.setElevation(0f);
        actionBar.setTitle("친구");

        FragmentManager manager = getSupportFragmentManager();
        manager.beginTransaction().replace(R.id.container , new FriendFragment()).commit();


    }
}