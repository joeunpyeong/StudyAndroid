package com.example.clonecoding_discord.start;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.Toast;

import com.example.clonecoding_discord.NoRegActivity;
import com.example.clonecoding_discord.R;
import com.example.clonecoding_discord.cmmon.CommonVar;
import com.example.clonecoding_discord.cmmon.DuplicateCode;
import com.example.clonecoding_discord.databinding.ActivityJoinBirthdayBinding;
import com.example.clonecoding_discord.databinding.DialogCalBinding;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class JoinBirthdayActivity extends AppCompatActivity {
    ActivityJoinBirthdayBinding binding;
    DatePicker dpDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityJoinBirthdayBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Drawable color_btnnext=binding.btnNext.getBackground(),
                        color_calenar=binding.btnCalendar.getBackground();

        dpDate = binding.dpDate;
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR); // 현재 연도
        int month = calendar.get(Calendar.MONTH) + 1; // 현재 월 (0부터 시작하므로 1을 더해줌)
        int day = calendar.get(Calendar.DAY_OF_MONTH); // 현재 일

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy.MM.dd");
        Date date = new Date(System.currentTimeMillis());
        String formattedDate = formatter.format(date);

        binding.btnCalendar.setText(formattedDate);

        binding.btnCalendar.setOnClickListener(v -> {
            DialogCalBinding dialogCalBinding = DialogCalBinding.inflate(getLayoutInflater());
           AlertDialog.Builder builder = new AlertDialog.Builder(this);
           builder.setView(dialogCalBinding.getRoot());
            AlertDialog dialog = builder.create();
            dialog.show();
            dialogCalBinding.btnCancel.setOnClickListener(v1 -> {
                dialog.dismiss();
                //   binding.cvCelender.setVisibility(View.GONE);
//            binding.layout.setBackgroundColor(Color.parseColor("#FFFFFF"));
//            binding.btnCalendar.setBackgroundColor(Color.parseColor("#FFFFFF"));
//            binding.btnNext.setBackgroundColor(Color.parseColor("#FFFFFF"));
            });

            dialogCalBinding.btnGet.setOnClickListener(v1 -> {
                int selectedYear = dpDate.getYear();
                int selectedMonth = dpDate.getMonth();
                int selectedDay = dpDate.getDayOfMonth();

                calendar.set(selectedYear, selectedMonth, selectedDay);
                Date selectedDate = new Date(calendar.getTimeInMillis());

                CommonVar.newUserInfo.setCreateTime(selectedDate);

                String formattedDate1 = selectedYear + "." + (selectedMonth + 1) + "." + selectedDay;
                binding.btnCalendar.setText(formattedDate1);
                binding.cvCelender.setVisibility(View.GONE);
                //binding.layout.setBackgroundColor(); <-----------  이거 두개 색상 어떻게 되돌리지
                //binding.btnNext.setBackgroundColor();

                StringBuilder strBuilder = new StringBuilder();
                strBuilder.append("Selected Date: ");
                strBuilder.append(formattedDate1);
                Toast.makeText(this, strBuilder.toString(), Toast.LENGTH_SHORT).show();
                dialog.dismiss();
            });


            //binding.cvCelender.setVisibility(View.VISIBLE);
//            binding.layout.setBackgroundColor(Color.parseColor("#80000000"));
//            binding.btnCalendar.setBackgroundColor(Color.parseColor("#80000000"));
//            binding.btnNext.setBackgroundColor(Color.parseColor("#80000000"));
        });


        binding.btnNext.setOnClickListener(v -> {
            int selectedYear = dpDate.getYear();
            if (year - 12 > selectedYear) {
                Intent intent = new Intent(this, NoRegActivity.class);
                startActivity(intent);
            } else {
                Intent intent = new Intent(this, ProfileActivity.class);
                startActivity(intent);
            }
        });

        DuplicateCode.BackButton(binding.btnBack, this);
    }
}
