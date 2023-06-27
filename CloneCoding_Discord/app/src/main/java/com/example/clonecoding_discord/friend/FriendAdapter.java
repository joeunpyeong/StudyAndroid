package com.example.clonecoding_discord.friend;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

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
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ItemOnlineRecvBinding binding;
        public ViewHolder(@NonNull ItemOnlineRecvBinding binding) {
            super(binding.getRoot());
            this.binding=binding;
        }
    }
}
