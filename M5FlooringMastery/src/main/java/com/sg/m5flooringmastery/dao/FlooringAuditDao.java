package com.sg.m5flooringmastery.dao;

import com.sg.m5flooringmastery.model.Audit;
import java.io.IOException;

public interface FlooringAuditDao {
    
    public void writeAuditEntry(Audit audit) throws IOException;
    public void writeAuditError(Throwable ex) throws IOException;
}