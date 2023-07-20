package com.example.clonecoding_discord.start;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.clonecoding_discord.R;
import com.example.clonecoding_discord.cmmon.CommonVar;
import com.example.clonecoding_discord.databinding.ActivityProfileBinding;

import java.util.Random;

public class ProfileActivity extends AppCompatActivity {
    ActivityProfileBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityProfileBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        ImageView[] imvArr=
                {binding.vSelect1,binding.vSelect2,binding.vSelect3
                ,binding.vSelect4,binding.vSelect5,binding.vSelect6
                ,binding.vSelect7,binding.vSelect8};
        ImageView[] btnArr ={
                binding.btnImg1,binding.btnImg2,binding.btnImg3,
                binding.btnImg4,binding.btnImg5,binding.btnImg6,
                binding.btnImg7,binding.btnImg8};
        int[] imgArr ={R.drawable.img_profile1 , R.drawable.img_profile2,R.drawable.img_profile3,R.drawable.img_profile4,
                R.drawable.img_profile5 , R.drawable.img_profile6,R.drawable.img_profile7,R.drawable.img_profile8,

        };
        for (int i = 0; i < btnArr.length; i++) {
            int indexI = i;
            btnArr[i].setOnClickListener(v -> {
                for (int j = 0; j < btnArr.length; j++) {
                    int indexJ=j;
                    if (indexJ == indexI)
                        imvArr[indexJ].setVisibility(View.VISIBLE);
                    else
                        imvArr[indexJ].setVisibility(View.GONE);

                }
                binding.btnChoice.setImageResource(imgArr[indexI]);
            });
        }

        binding.btnChoice.setOnClickListener(v -> {});









        binding.btnNext.setOnClickListener(v -> {
            CommonVar.newUserInfo.setProfile_img(convertBytesToHex());// ------------바꿔야함
            CommonVar.newUserInfo.setProfile_banner(convertBytesToHex());
            Intent intent = new Intent(this , AllowSearchActivity.class);
            startActivity(intent);
        });
    }
    private static String convertBytesToHex() {
        byte[] bytes = new byte[3];
        new Random().nextBytes(bytes);
        StringBuilder result = new StringBuilder();
        for (byte temp : bytes) {
            result.append(String.format("%02x", temp));
        }
        return "#"+result.toString();
    }

}