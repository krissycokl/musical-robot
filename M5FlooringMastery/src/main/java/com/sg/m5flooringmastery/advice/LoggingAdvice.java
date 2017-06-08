package com.sg.m5flooringmastery.advice;

import com.sg.m5flooringmastery.dao.FlooringAuditDao;
import com.sg.m5flooringmastery.model.Audit;
import com.sg.m5flooringmastery.model.Order;
import java.io.IOException;
import org.aspectj.lang.JoinPoint;

public class LoggingAdvice {
    
    private FlooringAuditDao auditDao;
    
    public LoggingAdvice(FlooringAuditDao auditDao){
        this.auditDao = auditDao;
    }
    
    private void logError(JoinPoint jp, Throwable ex) throws IOException{
        auditDao.writeAuditError(ex);
    }

    private void logAdd(JoinPoint jp) throws IOException{
        Order added = (Order) jp.getArgs()[0];
        Audit addAudit = new Audit(added, null);
        auditDao.writeAuditEntry(addAudit);
    }
    
    private void logRemove(JoinPoint jp, Order removed) throws IOException{
        Audit removeAudit = new Audit(null, removed);
        auditDao.writeAuditEntry(removeAudit);
    }
    
    private void logEdit(JoinPoint jp, Order edited) throws IOException{
        Order added = edited;
        Order removed = (Order) jp.getArgs()[0];
        Audit editAudit = new Audit(added, removed);
        auditDao.writeAuditEntry(editAudit);
    }
}
