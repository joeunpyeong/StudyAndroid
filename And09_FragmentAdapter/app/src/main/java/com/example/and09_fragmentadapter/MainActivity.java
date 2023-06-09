package com.example.and09_fragmentadapter;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.example.and09_fragmentadapter.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    //FrameLayout과 Button두개 초기화 시키기.

    // Button을 각각 클릭시 로그에 메뉴1 , 메뉴2가 출력되게 코딩해보기.
//    FrameLayout container ;
//    Button btn_menu1 , btn_menu2 , btn_adapter;
    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        binding=ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());//getRoot ==>디자인 xml파일의 최상단 레이아웃

        // Fragment를 붙이기 위한 공간 , Fragment , FragmentManager 3가지의 요소가 필요하다.

//        btn_menu1 = findViewById(R.id.btn_menu1);
//        btn_menu2 = findViewById(R.id.btn_menu2);
//        btn_adapter = findViewById(R.id.btn_adapter);
       //container = findViewById(R.id.container); <= FragmentManager에서는 객체로 초기화된 위젯이 필요 x , 디자인파일에 있는 id만 명시해주면 O

        FragmentManager manager = getSupportFragmentManager();//프래그먼트 매니저의 초기화식.


        binding.btnMenu1.setOnClickListener(v->{
            Log.d("버튼", "메뉴1");
            //트랜잭션 : Oracle 작업 최소 단위     세트 : Commit & Rollback
            //manager.beginTransaction().add(R.id.container , new HomeFragment() , "A").commit();
            manager.beginTransaction().replace(R.id.container , new HomeFragment()).commit();
        });
        binding.btnMenu2.setOnClickListener(v->{
            Log.d("버튼", "메뉴2");
            // SubFragment를 하나 추가 후  ( 디자인 구분을 할수있게 배경색을 바꿔줌 )
            // FragmentManager를 이용해서 replace처리해보기.
            manager.beginTransaction().replace(R.id.container , new SubFragment()).commit();
            //manager.beginTransaction().remo
        });

        binding.btnAdapter.setOnClickListener(v->{
            Intent intent = new Intent(this , AdapterActivity.class);
            startActivity(intent);
        });


    }
}