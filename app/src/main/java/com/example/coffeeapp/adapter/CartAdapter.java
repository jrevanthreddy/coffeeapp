package com.example.coffeeapp.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.coffeeapp.R;
import com.example.coffeeapp.model.Cart;

import java.util.List;

public class CartAdapter extends RecyclerView.Adapter<CartAdapter.CartViewHolder> {

    private List<Cart> cartList;
    public CartAdapter(List<Cart> cartList) {
        this.cartList = cartList;
    }

    @NonNull
    @Override
    public CartAdapter.CartViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_item,parent,false);
        return new CartViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CartAdapter.CartViewHolder holder, int position) {
        Cart cart = cartList.get(position);

        holder.name.setText(cart.getName());
        holder.desc.setText(cart.getDesc());
        holder.price.setText(cart.getPrice());
        holder.imageView.setImageResource(cart.getImage());
    }

    @Override
    public int getItemCount() {
        return cartList.size();
    }
    public static class CartViewHolder extends RecyclerView.ViewHolder {

        TextView name,desc,price;
        ImageView imageView;

        public CartViewHolder(@NonNull View itemView) {
            super(itemView);

            name  = itemView.findViewById(R.id.name_cart);
            desc = itemView.findViewById(R.id.desc_cart);
            price = itemView.findViewById(R.id.price_cart);
            imageView = itemView.findViewById(R.id.image_cart);
        }
    }
}
