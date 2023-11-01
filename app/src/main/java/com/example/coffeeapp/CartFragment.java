package com.example.coffeeapp;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.coffeeapp.adapter.CartAdapter;
import com.example.coffeeapp.model.Cart;
import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.List;

public class CartFragment extends Fragment {

    private RecyclerView recyclerView;

    CartAdapter cartAdapter;
    private List<Cart> cartList;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_cart,container,false);

        recyclerView = view.findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        ItemTouchHelper itemTouchHelper =new ItemTouchHelper(simpleCallback);
        itemTouchHelper.attachToRecyclerView(recyclerView);

        cartList = new ArrayList<>();

        Cart cart = new Cart(R.drawable.coffee01,"Cappuccino","Dakgona Macha","₹299");
        Cart cart1 = new Cart(R.drawable.coffee02,"Cappuccino","Bursting Blueberry","₹249");
        Cart cart2 = new Cart(R.drawable.coffee03,"Cappuccino","cinnamon & Cocoa","₹99");
        Cart cart3 = new Cart(R.drawable.coffee01,"Cappuccino","Dakgona Macha","₹299");


        cartList.add(cart);
        cartList.add(cart1);
        cartList.add(cart2);
        cartList.add(cart3);


        CartAdapter cartAdapter = new CartAdapter(cartList);
        recyclerView.setAdapter(cartAdapter);
        return view;


    }
    String deletedCart = null;
    ItemTouchHelper.SimpleCallback simpleCallback = new ItemTouchHelper.SimpleCallback(0,ItemTouchHelper.LEFT|ItemTouchHelper.RIGHT) {
        @Override
        public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
            return false;
        }

        @Override
        public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {

             int positioin = viewHolder.getAdapterPosition();
            switch (direction){
                case ItemTouchHelper.LEFT:
                    cartList.remove(positioin);
                    cartAdapter.notifyItemRemoved(positioin);
                    Snackbar.make(recyclerView,deletedCart,Snackbar.LENGTH_SHORT)
                            .setAction("undo", new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    cartList.add(positioin,cartList.get(positioin));
                                    cartAdapter.notifyItemInserted(positioin);
                                }
                            }).show();
                    break;
                case ItemTouchHelper.RIGHT:
                    break;
            }
        }
    };
}