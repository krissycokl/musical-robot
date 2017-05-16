package com.sg.ClassModeling;

public class House3D {
    private Room[] rooms;
    private double lotWidth;
    private double lotLength;
    private double driveWidth;
    private double driveLength;

    public Room[] getRooms() {
        return rooms;
    }

    public void setRooms(Room[] rooms) {
        this.rooms = rooms;
    }

    public double getLotWidth() {
        return lotWidth;
    }

    public void setLotWidth(double lotWidth) {
        this.lotWidth = lotWidth;
    }

    public double getLotLength() {
        return lotLength;
    }

    public void setLotLength(double lotLength) {
        this.lotLength = lotLength;
    }

    public double getDriveWidth() {
        return driveWidth;
    }

    public void setDriveWidth(double driveWidth) {
        this.driveWidth = driveWidth;
    }

    public double getDriveLength() {
        return driveLength;
    }

    public void setDriveLength(double driveLength) {
        this.driveLength = driveLength;
    }

    public String getRoofMaterial() {
        return roofMaterial;
    }

    public void setRoofMaterial(String roofMaterial) {
        this.roofMaterial = roofMaterial;
    }

    public String getExteriorWallMaterial() {
        return exteriorWallMaterial;
    }

    public void setExteriorWallMaterial(String exteriorWallMaterial) {
        this.exteriorWallMaterial = exteriorWallMaterial;
    }
    
    private String roofMaterial;
    private String exteriorWallMaterial;
    
    public House3D(int numRooms){
        this.rooms = new Room[numRooms];
    }
    
    public int numBathrooms(){
        // Counts number of bathrooms in rooms array
    }
    
    public int numBedrooms(){
        // Counts number of bedrooms in rooms array
    }
}
