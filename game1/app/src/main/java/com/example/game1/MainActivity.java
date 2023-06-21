package com.example.game1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button btn_start,btn_option,btn_login;
    static boolean loginCheck=false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_start=findViewById(R.id.btn_start);
        btn_option=findViewById(R.id.btn_option);
        btn_login=findViewById(R.id.btn_login);

        btn_start.setOnClickListener(v -> {
            if (loginCheck == false) {
                Toast.makeText(this, "로그인을 먼저 해주세요.", Toast.LENGTH_SHORT).show();
            }else {
                Intent intent = new Intent();
            }
        });

        btn_option.setOnClickListener(v -> {
            if (loginCheck == false) {
                Toast.makeText(this, "로그인을 먼저 해주세요.", Toast.LENGTH_SHORT).show();
            }else {
                int a = 0;
            }
        });

        btn_login.setOnClickListener(v -> {

        });


    }
//    @Override
//    public void onClick(View v){
//        if (v.getId() == R.id.btn_start) {
//            if (loginCheck == false) {
//
//            }
//        } else if (v.getId() == R.id.btn_option) {
//            if (loginCheck == false) {
//                if (loginCheck == false) {
//                    Toast.makeText(this, "로그인을 먼저 해주세요.", Toast.LENGTH_SHORT).show();
//                }else {
//                    int a = 0;
//                }
//            }
//
//        } else if (v.getId() == R.id.btn_login) {
//
//        }
//    }

//    public void loginChecking(){
//        if (loginCheck == false) {
//            Toast.makeText(this, "로그인을 먼저 해주세요.", Toast.LENGTH_SHORT).show();
//        }else {
//            int a = 0;
//        }
//    }

}