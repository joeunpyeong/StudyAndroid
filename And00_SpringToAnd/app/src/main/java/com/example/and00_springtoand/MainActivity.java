package com.example.and00_springtoand;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // ApiIterface 가 초기화 되어야함.
        //초기화 식 : ApiInterface name = Retrofit.create( ApiInterface.class );
        RetrofitInterface api = new RetrofitClient().getRetrofit().create(RetrofitInterface.class);
        HashMap<String , Object> paramMap = new HashMap<>();
        paramMap.put("param","값안드");
        paramMap.put("param","값안드1");
        paramMap.put("param","값안드2");
        paramMap.put("param1","값안드3");
        //CallBack : 희미하게 KakaoLogin
        //jsp 카카오 로그인 버튼 누름 -> Controller -> REST API(카카오 서버에 특정 맵핑을 호출하고, 파라메터를 넘겨줌.(Client_id))->페이지
        // -> 사용자가 카카오 로그인을 함(언제끝남? 모름?) 끝나면 내가 만들어둔 나의 Controller로 데이터를 주라. -> CallBack?


        //Dialog처리 : 사용자는 기다리는 일을 잘못함. (==>아무런 디자인 처리 없이)
        ProgressDialog dialog = new ProgressDialog(this);
        dialog.setTitle("레트로핏");
        dialog.setMessage("데이터를 가져오는 중..");
        dialog.setProgress(ProgressDialog.STYLE_SPINNER);
        dialog.setCancelable(false);//저지불가 ( 방해 못함)
        dialog.show();



        api.clientPostMethod("list.cu",paramMap).enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                Log.d("레트로핏", "onResponse: 응답이 왔음. Spring에서 이후 처리 진행 " + response.body());
                dialog.dismiss();
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                dialog.dismiss();
                Log.d("레트로핏", "onResponse: url , 포트 , Spring응답없음 등의 이유로 실패 ");
            }
        });

    }
}