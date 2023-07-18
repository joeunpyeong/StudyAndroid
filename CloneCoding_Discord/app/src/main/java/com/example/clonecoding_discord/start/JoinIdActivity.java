package com.example.clonecoding_discord.start;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputType;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;

import com.example.clonecoding_discord.R;
import com.example.clonecoding_discord.cmmon.CommonVar;
import com.example.clonecoding_discord.cmmon.DuplicateCode;
import com.example.clonecoding_discord.databinding.ActivityJoinIdBinding;
import com.example.clonecoding_discord.main.MainActivity;
import com.example.clonecoding_discord.vo.UserVO;

public class JoinIdActivity extends AppCompatActivity {

    ActivityJoinIdBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityJoinIdBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.btnPhone.setOnClickListener(v -> {
            binding.btnEmail.setBackgroundResource(R.drawable.custom_choice1);
            binding.btnEmail.setTextColor(ContextCompat.getColor(this, R.color.black));
            binding.btnDialing.setVisibility(View.VISIBLE);
            binding.edtEdit.setHint("전화번호");
            binding.edtEdit.setText("");
            binding.tvText.setText("전화번호");
            binding.edtEdit.setInputType(InputType.TYPE_CLASS_NUMBER);

            binding.btnPhone.setBackground(ContextCompat.getDrawable(this, R.drawable.custom_choice1));
            binding.btnEmail.setBackgroundColor(Color.parseColor("#00FFFFFF"));
            binding.btnEmail.setTextColor(ContextCompat.getColor(this, R.color.edittext_hint_gray));
        });

        binding.btnEmail.setOnClickListener(v -> {
            binding.btnEmail.setBackgroundResource(R.drawable.custom_choice1);
            binding.btnEmail.setTextColor(ContextCompat.getColor(this, R.color.black));
            binding.btnDialing.setVisibility(View.GONE);
            binding.edtEdit.setHint("이메일");
            binding.edtEdit.setText("");
            binding.tvText.setText("이메일");
            binding.edtEdit.setInputType(InputType.TYPE_CLASS_TEXT);

            binding.btnPhone.setBackgroundColor(Color.parseColor("#00FFFFFF"));
            binding.btnEmail.setBackground(ContextCompat.getDrawable(this, R.drawable.custom_choice1));
            binding.btnPhone.setTextColor(ContextCompat.getColor(this, R.color.edittext_hint_gray));
        });

        binding.edtEdit.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                // 변경 전 텍스트 상태를 처리
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                // 텍스트 변경 시 상태를 처리
                if (TextUtils.isEmpty(charSequence)==true) {
                    binding.btnNext.setEnabled(false); // 버튼 비활성화
                } else {
                    binding.btnNext.setEnabled(true); // 버튼 활성화
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {
                // 변경 후 텍스트 상태를 처리
            }
        });
        binding.btnNext.setOnClickListener(v -> {
            CommonVar.newUserInfo.setUser_id(binding.edtEdit.getText().toString());
            Intent intent = new Intent(this , JoinNicknameActivity.class);
            startActivity(intent);
        });
        DuplicateCode.IdBtnVisible(binding.edtEdit,binding.btnClear);
        DuplicateCode.EdtClear(binding.btnClear, binding.edtEdit);
        DuplicateCode.BackButton(binding.btnBack,this);
    }
}