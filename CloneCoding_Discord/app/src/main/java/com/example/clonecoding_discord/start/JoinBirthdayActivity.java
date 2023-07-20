package com.example.clonecoding_discord.start;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.clonecoding_discord.cmmon.DuplicateCode;
import com.example.clonecoding_discord.databinding.ActivityJoinBirthdayBinding;
import com.example.clonecoding_discord.databinding.DialogCalBinding;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class JoinBirthdayActivity extends AppCompatActivity {
    ActivityJoinBirthdayBinding binding;
  //  DatePicker dpDate;
  DialogCalBinding dialogCalBinding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityJoinBirthdayBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Drawable color_btnnext=binding.btnNext.getBackground(),
                        color_calenar=binding.btnCalendar.getBackground();

       // dpDate = binding.dpDate;
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR); // 현재 연도
        int month = calendar.get(Calendar.MONTH) + 1; // 현재 월 (0부터 시작하므로 1을 더해줌)
        int day = calendar.get(Calendar.DAY_OF_MONTH); // 현재 일

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy.MM.dd");
        Date date = new Date(System.currentTimeMillis());
        String formattedDate = formatter.format(date);

        binding.btnCalendar.setText(formattedDate);

        binding.btnCalendar.setOnClickListener(v -> {
            dialogCalBinding = DialogCalBinding.inflate(getLayoutInflater());
           AlertDialog.Builder builder = new AlertDialog.Builder(this);
           builder.setView(dialogCalBinding.getRoot());
            AlertDialog dialog = builder.create();
            dialog.show();
            dialogCalBinding.btnCancel.setOnClickListener(v1 -> {
                dialog.dismiss();
            });

            dialogCalBinding.btnGet.setOnClickListener(v1 -> {
                calendar.set(dialogCalBinding.dpDate.getYear(), dialogCalBinding.dpDate.getMonth(), dialogCalBinding.dpDate.getDayOfMonth());
                String formattedDate1;
                formattedDate1 = dialogCalBinding.dpDate.getYear()+"";
                if ((dialogCalBinding.dpDate.getMonth() + 1)<10) {
                    formattedDate1 += ".0" + (dialogCalBinding.dpDate.getMonth() + 1);
                }else {
                    formattedDate1 += "." + (dialogCalBinding.dpDate.getMonth() + 1);}

                if ((dialogCalBinding.dpDate.getDayOfMonth())<10) {
                    formattedDate1 += ".0" + dialogCalBinding.dpDate.getDayOfMonth();
                }else {
                    formattedDate1 += "." + dialogCalBinding.dpDate.getDayOfMonth();}
                binding.btnCalendar.setText(formattedDate1);
                binding.cvCelender.setVisibility(View.GONE);

                StringBuilder strBuilder = new StringBuilder();
                strBuilder.append("Selected Date: ");
                strBuilder.append(formattedDate1);
                binding.btnCalendar.setText(formattedDate1);

                //  Toast.makeText(JoinBirthdayActivity.this, strBuilder.toString(), Toast.LENGTH_SHORT).show();
                dialog.dismiss();
            });
        });


        binding.btnNext.setOnClickListener(v -> {
            dialogCalBinding.dpDate.getYear();
            Log.d("현재 년도", "onCreate: "+year);
            Log.d("선택 년도", "onCreate: "+  dialogCalBinding.dpDate.getYear());
            if (dialogCalBinding == null ||year -   dialogCalBinding.dpDate.getYear()  < 12) {
                Intent intent = new Intent(this, NoRegActivity.class);
                startActivity(intent);
            }else{
                Intent intent = new Intent(this, ProfileActivity.class);
                startActivity(intent);
            }
        });

        DuplicateCode.BackButton(binding.btnBack, this);
    }
}
