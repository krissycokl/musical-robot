package com.sg.classroster;
import com.sg.classroster.controller.ClassRosterController;
import com.sg.classroster.dao.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
    public static void main(String[] args) throws ClassRosterPersistenceException {
        /*UserIO io = new UserIOConsoleImpl();
        ClassRosterView view = new ClassRosterView(io);
        ClassRosterDao dao = new ClassRosterDaoFileImpl();
        ClassRosterAuditDao auditDao = new ClassRosterAuditDaoFileImpl();
        ClassRosterService service = new ClassRosterServiceImpl(dao, auditDao);
        ClassRosterController controller = new ClassRosterController(service, view);*/
        
        ApplicationContext ctx = 
                new ClassPathXmlApplicationContext("applicationContext.xml");
        ClassRosterController controller = 
                ctx.getBean("controller", ClassRosterController.class);
        controller.run();
    }
}
