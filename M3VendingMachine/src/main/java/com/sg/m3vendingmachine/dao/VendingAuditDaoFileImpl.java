package com.sg.m3vendingmachine.dao;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class VendingAuditDaoFileImpl implements VendingAuditDao {

    private final String OUTPUT;
    private PrintWriter out;
    
    public VendingAuditDaoFileImpl(String filename) {
        this.OUTPUT = filename;
    }
    
    @Override
    public void writeAuditEntry(String entry) {
        try {
            this.out = new PrintWriter(new FileWriter(OUTPUT,true));
        } catch (IOException e) {
            //failed to write
        }
        
        String timestamp = LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME);
        out.append(entry+" - "+timestamp+"\n");
        out.flush();
        out.close();
    }

}
