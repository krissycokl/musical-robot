package com.sg.m5flooringmastery.advice;

import com.sg.m5flooringmastery.dao.FlooringAuditDao;
import com.sg.m5flooringmastery.dao.FlooringDao;
import com.sg.m5flooringmastery.dao.FlooringDaoFileROImpl;
import com.sg.m5flooringmastery.model.Audit;
import com.sg.m5flooringmastery.model.Order;
import com.sg.m5flooringmastery.service.FlooringServiceImpl;
import java.io.IOException;
import org.aspectj.lang.JoinPoint;

public class LoggingAdvice {

    private FlooringAuditDao auditDao;

    public LoggingAdvice(FlooringAuditDao auditDao) {
        this.auditDao = auditDao;
    }

    private void logError(JoinPoint jp, Throwable ex) throws IOException {
        FlooringServiceImpl serviceImpl = (FlooringServiceImpl) jp.getTarget();
        FlooringDao implementation = serviceImpl.getFlooringDaoImpl();
        if (!(implementation instanceof FlooringDaoFileROImpl)){
            auditDao.writeAuditError(ex);
        }
    }

    private void logAdd(JoinPoint jp) throws IOException {
        FlooringServiceImpl serviceImpl = (FlooringServiceImpl) jp.getTarget();
        FlooringDao implementation = serviceImpl.getFlooringDaoImpl();
        if (!(implementation instanceof FlooringDaoFileROImpl)){
            Order added = (Order) jp.getArgs()[0];
            Audit addAudit = new Audit(added, null);
            auditDao.writeAuditEntry(addAudit);
        }
    }

    private void logRemove(JoinPoint jp, Order removed) throws IOException {
        FlooringServiceImpl serviceImpl = (FlooringServiceImpl) jp.getTarget();
        FlooringDao implementation = serviceImpl.getFlooringDaoImpl();
        if (!(implementation instanceof FlooringDaoFileROImpl)){
            Audit removeAudit = new Audit(null, removed);
            auditDao.writeAuditEntry(removeAudit);
        }
    }

    private void logEdit(JoinPoint jp, Order edited) throws IOException {
        FlooringServiceImpl serviceImpl = (FlooringServiceImpl) jp.getTarget();
        FlooringDao implementation = serviceImpl.getFlooringDaoImpl();
        if (!(implementation instanceof FlooringDaoFileROImpl)){
            Order added = edited;
            Order removed = (Order) jp.getArgs()[0];
            Audit editAudit = new Audit(added, removed);
            auditDao.writeAuditEntry(editAudit);
        }
    }
}
