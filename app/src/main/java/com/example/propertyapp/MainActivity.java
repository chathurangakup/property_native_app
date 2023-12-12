package com.example.propertyapp;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActionBar actionBar = getSupportActionBar();

        // Customize the back button

        // showing the back button in action bar
//        actionBar.setDisplayHomeAsUpEnabled(true);
//        Intent intent = getIntent();
//        String itemAddress = intent.getStringExtra("address_save");
//        String itemSubrub = intent.getStringExtra("subrub");
//        String itemState = intent.getStringExtra("state");
//        String itemPostcode = intent.getStringExtra("postcode");
//        String itemPrice = intent.getStringExtra("price");
//
//        getSupportActionBar().setTitle("Property Shop");


//        RecyclerView recyclerView= findViewById(R.id.recycleview);
//
//        List<Item> items= new ArrayList<Item>();
//        items.add(new Item("No23","kandy road,","ddddd","12000","$2300"));
//        System.out.println("itemAddress"+itemAddress);
//        if(itemAddress!=null){
//            items.add(new Item(itemAddress,itemSubrub,itemState,itemPostcode,"$"+itemPrice));
//        }
//        System.out.println("items"+items);
//        recyclerView.setLayoutManager(new LinearLayoutManager(this));
//        recyclerView.setAdapter(new MyAdapter(getApplicationContext(),items));

        Fragment fragment = RecycleFragment.newInstance();
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frame_container,fragment,"main_fragment");
        transaction.commit();

    }
}