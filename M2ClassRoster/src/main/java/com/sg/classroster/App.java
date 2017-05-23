package com.sg.classroster;
import com.sg.classroster.controller.ClassRosterController;
import com.sg.classroster.dao.*;
import com.sg.classroster.service.ClassRosterService;
import com.sg.classroster.service.ClassRosterServiceImpl;
import com.sg.classroster.ui.*;

public class App {
    public static void main(String[] args) throws ClassRosterPersistenceException {
        UserIO io = new UserIOConsoleImpl();
        ClassRosterView view = new ClassRosterView(io);
        ClassRosterDao dao = new ClassRosterDaoFileImpl();
        ClassRosterAuditDao auditDao = new ClassRosterAuditDaoFileImpl();
        ClassRosterService service = new ClassRosterServiceImpl(dao, auditDao);
        ClassRosterController controller = new ClassRosterController(service, view);
        controller.run();
    }
}
