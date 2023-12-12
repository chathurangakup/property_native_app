package com.example.propertyapp;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyViewHolder>  {


    @NonNull
    Context context;
    List<Item> items;



    private ItemClickListner itemClickListner;
    public MyAdapter(@NonNull Context context, List<Item> items,ItemClickListner itemClickListner) {
        this.context = context;
        this.items = items;
        this.itemClickListner = itemClickListner;
    }




    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return  new MyViewHolder(LayoutInflater.from(context).inflate(R.layout.item_view,parent,false ));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        final Item currentItem = items.get(position);

        holder.addressView.setText(items.get(position).getAddress());
        holder.suburbView.setText(items.get(position).getSuburb());
        holder.stateView.setText(items.get(position).getState());
        holder.postcodeView.setText(items.get(position).getPostcode());
        holder.priceView.setText(items.get(position).getPrice());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle item click
                 //openDetailActivity(currentItem);
                 itemClickListner.onItemClick(items.get(position));
            }
        });
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    private void openDetailActivity(Item dataModel) {


        Application application = (Application) context.getApplicationContext();
        Intent intent = new Intent(context, DetailActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        intent.putExtra("address", dataModel.getAddress());
        intent.putExtra("subrub", dataModel.getSuburb());
        intent.putExtra("state", dataModel.getState());
        intent.putExtra("postcode", dataModel.getPostcode());
        intent.putExtra("price", dataModel.getPrice());
        application.startActivity(intent);

    }

    interface  ItemClickListner {
        public void onItemClick(Item item);
    }
}
