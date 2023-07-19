package com.example.project02_lastprj.member;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.example.project02_lastprj.MainActivity;
import com.example.project02_lastprj.common.CommonVar;
import com.example.project02_lastprj.common.CommonConn;
import com.example.project02_lastprj.databinding.ActivityLoginBinding;
import com.google.gson.Gson;
import com.kakao.sdk.auth.model.OAuthToken;
import com.kakao.sdk.common.KakaoSdk;
import com.kakao.sdk.common.model.ClientErrorCause;
import com.kakao.sdk.user.UserApiClient;
import com.kakao.sdk.user.model.User;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

public class LoginActivity extends AppCompatActivity {
    //member/login?id=dev&pw=dev
    //구글 로그인은 혼자 해보기.(구글 개발자 콘솔 등록되어야 함.)
    ActivityLoginBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        checkPermission();
        KakaoSdk.init(this,"95a17db762da7ec815299df18e20e06a");
//        UserApiClient.getInstance().unlink(new Function1<Throwable, Unit>() {
//            @Override
//            public Unit invoke(Throwable throwable) {
//                return null;
//            }
//        });
        binding.btnLogin.setOnClickListener(v->{
            login();
        });
        Log.d("키해시", "login: " + getKeyHash(this));

        binding.imgvKakaologin.setOnClickListener(v->{
            kakaoLogin(this);
        });
    }

    public void login(){
        if(binding.edtId.getText().toString().length() < 1
                || binding.edtPw.getText().toString().length() < 1
        ){
            Toast.makeText(this, "아이디 또는 패스워드를 입력하세요.!", Toast.LENGTH_SHORT).show();
            return;
        }
        CommonConn conn = new CommonConn(this , "member/login");
        conn.addParamMap("id" , binding.edtId.getText().toString());
        conn.addParamMap("pw" , binding.edtPw.getText().toString());
        conn.onExcute((isResult, data) -> {
            if(isResult){
                CommonVar.loginInfo = new Gson().fromJson(data , MemberVO.class);
                if(CommonVar.loginInfo==null){
                    Toast.makeText(this, "아이디 또는 비밀번호를 확인하세요.", Toast.LENGTH_SHORT).show();
                }else{
                    //CommonVar.loginInfo = vo;
                    Intent intent = new Intent(LoginActivity.this , MainActivity.class);
                    startActivity(intent);
                }
            }
        });


    }

    public void kakaoLogin(Context context){
        // 카카오톡이 설치되어 있으면 카카오톡으로 로그인, 아니면 카카오계정으로 로그인(웹뷰)
        // Kotlin은 경우에 따라서 생성자 대신에 메소드로 객체를 return받음. UserApiClient name = new ....x -> UserApiClient.{ static UserApiClient.method )
        Function2<OAuthToken, Throwable, Unit> callback = (token, error) -> {
            if(error != null){
                Log.e("카카오 로그인 에러", "invoke: " + error.getMessage());
            }else{
                Log.d("카카오 로그인 성공", "invoke: " + token.toString());
                getKakaoProfile();
            }
            return null;
        };

        if(UserApiClient.getInstance().isKakaoTalkLoginAvailable(context)){
            Log.d("카카오", "isKakaoTalkLoginAvailable: true" );
            UserApiClient.getInstance().loginWithKakaoTalk(context,callback);
        }else{
            Log.d("카카오", "isKakaoTalkLoginAvailable: false" );
            UserApiClient.getInstance().loginWithKakaoAccount(context, callback);
        }

    }

    public void getKakaoProfile(){
        UserApiClient.getInstance().me((user, error) -> {
            if(error == null){
                Log.d("카카오", "getKakaoProfile: " + user.toString());
                Log.d("카카오", "getKakaoProfile: " + user.getKakaoAccount().getEmail());
                Log.d("카카오", "getKakaoProfile: " + user.getKakaoAccount().getProfile().getNickname());
                Log.d("카카오", "getKakaoProfile: " + user.getKakaoAccount().getProfile().getThumbnailImageUrl());
            }

            return null;
        });
    }
    public static String getKeyHash(final Context context) {
        PackageManager pm = context.getPackageManager();
        try {
            PackageInfo packageInfo = pm.getPackageInfo(context.getPackageName(), PackageManager.GET_SIGNATURES);
            if (packageInfo == null)
                return null;

            for (Signature signature : packageInfo.signatures) {
                try {
                    MessageDigest md = MessageDigest.getInstance("SHA");
                    md.update(signature.toByteArray());
                    return android.util.Base64.encodeToString(md.digest(), android.util.Base64.NO_WRAP);
                } catch (NoSuchAlgorithmException e) {
                    e.printStackTrace();
                }
            }
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }



    //나중에 재사용이 가능하게 commonMethod등의 클래스 내부에 넣어두면 좋음.
    private final int REQ_PERMISSION = 1000;
    private void checkPermission(){
        String[] permissions = { Manifest.permission.CAMERA  ,
                Manifest.permission.ACCESS_MEDIA_LOCATION

        } ;//카메라 권한을 String으로 가져옴.
        // ContextCompat(액티비티가 아닌곳) , ActivityCompat(액티비티)
        for(int i = 0 ; i <permissions.length ; i ++){
            //내가 모든 권한이 필요하다면 전체 권한을 하나씩 체크해서 허용 안됨이 있는경우 다시 요청을 하게 만든다.
            if(ActivityCompat.checkSelfPermission(this , permissions[i]) == PackageManager.PERMISSION_DENIED) {
                ActivityCompat.requestPermissions(this, permissions, REQ_PERMISSION);
                break;
            }
        }

        // int result = ActivityCompat.checkSelfPermission(this , permissions[0]);
        // Log.d("권한", "checkPermission: " + result);
//        Log.d("권한", "checkPermission: " + PackageManager.PERMISSION_GRANTED);
//        Log.d("권한", "checkPermission: " + PackageManager.PERMISSION_DENIED);
//
//        if(ActivityCompat.shouldShowRequestPermissionRationale(this , permissions[0])){
//            Log.d("권한", "shouldShowRequestPermissionRationale: 설명이 필요한 권한. ");
//            ActivityCompat.requestPermissions(this,permissions , REQ_PERMISSION);
//        }else{
//            Log.d("권한", "shouldShowRequestPermissionRationale: 설명이 x");
//            ActivityCompat.requestPermissions(this,permissions , REQ_PERMISSION);
//        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if(REQ_PERMISSION == requestCode){
            Log.d("권한", "onRequestPermissionsResult: 권한 요청 완료 ");
        }
    }
}