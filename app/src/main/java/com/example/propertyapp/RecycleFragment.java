package com.example.propertyapp;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link RecycleFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class RecycleFragment extends Fragment implements MyAdapter.ItemClickListner  {

    List<Item> items= new ArrayList<Item>();
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public RecycleFragment() {
        // Required empty public constructor
    }


    public static RecycleFragment newInstance() {
        RecycleFragment fragment = new RecycleFragment();
//        Bundle args = new Bundle();
//        args.putString(ARG_PARAM1, param1);
//        args.putString(ARG_PARAM2, param2);
//        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =inflater.inflate(R.layout.fragment_recycle, container, false);
        buidListData();



        initRecycleView(view);
        return view;
    }

    private void initRecycleView (View view){
        RecyclerView recyclerView=view.findViewById(R.id.recycleview);
        LinearLayoutManager layoutManager= new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);

        MyAdapter adapter= new MyAdapter(getContext(),items, this );
        recyclerView.setAdapter(adapter);

    }

    private void buidListData (){
        items.add(new Item("360 ","Peater point Road, ","Cairns ","4870","$2300"));
        items.add(new Item("250 ","Shahid St, ","Cairns ","4870","$350000"));

        Bundle bundle = getArguments();


        System.out.println("address_bun"+bundle);
        if(bundle!=null){
            String addresss = bundle.getString("mAddress");
//            System.out.println("address_bun"+addressBun);
//            items.add(new Item(addressBun,"Shahid St, ","Cairns ","4870","$350000"));
        }
//
    }


    @Override
    public void onItemClick(Item item) {
        Fragment fragment= DetailFragment.newInstance(item.getAddress(), item.getSuburb(), item.getState(), item.getPostcode(), item.getPrice());

        FragmentTransaction transaction= getActivity().getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frame_container,fragment);
        transaction.commit();
    }
}