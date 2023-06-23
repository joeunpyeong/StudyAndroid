package com.example.clonecoding_discord;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputType;
import android.text.TextWatcher;
import android.view.View;

import com.example.clonecoding_discord.databinding.ActivityLoginBinding;

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

        binding.edtId.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (binding.edtId.length()==0){
                    binding.imbDeleteId.setVisibility(View.GONE);
                } else if (binding.edtId.length()!=0) {
                    binding.imbDeleteId.setVisibility(View.VISIBLE);
                }

            }
            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        binding.btnLogin.setOnClickListener(v -> {
            //일단 페이지 이동 가능
            Intent intent =new Intent(this,JoinIdActivity.class);
            startActivity(intent);
        });

        DuplicateCode.EdtClear(binding.imbDeleteId,binding.edtId);
        DuplicateCode.BackButton(binding.btnBack,this);

    }
}