package com.example.clonecoding_discord.main.bottom_sheet;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.clonecoding_discord.databinding.ItemBottomSheetBinding;
import com.example.clonecoding_discord.main.admin.UserDTO;
import com.example.clonecoding_discord.vo.UserVO;

import java.util.ArrayList;

public class SheetAdapter extends RecyclerView.Adapter<SheetAdapter.ViewHolder> {
    ItemBottomSheetBinding binding;
    ArrayList<UserVO> list;
    Context context;

    public SheetAdapter(ArrayList<UserVO> list, Context context) {
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
        h.binding.imgvProfile.setImageResource(Integer.parseInt(list.get(i).getProfile_img()));
        h.binding.tvNickname.setText(list.get(i).getNick_name());
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