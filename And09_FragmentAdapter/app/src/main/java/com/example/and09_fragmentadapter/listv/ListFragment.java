package com.example.and09_fragmentadapter.listv;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.and09_fragmentadapter.R;

import java.util.ArrayList;

public class ListFragment extends Fragment {
    ListView listv;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v =  inflater.inflate(R.layout.fragment_list, container, false) ;

        ArrayList<ListDTO> list = new ArrayList<>();
        list.add(new ListDTO(R.drawable.img1 , "캐릭터1" , "ㅎㅇ"));
        list.add(new ListDTO(R.drawable.img2 , "캐릭터2" , "ㅂㅂ"));
        list.add(new ListDTO(R.drawable.img3 , "캐릭터3" , "ㅎㅎㅎ"));
        list.add(new ListDTO(R.drawable.img4 , "캐릭터4" , "ㅎㅋ"));
        list.add(new ListDTO(R.drawable.img5 , "캐릭터15" , "ㅋㅋ"));
        list.add(new ListDTO(R.drawable.img1 , "캐릭터21" , "ㅎㅇ"));
        list.add(new ListDTO(R.drawable.img2 , "캐릭터22" , "ㅂㅂ"));
        list.add(new ListDTO(R.drawable.img3 , "캐릭터23" , "ㅎㅎㅎ"));
        list.add(new ListDTO(R.drawable.img4 , "캐릭터24" , "ㅎㅋ"));
        list.add(new ListDTO(R.drawable.img5 , "캐릭터215" , "ㅋㅋ"));

        listv = v.findViewById(R.id.listv);
        AdapterListView adapter = new AdapterListView(inflater , list);
        listv.setAdapter(adapter);


        return v;
    }
}