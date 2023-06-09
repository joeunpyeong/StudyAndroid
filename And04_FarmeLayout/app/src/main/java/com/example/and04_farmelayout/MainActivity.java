package com.example.and04_farmelayout;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {//?
    Button btn_change1, btn_change2;
    ImageView imgv1, imgv2, imgv3;
//    ArrayList<ImageView> imgList = new ArrayList<>();
    //현재 객체를 선언만 해둔 상태에서는 4개의 객체 모두 null인 상태이다.
    //null이 아니게 하려면 어떤 처리가 필요할까?

    //null이 아니게 만들고 if문을 이용하여 nullcheck를 하고 log를 직어보기
    //nullCheck : btn...img1중 하나라도 null이라면 null이 섞여있음 이라는 로그가 찍힘 아니라면 전부 초기화 완료라고 로그에 찍힘


    @Override //main
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //res하위에 있는 모든 것들은 "R"이라는 클래스로 하나로 묶인다.
        btn_change1 = findViewById(R.id.btn_change1);
        btn_change2 = findViewById(R.id.btn_change2);
//        //ArrayList<E> list.add(E);
//        imgList.add(findViewById(R.id.imgv1));
//        imgList.add(findViewById(R.id.imgv2));
//        imgList.add(findViewById(R.id.imgv3));
        imgv1 = findViewById(R.id.imgv1);
        imgv2 = findViewById(R.id.imgv2);
        imgv3 = findViewById(R.id.imgv3);

//        if (btn_change2 == null || imgv1 == null || imgv2 == null || imgv3 == null) {
//            Log.d("NullCheck", "null이 섞여있음");
//        }else{
//            Log.d("NullCheck", "null이 섞여있지 않음");
//        }


        //버튼의 클릭을 감지하는 메소드. 인터페이스 view.OnClickListner <-
        //1.직접 인터페이스를 인스턴스화하여 파라메터로 넘기는 방법
//        View.OnClickListener onClickListener = new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Log.d("버튼", "버튼이 눌림");
//            }
//        }
        //2.인터페이스를 초기화 할 수 있는 new 생성자로 파라메터를 넘기는 방법
//        btn_change.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Log.d("버튼", "버튼이 눌림 new");
//            }
//        });
        //3.방법을 이용해서 OnClick메소드를 직접 구현함. 버튼을 누를때마다 밑의 메소드가 실행되게 하려면 어떻게 해야할까?
        btn_change1.setOnClickListener(this);//내부적으로 가지고 있는 interface가 setter에서 초기화 됨.

        //A a = new A(1);
        btn_change2.setOnClickListener(this);//내부적으로 가지고 있는 interface가 setter에서 초기화 됨.

        //onClick(btn_change);

        //4. 자바의 인터페이스 단점을 보완=> lamda(람다식, 함수형으로 new나 불필요한 코드를 생략하고 사용하는 방법)
        //인터페시으싀 abstract메소드가 1개의 경우만 사용 가능.(인터페이스 내부 구조를 모르면 사용이 거의 불가능함. 초보자)
//        btn_change.setOnClickListener(v->{//인터페이스가 주는 파라메터를 (v) 써주고 메소드 지역을 -> 가르킴{}
//
//        });

    }

    //3. 인터페이스를 상속받는 방법
    //->Spring MVC의 경우 DAO 또는 Service가 반드시 구연해야만 하는 메소드의 형태를 만들어서 설계도 개념으로 사용.
    //(많은 개발자가 협업 시 편리한 방법)

    //->Android <-다향성을 이용한 방법 : View.OnClickListener <= onClick이라는 메소드를 반드시 가지고 있음.
    //                                                        View.OnClickListener라는 것을 상속받은 Class는 ==ViewOnClickListener와 같다가 성립
    @Override
    public void onClick(View v) {
        //View v는 버튼
        //ArrayList,arr(배열),HashMap 이용해서 풀어보기

        if (v.getId() == R.id.btn_change1) {//이전
            if (imgv1.getVisibility() == View.VISIBLE) {
                imgv1.setVisibility(View.GONE);
                imgv2.setVisibility(View.GONE);
            } else if (imgv2.getVisibility() == View.VISIBLE) {
                imgv1.setVisibility(View.VISIBLE);
            } else if (imgv3.getVisibility() == View.VISIBLE) {
                imgv2.setVisibility(View.VISIBLE);

            }


        }
        if (v.getId() == R.id.btn_change2) {//다음
            Log.d("버튼", "인터페이스 상속받아서 버튼이 눌림");
            if (imgv1.getVisibility() == View.VISIBLE) {
                imgv1.setVisibility(View.GONE);
            } else if (imgv2.getVisibility() == View.VISIBLE) {
                imgv2.setVisibility(View.GONE);
            } else if (imgv3.getVisibility() == View.VISIBLE) {
                imgv1.setVisibility(View.VISIBLE);
                imgv2.setVisibility(View.VISIBLE);
            }
        }
    }
}
