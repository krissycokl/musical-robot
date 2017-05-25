package com.sg.m2dvdlibrary.dao;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;

public class DVDAuditDaoImpl implements DVDAuditDao {
    private final String AUDIT_FILE = "output_record.txt";
    private PrintWriter out;

    @Override
    public void writeAuditEntry(String entry) throws DVDDaoException {
        try{
            out = new PrintWriter(new FileWriter(AUDIT_FILE, true));
        } catch (IOException e) {
            throw new DVDDaoException("Error writing to file.");
        }
        
        LocalDateTime timestamp = LocalDateTime.now();
        out.append(entry+"::("+timestamp.toString()+")");
        out.flush();
        out.close();
    }
    
}
