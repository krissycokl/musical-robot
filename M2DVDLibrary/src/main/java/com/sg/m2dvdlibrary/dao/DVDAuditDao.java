package com.sg.m2dvdlibrary.dao;

public interface DVDAuditDao {
    public void writeAuditEntry(String entry) throws DVDDaoException;
}
