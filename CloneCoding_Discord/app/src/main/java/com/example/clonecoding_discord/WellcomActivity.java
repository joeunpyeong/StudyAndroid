package com.example.clonecoding_discord;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class WellcomActivity extends AppCompatActivity {

    Button btn_join,btn_login;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wellcom);

        btn_join=findViewById(R.id.btn_join);
        btn_login=findViewById(R.id.btn_login);

        btn_join.setOnClickListener(v -> {
            Intent intent =new Intent(this,LoginActivity.class);
            startActivity(intent);
        });
        btn_login.setOnClickListener(v -> {
            Intent intent =new Intent(this,JoinIdActivity.class);
            startActivity(intent);
        });
    }
}