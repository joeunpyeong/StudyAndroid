package com.example.clonecoding_discord.cmmon;

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

    public static void EdtClear(ImageButton imb, EditText edt) { //edt 삭제
        imb.setOnClickListener(v -> {
            edt.setText("");
        });
    }

    public static void IdBtnVisible(EditText edtId,ImageButton imbDeleteId){ //버튼 보이게 안보이게
        edtId.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (edtId.length()==0){
                    imbDeleteId.setVisibility(View.GONE);
                } else if (edtId.length()!=0) {
                    imbDeleteId.setVisibility(View.VISIBLE);
                }

            }
            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }




}
