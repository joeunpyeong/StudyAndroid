package com.example.exam00_java;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    //getSum이라는 메소드 만들기. (숫자 두개 입력받아서 두 수의 합을 구하는 메소드)

    TextView tv1;
    Button btn1,btn_start,btn_stop;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv1 = findViewById(R.id.tv1);
        btn1 = findViewById(R.id.btn1);
        btn_start=findViewById(R.id.btn_start);
        btn_stop=findViewById(R.id.btn_stop);

        ClacDAO dao = new ClacDAO();
        dao.a=1;
        dao.b=1;
        dao.d=0;
        dao.e=0;
        dao.g=0;

        ClacDAO.ChildClass cc=dao . new ChildClass();
        cc.fieldChild=5;
        ClacDAO.StaticChildClass scc = new ClacDAO.StaticChildClass();


        tv1.setText(dao.getSum(1,2)+"");
        btn1.setText(dao.getSum(1,2)+"");
        //dao.getSum(2,3,tv1);
        //getSum(2,3); //메소드가 구현(정의)되어있는 파라메터부= 호출부의 파라메터 값을 합치면 변수 초기화식이 된다.
        //dao.getSum(2,3,btn1);

        btn_start.setOnClickListener(new JepOnclick());
    }

    //메소드는 구현이 자유롭다.
    //실행은 항상 사용하는 곳에서 호출을 해줘야지만 됨
public class JepOnclick implements View.OnClickListener{//View.OnClickListner는 onClick이라는 메소드가 반드시 구현되어야하는 규칙이 있다
                                                        //(인터페이스)상속을 받게되면 onClick이라는 메소드가 반드시 구현되기때문에 둘은 같다라는
                                                        //규칙이 성립된다
        @Override
        public void onClick(View v){
            Log.d("온클릭", "onClick: ");
        }
    }
}