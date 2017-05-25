package com.sg.m2dvdlibrary.service;

import com.sg.m2dvdlibrary.dao.*;
import com.sg.m2dvdlibrary.dto.DVD;
import java.util.HashMap;

public class DVDServiceImpl implements DVDService {
    
    DVDDao dao;
    DVDAuditDao auditDao;
    
    public DVDServiceImpl(DVDDao dao, DVDAuditDao auditDao){
        this.dao = dao;
        this.auditDao = auditDao;
    }
    
    @Override
    public DVD editDVD(DVD dvd, DVDFields.fields field, String value) throws DVDDataValidationException{
        validateDVDInfo(dvd);
        dao.editDVD(dvd, field, value);
        return dvd;
    }

    @Override
    public DVD getDVD(Integer key) {
        return dao.getDVD(key);
    }

    @Override
    public DVD addDVD(DVD dvd) throws
            DVDDataValidationException,
            DVDDaoException {
        validateDVDInfo(dvd);
        auditDao.writeAuditEntry(dvd.getTitle()+" ("+dvd.getYear().getYear()+") added.");
        return dao.addDVD(dvd);
    }

    @Override
    public DVD removeDVD(Integer key) throws DVDDaoException {
        auditDao.writeAuditEntry(dao.getDVD(key).getTitle()+" ("+dao.getDVD(key).getYear().getYear()+") removed.");
        return dao.removeDVD(key);
    }

    @Override
    public HashMap<Integer, DVD> listDVDs() {
        return dao.listDVDs();
    }

    @Override
    public HashMap<Integer, DVD> listDVDs(String title) {
        return dao.listDVDs(title);
    }

    @Override
    public HashMap<Integer, DVD> populate() throws DVDDaoException {
        return dao.populate();
    }

    @Override
    public void save() throws DVDDaoException {
        dao.save();
    }

    private void validateDVDInfo(DVD dvd) throws DVDDataValidationException {
        if (dvd.getTitle().isEmpty() ||
            dvd.getTitle() == null   ||
            dvd.getTitle().equals("none")){
            throw new DVDDataValidationException("Title is a required field.");
        }
    }

}
