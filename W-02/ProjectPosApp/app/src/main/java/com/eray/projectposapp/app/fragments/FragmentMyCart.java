package com.eray.projectposapp.app.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.eray.projectposapp.R;
import com.eray.projectposapp.app.Adapter.CartAdapter;
import com.eray.projectposapp.app.Adapter.ShopAdapter;
import com.eray.projectposapp.app.models.CartModel;

import java.util.ArrayList;
import java.util.List;

import javax.xml.namespace.QName;

public class FragmentMyCart extends Fragment {
    private List<CartModel> list;
    private CartAdapter cartAdapter;
    private RecyclerView recyclerView;


    public FragmentMyCart() {}


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_fragment_my_cart, container, false);
        recyclerView = view.findViewById(R.id.cart_recyc);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));




        return view;
    }


    private void setDatas(){
        Bundle bundle = this.getArguments();
        String name = getArguments().getString("name");
        String price = getArguments().getString("price");
        String image = getArguments().getString("image");

        recyclerView.setLayoutManager(new LinearLayoutManager(this.getContext()));
        list = new ArrayList<>();
        list.add(new CartModel(R.drawable.img_1, "Mac Pro ", "1150$"));
        list.add(new CartModel(R.drawable.img_2, "Sony Headphones ", "350$"));
        list.add(new CartModel(R.drawable.img_3, "Rode Mic", "550$"));

        recyclerView.setAdapter(cartAdapter);

    }

}