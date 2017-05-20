package com.sg.m2dvdlibrary.ui;

import com.sg.m2dvdlibrary.dto.DVD;
import java.util.HashMap;

public class DVDView {

    private UserIO io;
    
    public DVDView(UserIO io){
        this.io = io;
    }
    
    public int getMenuImport(){
        io.print("\n~~~~~ Welcome to Your DVD Library ~~~~~");
        io.print("Do you want to import a library, or start a new one?");
        io.print("1.) Import");
        io.print("2.) New");
        io.print("3.) Exit");
        return io.getInt("",1,3);
    }
    
    public int getMenuMain(){
        io.print("\n~~~~~ Main Menu ~~~~~");
        io.print("1.) Add DVD");
        io.print("2.) Get DVD by name");
        io.print("3.) Browse all DVDs");
        io.print("4.) Exit and save changes");
        io.print("5.) Exit without saving");
        return io.getInt("What would you like to do?",1,5);
    }
    
    public int getMenuDVD(DVD dvd){
        io.print("   Title: "+dvd.getTitle());
        io.print("    Year: "+dvd.getYear());
        io.print("Director: "+dvd.getDirector());
        io.print("  Studio: "+dvd.getStudio());
        io.print("  Rating: "+dvd.getRating());
        io.print(" Comment: "+dvd.getNote());
        io.print("\nWhat would you like to do?");
        io.print("1.) Edit title");
        io.print("2.) Edit year");
        io.print("3.) Edit director");
        io.print("4.) Edit studio");
        io.print("5.) Edit rating");
        io.print("6.) Edit comment");
        io.print("7.) Delete "+dvd.getTitle());
        io.print("8.) Go back");
        return io.getInt("",1,8);
    }
    
    public void showDVDs(HashMap<Integer,DVD> library){
        if (library.isEmpty()){
            io.print("No DVDs found.");
            return;
        }
        for (Integer key : library.keySet()){
            io.print(key+".)"
                    +"\t"+library.get(key).getTitle()+" ("
                    +library.get(key).getYear()+")\n");
        }
    }
    
    public void bannerAllDVDS(){
        io.print("~~~~~ All DVDs ~~~~~");
    }
    
    public String getMenuMultiple(){
        io.print("Type a number to see more details,");
        return io.getString("or hit enter to go back.");
    }
    
    public void bannerBadInput(){
        io.getString("Invalid input. Please hit return.");
    }
    
    public DVD getNewDVDInfo() throws NumberFormatException {
        DVD dvd = new DVD();
        io.print("\n~~~~~ Add DVD ~~~~~");
        dvd.setTitle   (getTitle());
        dvd.setYear    (getYear());
        dvd.setDirector(getDirector());
        dvd.setStudio  (getStudio());
        dvd.setRating  (getRating());
        dvd.setNote    (getNote());
        return dvd;
    }
    
    public void bannerError(String errMsg){
        io.print("\n~~~~~ ERROR ~~~~~");
        io.print(errMsg);
    }
    
    public int confirmSave(){
        io.print("Do you really want to save your changes?");
        io.print("1.) Yes       2.) No");
        return io.getInt("",1,2);
    }
    
    public int confirmExit(){
        io.print("Do you really want to exit without saving?");
        io.print("1.) Yes       2.) No");
        return io.getInt("",1,2);
    }
    
    public void goodBye(){
        io.print("\n~~~~~ GOOD BYE ~~~~~");
    }
    
    public String getDVDTitle(){
        return io.getString("Please input the title of the DVD.");
    }
    
    public void importSuccess(int num){
        io.print("Imported "+num+" DVDs\n");
    }
    
    public void saveSuccess(int num){
        io.print("Saved "+num+" DVDs\n");
    }
    
    public String getTitle(){
        return io.getString("Title:");
    }
    public int getYear(){
        return io.getInt("Year:",1900,2050);
    }
    public String getDirector(){
        return io.getString("Director:");
    }
    public String getStudio(){
        return io.getString("Studio:");
    }
    public String getRating(){
        return io.getString("Rating:");
    }
    public String getNote(){
        return io.getString("Comment:");
    }
}
