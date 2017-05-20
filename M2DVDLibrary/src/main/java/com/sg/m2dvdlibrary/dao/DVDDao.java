package com.sg.m2dvdlibrary.dao;

import com.sg.m2dvdlibrary.dto.DVD;
import java.util.HashMap;

public interface DVDDao {

    public DVD getDVD(Integer key);
    public DVD addDVD(DVD dvd);
    public DVD removeDVD(Integer key);
    public HashMap<Integer,DVD> listDVDs();
    public HashMap<Integer,DVD> listDVDs(String title);
    public HashMap<Integer,DVD> populate() throws DVDDaoException;
    public void save() throws DVDDaoException;
    
}
