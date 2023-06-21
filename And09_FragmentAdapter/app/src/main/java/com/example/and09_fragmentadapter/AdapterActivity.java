package com.example.and09_fragmentadapter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ListView;

import com.example.and09_fragmentadapter.listv.ListFragment;

public class AdapterActivity extends AppCompatActivity {
//    ListView listv;
    Button btn_list, btn_grid, btn_recy,btn_practice;
    ListView container;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adapter);

        btn_list=findViewById(R.id.btn_list);
        btn_grid=findViewById(R.id.btn_grid);
        btn_recy=findViewById(R.id.btn_recy);
        btn_practice=findViewById(R.id.btn_practice);

        btn_list.setOnClickListener(v -> {
            getSupportFragmentManager().beginTransaction().replace(R.id.container, new ListFragment()).commit(); //여기 좀더 알아보기
        });


        //용도나 형태에 따라서 어댑터의 종류는 많음. 사용 빈도가 가장 낮은거는 오래된 방식. (Array형태로 String 넣는 방식)
        //ArrayAdapter (기본적으로 안드로이드에서 제공해주는 어댑터)

        //Context(맥락) : 현재 모든 앱의 상태, 그리고 화면에 떠있는 객체상태등 모든 상태를 알 수 있는 변수
        // 액티비티이냐 화면에 떠있는 객체 (상태)이냐를 묻는것이라고 판단을 하면 더 편함

        //ArrayAdapter(Context , 반복될 모양의 xml , 내용이 바뀌어야 한다면 사용될 데이터);
        //기본 템플릿:android.R.layout.simple_list_item_1
        //기본 템플릿으로는 모든 모양을 만들 수가 없음.Custom=> 이후 사용하게 됨.(Adapter)
//        String[] arrItem=new String[10];
//        for(int i=0;i<10;i++){
//            arrItem[i] ="JEP"+ UUID.randomUUID().toString();
//        }
//        ArrayAdapter adapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1,arrItem);
//
//
//        listv=findViewById(R.id.listv);
//        listv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                Log.d("리스트 뷰", "onItemClick: "+position);
//                //position을 활용해서 JEP UUID가 Toast메세지로 나오게 처리해보기
//                Toast.makeText(AdapterActivity.this, arrItem[position], Toast.LENGTH_SHORT).show();
//            }
//        });
//        listv.setAdapter(adapter);
    }

}