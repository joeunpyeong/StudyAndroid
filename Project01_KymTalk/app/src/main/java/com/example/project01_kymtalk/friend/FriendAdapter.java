package com.example.project01_kymtalk.friend;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.project01_kymtalk.databinding.ItemFriendRecvBinding;

//2.만들어둔 뷰홀도를 이용해서 어댑터 상속받기
public class FriendAdapter extends RecyclerView.Adapter<FriendAdapter.ViewHolder> {

    ItemFriendRecvBinding binding;
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //LayoutInflater inflater = (LayoutInflater) parent.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        binding= ItemFriendRecvBinding.inflate(inflater,parent,false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 10;
    }

    //1.위젯들을 묶어서 저장해놓을 객체 ViewHolder
    public class ViewHolder extends RecyclerView.ViewHolder{

        ItemFriendRecvBinding binding;
        public ViewHolder(@NonNull ItemFriendRecvBinding binding) {
            super(binding.getRoot());
            this.binding=binding;
        }
    }



}
