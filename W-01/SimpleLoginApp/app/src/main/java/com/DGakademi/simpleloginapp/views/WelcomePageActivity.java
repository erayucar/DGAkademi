package com.DGakademi.simpleloginapp.views;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.DGakademi.simpleloginapp.Adapter.CustomAdapter;
import com.DGakademi.simpleloginapp.Adapter.FactoryList;
import com.DGakademi.simpleloginapp.R;
import com.DGakademi.simpleloginapp.models.Audi;
import com.DGakademi.simpleloginapp.models.BMW;
import com.DGakademi.simpleloginapp.models.Mercedes;

import java.util.ArrayList;
import java.util.List;

public class WelcomePageActivity extends AppCompatActivity {
    BMW bmw = new BMW();
    Mercedes Mercedes = new Mercedes();
    Audi Audi = new Audi();
    private ArrayList<FactoryList> factoryLists;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_page);

        ListView listView = findViewById(R.id.listView);
        factoryLists = setFactories();
        CustomAdapter customAdapter = new CustomAdapter(WelcomePageActivity.this,factoryLists);
        listView.setAdapter(customAdapter);

    }
    private ArrayList<FactoryList> setFactories(){
        factoryLists = new ArrayList<>();

        factoryLists.add(new FactoryList(R.drawable.bmw, bmw.getFactoryName(), bmw.getProducedDoors(), bmw.getProducedEngines(), bmw.getProducedWheels()));
        factoryLists.add(new FactoryList(R.drawable.mercedes, Mercedes.getFactoryName(), Mercedes.getProducedDoors(), Mercedes.getProducedEngines(), Mercedes.getProducedWheels()));
        factoryLists.add(new FactoryList(R.drawable.audi, Audi.getFactoryName(), Audi.getProducedDoors(), Audi.getProducedEngines(), Audi.getProducedWheels()));

            return factoryLists;


    }


}