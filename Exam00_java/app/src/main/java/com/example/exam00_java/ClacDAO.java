package com.example.exam00_java;

import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

//계산용 DAO
public class ClacDAO {
    //클래스의 멤버는 크게 2가지 있다.
    int a, b;               //인스턴스
    private int c;          //인스턴스
    public int d;           //인스턴스
    static int e;           //스태틱
    private static int f;   //스태틱
    public static int g;    //스태틱

    public int getSum(int a, int b){
        return a+b;
    }
    public static int getSum(){
        return 0;
    }
    public class ChildClass{
        int fieldChild;
    }
    public static class StaticChildClass{
        int fieldChild1;
    }
    //지역변수 (메소드 내부에서 선언되어 사용되는 변수)

    public int method(){
        //지역화폐
        //외부에서 절대로 접근이 불가능하다. ==>return
        int num1=0;//지역 변수
        return num1;
    }

//    public void getSum(int a, int b, TextView tv1){
//        Log.d("두 수의 합(텍스트 뷰)","getSum: "+(a+b));
//        tv1.setText((a+b)+"");
//    }
//    public void getSum(int a, int b, Button btn1){
//        Log.d("두 수의 합(버튼)","getSum: "+(a+b));
//        btn1.setText((a+b)+"");
//    }

}
