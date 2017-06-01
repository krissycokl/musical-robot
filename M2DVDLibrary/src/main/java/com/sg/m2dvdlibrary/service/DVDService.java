package com.sg.m2dvdlibrary.service;

import com.sg.m2dvdlibrary.dao.DVDDaoException;
import com.sg.m2dvdlibrary.dao.DVDFields;
import com.sg.m2dvdlibrary.dto.DVD;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public interface DVDService {

    public DVD getDVD(Integer key);
    public String editDVD(DVD dvd, DVDFields.fields field, String value) throws
            DVDDaoException;
    public LocalDate editDVDDate(DVD dvd, LocalDate value) throws
            DVDDaoException;
    public DVD addDVD(DVD dvd) throws
            DVDDataValidationException,
            DVDDaoException;
    public DVD removeDVD(Integer key) throws DVDDaoException;
    public Map<Integer,DVD> listDVDs();
    public Map<Integer,DVD> listDVDs(String title);
    public Map<Integer,DVD> populate() throws DVDDaoException;
    public void save() throws DVDDaoException;
    public Map<Integer,DVD> getDVDsAfterYear(int year);
    public Map<Integer,DVD> getDVDsByRating(String rating);
    public Map<String, List<DVD>> getDVDsByDirector(String director);
    public Map<Integer,DVD> getDVDsByStudio(String studio);
    public double getAverageAge();
    public int getByAge(boolean newest);
    public long getNotesNumber();
    public double getNotesAvgLen();
    
}
