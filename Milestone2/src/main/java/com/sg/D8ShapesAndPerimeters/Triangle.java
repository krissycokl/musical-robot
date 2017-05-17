package com.sg.D8ShapesAndPerimeters;

public class Triangle extends Shape{
    public double area(double w, double l){
        return .5*w*l;
    }
    
    public double perimeter(double side1, double side2, double side3){
        return side1+side2+side3;
    }
}
