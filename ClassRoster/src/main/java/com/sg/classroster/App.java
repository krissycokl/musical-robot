package com.sg.classroster;
import com.sg.classroster.controller.ClassRosterController;
import com.sg.classroster.dao.*;
import com.sg.classroster.ui.*;

public class App {
    public static void main(String[] args) {
        UserIO io = new UserIOConsoleImpl();
        ClassRosterView view = new ClassRosterView(io);
        ClassRosterDao dao = new ClassRosterDaoFileImpl();
        ClassRosterController controller = new ClassRosterController(dao, view);
        controller.run();
    }
}
