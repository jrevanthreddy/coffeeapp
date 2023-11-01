package com.example.coffeeapp;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.coffeeapp.adapter.MyCustomAdapter;
import com.example.coffeeapp.model.Coffee;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        TextView textView = view.findViewById(R.id.cappuccino);
        TextView textView1 = view.findViewById(R.id.latte);
        TextView textView2 = view.findViewById(R.id.americano);
        TextView textView3 = view.findViewById(R.id.espresso);
        TextView textView4 = view.findViewById(R.id.flatwhite);

        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "Cappuccino", Toast.LENGTH_SHORT).show();
            }
        });
        textView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "Latte", Toast.LENGTH_SHORT).show();
            }
        });
        textView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "Americano", Toast.LENGTH_SHORT).show();
            }
        });
        textView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "Espresso", Toast.LENGTH_SHORT).show();
            }
        });
        textView4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "Flatwhite", Toast.LENGTH_SHORT).show();
            }
        });

        GridView gridView = view.findViewById(R.id.grid_view1);
        List<Coffee> coffeeList = new ArrayList<>();

        Coffee coffee = new Coffee(R.drawable.coffee01,"4.5","Capuccino","₹99");
        Coffee coffee1 = new Coffee(R.drawable.coffee03,"4.2","Capuccino","₹199");
        Coffee coffee2 = new Coffee(R.drawable.coffee9,"4.3","Capuccino","₹299");
        Coffee coffee3 = new Coffee(R.drawable.coffee03,"4.1","Capuccino","₹159");
        Coffee coffee4 = new Coffee(R.drawable.coffee9,"3.5","Capuccino","₹189");
        Coffee coffee5 = new Coffee(R.drawable.coffee03,"3.2","Capuccino","₹399");
        Coffee coffee6 = new Coffee(R.drawable.coffee9,"4.7","Capuccino","₹99");
        Coffee coffee7 = new Coffee(R.drawable.coffee03,"4.5","Capuccino","₹399");
        Coffee coffee8 = new Coffee(R.drawable.coffee9,"3.9","Capuccino","₹299");


        coffeeList.add(coffee);
        coffeeList.add(coffee1);
        coffeeList.add(coffee2);
        coffeeList.add(coffee3);
        coffeeList.add(coffee4);
        coffeeList.add(coffee5);
        coffeeList.add(coffee6);
        coffeeList.add(coffee7);
        coffeeList.add(coffee8);

        MyCustomAdapter myCustomAdapter = new MyCustomAdapter(coffeeList, getContext());
        gridView.setAdapter(myCustomAdapter);
        return view;
    }
}