package com.example.clonecoding_discord;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.widget.Toast;

import com.example.clonecoding_discord.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    // MainActivity 바인딩 (뷰결합) 처리하기.

    ActivityMainBinding binding;
    ActionBar actionBar ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        FragmentManager manager = getSupportFragmentManager();
        manager.beginTransaction().replace(R.id.container , new MainFragment()).commit();

        binding.bottomNavigation.setOnItemSelectedListener(item -> {
            Fragment fragment=null;
            if(item.getItemId() ==R.id.tab1){
                fragment = new MainFragment();
                //manager.beginTransaction().replace(R.id.container,   new FriendFragment()).commit();
            }else if(item.getItemId() ==R.id.tab2){
                fragment = new FriendFragment();
            }else if(item.getItemId() ==R.id.tab3){
                //어디로 가고싶은가요? 라는게 나오는거임
            }else if(item.getItemId() ==R.id.tab4){
                fragment = new AlarmFragment();
            }else if(item.getItemId() ==R.id.tab5){
                fragment = new SettingFragment();
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