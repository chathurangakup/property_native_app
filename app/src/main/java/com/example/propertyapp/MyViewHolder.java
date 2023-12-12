package com.example.propertyapp;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MyViewHolder  extends RecyclerView.ViewHolder {
    TextView addressView,suburbView,stateView,postcodeView,priceView;
    public MyViewHolder(@NonNull View itemView) {
        super(itemView);
        addressView = itemView.findViewById(R.id.address);
        suburbView = itemView.findViewById(R.id.subrub);
        stateView = itemView.findViewById(R.id.state);
        postcodeView = itemView.findViewById(R.id.postcode);
        priceView = itemView.findViewById(R.id.price);
    }
}
