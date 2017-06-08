package com.sg.m5flooringmastery.dao;

import com.sg.m5flooringmastery.model.Audit;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class FlooringAuditDaoFileImpl implements FlooringAuditDao {

    private final String FILENAME;
    
    public FlooringAuditDaoFileImpl(String filename){
        this.FILENAME = filename;
    }
    
    @Override
    public void writeAuditEntry(Audit audit) throws IOException {
        PrintWriter out = new PrintWriter(new FileWriter(FILENAME, true));
        out.println(audit.toString());
        out.flush();
        out.close();
    }
    
    @Override
    public void writeAuditError(Throwable ex) throws IOException{
        Audit errorAudit = new Audit(null, null);
        PrintWriter out = new PrintWriter(new FileWriter(FILENAME, true));
        out.println(errorAudit.getTimeStamp()+" ERROR: "+ex.getMessage());
        out.flush();
        out.close();
    }
}
