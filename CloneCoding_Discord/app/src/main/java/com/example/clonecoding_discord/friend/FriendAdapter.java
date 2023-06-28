package com.example.clonecoding_discord.friend;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.clonecoding_discord.admin.UserDTO;
import com.example.clonecoding_discord.databinding.ItemOnlineRecvBinding;

import java.util.ArrayList;

public class FriendAdapter extends RecyclerView.Adapter<FriendAdapter.ViewHolder>{

    ItemOnlineRecvBinding binding;
    ArrayList<FriendDTO> list;
    Context context;

    public FriendAdapter(ArrayList<FriendDTO> list, Context context) {
        this.list=list;
        this.context=context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext())  ;
        binding = ItemOnlineRecvBinding.inflate( inflater , parent , false );
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder h, int i) {
        h.binding.imgvProfile.setImageResource(list.get(i).getProfileImg());
        h.binding.tvNickname.setText(list.get(i).getUserNickName());
//        h.binding.lnOnlineFn.setOnLongClickListener(v -> {
//        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ItemOnlineRecvBinding binding;
        public ViewHolder(@NonNull ItemOnlineRecvBinding binding) {
            super(binding.getRoot());
            this.binding=binding;
        }
    }
}
