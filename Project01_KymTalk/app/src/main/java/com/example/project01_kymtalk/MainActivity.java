package com.example.project01_kymtalk;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.example.project01_kymtalk.chat.ChatFragment;
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

        binding.bottomNavigation.setOnItemSelectedListener(item -> {
            Fragment fragment=null;
            if(item.getItemId() ==R.id.tab1){
                fragment = new FriendFragment();
                actionBar.setTitle("친구");
                //manager.beginTransaction().replace(R.id.container,   new FriendFragment()).commit();
            }else if(item.getItemId() ==R.id.tab2){
                actionBar.setTitle("채팅");
                fragment = new ChatFragment();
               // manager.beginTransaction().replace(R.id.container, new ChatFragment()).commit();
                //package chat 추가 후 ChatFragment 추가,ChatFragment에 리사이클러뷰를 이용하여 카카오톡의 채팅목록을 구현하기.

            }else if(item.getItemId() ==R.id.tab3){
                actionBar.setTitle("오픈채팅");

            }else if(item.getItemId() ==R.id.tab4){
                actionBar.setTitle("쇼핑");

            }else if(item.getItemId() ==R.id.tab5){
                actionBar.setTitle("더보기");

            }else{
                return false;//메뉴가 바뀌는 처리를 취소한다.(들어올 가능성 없음)
            }


            if(fragment ==null) {
                Toast.makeText(this,"아직 메뉴가 준비가 안되었습니다.",Toast.LENGTH_SHORT).show();
            }else {
                manager.beginTransaction().replace(R.id.container, fragment).commit();
            }
            return true;
        });


    }
}