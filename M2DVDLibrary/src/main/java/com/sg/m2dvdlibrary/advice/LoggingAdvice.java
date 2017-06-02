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
    
    public void auditDVD(String action, DVD dvd) {
        String auditEntry = action +": "+
                "ID " + dvd.getKey() + ", "
                +dvd.getTitle()+".";
        try {
            auditDao.writeAuditEntry(auditEntry);
        } catch (DVDDaoException ex) {
            System.err.println("Failed to write to audit file.");
        }
    }
    
    public void auditAdd(JoinPoint jp){
        DVD dvd = (DVD) jp.getArgs()[0];
        String action = jp.getSignature().getName();
        auditDVD(action, dvd);
    }
    
    public void auditRemove(JoinPoint jp, DVD returnVal){
        String action = jp.getSignature().getName();
        auditDVD(action, returnVal);
    }
    
    public void auditEdit(JoinPoint jp, String returnVal){
        DVD dvd = (DVD) jp.getArgs()[0];
        String oldVal = returnVal;
        String action = jp.getSignature().getName()+": "+
                jp.getArgs()[1].toString()+" changed from "+
                oldVal + " to "+jp.getArgs()[2].toString();
        auditDVD(action, dvd);
    }
    
    public void auditEditDate(JoinPoint jp, LocalDate returnVal){
        DVD dvd = (DVD) jp.getArgs()[0];
        String oldVal = returnVal.toString();
        String action = jp.getSignature().getName()+": "+
                "RELEASE DATE changed from "+
                oldVal + " to "+dvd.getYear().toString();
        auditDVD(action, dvd);
    }
}
