package com.sg.D8ShapesAndPerimeters;

public class Rectangle extends Shape{
    public double area(double w, double l){
        return w*l;
    }
    
    public double perimeter(double w, double l){
        return 2*(w+l);
    }
}
