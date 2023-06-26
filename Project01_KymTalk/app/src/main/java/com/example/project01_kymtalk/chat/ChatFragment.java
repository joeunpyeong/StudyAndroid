package com.example.project01_kymtalk.chat;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.project01_kymtalk.R;
import com.example.project01_kymtalk.databinding.FragmentChatBinding;
import com.example.project01_kymtalk.friend.FriendAdapter;
import com.example.project01_kymtalk.friend.FriendDTO;

import java.util.ArrayList;

public class ChatFragment extends Fragment {

    FragmentChatBinding binding ;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentChatBinding.inflate(inflater , container , false);

        binding.recvChat.setAdapter(new ChatAdapter(getList() , getContext() ));
        binding.recvChat.setLayoutManager(new LinearLayoutManager(getContext()));

        // Inflate the layout for this fragment
        return binding.getRoot();
    }
    public ArrayList<ChatDTO> getList(){
        ArrayList<ChatDTO> list = new ArrayList<>();
        list.add(new ChatDTO(R.drawable.friend_img1 , "이름 1" , "12"));
        list.add(new ChatDTO(R.drawable.friend_img2 , "이름 2" , "23"));
        list.add(new ChatDTO(R.drawable.friend_img3 , "이름 3" , "45"));
        list.add(new ChatDTO(R.drawable.friend_img4 , "이름 4" , "56"));
        list.add(new ChatDTO(R.drawable.friend_img5 , "이름 5" , "67"));
        list.add(new ChatDTO(R.drawable.friend_img6 , "이름 6" , "78"));
        list.add(new ChatDTO(R.drawable.friend_img7 , "이름 7" , "89"));
        list.add(new ChatDTO(R.drawable.friend_img8 , "이름 8" , "90"));
        return list;
    }
}