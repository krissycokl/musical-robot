package com.sg.ClassModeling;

public class AirplaneFlightSim {
    
    private final int   id;
    private int         numWheels;
    private double      mass;
    private double[]    dimensions;
    private String      engineType;
    private String      color;
    
    public AirplaneFlightSim(int id){
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public int getNumWheels() {
        return numWheels;
    }

    public void setNumWheels(int numWheels) {
        this.numWheels = numWheels;
    }

    public double getMass() {
        return mass;
    }

    public void setMass(double mass) {
        this.mass = mass;
    }

    public double[] getDimensions() {
        return dimensions;
    }

    public void setDimensions(double[] dimensions) {
        this.dimensions = dimensions;
    }

    public String getEngineType() {
        return engineType;
    }

    public void setEngineType(String engineType) {
        this.engineType = engineType;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
