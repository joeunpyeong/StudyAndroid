package com.example.clonecoding_discord.start;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;

import com.example.clonecoding_discord.cmmon.CommonConn;
import com.example.clonecoding_discord.cmmon.CommonVar;
import com.example.clonecoding_discord.cmmon.DuplicateCode;
import com.example.clonecoding_discord.databinding.ActivityLoginBinding;
import com.example.clonecoding_discord.main.MainActivity;
import com.example.clonecoding_discord.vo.UserVO;
import com.google.gson.Gson;

public class LoginActivity extends AppCompatActivity {
    boolean showPwTogle =false;
    ActivityLoginBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding=ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        binding.imbToggleShow.setOnClickListener(v -> {
            if (showPwTogle ==false) {
                binding.edtPw.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD | InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);
                showPwTogle = true;
            }else{
                binding.edtPw.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
                showPwTogle =false;
            }
        });

        GradientDrawable gdbFals = new GradientDrawable();
        float[] cornerRadii = {10, 10, 10, 10, 10, 10, 10, 10}; // 각 꼭지점의 반지름 값
        gdbFals.setCornerRadii(cornerRadii);
        gdbFals.setStroke(2, Color.RED);  // 테두리의 두께와 색상을 설정합니다. 여기서는 두께 2dp, 빨간색입니다.


        binding.btnLogin.setOnClickListener(v -> {
            if(binding.edtId.getText().toString().length() < 1
                    || binding.edtPw.getText().toString().length() < 1
            ){
                binding.tvIdError.setText("필수 입력 칸이에요");
                binding.tvIdError.setVisibility(View.VISIBLE);
                binding.layoutId.setBackground(gdbFals);
                return;
            }
            CommonConn conn = new CommonConn(this , "user/login");
            conn.addParamMap("user_id", binding.edtId.getText().toString());
            conn.addParamMap("user_pw", binding.edtPw.getText().toString());


            conn.onExcute((isResult, data) -> {
                if(isResult){
                    CommonVar.loginInfo = new Gson().fromJson(data , UserVO.class);
                    if(CommonVar.loginInfo==null){
                        binding.tvIdError.setText("유효하지 않은 아이디 또는 비밀번호입니다.");
                        binding.tvIdError.setVisibility(View.VISIBLE);
                        binding.tvPwError.setText("유효하지 않은 아이디 또는 비밀번호입니다.");
                        binding.tvPwError.setVisibility(View.VISIBLE);
                        binding.layoutId.setBackground(gdbFals);
                        binding.layoutPw.setBackground(gdbFals);
                    }else{
                        //CommonVar.loginInfo = vo;
                        Intent intent = new Intent(this , MainActivity.class);
                        startActivity(intent);
                    }
                }
            });


        });
        binding.btnBack.setOnClickListener(v -> {
            Intent intent = new Intent(this , WellcomActivity.class);
            startActivity(intent);
        });
        DuplicateCode.IdBtnVisible(binding.edtId,binding.imbDeleteId);
        DuplicateCode.EdtClear(binding.imbDeleteId,binding.edtId);

    }


}
