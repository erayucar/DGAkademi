package com.eray.projectposapp.app.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.eray.projectposapp.R;
import com.eray.projectposapp.app.Adapter.ShopAdapter;
import com.eray.projectposapp.app.models.CartModel;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {
    private List<CartModel> list;
    private ShopAdapter shopAdapter;
    private RecyclerView recyclerView;
    private GridLayoutManager gridLayoutManager;
    private Button addToCart;
    private ImageView imageINC, imageDEC;
    private TextView textQuantity;
    private CartModel cartModel;
    private int quantity;


    public HomeFragment() {
    }



    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        recyclerView = view.findViewById(R.id.shop_recy);

        addToCart = view.findViewById(R.id.add_to_cart);

        setDatas();







        /* addToCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle();
                bundle.putInt("key", list.get();
            }
        }); */



        return view;
    }



private void sendDataToFragment(){
        Fragment frag = new FragmentMyCart();
        Bundle bundle = new Bundle();
        String name = cartModel.getName();
    System.out.println(name);
        String image = cartModel.getStringImage();
    String price = cartModel.getPrice();

        bundle.putString("name", name);
        bundle.putString("image", image);
        bundle.putString("quantity", price);
        frag.setArguments(bundle);




}




    private void setDatas(){
        gridLayoutManager = new GridLayoutManager(getContext(),2);
        recyclerView.setLayoutManager(gridLayoutManager);
        list = new ArrayList<>();
        list.add(new CartModel(R.drawable.img, "DSLR Camera", "150$"));
        list.add(new CartModel(R.drawable.img_1, "Mac Pro ", "1150$"));
        list.add(new CartModel(R.drawable.img_2, "Sony Headphones ", "350$"));
        list.add(new CartModel(R.drawable.img_3, "Rode Mic", "550$"));
        shopAdapter = new ShopAdapter(list);
        recyclerView.setAdapter(shopAdapter);

    }








}