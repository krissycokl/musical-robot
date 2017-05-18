package com.sg.D8StateCapitals;

public class Capital {
    private final String NAME;
    private int population;
    private double area;

    public Capital(String name, double area, int population){
        this.NAME = name;
        this.population = population;
        this.area = area;
    }
    
    public String getName() {
        return NAME;
    }
    
    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }
    
    
}
