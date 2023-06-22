package com.example.and09_fragmentadapter.recycler;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.and09_fragmentadapter.R;

import java.util.ArrayList;
import java.util.Random;

public class RecyclerFragment extends Fragment {
    RecyclerView recv;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_recycler, container, false);
        // Context : 현재 앱의 모든 상태와 외부의 리소스 등에 접근하는 모든 기능들을 의미함.
        //※안드로이드 4대 컴포넌트는 모두 Context를 이용해서 만들어졌고 4대 컴포넌트들만 Context에 자유롭게 접근이 가능하다.※
        // 4대컴포넌트 <= Activity
        new NormalClass().testToast(getContext(), "프래그먼트이기때문에 get으로 받아옴 ");

        recv = v.findViewById(R.id.recv);
        ArrayList<RecvDTO> list = getList();
        recv.setAdapter(new AdapterRecv(inflater , list));
        recv.setLayoutManager(new LinearLayoutManager(getContext()));
        return v;
    }
    int[] imgs = {
            R.drawable.img1,
            R.drawable.img2,
            R.drawable.img3,
            R.drawable.img4,
            R.drawable.img5,
            R.drawable.img6
    };
    String[] genders = { "남" , "여"};
    ArrayList<RecvDTO> getList(){
        //데이터 10건을 포함하고있는 ArrayList만들기
        ArrayList<RecvDTO> list= new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(new RecvDTO(imgs[new Random().nextInt(imgs.length)] , i+new Random().nextInt(100)+1 , genders[new Random().nextInt(genders.length)]  , "김이름"+i , "농성동"+i));
        }
        return list;
    }


}