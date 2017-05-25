package com.sg.m2dvdlibrary.service;

import com.sg.m2dvdlibrary.dao.DVDDaoException;
import com.sg.m2dvdlibrary.dao.DVDFields;
import com.sg.m2dvdlibrary.dto.DVD;
import java.util.HashMap;

public interface DVDService {

    public DVD getDVD(Integer key);
    public DVD editDVD(DVD dvd, DVDFields.fields field, String value) throws DVDDataValidationException;
    public DVD addDVD(DVD dvd) throws
            DVDDataValidationException,
            DVDDaoException;
    public DVD removeDVD(Integer key) throws DVDDaoException;
    public HashMap<Integer,DVD> listDVDs();
    public HashMap<Integer,DVD> listDVDs(String title);
    public HashMap<Integer,DVD> populate() throws DVDDaoException;
    public void save() throws DVDDaoException;
    
}
