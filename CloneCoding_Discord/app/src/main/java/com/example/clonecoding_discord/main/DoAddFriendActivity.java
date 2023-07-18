package com.example.clonecoding_discord.main;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Gravity;
import android.widget.Toast;

import com.example.clonecoding_discord.R;
import com.example.clonecoding_discord.cmmon.CommonConn;
import com.example.clonecoding_discord.cmmon.CommonVar;
import com.example.clonecoding_discord.cmmon.DuplicateCode;
import com.example.clonecoding_discord.databinding.ActivityDoAddFriendBinding;
import com.example.clonecoding_discord.vo.FriendVO;
import com.example.clonecoding_discord.vo.UserVO;
import com.google.android.material.snackbar.Snackbar;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.List;

public class DoAddFriendActivity extends AppCompatActivity {
    ActivityDoAddFriendBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding= ActivityDoAddFriendBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.userTag.setText("내 사용자명: "+CommonVar.loginInfo.getUser_tag());

        GradientDrawable gdbFals = new GradientDrawable();
        float[] cornerRadii = {10, 10, 10, 10, 10, 10, 10, 10}; // 각 꼭지점의 반지름 값
        gdbFals.setCornerRadii(cornerRadii);
        gdbFals.setStroke(2, Color.RED);
        binding.btnFriendInvite.setEnabled(false);
        binding.edtUserTag.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                // 변경 전 텍스트 상태를 처리
            }
            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                // 텍스트 변경 시 상태를 처리
                if (charSequence.toString().isEmpty()) {
                    binding.btnFriendInvite.setEnabled(false);
                } else {
                    binding.btnFriendInvite.setEnabled(true);
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {
                // 변경 후 텍스트 상태를 처리
            }
        });

        binding.btnFriendInvite.setOnClickListener(v -> {

            CommonConn uf = new CommonConn(this , "user/find");
            uf.addParamMap("user_tag",binding.edtUserTag.getText().toString());


            CommonConn fc = new CommonConn(this , "friend/check");
            fc.addParamMap("user_tag",CommonVar.loginInfo.getUser_tag());
            fc.addParamMap("friend_user_tag", binding.edtUserTag.getText().toString());

            CommonConn fa = new CommonConn(this,"friend/add");
            fa.addParamMap("user_tag",CommonVar.loginInfo.getUser_tag());
            fa.addParamMap("friend_user_tag", binding.edtUserTag.getText().toString());
            fa.addParamMap("status", "요청중");  //<------------------------------------------------------------이거 db에 글자 깨짐



            uf.onExcute((isResult, data) -> {
                UserVO userVO = new Gson().fromJson(data,UserVO.class);

                fc.onExcute((fc_isResult, fc_data) -> {
                 //   TypeToken typeToken = new TypeToken();
                    if(fc_isResult){
                        ArrayList<FriendVO> list = new Gson().fromJson(fc_data ,
                                new TypeToken<ArrayList<FriendVO>>(){}.getType());
                        FriendVO friendVO = list.get(0); //-?
                        if(userVO==null){
                            binding.userTag.setText("흠, 안되는군요. 사용자명을 올바르게 입력했는지 확인하세요.");
                            binding.userTag.setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.red));
                            binding.layout.setBackground(gdbFals);
                        } else if (friendVO==null||!friendVO.getStatus().equals("친구")){
                            fa.onExcute((fa_isResult,fa_data)->{
                                Toast.makeText(this, "친구 요청 완료", Toast.LENGTH_SHORT).show();
                                binding.userTag.setText("내 사용자명: "+CommonVar.loginInfo.getUser_tag());
                                binding.userTag.setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.edittext_hint_gray));
                                binding.layout.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.custom_choice));

                            });
                        }else if(friendVO.getStatus().equals("대기중")){
                            binding.userTag.setText(binding.edtUserTag.getText().toString()+"님이 친구 요청을 수락하지 않네요. 친구가 되려면 상대방이 나를 추가해야 해요.");
                            binding.userTag.setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.red));
                            binding.layout.setBackground(gdbFals);
                        }else if(friendVO.getStatus().equals("친구")){
                            binding.userTag.setText("이미 친구가 된 사용자에요!");
                            binding.userTag.setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.red));
                            binding.layout.setBackground(gdbFals);
                        }
                    }
                });

            });


        });


        DuplicateCode.BackButton(binding.btnBack,this);

    }
}