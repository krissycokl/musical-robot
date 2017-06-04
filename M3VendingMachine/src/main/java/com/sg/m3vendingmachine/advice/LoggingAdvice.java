package com.sg.m3vendingmachine.advice;

import com.sg.m3vendingmachine.dao.InventoryDao;
import com.sg.m3vendingmachine.dao.VendingAuditDao;
import com.sg.m3vendingmachine.dto.Item;
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
        String entry = (int) jp.getArgs()[0]+": One "+dao.getItem((int) jp.getArgs()[0]).getName()+" vended.";
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
        Item item = dao.getItem((int) jp.getArgs()[0]);
        int qty = (int) jp.getArgs()[1];
        String entry = item.getID()+": Maintenance stocked "+qty+" EA "+item.getName()+".";
        auditDao.writeAuditEntry(entry);
    }
    
    public void logServiceNewItem(JoinPoint jp, int key){
        String entry = key + ": New item added to offering.";
        auditDao.writeAuditEntry(entry);
    }
    
    public void logServiceEditName(JoinPoint jp, String oldVal){
        Item item = dao.getItem((int) jp.getArgs()[0]);
        String entry = item.getID()+": Item name changed from "+oldVal+" to "+item.getName()+".";
        auditDao.writeAuditEntry(entry);
    }
    
    public void logServiceEditCost(JoinPoint jp, BigDecimal oldVal){
        Item item = dao.getItem((int) jp.getArgs()[0]);
        String entry = item.getID()+": Item "+item.getName()+" cost changed from "+oldVal+" to "+item.getCost()+".";
        auditDao.writeAuditEntry(entry);
    }
    
    public void logServiceActivate(JoinPoint jp){
        Item item = dao.getItem((int) jp.getArgs()[0]);
        String entry = item.getID()+": Item "+item.getName()+" toggled (in)active.";
        auditDao.writeAuditEntry(entry);
    }
}
