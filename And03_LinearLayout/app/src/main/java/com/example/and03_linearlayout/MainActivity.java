package com.example.and03_linearlayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.util.LogWriter;

import android.os.Bundle;
import android.util.Log;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.linear4);//디자인 파일 리소스와 java코드 연결부
        LinearLayout line1 = findViewById(R.id.line1);
        Log.i("조은평", "로그 info");
        Log.w("조은평", "경고", null);
        if(line1 !=null){
            //System.out.println();  Android에서는 syso를 사용 x
            //log. <- 사용. 단축키 : logd
            Log.d("조은평", "Linear가 null이 아님");
        }else{
            //Log.d("조은평", "Linear가 null임");
            Log.e("조은평", "Linear가 null임 오류로 로그찍기", null);
        }
        
        
        
    }
}