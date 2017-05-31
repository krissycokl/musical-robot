package com.sg.m2dvdlibrary.App;
import com.sg.m2dvdlibrary.controller.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
    public static void main(String[] args) {
    /*  
        UserIO io = new UserIOConsoleImpl();
        DVDView view = new DVDView(io);
        DVDDao dao = new DVDDaoFileImpl();
        DVDAuditDao auditDao = new DVDAuditDaoImpl();
        DVDService service = new DVDServiceImpl(dao, auditDao);
        DVDController controller = new DVDController(view, service);
    */
    
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        
        DVDController controller = ctx.getBean("controller",DVDController.class);
        
        controller.begin();
    }
}
