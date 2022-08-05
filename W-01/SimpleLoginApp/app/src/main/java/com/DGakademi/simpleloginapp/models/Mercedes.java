package com.DGakademi.simpleloginapp.models;

import com.DGakademi.simpleloginapp.base.Factory;

public class Mercedes extends Factory {

    private int Mnumberofdoors = 2;
    private int MnumberofEngines = 2;
    private int MnumberofWheels = 8;


    @Override
    public String getFactoryName() {
        String Name = "Mercedes";
        return Name;
    }

    @Override
    public String getProducedDoors() {
        String door =String.valueOf(Mnumberofdoors);
        return door;
    }

    @Override
    public String getProducedEngines() {
        String engines =String.valueOf(MnumberofEngines);
        return engines;
    }

    @Override
    public String getProducedWheels() {
        String wheels =String.valueOf(MnumberofWheels);
        return wheels;
    }

}
