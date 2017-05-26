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
import java.time.temporal.ChronoUnit;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class DVDDaoFileImpl implements DVDDao {
    
    public final String DELIMITER = "::";
    public final String FILENAME = "output.txt";
    private int currKey = 0;
    
    HashMap<Integer, DVD> library = new HashMap<>();

    @Override
    public String editDVD(DVD dvd, DVDFields.fields field, String value){
        String oldValue = "";
        switch(field){
            case TITLE:
                oldValue = dvd.getTitle();
                dvd.setTitle(value);
                break;
            case YEAR:
                oldValue = dvd.getYear().format(DateTimeFormatter.ofPattern("mm/DD/uuuu"));
                LocalDate ld;
                try{
                    ld = LocalDate.parse(value,DateTimeFormatter.ofPattern("mm/DD/uuuu"));
                } catch (DateTimeParseException e){
                    ld = LocalDate.parse("01/01/2000",DateTimeFormatter.ofPattern("mm/DD/uuuu"));
                }
                dvd.setYear(ld);
                break;
            case DIRECTOR:
                oldValue = dvd.getDirector();
                dvd.setDirector(value);
                break;
            case STUDIO:
                oldValue = dvd.getStudio();
                dvd.setStudio(value);
                break;
            case RATING:
                oldValue = dvd.getRating();
                dvd.setRating(value);
                break;
            case COMMENT:
                oldValue = dvd.getNote();
                dvd.setNote(value);
                break;
        }
        return oldValue;
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
    public Map<Integer, DVD> listDVDs(String title) {
        Map<Integer, DVD> matches = new HashMap<>();
        for (Integer key : library.keySet()){
            if (library.get(key).getTitle().toLowerCase().contains(title.toLowerCase())){
                matches.put(key, library.get(key));
            }
        }
        return matches;
    }

    @Override
    public Map<Integer, DVD> populate() throws DVDDaoException {
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

    @Override
    public Map<Integer,DVD> getDVDsAfterYear(int year) {
        return library.entrySet()
                .stream()
                .filter(entry -> entry.getValue().getYear().isAfter(LocalDate.ofYearDay(year, 364)))
                .collect(Collectors.toMap(e-> e.getKey(), e->e.getValue()));
    }

    @Override
    public Map<Integer,DVD> getDVDsByRating(String rating) {
        return library.entrySet()
                .stream()
                .filter(e -> e.getValue().getRating().equals(rating))
                .collect(Collectors.toMap(e-> e.getKey(), e-> e.getValue()));
    }

    @Override
    public Map<String, List<DVD>> getDVDsByDirector(String director) {
        return library.values()
                .stream()
                .filter(dvd -> dvd.getDirector().equals(director))
                .collect(Collectors.groupingBy(dvd -> dvd.getRating()));
    }

    @Override
    public Map<Integer,DVD> getDVDsByStudio(String studio) {
        return library.entrySet()
                .stream()
                .filter(e -> e.getValue().getStudio().equals(studio))
                .collect(Collectors.toMap(e->e.getKey(), e->e.getValue()));
    }

    @Override
    public double getAverageAge() {
        return library.values()
                .stream()
                .collect(Collectors.averagingDouble(
                        dvd -> dvd.getYear().until(LocalDate.now(), ChronoUnit.YEARS)));
    }

    @Override
    public int getByAge(boolean newest) {
        if(newest){
            return library.entrySet()
                .stream()
                .max((e1, e2) -> e1.getValue().getYear().compareTo(e2.getValue().getYear()) > 0 ? 1 : -1)
                .get().getKey();
        } else {
            return library.entrySet()
                .stream()
                .min((e1, e2) -> e1.getValue().getYear().compareTo(e2.getValue().getYear()) > 0 ? 1 : -1)
                .get().getKey();
        }
        
    }

    @Override
    public long getNotes() {
        return library.values()
                .stream()
                .filter(dvd -> !dvd.getNote().equals("none") && !dvd.getNote().isEmpty())
                .count();
    }
}
