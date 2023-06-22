package com.example.clonecoding_discord;

import android.app.Activity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

public class DuplicateCode {
    public static void BackButton(Button backButton, final Activity activity) {
        backButton.setOnClickListener(v -> activity.finish());
    }

    public static void EdtClear(ImageButton imb, EditText edt) {
        imb.setOnClickListener(v -> {
            edt.setText("");
        });
    }

}
