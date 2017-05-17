package com.sg.D6ClassModeling;

public class HouseGPS {
    private double latitude;
    private double longitude;
    private String typeOfDwelling;
    private Address address;
    
    public HouseGPS(double latitude, double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }
    
    public double getLatitude(){
        return this.latitude;
    }
    public void setLatitude(double latitude){
        this.latitude = latitude;
    }
    public double getLongitude(){
        return this.longitude;
    }
    public void setLongitude(double longitude){
        this.longitude = longitude;
    }
    public String getTypeOfDwelling(){
        return this.typeOfDwelling;
    }
    public void setTypeOfDwelling(String typeOfDwelling){
        this.typeOfDwelling = typeOfDwelling;
    }
    public Address getAddress(){
        return this.address;
    }
    public void setAddress(Address address){
        this.address = address;
    }
    
    public HouseGPS[] findNeighbors(int miles){
        // Will return any other houses in the database (??) within miles miles
    }
    public String getTimeZone(){
        // Will determine the time zone mathematically from lat & lon
        // if that's possible...
        return "GMT";
    }
}