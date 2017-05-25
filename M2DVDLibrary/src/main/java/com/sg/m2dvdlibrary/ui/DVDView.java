package com.sg.m2dvdlibrary.ui;

import com.sg.m2dvdlibrary.dao.DVDFields;
import com.sg.m2dvdlibrary.dto.DVD;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
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
        io.print("\n   Title: "+dvd.getTitle());
        io.print("    Year: "+dvd.getYear().format(DateTimeFormatter.ofPattern("MM/dd/uuuu")));
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
            io.print("\nNo DVDs found.");
            return;
        }
        for (Integer key : library.keySet()){
            io.print(key+".)"
                    +"\t"+library.get(key).getTitle()+" ("
                    +library.get(key).getYear().getYear()+")");
        }
    }
    
    public void bannerAllDVDS(){
        io.print("\n~~~~~ All DVDs ~~~~~");
    }
    
    public int getMenuMultiple(){
        io.print("\nType a number to see more details,");
        return io.getInt("or type -1 to go back.");
    }
    
    public void bannerBadInput(){
        io.getString("Invalid input. Please hit return.");
    }
    
    public DVD getNewDVDInfo() {
        DVD dvd = new DVD();
        io.print("\n~~~~~ Add DVD ~~~~~");
        dvd.setTitle   (getTitle());
        
        String year = getYear();
        LocalDate ld;
                try{
                    ld = LocalDate.parse(year,DateTimeFormatter.ofPattern("MM/dd/uuuu"));
                } catch (DateTimeParseException e){
                    ld = LocalDate.parse("01/01/2000",DateTimeFormatter.ofPattern("MM/dd/uuuu"));
                }
        
        dvd.setYear    (ld);
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
        io.print("\nDo you really want to save your changes?");
        io.print("This will overwrite your existing library.");
        io.print("1.) Yes       2.) No");
        return io.getInt("",1,2);
    }
    
    public int confirmExit(){
        io.print("\nDo you really want to exit without saving?");
        io.print("1.) Yes       2.) No");
        return io.getInt("",1,2);
    }
    
    public void goodBye(){
        io.print("\n~~~~~ GOOD BYE ~~~~~");
    }
    
    public String getDVDTitle(){
        String title = io.getString("\nPlease input the title of the DVD.");
        if(!title.isEmpty()){return title;}
        return "~no title provided~";
    }
    
    public void importSuccess(int num){
        io.print("Imported "+num+" DVDs\n");
    }
    
    public void saveSuccess(int num){
        io.print("Saved "+num+" DVDs\n");
    }
    
    public String getTitle(){
        String holder = "";
        boolean validTitle = false;
        while (!validTitle){
            holder = io.getString("Title:");
            if(!holder.isEmpty()){validTitle = true;}
        }
        return holder;
    }
    
    public String getYear(){
        String holder = io.getString("Release Date: MM/DD/YYYY");
        return holder;
    }
    public String getDirector(){
        String holder = io.getString("Director:");
        if(!holder.isEmpty()){return holder;}
        return "none";
    }
    public String getStudio(){
        String holder = io.getString("Studio:");
        if(!holder.isEmpty()){return holder;}
        return "none";
    }
    public String getRating(){
        String holder = io.getString("Rating:");
        if(!holder.isEmpty()){return holder;}
        return "none";
    }
    public String getNote(){
        String holder = io.getString("Comment:");
        if(!holder.isEmpty()){return holder;}
        return "none";
    }
    
    public int confirmDelete(){
        io.print("Do you really want to delete this DVD?");
        io.print("1.) Yes       2.) No");
        return io.getInt("",1,2);
    }
}
