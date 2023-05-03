package com.android.optimaldistributionrelationalsystem.sara;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.android.optimaldistributionrelationalsystem.R;

import java.util.ArrayList;

public class OrderAdapter extends RecyclerView.Adapter<OrderAdapter.viewHolder> {
    ArrayList<orderitem> plist;

    Context context;
    itemClickListener itemClickListener;



    public OrderAdapter(ArrayList<orderitem> plist, Context context,itemClickListener itemClickListener){
        this.plist=plist;
        this.context=context;
        this.itemClickListener =itemClickListener;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.activity_order_item,parent,false);
        return new viewHolder(view,itemClickListener);
    }

    @Override
    public void onBindViewHolder(@NonNull OrderAdapter.viewHolder holder, int position) {
        final orderitem items=plist.get(position);
        holder.ordimg.setImageResource(items.getOrdimg());
        holder.price.setText(items.getPrice());
        holder.name.setText(items.getName());
        holder.add.setText(items.getAdd());
        holder.quantity.setText(items.getQuantity());
        holder.store.setText(items.getStore());







    }

    @Override
    public int getItemCount() {
        return plist.size();
    }

    public static class viewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        itemClickListener itemClickListener;
        ImageView ordimg;

        TextView name,quantity,price,store,add;
        Button button;

        public viewHolder(@NonNull View itemView,itemClickListener itemClickListener) {
            super(itemView);

            ordimg=itemView.findViewById(R.id.imageorder);
            name=itemView.findViewById(R.id.ordername);
            add=itemView.findViewById(R.id.add);
            quantity=itemView.findViewById(R.id.quantity);
            price=itemView.findViewById(R.id.priceorder);
            store=itemView.findViewById(R.id.storecode);
            button=itemView.findViewById(R.id.bu);
            this.itemClickListener = itemClickListener;
            button.setOnClickListener(this);
            // itemView.setOnClickListener(this);

        }

        @Override
        public void onClick(View view) {
            itemClickListener.onItemClik(view);
        }
    }
    public interface itemClickListener{
        void onItemClik(View view);
    }
}