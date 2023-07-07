package com.example.clonecoding_discord.start;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;

import com.example.clonecoding_discord.CommonConn;
import com.example.clonecoding_discord.DuplicateCode;
import com.example.clonecoding_discord.databinding.ActivityLoginBinding;
import com.example.clonecoding_discord.start.JoinIdActivity;

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


        binding.btnLogin.setOnClickListener(v -> {
            CommonConn conn = new CommonConn(this , "user/login.cu");
            conn.addParamMap("user_id", binding.edtId.getText().toString());
            conn.addParamMap("user_pw", binding.edtPw.getText().toString());
            conn.onExcute(new CommonConn.JepCallBack() {
                @Override
                public void onResult(boolean isResult, String data) {

                }
            });
        });

        DuplicateCode.IdBtnVisible(binding.edtId,binding.imbDeleteId);
        DuplicateCode.EdtClear(binding.imbDeleteId,binding.edtId);
        DuplicateCode.BackButton(binding.btnBack,this);

    }
}
