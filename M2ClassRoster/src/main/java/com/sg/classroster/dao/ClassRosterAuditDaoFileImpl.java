package com.sg.classroster.dao;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;

public class ClassRosterAuditDaoFileImpl implements ClassRosterAuditDao {

    public static final String AUDIT_FILE = "audit.txt";
    
    @Override
    public void writeAuditEntry(String entry) throws ClassRosterPersistenceException {
        PrintWriter out;
        
        try{
            // the "true" in the call below to filewriter opens in APPEND MODE
            out = new PrintWriter(new FileWriter(AUDIT_FILE, true));
        } catch (IOException e) {
            throw new ClassRosterPersistenceException("Could not persist audit info.", e);
        }
        
        LocalDateTime timestamp = LocalDateTime.now();
        out.println(timestamp.toString()+": "+entry);
        out.flush();
    }

}
