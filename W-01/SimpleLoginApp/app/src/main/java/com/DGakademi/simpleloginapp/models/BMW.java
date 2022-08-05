package com.DGakademi.simpleloginapp.models;

import com.DGakademi.simpleloginapp.base.Factory;

public class BMW extends Factory {
   private int Bnumberofdoors = 2;
   private int BnumberofEngines = 2;
   private int BnumberofWheels = 6;


    @Override
    public String getFactoryName() {
        String Name = "BMW";
        return Name;
    }

    @Override
    public String getProducedDoors() {
        String door =String.valueOf(Bnumberofdoors);
        return door;
    }

    @Override
    public String getProducedEngines() {
        String engines =String.valueOf(BnumberofEngines);
        return engines;
    }

    @Override
    public String getProducedWheels() {

        String wheels =String.valueOf(BnumberofWheels);
        return wheels;
    }

}

