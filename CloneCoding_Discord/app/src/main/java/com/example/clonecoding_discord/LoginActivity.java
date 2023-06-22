package com.example.clonecoding_discord;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import com.example.clonecoding_discord.DuplicateCode;

public class LoginActivity extends AppCompatActivity {
    Button btn_back,btn_login;
    EditText edt_id,edt_pw;
    ImageButton imb_delete_id,imb_toggle_show;
    boolean showtogle=false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        btn_back=findViewById(R.id.btn_back);
        btn_login=findViewById(R.id.btn_login);
        edt_id=findViewById(R.id.edt_id);
        edt_pw=findViewById(R.id.edt_pw);
        imb_delete_id=findViewById(R.id.imb_delete_id);
        imb_toggle_show=findViewById(R.id.imb_toggle_show);

        if (edt_id.length()==0){
            imb_delete_id.setVisibility(View.GONE);
        } else if (edt_id.length()==0) {
            imb_delete_id.setVisibility(View.VISIBLE);
        }
        imb_toggle_show.setOnClickListener(v -> {
            if (showtogle==false) {
                edt_pw.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD | InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);
                showtogle = true;
            }else if(showtogle==true){
                edt_pw.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
                showtogle =false;
            }
        });
        DuplicateCode.EdtClear(imb_delete_id,edt_id);
        DuplicateCode.BackButton(btn_back,this);
    }
}