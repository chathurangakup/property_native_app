package com.example.propertyapp;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.ActionBar;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link DetailFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class DetailFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_ADDRESS = "address";
    private static final String ARG_SUBRUB= "subrub";
    private static final String ARG_STATE= "state";
    private static final String ARG_POSTCODE= "postcode";
    private static final String ARG_PRICE= "price";

    // TODO: Rename and change types of parameters
    private String address;
    private String subrub;
    private String state;
    private String postcode;
    private String price;

    public DetailFragment() {
        // Required empty public constructor
    }


    // TODO: Rename and change types and number of parameters
    public static DetailFragment newInstance(String address, String subrub, String state, String postcode, String price) {
        DetailFragment fragment = new DetailFragment();
        Bundle args = new Bundle();
        args.putString(ARG_ADDRESS, address);
        args.putString(ARG_SUBRUB, subrub);
        args.putString(ARG_STATE, state);
        args.putString(ARG_POSTCODE, postcode);
        args.putString(ARG_PRICE, price);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            address = getArguments().getString(ARG_ADDRESS);
            subrub = getArguments().getString(ARG_SUBRUB);
            state = getArguments().getString(ARG_STATE);
            postcode = getArguments().getString(ARG_POSTCODE);
            price = getArguments().getString(ARG_PRICE);
        }


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_detail, container, false);
        EditText addressFreg = view.findViewById(R.id.address_display_freg);
        addressFreg.setText(address);
        EditText subrubFreg = view.findViewById(R.id.suburb_display_freg);
        subrubFreg.setText(subrub);
        EditText stateFreg = view.findViewById(R.id.state_display_freg);
        stateFreg.setText(state);
        EditText postcodeFreg = view.findViewById(R.id.postcode_display_freg);
        postcodeFreg.setText(postcode);
        EditText priceFreg = view.findViewById(R.id.price_display_freg);
        priceFreg.setText(price);
        Button new_property_btn = view.findViewById(R.id.new_property_btn_freg);
        new_property_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Call method to handle button click
                onAddButtonClick(v);
            }
        });
        return view;
    }

    public void onAddButtonClick(View view) {
        // Create an Intent to start the next activity
        Intent intent = new Intent(getContext(), SaveActivity.class);

        // You can pass data to the next activity if needed
        // intent.putExtra("key", "value");

        // Start the next activity
        startActivity(intent);
    }
}