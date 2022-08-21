package com.eray.projectposapp.app.views;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Button;

import com.eray.projectposapp.R;
import com.eray.projectposapp.app.fragments.FragmentMyCart;
import com.eray.projectposapp.app.fragments.HomeFragment;
import com.eray.projectposapp.app.models.CartModel;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class HomeActivity extends AppCompatActivity {
    private BottomNavigationView bottomNavigationView;
    private FragmentMyCart fragmentMyCart = new FragmentMyCart();
    private HomeFragment homeFragment = new HomeFragment();
    private Button addToCart;
    private CartModel cartModel;
    private int totalPrice;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        bottomNavigationView = findViewById(R.id.bottomnavigation);




        getSupportFragmentManager().beginTransaction().replace(R.id.container, homeFragment).commit();

        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.home:
                        getSupportFragmentManager().beginTransaction().replace(R.id.container,homeFragment ).commit();
                        return true;
                    case R.id.shopping_card:
                        getSupportFragmentManager().beginTransaction().replace(R.id.container, fragmentMyCart).commit();
                        return true;
                }


                return false;
            }
        });
    }



}