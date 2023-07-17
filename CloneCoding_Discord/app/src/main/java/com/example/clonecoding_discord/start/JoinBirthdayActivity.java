package com.example.clonecoding_discord.start;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Binder;
import android.os.Bundle;
import android.renderscript.ScriptGroup;
import android.view.View;
import android.widget.DatePicker;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.example.clonecoding_discord.cmmon.CommonVar;
import com.example.clonecoding_discord.cmmon.DuplicateCode;
import com.example.clonecoding_discord.databinding.ActivityJoinBirthdayBinding;
import com.example.clonecoding_discord.main.MainActivity;

import java.util.Calendar;

public class JoinBirthdayActivity extends AppCompatActivity {
    ActivityJoinBirthdayBinding binding;
    DatePicker dpDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityJoinBirthdayBinding.inflate(getLayoutInflater());

        setContentView(binding.getRoot());
        dpDate = (DatePicker) binding.dpDate;
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR); // 현재 연도
        int month = calendar.get(Calendar.MONTH) + 1; // 현재 월 (0부터 시작하므로 1을 더해줌)
        int day = calendar.get(Calendar.DAY_OF_MONTH); // 현재 일
        if (month % 10 < 1 && day % 10 < 1) {
            binding.btnCalendar.setText(year + ".0" + month + ".0" + day);
        } else if (month % 10 < 1) {
            binding.btnCalendar.setText(year + ".0" + month + "." + day);
        } else if (day % 10 < 1) {
            binding.btnCalendar.setText(year + "." + month + ".0" + day);
        }
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy.MM.dd");
        Date date = new Date(System.currentTimeMillis());

        binding.btnCalendar.setText(formatter.format(date));


        binding.btnCalendar.setOnClickListener(v -> {
            binding.cvCelender.setVisibility(View.VISIBLE);
        });

        binding.btnGet.setOnClickListener(v -> {
            int selectedYear = dpDate.getYear();
            int selectedMonth = dpDate.getMonth();
            int selectedDay = dpDate.getDayOfMonth();

            calendar.set(selectedYear, selectedMonth, selectedDay);
            Date selectedDate = calendar.getTime();

            java.sql.Date sqlDate = new java.sql.Date(selectedDate.getTime());
            CommonVar.newUserInfo.setCreateTime(sqlDate);

            String formattedDate = selectedYear + "." + (selectedMonth + 1) + "." + selectedDay;
            binding.btnCalendar.setText(formattedDate);
            binding.cvCelender.setVisibility(View.GONE);

            StringBuilder builder = new StringBuilder();
            builder.append("Selected Date: ");
            builder.append(formattedDate);
            Toast.makeText(this, builder.toString(), Toast.LENGTH_SHORT).show();
        });
        binding.btnNext.setOnClickListener(v -> {
            Intent intent = new Intent(this , ProfileActivity.class);
            startActivity(intent);
        });
    }
}