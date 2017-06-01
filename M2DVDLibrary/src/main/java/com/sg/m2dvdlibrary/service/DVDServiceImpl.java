package com.sg.m2dvdlibrary.service;

import com.sg.m2dvdlibrary.dao.*;
import com.sg.m2dvdlibrary.dto.DVD;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public class DVDServiceImpl implements DVDService {

    DVDDao dao;
    DVDAuditDao auditDao;

    public DVDServiceImpl(DVDDao dao, DVDAuditDao auditDao) {
        this.dao = dao;
        this.auditDao = auditDao;
    }

    @Override
    public String editDVD(DVD dvd, DVDFields.fields field, String value) throws DVDDaoException {
        return dao.editDVD(dvd, field, value);
    }

    @Override
    public LocalDate editDVDDate(DVD dvd, LocalDate value) throws DVDDaoException {
        return dao.editDVDDate(dvd, value);
    }

    @Override
    public DVD getDVD(Integer key) {
        return dao.getDVD(key);
    }

    @Override
    public DVD addDVD(DVD dvd) throws DVDDataValidationException,
            DVDDaoException {
        validateDVDInfo(dvd);
        return dao.addDVD(dvd);
    }

    @Override
    public DVD removeDVD(Integer key) throws DVDDaoException {
        return dao.removeDVD(key);
    }

    @Override
    public Map<Integer, DVD> listDVDs() {
        return dao.listDVDs();
    }

    @Override
    public Map<Integer, DVD> listDVDs(String title) {
        return dao.listDVDs(title);
    }

    @Override
    public Map<Integer, DVD> populate() throws DVDDaoException {
        return dao.populate();
    }

    @Override
    public void save() throws DVDDaoException {
        dao.save();
    }

    private void validateDVDInfo(DVD dvd) throws DVDDataValidationException {
        if (dvd.getTitle().isEmpty()
                || dvd.getTitle() == null
                || dvd.getTitle().equals("none")) {
            throw new DVDDataValidationException("Title is a required field.");
        }
    }

    @Override
    public Map<Integer, DVD> getDVDsAfterYear(int year) {
        return dao.getDVDsAfterYear(year);
    }

    @Override
    public Map<Integer, DVD> getDVDsByRating(String rating) {
        return dao.getDVDsByRating(rating);
    }

    @Override
    public Map<String, List<DVD>> getDVDsByDirector(String director) {
        return dao.getDVDsByDirector(director);
    }

    @Override
    public Map<Integer, DVD> getDVDsByStudio(String studio) {
        return dao.getDVDsByStudio(studio);
    }

    @Override
    public double getAverageAge() {
        return dao.getAverageAge();
    }

    @Override
    public int getByAge(boolean newest) {
        return dao.getByAge(newest);
    }

    @Override
    public long getNotesNumber() {
        return dao.getNotesNumber();
    }

    @Override
    public double getNotesAvgLen() {
        return dao.getNotesAvgLen();
    }

}
