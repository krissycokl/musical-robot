package com.sg.D8ShapesAndPerimeters;

public class Square extends Shape{
    public double area(double side){
        return side*side;
    }
    
    public double perimeter(double side){
        return 4*side;
    }
}
