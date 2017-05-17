package com.sg.D8ShapesAndPerimeters;

public class Circle extends Shape {
    public double area(double radius){
        return radius*radius*Math.PI;
    }
    
    public double perimeter(double radius){
        return 2*radius*Math.PI;
    }
}
