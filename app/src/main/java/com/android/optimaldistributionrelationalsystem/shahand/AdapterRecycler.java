package com.android.optimaldistributionrelationalsystem.shahand;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.android.optimaldistributionrelationalsystem.databinding.RecycleItemBinding;
import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class AdapterRecycler extends RecyclerView.Adapter<AdapterRecycler.Holder> {

    private ArrayList<DataModel> list;

    @SuppressLint("NotifyDataSetChanged")
    public void setList(ArrayList<DataModel> list,int pos) {
        this.list = list;
        notifyItemChanged(pos);
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        RecycleItemBinding binding = RecycleItemBinding.inflate(LayoutInflater.from(parent.getContext()),
                parent, false);
        return new Holder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {

        DataModel dataModel = list.get(position);

        //here we use glide library to show image
        Glide.with(holder.itemView.getContext())
                .load(dataModel.getAvatar())
                .into(holder.binding.imageView);

        holder.binding.materialButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //here put what the button doing
            }
        });
    }

    @Override
    public int getItemCount() {
        return list == null ?0 : list.size();
    }

    static class Holder extends RecyclerView.ViewHolder {

        RecycleItemBinding binding;

        public Holder(RecycleItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
