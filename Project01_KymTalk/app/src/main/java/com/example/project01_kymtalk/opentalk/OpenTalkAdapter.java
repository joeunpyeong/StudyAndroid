package com.example.project01_kymtalk.opentalk;

import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.project01_kymtalk.databinding.ItemFriendRecvBinding;
import com.example.project01_kymtalk.databinding.ItemRcv1Binding;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class OpenTalkAdapter extends RecyclerView.Adapter<OpenTalkAdapter.ViewHolder>{
    ItemRcv1Binding binding;

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
        ItemRcv1Binding binding;
        public ViewHolder(@NonNull ItemRcv1Binding binding) {
            super(binding.getRoot());
            this.binding=binding;
        }
    }
}
