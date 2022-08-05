package com.DGakademi.simpleloginapp.views;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.DGakademi.simpleloginapp.Adapter.ListViewAdapter;
import com.DGakademi.simpleloginapp.Adapter.FactoryList;
import com.DGakademi.simpleloginapp.R;
import com.DGakademi.simpleloginapp.models.Audi;
import com.DGakademi.simpleloginapp.models.BMW;
import com.DGakademi.simpleloginapp.models.Mercedes;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.ArrayList;

public class WelcomePageActivity<signOutUser> extends AppCompatActivity {
    BMW bmw = new BMW();
    Mercedes Mercedes = new Mercedes();
    Audi Audi = new Audi();

    private Button LogOut;
    private FirebaseAuth mAuth;

    private ArrayList<FactoryList> factoryLists;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_page);
        LogOut = findViewById(R.id.lOG_OUT);
        mAuth = FirebaseAuth.getInstance();


        LogOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mAuth.signOut();
                signOutUser();

            }
        });

        ListView listView = findViewById(R.id.listView);

        factoryLists = setFactories();

        ListViewAdapter listViewAdapter = new ListViewAdapter(WelcomePageActivity.this,factoryLists);
        listView.setAdapter(listViewAdapter);

    }
    private ArrayList<FactoryList> setFactories(){
        factoryLists = new ArrayList<>();

        factoryLists.add(new FactoryList(R.drawable.bmw, bmw.getFactoryName(), bmw.getProducedDoors(), bmw.getProducedEngines(), bmw.getProducedWheels()));
        factoryLists.add(new FactoryList(R.drawable.mercedes, Mercedes.getFactoryName(), Mercedes.getProducedDoors(), Mercedes.getProducedEngines(), Mercedes.getProducedWheels()));
        factoryLists.add(new FactoryList(R.drawable.audi, Audi.getFactoryName(), Audi.getProducedDoors(), Audi.getProducedEngines(), Audi.getProducedWheels()));

            return factoryLists;


    }
    private void signOutUser(){
        Intent logOut = new Intent(WelcomePageActivity.this, LogInActivity.class);
        logOut.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(logOut);
        finish();



    }


}