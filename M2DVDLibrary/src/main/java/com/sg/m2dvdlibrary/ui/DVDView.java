package com.sg.m2dvdlibrary.ui;

import com.sg.m2dvdlibrary.dto.DVD;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Map;

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
        io.print("4.) Advanced search");
        io.print("5.) Exit and save changes");
        io.print("6.) Exit without saving");
        return io.getInt("What would you like to do?",1,6);
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
    
    public void showDVDs(Map<Integer,DVD> library){
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
    
    public void showDVDs(List<DVD> listDVD){
        int ctr = 1;
        if (listDVD.isEmpty()){
            bannerNoResults();
            return;
        }
        for (DVD dvd : listDVD){
            io.print(ctr+".)"
                    +"\t"+dvd.getTitle()+" ("
                    +dvd.getYear().getYear()+")");
            ctr++;
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
        dvd.setYear    (getDate());
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
    
    public void groupMoviesByRating(Map<String, List<DVD>> DVDs){
        for (String rating : DVDs.keySet()){
            if (rating.equals("none")){io.print("\n\tUnrated:");
            } else {                   io.print("\n\tRated "+rating+":");
            }
            showDVDs(DVDs.get(rating));
        }
    }
    
    public void bannerNoResults(){
        io.print("\nNo DVDs found.");
    }
    
    public void bannerDeleted(String title){
        io.print("\n"+title+" deleted");
    }
    
    public void bannerAverageAge(double age){
        io.print("\nThe average age of the movies in your collection is "+age+" years.");
    }
    
    public void bannerMoviesBy(String field, String criteria){
        io.print("\n~~~ Movies by "+field+": "+criteria+" ~~~");
    }
    
    public void bannerMoviesAfter(int year){
        io.print("\n~~~ Movies Released After "+year+" ~~~");
    }
    
    public void bannerMoviesRated(String rating){
        io.print("\n~~~ Movies Rated "+rating+" ~~~");
    }
    
    public void bannerMovieByAge(boolean newest){
        String which;
        if (newest) {which = "Newest";}
        else {which = "Oldest";}
        io.print("\nThe " + which + " Movie in Your Collection:");
    }
    
    public void bannerNumberOfNotes(long notes){
        io.print("\n"+notes+" DVDs in your collection have user notes.");
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
    
    public LocalDate getDate(){
        return io.getDate("Release Date: MM/DD/YYYY", "01/01/2000");
    }
    public int getYear(){
        return io.getInt("Year:");
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
    
    public int getMenuSearch(){
        io.print("\n~~~~~ Advanced Search ~~~~~");
        io.print("1.) List DVDs released after a given year");
        io.print("2.) List DVDs by MPAA rating");
        io.print("3.) List DVDs by director");
        io.print("4.) List DVDs by studio");
        io.print("5.) Get average age of all DVDs in library");
        io.print("6.) Get the newest DVD in library");
        io.print("7.) Get the oldest DVD in library");
        io.print("8.) See how many DVDs have user notes");
        io.print("9.) Go back");
        return io.getInt("What would you like to see?",1,9);
    }
}
