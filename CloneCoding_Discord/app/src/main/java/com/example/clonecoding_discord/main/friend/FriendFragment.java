package com.example.clonecoding_discord.main.friend;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;

import com.example.clonecoding_discord.databinding.InviteBottomSheetBinding;
import com.example.clonecoding_discord.main.DoAddFriendActivity;
import com.example.clonecoding_discord.main.PermitFindFriendActivity;
import com.example.clonecoding_discord.R;
import com.example.clonecoding_discord.databinding.FragmentFriendBinding;
import com.example.clonecoding_discord.main.bottom_sheet.SheetAdapter;

import java.util.ArrayList;

public class FriendFragment extends Fragment {


    FragmentFriendBinding binding;

    ArrayList<FriendDTO> list = new ArrayList<>();
    FriendAdapter friendAdapter;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding= FragmentFriendBinding.inflate(inflater,container,false);

        friendAdapter = new FriendAdapter(getList(), getContext());
        binding.recvOnline.setAdapter(friendAdapter);
        binding.recvOnline.setLayoutManager(new LinearLayoutManager(getContext()));



        if (list.size()<=0){
            binding.noFraiend.setVisibility(View.VISIBLE);
            binding.haveFraiend.setVisibility(View.GONE);
        }else{
            binding.noFraiend.setVisibility(View.GONE);
            binding.haveFraiend.setVisibility(View.VISIBLE);
        }

        binding.imbFriendPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(requireContext(), DoAddFriendActivity.class);
                startActivity(intent);
                requireActivity().overridePendingTransition(R.anim.slide_up, 0);
            }
        });
        binding.imbSendMsg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog();
            }
        });

        binding.imbPermitFindFriend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(requireContext(), PermitFindFriendActivity.class);
                startActivity(intent);
                requireActivity().overridePendingTransition(R.anim.slide_up, 0);
            }
        });

        return binding.getRoot();
    }
    public ArrayList<FriendDTO> getList(){
        ArrayList<FriendDTO> list = new ArrayList<>();

        return list;
    }
    InviteBottomSheetBinding btm_biding;
    private void showDialog(){
        final Dialog dialog = new Dialog(getActivity());
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        btm_biding = InviteBottomSheetBinding.inflate(getLayoutInflater());
        dialog.setContentView(btm_biding.getRoot());

        btm_biding.recvFriend.setAdapter(new SheetAdapter(getList(),getContext()));

        btm_biding.recvFriend.setLayoutManager(new LinearLayoutManager(getContext()));
        dialog.show();
        dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
      //  dialog.getWindow().getAttributes().windowAnimations = R.style.DialoAnimation;
        dialog.getWindow().setGravity(Gravity.BOTTOM);

    }

}