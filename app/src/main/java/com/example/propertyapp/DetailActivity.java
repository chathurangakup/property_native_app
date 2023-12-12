package com.example.propertyapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class DetailActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);


        // Retrieve data from intent
        Intent intent = getIntent();
        String itemAddress = intent.getStringExtra("address");
        String itemSubrub = intent.getStringExtra("subrub");
        String itemState = intent.getStringExtra("state");
        String itemPostcode = intent.getStringExtra("postcode");
        String itemPrice = intent.getStringExtra("price");

         //Use the data to populate the views in the detail activity
        EditText itemAddressEditText = findViewById(R.id.address_display);
        EditText itemSubrubEditText  = findViewById(R.id.suburb_display);
        EditText itemStateEditText = findViewById(R.id.state_display);
        EditText itemPostcodeEditText  = findViewById(R.id.postcode_display);
        EditText itemPriceEditText = findViewById(R.id.price_display);
        Button new_property_btn = findViewById(R.id.new_property_btn);




        itemAddressEditText.setText(itemAddress);
        itemSubrubEditText.setText(itemSubrub);
        itemStateEditText.setText(itemState);
        itemPostcodeEditText.setText(itemPostcode);
        itemPriceEditText.setText(itemPrice);

        new_property_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Call method to handle button click
                onAddButtonClick(v);
            }
        });



    }

    // Method to handle button click
    public void onAddButtonClick(View view) {
        // Create an Intent to start the next activity
        Intent intent = new Intent(this, SaveActivity.class);

        // You can pass data to the next activity if needed
        // intent.putExtra("key", "value");

        // Start the next activity
        startActivity(intent);
    }
}
