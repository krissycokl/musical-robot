package com.sg.m2dvdlibrary.dao;

import com.sg.m2dvdlibrary.dto.DVD;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.HashMap;
import java.util.Scanner;

public class DVDDaoFileImpl implements DVDDao {
    
    public final String DELIMITER = "::";
    public final String FILENAME = "output.txt";
    private int currKey = 0;
    
    HashMap<Integer, DVD> library = new HashMap<>();

    @Override
    public DVD editDVD(DVD dvd, DVDFields.fields field, String value){
        switch(field){
            case TITLE:
                dvd.setTitle(value);
                break;
            case YEAR:
                LocalDate ld;
                try{
                    ld = LocalDate.parse(value,DateTimeFormatter.ofPattern("MM/dd/uuuu"));
                } catch (DateTimeParseException e){
                    ld = LocalDate.parse("01/01/2000",DateTimeFormatter.ofPattern("MM/dd/uuuu"));
                }
                dvd.setYear(ld);
                break;
            case DIRECTOR:
                dvd.setDirector(value);
                break;
            case STUDIO:
                dvd.setStudio(value);
                break;
            case RATING:
                dvd.setRating(value);
                break;
            case COMMENT:
                dvd.setNote(value);
                break;
        }
        return dvd;
    }
    
    @Override
    public DVD getDVD(Integer key) {
        return library.get(key);
    }

    @Override
    public DVD addDVD(DVD dvd) {
        library.put(currKey, dvd);
        currKey++;
        return dvd;
    }

    @Override
    public DVD removeDVD(Integer key) {
        return library.remove(key);
    }

    @Override
    public HashMap<Integer, DVD> listDVDs() {
        return library;
    }
    
    @Override
    public HashMap<Integer, DVD> listDVDs(String title) {
        HashMap<Integer, DVD> matches = new HashMap<>();
        for (Integer key : library.keySet()){
            if (library.get(key).getTitle().toLowerCase().contains(title.toLowerCase())){
                matches.put(key, library.get(key));
            }
        }
        return matches;
    }

    @Override
    public HashMap<Integer, DVD> populate() throws DVDDaoException {
        Scanner sc;
        try {
            sc = new Scanner(new BufferedReader(new FileReader(FILENAME)));
        } catch (FileNotFoundException ex) {
            throw new DVDDaoException("Failure in IO", ex);
        }
        while (sc.hasNextLine()){
            DVD curDVD = new DVD();
            String[] values = sc.nextLine().split("::");
            curDVD.setTitle(values[1]);
            curDVD.setYear(LocalDate.parse(values[2],DateTimeFormatter.ofPattern("uuuu-MM-dd")));
            curDVD.setDirector(values[3]);
            curDVD.setStudio(values[4]);
            curDVD.setRating(values[5]);
            curDVD.setNote(values[6]);
            library.put(Integer.parseInt(values[0]), curDVD);
        }
        int newKey =-1;
        for (Integer key : library.keySet()){
            newKey = Math.max(key,newKey);
        }
        currKey = newKey+1;
        return library;
    }

    @Override
    public void save() throws DVDDaoException{
        PrintWriter out;
        
        try {
            out = new PrintWriter(new FileWriter(FILENAME));
        } catch (IOException e) {
            throw new DVDDaoException("Failed to save.", e);
        }
        
        for (Integer key : library.keySet()){
            out.println(
                key+DELIMITER
               +library.get(key).getTitle()+DELIMITER
               +library.get(key).getYear().toString()+DELIMITER
               +library.get(key).getDirector()+DELIMITER
               +library.get(key).getStudio()+DELIMITER
               +library.get(key).getRating()+DELIMITER
               +library.get(key).getNote()
            );
            out.flush();
        }
        
        out.close();
    }
}
