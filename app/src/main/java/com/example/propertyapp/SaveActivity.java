package com.example.propertyapp;

import android.app.Application;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class SaveActivity extends AppCompatActivity {

    String address_val = "";
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.save_details);


        final androidx.fragment.app
                .FragmentManager mFragmentManager
                = getSupportFragmentManager();
        final androidx.fragment.app
                .FragmentTransaction mFragmentTransaction
                = mFragmentManager.beginTransaction();
        final RecycleFragment mFragment
                = new RecycleFragment();



        EditText itemAddressEditText = findViewById(R.id.sve_address_display);
        EditText itemSubrubEditText  = findViewById(R.id.sve_suburb_display);
        EditText itemStateEditText  = findViewById(R.id.sve_state_display);
        EditText itemPostCodeEditText  = findViewById(R.id.sve_postcode_display);
        EditText itemPriceEditText  = findViewById(R.id.sve_price_display);
        Button sveBtn = findViewById(R.id.sve_btn);

        sveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Call method to perform action
                String addressInput = itemAddressEditText.getText().toString().trim();
                String subrubInput = itemSubrubEditText.getText().toString().trim();
                String stateInput = itemStateEditText.getText().toString().trim();
                String postCodeInput = itemPostCodeEditText.getText().toString().trim();
                String priceInput =itemPriceEditText.getText().toString();
                if (addressInput.isEmpty() || subrubInput.isEmpty()) {
                    showToastMessage("Please enter address or suburb.");
                }else if(!priceInput.isEmpty()){
                    if(Integer.parseInt(priceInput)<1000){
                        showToastMessage("Please enter more than 1000 value");
                    }else{

                        Bundle mBundle = new Bundle();
                        mBundle.putString(
                                "mAddress",
                                addressInput);
                        mFragment.setArguments(mBundle);
//                        mFragmentTransaction
//                                .add(R.id.recycleview, mFragment)
//                                .commit();


//                        Application application = (Application) getApplicationContext();
//                        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
//                        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
//                        intent.putExtra("address_save", addressInput);
//
//
//
//
//                        address_val = addressInput;
//                        intent.putExtra("subrub", subrubInput);
//                        intent.putExtra("state", stateInput);
//                        intent.putExtra("postcode", postCodeInput);
//                        intent.putExtra("price", priceInput);
//                        application.startActivity(intent);

                    }
                }
            }
        });


    }

    public String getMyAddress() {
        return address_val;
    }

    private void showToastMessage(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}
