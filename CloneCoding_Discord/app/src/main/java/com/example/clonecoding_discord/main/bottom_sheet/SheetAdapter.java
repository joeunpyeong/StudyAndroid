package com.example.clonecoding_discord.main.bottom_sheet;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.clonecoding_discord.databinding.ItemBottomSheetBinding;
import com.example.clonecoding_discord.main.friend.FriendAdapter;
import com.example.clonecoding_discord.main.friend.FriendDTO;

import java.util.ArrayList;

public class SheetAdapter extends RecyclerView.Adapter<SheetAdapter.ViewHolder> {
    ItemBottomSheetBinding binding;
    ArrayList<FriendDTO> list;
    Context context;

    public SheetAdapter(ArrayList<FriendDTO> list, Context context) {
        this.list=list;
        this.context=context;
    }

    @NonNull
    @Override
    public SheetAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext())  ;
        binding = ItemBottomSheetBinding.inflate( inflater , parent , false );
        return new SheetAdapter.ViewHolder(binding);
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
        ItemBottomSheetBinding binding;
        public ViewHolder(@NonNull ItemBottomSheetBinding binding) {
            super(binding.getRoot());
            this.binding=binding;
        }
    }
}