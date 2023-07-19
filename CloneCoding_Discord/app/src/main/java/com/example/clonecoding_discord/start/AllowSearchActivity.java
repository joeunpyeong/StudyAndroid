package com.example.clonecoding_discord.start;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.clonecoding_discord.R;
import com.example.clonecoding_discord.cmmon.CommonConn;
import com.example.clonecoding_discord.cmmon.CommonVar;
import com.example.clonecoding_discord.databinding.ActivityAllowSearchBinding;
import com.example.clonecoding_discord.main.MainActivity;
import com.example.clonecoding_discord.vo.UserVO;
import com.google.gson.Gson;

public class AllowSearchActivity extends AppCompatActivity {
    ActivityAllowSearchBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityAllowSearchBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.btnNext.setOnClickListener(v -> {
            CommonConn ui_conn = new CommonConn(this, "user/insert");
            ui_conn.addParamMap("user_id", CommonVar.newUserInfo.getUser_id());
            ui_conn.addParamMap("user_pw", CommonVar.newUserInfo.getUser_pw());
            ui_conn.addParamMap("user_tag", CommonVar.newUserInfo.getUser_tag());
            ui_conn.addParamMap("nick_name", CommonVar.newUserInfo.getNick_name());
            ui_conn.addParamMap("profile_img", CommonVar.newUserInfo.getProfile_img());
            ui_conn.addParamMap("profile_banner", CommonVar.newUserInfo.getProfile_banner());
            ui_conn.onExcute(((isResult, data) -> {
                if (isResult) {
                    Log.d("newUserInfo1", "onCreate: " + CommonVar.newUserInfo.getUser_id());
                    Log.d("newUserInfo2", "onCreate: " + CommonVar.newUserInfo.getUser_pw());
                    Log.d("newUserInfo3", "onCreate: " + CommonVar.newUserInfo.getUser_tag());
                    Log.d("newUserInfo4", "onCreate: " + CommonVar.newUserInfo.getNick_name());
                    Log.d("newUserInfo5", "onCreate: " + CommonVar.newUserInfo.getProfile_img());
                    Log.d("newUserInfo6", "onCreate: " + CommonVar.newUserInfo.getProfile_banner());

                    CommonConn ul_conn = new CommonConn(this, "user/login");
                    ul_conn.addParamMap("user_id", CommonVar.newUserInfo.getUser_id());
                    ul_conn.addParamMap("user_pw", CommonVar.newUserInfo.getUser_pw());
                    ul_conn.onExcute(((isLoginResult, loginData) -> {
                            CommonVar.loginInfo = new Gson().fromJson(loginData, UserVO.class);
                    }));
                    Intent intent = new Intent(this, MainActivity.class);
                    startActivity(intent);
                }
            }));
        });
    }
}