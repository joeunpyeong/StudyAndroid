package com.example.clonecoding_discord;

import android.app.Activity;
import android.text.Editable;
import android.text.InputType;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import com.example.clonecoding_discord.databinding.ActivityLoginBinding;

public class DuplicateCode {
//    private boolean showTogle=false;

    public static void BackButton(Button backButton, Activity act) {
        backButton.setOnClickListener(v -> act.finish());
    }

    public static void EdtClear(ImageButton imb, EditText edt) {
        imb.setOnClickListener(v -> {
            edt.setText("");
        });
    }
//    public void IdBtnVisible(ActivityLoginBinding b1,ActivityLoginBinding b2){
//        binding.edtId.addTextChangedListener(new TextWatcher() {
//            @Override
//            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
//
//            }
//            @Override
//            public void onTextChanged(CharSequence s, int start, int before, int count) {
//                if (binding.edtId.length()==0){
//                    binding.imbDeleteId.setVisibility(View.GONE);
//                } else if (binding.edtId.length()!=0) {
//                    binding.imbDeleteId.setVisibility(View.VISIBLE);
//                }
//
//            }
//            @Override
//            public void afterTextChanged(Editable s) {
//
//            }
//        });
//    }

//    public void ShowPwBtn(ActivityLoginBinding binding,final boolean showTogle ){
//        this.showTogle=showTogle;
//
//        binding.imbToggleShow.setOnClickListener(v -> {
//            if (showTogle==false) {
//                binding.edtPw.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD | InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);
//                showTogle = true;
//            }else if(showTogle==true){
//                binding.edtPw.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
//                showTogle =false;
//            }
//        });
//    }

}
