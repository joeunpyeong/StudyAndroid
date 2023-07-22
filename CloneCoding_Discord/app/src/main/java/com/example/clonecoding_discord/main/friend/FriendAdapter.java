package com.example.clonecoding_discord.main.friend;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.clonecoding_discord.databinding.ItemOnlineRecvBinding;
import com.example.clonecoding_discord.vo.UserVO;

import java.util.ArrayList;

public class FriendAdapter extends RecyclerView.Adapter<FriendAdapter.ViewHolder>{

        ItemOnlineRecvBinding binding;
    ArrayList<UserVO> list;
    Context context;

    public FriendAdapter(ArrayList<UserVO> list) {
        this.list=list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        ItemOnlineRecvBinding binding = ItemOnlineRecvBinding.inflate(LayoutInflater.from(parent.getContext()) , parent,false );
        return new FriendAdapter.ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder h, int i) {
//        h.binding.imgvProfile.setImageDrawable(list.get(i).getProfile_img());
        h.binding.tvNickname.setText(list.get(i).getNick_name());
    }

    @Override
    public int getItemCount() {
        if(list == null) {
            return 0;
        } else {
            return list.size();
        }
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ItemOnlineRecvBinding binding;
        public ViewHolder(@NonNull ItemOnlineRecvBinding binding) {
            super(binding.getRoot());
            this.binding=binding;
        }
    }
}
