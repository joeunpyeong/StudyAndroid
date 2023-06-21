package com.example.and09_fragmentadapter;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


//※ Fragment에서 제일 중요한 메소드 ? : onCreateView 메소드
//  Fragment를 만들고 나서 불필요한 코드가 많이 있음. 전부 다 지운다
public class HomeFragment extends Fragment {



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false);
    }
}