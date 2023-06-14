package com.example.and07_activitiyintent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.Serializable;
import java.util.ArrayList;

public class LoginActivity extends AppCompatActivity {
    EditText edt_id,edt_pw;
    Button btn_login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        edt_id=findViewById(R.id.edt_id);
        edt_pw=findViewById(R.id.edt_pw);
        btn_login=findViewById(R.id.btn_login);
        //editText에 있는 글자를 가져오는 메소드: editText.getText()입니다. getText메소드가 리턴해주는 타입은 뭘까?
        //id가 admin 비밀번호가 admin1234일때 다음 화면으로 이동
        //그 외에는 Toast를 이용해서 아이디 또는 비밀번호 틀림이라고 메세지 띄우기

        btn_login.setOnClickListener(new View.OnClickListener(){//인터페이스를 new로 생성하면 메소드가 반드시 있어야해서 익명의 클래스 지역을 만든다
            @Override
            public void onClick(View v) {
                //Intent를 이용하면 화면전환 => Intent객체 (안드로이드의  4대 컴포넌트의 통신을 담당) Act => 'Intent'=>Act
                //Context (맥락, 상태정보 확인) : 현재 화면에 떠있는 객체인지?
                // ex)DAO,DTO,VO => 화면에 떠있는 객체가 아니기 때문에 그래픽 작업을 하면 오류가 발생함 => 일반 클래스
                // ex)Act,Fragment=>화면에 떠있는 객체이기 때문에 그래픽 작업을 할 수 있음. 하지만 화면에 떠 있는지의 상태를 알려줄 수 있는게 필요함 ==>Context
                //=>일반 클래스에서도 그래픽 처리가 가능하게 만드려면 Activity가 Context라는 것을 파라메터로 보내줬을때. 가능함.

                String id = edt_id.getText().toString();
                Log.d("글자", "onCreate: "+ edt_id);
                String pw = edt_pw.getText().toString();
                Log.d("글자", "onCreate: "+ edt_pw);
                if (id.equals("admin") == true && pw.equals("1234")==true) {
                    Toast.makeText(LoginActivity.this, "로그인 성공", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(LoginActivity.this ,MainActivity.class);
                    intent.putExtra("strkey",edt_id.getText().toString());
                    //inKey 숫자를 다음 엑티비티로 전송해보기(int)
                    intent.putExtra("intkey",10);

                    LoginDTO dto = new LoginDTO(edt_id.getText().toString()+"1",edt_pw.getText().toString()+"1");
                    intent.putExtra("dtokey",dto);

                    ArrayList<LoginDTO> list = new ArrayList<>(5);
                    list.add(new LoginDTO("a1","b1"));
                    list.add(new LoginDTO("a2","b2"));
                    list.add(new LoginDTO("a3","b3"));
                    list.add(new LoginDTO("a4","b4"));
                    list.add(new LoginDTO("a5","b5"));

                    intent.putExtra("list",list);//startActvity가 되기 전에 데이터 담는 처리를 끝내자

                    startActivity(intent);
                    //intent.putExtra("list",list); //전달 불가
                    
                }else{
                    Toast.makeText(LoginActivity.this, "로그인 실패", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

//    public class JepClass implements Serializable{
//
//    }
//    public class JepClass2 implements Serializable{
//
//    }
//    public class method(Serializable k){
//        //역직렬화 : JepClass k2 = (JepClass K)
//    }
}