package com.sg.D6ClassModeling;

public class AirplaneATC {
    private double[]    position;
    private double[]    heading;
    private double      velocity;
    private String      airline;
    private String      planeID;
    
    public AirplaneATC(String planeID, String airline){
        this.planeID = planeID;
        this.airline = airline;
    }
    
    public static double calcDistane(AirplaneATC plane1, AirplaneATC plane2){
        // calculate distance between two planes
    }
    
    public double calcETA(double coords){
        // calculate time remaining to destination
    }

    public double[] getPosition() {
        return position;
    }

    public void setPosition(double[] position) {
        this.position = position;
    }

    public double[] getHeading() {
        return heading;
    }

    public void setHeading(double[] heading) {
        this.heading = heading;
    }

    public double getVelocity() {
        return velocity;
    }

    public void setVelocity(double velocity) {
        this.velocity = velocity;
    }

    public String getAirline() {
        return airline;
    }

    public String getPlaneID() {
        return planeID;
    }
    
}
