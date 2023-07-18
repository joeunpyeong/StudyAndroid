package com.example.clonecoding_discord.start;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
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

        binding.edtPw.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                // 변경 전 텍스트 상태를 처리
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                // 텍스트 변경 시 상태를 처리
                String nickname = binding.edtNickname.getText().toString();
                String pw = charSequence.toString();
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

        GradientDrawable gdbFals = new GradientDrawable();
        float[] cornerRadii = {10, 10, 10, 10, 10, 10, 10, 10};
        gdbFals.setCornerRadii(cornerRadii);
        gdbFals.setStroke(2, Color.RED);

        binding.btnNext.setOnClickListener(v -> {
            if(binding.edtPw.length()<8){
                binding.tvTxt.setText("최소 8글자 이상이어야 해요.");
                binding.tvTxt.setVisibility(View.VISIBLE);
                binding.layoutPw.setBackground(gdbFals);
            }else if(hasSequentialNumbers(binding.edtPw.getText().toString())==true){
                binding.tvTxt.setText("너무 쉽거나 흔한 비밀번호에요");
                binding.tvTxt.setVisibility(View.VISIBLE);
                binding.layoutPw.setBackground(gdbFals);

            }else {
                CommonVar.newUserInfo.setNick_name(binding.edtNickname.getText().toString());
                CommonVar.newUserInfo.setUser_pw(binding.edtPw.getText().toString());

                Intent intent = new Intent(this, JoinBirthdayActivity.class);
                startActivity(intent);
            }
        });
        DuplicateCode.IdBtnVisible(binding.edtNickname,binding.imbDeleteNickname);
        DuplicateCode.EdtClear(binding.imbDeleteNickname, binding.edtNickname);
        DuplicateCode.BackButton(binding.btnBack, this);
    }

    public boolean hasSequentialNumbers(String password) {
        int sequentialCount = 0; // 연속된 숫자의 개수를 저장할 변수
        int consecutiveCount = 0; // 연속된 카운트를 세는 변수

        // 비밀번호 문자열을 순회하며 연속된 숫자 패턴 검사
        for (int i = 0; i < password.length() - 1; i++) {
            char currentChar = password.charAt(i);
            char nextChar = password.charAt(i + 1);

            // 현재 문자와 다음 문자가 연속된 숫자인지 확인
            if (Character.isDigit(currentChar) && Character.isDigit(nextChar) && nextChar - currentChar == 1) {
                consecutiveCount++;
                if (consecutiveCount >= 2) {
                    sequentialCount++;
                    if (sequentialCount >= 2) {
                        return true; // 순서대로 나란히 3개 이상의 숫자가 있는 경우 true 반환
                    }
                }
            } else {
                consecutiveCount = 0; // 연속 카운트 초기화
            }
        }

        return false; // 순서대로 나란히 3개 이상의 숫자가 없는 경우 false 반환
    }
}
