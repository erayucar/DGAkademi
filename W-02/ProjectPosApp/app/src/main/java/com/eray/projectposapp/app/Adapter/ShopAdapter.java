package com.eray.projectposapp.app.Adapter;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.eray.projectposapp.R;
import com.eray.projectposapp.app.models.CartModel;

import java.util.List;

public class ShopAdapter extends RecyclerView.Adapter<ShopAdapter.ViewHolder> {
    private ImageView imageINC, imageDEC;
    private TextView textQuantity;
    private int quantity;

    List<CartModel> list;
    public ShopAdapter(List<CartModel> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ShopAdapter.ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.shop_item,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.imageView.setImageResource(list.get(position).getImage());
        holder.name.setText(list.get(position).getName());
        holder.price.setText(list.get(position).getPrice());


        imageINC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String currentValue = textQuantity.getText().toString();
                quantity = Integer.parseInt(currentValue);
                quantity++;
                textQuantity.setText(String.valueOf(quantity));
            }
        });
        imageDEC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String currentValue = textQuantity.getText().toString();
                quantity = Integer.parseInt(currentValue);
                if (quantity != 0) {
                    quantity--;
                    textQuantity.setText(String.valueOf(quantity));
                }

            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView ;
        TextView name,price;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.Item_Image);
            name = itemView.findViewById(R.id.item_name);
            price = itemView.findViewById(R.id.price);
            imageINC = itemView.findViewById(R.id.inc_id);
            imageDEC = itemView.findViewById(R.id.dec_ic);
            textQuantity = itemView.findViewById(R.id.quantity);

        }
    }
}
