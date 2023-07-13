package com.example.project02_lastprj;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.project02_lastprj.databinding.ActivityMainBinding;
import com.example.project02_lastprj.department.DepartmentAdapter;
import com.example.project02_lastprj.member.LoginActivity;

import me.ibrahimsn.lib.OnItemReselectedListener;
import me.ibrahimsn.lib.OnItemSelectedListener;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        getSupportFragmentManager().beginTransaction().replace(R.id.container , new com.example.project02_lastprj.customer.CustomerFragment()).commit();

        binding.bottomBar.setOnItemSelectedListener(new OnItemSelectedListener() {
            @Override
            public boolean onItemSelect(int i) {
                if (i == 0) {
                    //customer패키지 내부에 CustomerFragment를 만들고 i가 0일때 해당하는 Fragment가 Container에 붙게 처리하기.
                    getSupportFragmentManager().beginTransaction().replace(R.id.container , new com.example.project02_lastprj.customer.CustomerFragment()).commit();

                } else if ((i==1)) {
                    getSupportFragmentManager().beginTransaction().replace(R.id.container , new com.example.project02_lastprj.department.DepartmentFragment()).commit();
                }else if ((i==2)) {

                }else if ((i==3)) {

                }
                return true;
            };
        });
    }
}