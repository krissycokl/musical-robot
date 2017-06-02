package com.sg.m3vendingmachine.advice;

import com.sg.m3vendingmachine.dao.InventoryDao;
import com.sg.m3vendingmachine.dao.VendingAuditDao;
import java.math.BigDecimal;
import org.aspectj.lang.JoinPoint;

public class LoggingAdvice {
    
    InventoryDao    dao;
    VendingAuditDao auditDao;
    
    public LoggingAdvice(InventoryDao dao, VendingAuditDao auditDao){
        this.auditDao = auditDao;
        this.dao      = dao;
    }
    
    public void logError(JoinPoint jp, Throwable thrown){
        auditDao.writeAuditEntry("Attempted "+jp.getSignature().getName()+
                ". Error: "+thrown.getMessage());
    }
    
    public void logPurchase(JoinPoint jp){
        String entry = "One "+dao.getItem((int) jp.getArgs()[0]).getName()+" vended.";
        auditDao.writeAuditEntry(entry);
    }
    
    public void logInsertCoin(JoinPoint jp){
        String entry = "User added $"+(BigDecimal) jp.getArgs()[0]+".";
        auditDao.writeAuditEntry(entry);
    }
    
    public void logCoinReturn(JoinPoint jp, BigDecimal[] changeAry){
        String entry = "Machine returned ";
        entry += changeAry[0] + " Qs, "+changeAry[1]+" Ds, "+changeAry[2]+" Ns, "+changeAry[3]+" Ps";
        auditDao.writeAuditEntry(entry);
    }
    
    // Service menu logging
    public void logServiceStock(JoinPoint jp){
        auditDao.writeAuditEntry(jp.getSignature().getName());
    }
    
    public void logServiceNewItem(JoinPoint jp){
        auditDao.writeAuditEntry(jp.getSignature().getName());
    }
    
    public void logServiceEdit(JoinPoint jp){
        auditDao.writeAuditEntry(jp.getSignature().getName());
    }
    
    public void logServiceToggleActive(JoinPoint jp){
        auditDao.writeAuditEntry(jp.getSignature().getName());
    }
}
