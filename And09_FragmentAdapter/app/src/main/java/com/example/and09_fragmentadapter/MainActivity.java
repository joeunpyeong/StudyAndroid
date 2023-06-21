package com.example.and09_fragmentadapter;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;

public class MainActivity extends AppCompatActivity {
    //FrameLayout과 Button두개 초기화 시키기.
    FrameLayout container_fl;
    Button btn_menu1,btn_menu2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Fragment를 붙이기 위한 공간, Fragment , FragmentManager 3가지의 요소가 필요하다.

        container_fl = findViewById(R.id.container_fl);
        btn_menu1 = findViewById(R.id.btn_menu1);
        btn_menu2 = findViewById(R.id.btn_menu2);
        //container = findViewById(R.id.container); <= FragmentManager에서는 객체로 초기화된 위젯이 필요 x, 디자인 파일에 있는 id만 명시해주면 O

        FragmentManager manager = getSupportFragmentManager(); //프래그먼트 매니저의 초기화식

        btn_menu1.setOnClickListener(v -> {
                Log.d("버튼", "onClick: 메뉴1");
                //트랜잭션 : Oracle 작업 최소 단위  <=>  세트: Commit & Rollback
                manager.beginTransaction().add(R.id.container_fl,new HomeFragment(),"A").commit();

        });
        btn_menu2.setOnClickListener(v -> {
            Log.d("버튼", "onClick: 메뉴2");

        });


    }

}