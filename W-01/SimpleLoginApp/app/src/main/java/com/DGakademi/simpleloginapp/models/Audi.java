package com.DGakademi.simpleloginapp.models;

import com.DGakademi.simpleloginapp.base.Factory;

public class Audi extends Factory {
    private int Anumberofdoors = 5;
    private int AnumberofEngines = 1;
    private int AnumberofWheels = 4;


    @Override
    public String getFactoryName() {
        String Name = "Audi";
        return Name;
    }

    @Override
    public String getProducedDoors() {
        String door = String.valueOf(Anumberofdoors);
        return door;
    }

    @Override
    public String getProducedEngines() {
        String engines = String.valueOf(AnumberofEngines);
        return engines;
    }

    @Override
    public String getProducedWheels() {
        String wheels = String.valueOf(AnumberofWheels);
        return wheels;
    }



}
