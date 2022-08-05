package com.DGakademi.simpleloginapp.Adapter;

public class FactoryList {

    private final Integer factoryIcon;
    private final String factoryName;
    private final String producedDoor;
    private final String producedEngines;
    private final String producedWheels;

    public FactoryList(Integer factoryIcon,
                       String factoryName,
                       String producedDoor,
                       String producedEngines,
                       String producedWheels){
        this.factoryIcon = factoryIcon;
        this.factoryName = factoryName;
        this.producedDoor = producedDoor;
        this.producedEngines = producedEngines;
        this.producedWheels = producedWheels;
    }

    public Integer getFactoryIcon() {
        return factoryIcon;
    }

    public String getFactoryName() {
        return factoryName;
    }

    public String getProducedDoors() {
        return producedDoor;
    }

    public String getProducedEngines() {
        return producedEngines;
    }

    public String getProducedWheels() {
        return producedWheels;
    }
}
