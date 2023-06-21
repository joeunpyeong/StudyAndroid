package com.example.exam_vendingmachine;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    // ArrayList에 이미 담았기때문에 필요가없음. (혼동)
    //TextView tv_name1 , tv_name2 , tv_name3 , tv_name4 , tv_cnt1 , tv_cnt2 , tv_cnt3 , tv_cnt4;
    //Button btn_order1 , btn_order2 , btn_order3 , btn_order4 ;

   // int cola =1000, cider=1100 , fanta=1200 , sol=1300 ;
  //  int cntCola=10 , cntCider=11, cntFanta=12,cntSol=13;

    int userMoney = 999999999;
    ArrayList<DrinkDTO> list = new ArrayList<>();

    ArrayList<ViewHolder> viewList = new ArrayList<>();
    //ArrayList<TextView> nameList = new ArrayList<>();
    //ArrayList<TextView> cntList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        list.add(new DrinkDTO("콜라" , 1000 , 10));
        list.add(new DrinkDTO("사이다" , 1100 , 11));
        list.add(new DrinkDTO("환타" , 1200 , 12));
        list.add(new DrinkDTO("솔" , 1300 , 13));
        //ViewHolder를 하나 객체 생성해보기(인스턴스화) 초기화 ( viewList에 있는 버튼들에 각각 온클릭이벤트 연결)
        //int id = R.id.tv_name1;//int<= findViewById(View)
        viewList.add(new ViewHolder(findViewById(R.id.tv_name1) , findViewById(R.id.tv_cnt1) , findViewById(R.id.btn_order1)));//
        viewList.add(new ViewHolder(findViewById(R.id.tv_name2) , findViewById(R.id.tv_cnt2) , findViewById(R.id.btn_order2)));//
        viewList.add(new ViewHolder(findViewById(R.id.tv_name3) , findViewById(R.id.tv_cnt3) , findViewById(R.id.btn_order3)));//
        viewList.add(new ViewHolder(findViewById(R.id.tv_name4) , findViewById(R.id.tv_cnt4) , findViewById(R.id.btn_order4)));//


        for (int i = 0; i < viewList.size(); i++) {// 0 < N-1 , 0~3(4-1)
            final int idx = i;
            viewList.get(i).getBtn_order().setOnClickListener(v->{
                viewList.get(idx).getTv_cnt().setText("aaaaaa");//?
            });
        }

        for (int i = 0; i < viewList.size(); i++) {// 0 < N-1 , 0~3(4-1)
            final int idx = i;
            viewList.get(i).getBtn_order().setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    viewList.get(idx).getTv_cnt().setText("aaaaaa");
                }
            });
        }

//        nameList.add(findViewById(R.id.tv_name1));
//        nameList.add(findViewById(R.id.tv_name2));
//        nameList.add(findViewById(R.id.tv_name3));
//        nameList.add(findViewById(R.id.tv_name4));
//
//        cntList.add(findViewById(R.id.tv_cnt1));
//        cntList.add(findViewById(R.id.tv_cnt2));
//        cntList.add(findViewById(R.id.tv_cnt3));
//        cntList.add(findViewById(R.id.tv_cnt4));
        // tv_name1~4<= 현재 각각 흩어져있는 텍스트뷰들을 하나의 ArrayList로 묶어보기.
        //tv_name1 = findViewById(R.id.tv_name1);
        //tv_name2 = findViewById(R.id.tv_name2);
        //tv_name3 = findViewById(R.id.tv_name3);
        //tv_name4 = findViewById(R.id.tv_name4);

        // tv_cnt1~4<= 현재 각각 흩어져있는 텍스트뷰들을 하나의 ArrayList로 묶어보기.
        //v_cnt1 = findViewById(R.id.tv_cnt1);
        //v_cnt2 = findViewById(R.id.tv_cnt2);
        //v_cnt3 = findViewById(R.id.tv_cnt3);
        //v_cnt4 = findViewById(R.id.tv_cnt4);


//        btn_order1 = findViewById(R.id.btn_order1);
//        btn_order2 = findViewById(R.id.btn_order2);
//        btn_order3 = findViewById(R.id.btn_order3);
//        btn_order4 = findViewById(R.id.btn_order4);
//
//        btn_order1.setOnClickListener(new KymOnClickListener(0));
//        btn_order2.setOnClickListener(new KymOnClickListener(1));
//        btn_order3.setOnClickListener(new KymOnClickListener(2));
//        btn_order4.setOnClickListener(new KymOnClickListener(3));

    }

    public void setTextMethod(TextView tv){
        tv.setText("ㅎㅇ");
    }

    public interface Test{
        public int idx =0;//인터페이스에서 변수의 규칙 ( 변수는 반드시 final로 변하지 않을것 )

    }

    //list<=데이터를 묶어놓은 자료구조 ( 버튼 1번이 눌렸을때는 자료구조의 인덱스 0번 주소값 )=>(2=>1)
//    public class KymOnClickListener implements View.OnClickListener {
//        private int index ;
//        public KymOnClickListener(int index) {
//            this.index = index;
//        }
//        @Override
//        public void onClick(View v) {
//           userMoney -= list.get(index).getPrice(); //기존금액 = 기존금액 - 콜라
//           list.get(index).setCnt(list.get(index).getCnt()-1);
//           nameList.get(index).setText(list.get(index).getName() + "(" + list.get(index).getPrice() + ") 원 ");
//           cntList.get(index).setText(list.get(index).getCnt()+"개 남음");
//        }
//    }


//    @Override
//    public void onClick(View v) {
//        if(v.getId() == R.id.btn_order1){
//            //개수차감 , 금액차감(사용자) , 디자인 처리
//            userMoney -= list.get(0).getPrice(); //기존금액 = 기존금액 - 콜라
//            list.get(0).setCnt(list.get(1).getCnt()-1);
//            tv_name1.setText("콜라(" + list.get(0).getPrice() + ") 원 ");
//            tv_cnt1.setText(list.get(0).getCnt()+"개 남음");
//        }
//    }
}