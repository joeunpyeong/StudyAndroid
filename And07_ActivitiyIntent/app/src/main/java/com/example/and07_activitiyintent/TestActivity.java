package com.example.and07_activitiyintent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;

public class TestActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        Intent intent= getIntent();
        String str=intent.getStringExtra("str");
        String num=intent.getStringExtra("num");
        ArrDTO dto= (ArrDTO) intent.getSerializableExtra("dto");
        ArrayList<ArrDTO> arrDTOS= (ArrayList<ArrDTO>) intent.getSerializableExtra("arrDTOS");

        Log.d("응애", "onCreate: "+str);
        Log.d("응애", "onCreate: "+num);
        Log.d("응애", "onCreate: "+dto);
        Log.d("응애", "onCreate: "+arrDTOS);
    }
}