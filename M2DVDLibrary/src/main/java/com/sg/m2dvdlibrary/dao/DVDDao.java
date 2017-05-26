package com.sg.m2dvdlibrary.dao;

import com.sg.m2dvdlibrary.dto.DVD;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public interface DVDDao {

    public DVD addDVD(DVD dvd);
    public DVD removeDVD(Integer key);
    public DVD getDVD(Integer key);
    public String editDVD(DVD dvd, DVDFields.fields field, String value);
    public LocalDate editDVDDate(DVD dvd, LocalDate value);
    public double getAverageAge();
    public int getByAge(boolean newest);
    public Map<Integer,DVD> getDVDsAfterYear(int year);
    public Map<String, List<DVD>> getDVDsByDirector(String director);
    public Map<Integer,DVD> getDVDsByRating(String rating);
    public Map<Integer,DVD> getDVDsByStudio(String studio);
    public double getNotesAvgLen();
    public long getNotesNumber();
    public Map<Integer,DVD> listDVDs();
    public Map<Integer,DVD> listDVDs(String title);
    public Map<Integer,DVD> populate() throws DVDDaoException;
    public void save() throws DVDDaoException;
    
}
