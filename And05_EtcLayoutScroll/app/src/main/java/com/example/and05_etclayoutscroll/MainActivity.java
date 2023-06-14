package com.example.and05_etclayoutscroll;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.HorizontalScrollView;
import android.widget.ScrollView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView tv_text = findViewById(R.id.tv_text); // 내가 레이아웃(actvity_main)에 만든 위젯을 찾아서 java코드 변수로 초기화
        //TextView.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR//<= Static Member : 클래스가 인스턴스화 하지 않아도 메모리에 이미 올라가 있는 자원
        //tv_text.append(); <= Instance Member : 클래스가 인스턴스화 해야지만 메모리에 로딩되는 멤버
        Button btn_scroll = findViewById(R.id.btn_scroll);
        ScrollView scrollView=findViewById(R.id.scrollView);
        HorizontalScrollView horizon_scroll=findViewById(R.id.horizon_Scroll);

        //static키워드가 있어서 초기화 과정없이 사용 가능. JepClass.ATTR
        //static키워드가 없어서 초기화를 시켜야만 사용 가능 .new JepClass().append("초기화해야 사용 가능")

        for (int i = 2; i <= 100; i++) {
            tv_text.append("\n");
            for (int j = 0; j < 7; j++) {
                tv_text.append("안녕하세요");//기존 문자열에 새로운 문자열을 붙임
            }
        }
        btn_scroll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("스크롤 위치", "onClick: getScrollY:"+scrollView.getScrollY());
                //scrollView.scrollTo(0,scrollView.getScrollY()+100);
                horizon_scroll.smoothScrollTo(horizon_scroll.getScrollX()+100,0);
            }
        });
    }
}