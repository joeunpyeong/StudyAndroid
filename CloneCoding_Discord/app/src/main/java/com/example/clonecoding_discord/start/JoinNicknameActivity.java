package com.example.clonecoding_discord.start;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputType;
import android.text.TextWatcher;
import android.view.View;

import com.example.clonecoding_discord.R;
import com.example.clonecoding_discord.cmmon.CommonVar;
import com.example.clonecoding_discord.cmmon.DuplicateCode;
import com.example.clonecoding_discord.databinding.ActivityJoinNicknameBinding;
import com.example.clonecoding_discord.main.MainActivity;
import com.example.clonecoding_discord.vo.UserVO;

public class JoinNicknameActivity extends AppCompatActivity {
    boolean showPwTogle=false;
    ActivityJoinNicknameBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        CommonVar.newUserInfo = new UserVO();
        binding = ActivityJoinNicknameBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.imbToggleShow.setOnClickListener(v -> {
            if (showPwTogle == false) {
                binding.edtPw.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD | InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);
                showPwTogle = true;
            } else {
                binding.edtPw.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
                showPwTogle = false;
            }
        });

        binding.edtNickname.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                // 변경 전 텍스트 상태를 처리
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                // 텍스트 변경 시 상태를 처리
                String nickname = charSequence.toString();
                if (binding.edtNickname.length() == 0) {
                    binding.imbDeleteNickname.setVisibility(View.GONE);
                } else if (binding.edtNickname.length() != 0) {
                    binding.imbDeleteNickname.setVisibility(View.VISIBLE);
                }
                String pw = binding.edtPw.getText().toString();
                if (pw.isEmpty() || nickname.isEmpty()) {
                    binding.btnNext.setEnabled(false);
                } else {
                    binding.btnNext.setEnabled(true);
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {
                // 변경 후 텍스트 상태를 처리
            }
        });


        binding.btnNext.setOnClickListener(v -> {
            CommonVar.newUserInfo.setNick_name(binding.edtNickname.getText().toString());
            CommonVar.newUserInfo.setUser_pw(binding.edtPw.getText().toString());

            Intent intent = new Intent(this, JoinBirthdayActivity.class);
            startActivity(intent);
        });

        DuplicateCode.EdtClear(binding.imbDeleteNickname, binding.edtNickname);
        DuplicateCode.BackButton(binding.btnBack, this);
    }
}
