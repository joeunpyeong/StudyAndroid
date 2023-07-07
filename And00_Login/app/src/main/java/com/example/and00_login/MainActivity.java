package com.example.and00_login;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    // editext사용자가 어떤걸입력함. 입력을 마치고 , 로그인 버튼을 누름=>전송
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EditText edt_id = findViewById(R.id.edt_id);
        EditText edt_pw = findViewById(R.id.edt_pw);
        Button btn_login = findViewById(R.id.btn_btn);

        btn_login.setOnClickListener(v->{
            CommonConn conn = new CommonConn(this , "member/login.cu");
            conn.addParamMap("id", edt_id.getText().toString());
            conn.addParamMap("pw", edt_pw.getText().toString());
            conn.onExcute(new CommonConn.JepCallBack() {
                @Override
                public void onResult(boolean isResult, String data) {

                }
            }); // onExcute 메소드가 실행되면 일단 Spring으로 전송처리는 정상적으로 작동한다. ( 결과를 가져오려면 어떻게 해야할까? )

        });
    }

    //올바른 방법아니여서 한번 확인하고 지울꺼임./
//    public static void test(String data){
//        Log.d("결과 : ", "onCreate: ↑ "  + data);
//    }

}