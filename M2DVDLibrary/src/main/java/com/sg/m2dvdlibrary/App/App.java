package com.sg.m2dvdlibrary.App;
import com.sg.m2dvdlibrary.ui.*;
import com.sg.m2dvdlibrary.controller.*;
import com.sg.m2dvdlibrary.dao.*;
import com.sg.m2dvdlibrary.service.*;

public class App {
    public static void main(String[] args) {
        UserIO io = new UserIOConsoleImpl();
        DVDView view = new DVDView(io);
        DVDDao dao = new DVDDaoFileImpl();
        DVDAuditDao auditDao = new DVDAuditDaoImpl();
        DVDService service = new DVDServiceImpl(dao, auditDao);
        DVDController controller = new DVDController(view, service);
        controller.begin();
    }
}
