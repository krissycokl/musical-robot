package com.sg.m2dvdlibrary.advice;

import com.sg.m2dvdlibrary.dao.DVDAuditDao;
import com.sg.m2dvdlibrary.dao.DVDDao;
import com.sg.m2dvdlibrary.dao.DVDDaoException;
import com.sg.m2dvdlibrary.dto.DVD;
import java.time.LocalDate;
import org.aspectj.lang.JoinPoint;

public class LoggingAdvice {
    DVDAuditDao auditDao;
    DVDDao      dao;
    
    public LoggingAdvice(DVDAuditDao auditDao, DVDDao dao){
        this.auditDao = auditDao;
        this.dao      = dao;
    }
    
    public void tryWrite(String auditEntry){
        try {
            auditDao.writeAuditEntry(auditEntry);
        } catch (DVDDaoException ex) {
            System.err.println("Failed to write to audit file.");
        }
    }
    
    public void auditAdd(JoinPoint jp){
        DVD dvd = (DVD) jp.getArgs()[0];
        String name = dvd.getTitle();
        String auditEntry = jp.getSignature().getName()+": "+
                name+".";
        tryWrite(auditEntry);
    }
    
    public void auditRemove(JoinPoint jp, DVD returnVal){
        int key = Integer.parseInt(jp.getArgs()[0].toString());
        String name = returnVal.getTitle();
        String auditEntry = jp.getSignature().getName()+": "+
                "ID " + key + ", "+name+".";
        tryWrite(auditEntry);
    }
    
    public void auditEdit(JoinPoint jp, String returnVal){
        DVD dvd = (DVD) jp.getArgs()[0];
        String name = dvd.getTitle();
        String oldVal = returnVal;
        String auditEntry = jp.getSignature().getName()+": "+
                name +" "+ jp.getArgs()[1].toString()+" changed from "+
                oldVal + " to "+jp.getArgs()[2].toString();
        tryWrite(auditEntry);
    }
    
    public void auditEditDate(JoinPoint jp, LocalDate returnVal){
        DVD dvd = (DVD) jp.getArgs()[0];
        String name = dvd.getTitle();
        String oldVal = returnVal.toString();
        String auditEntry = jp.getSignature().getName()+": "+
                name +" RELEASE DATE changed from "+
                oldVal + " to "+jp.getArgs()[1].toString();
        tryWrite(auditEntry);
    }
}
