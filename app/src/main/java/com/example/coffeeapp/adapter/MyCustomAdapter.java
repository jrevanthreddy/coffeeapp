package com.example.coffeeapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.coffeeapp.R;
import com.example.coffeeapp.model.Coffee;

import java.util.List;

public class MyCustomAdapter extends BaseAdapter {

    List<Coffee> coffeeList;
    Context context;

    public MyCustomAdapter(List<Coffee> coffeeList, Context context) {
        this.coffeeList = coffeeList;
        this.context = context;
    }

    @Override
    public int getCount() {
        return coffeeList.size();
    }

    @Override
    public Object getItem(int position) {
        return coffeeList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null){
            LayoutInflater inflater = LayoutInflater.from(context);
            convertView = inflater.inflate(R.layout.grid_item,parent,false);
        }

        Coffee coffee = coffeeList.get(position);

        ImageView imageView = convertView.findViewById(R.id.image);
        TextView ratingTextView = convertView.findViewById(R.id.rating);
        TextView nameTextView = convertView.findViewById(R.id.name);
        TextView priceTextView = convertView.findViewById(R.id.price);

        imageView.setImageResource(coffee.getImage());
        nameTextView.setText(coffee.getName());
        ratingTextView.setText(coffee.getRating());
        priceTextView.setText(coffee.getPrice());

        return convertView;
    }
}
