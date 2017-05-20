package com.sg.m2dvdlibrary.App;
import com.sg.m2dvdlibrary.ui.*;
import com.sg.m2dvdlibrary.controller.*;
import com.sg.m2dvdlibrary.dao.*;

public class App {
    public static void main(String[] args) {
        UserIO io = new UserIOConsoleImpl();
        DVDView view = new DVDView(io);
        DVDDao dao = new DVDDaoFileImpl();
        DVDController controller = new DVDController(view, dao);
        boolean run = true;
        
        try{
            int choice = view.getMenuImport();
            switch(choice){
                case 1:
                    dao.populate();
                    view.importSuccess(dao.listDVDs().size());
                    break;
                case 2:
                    break;
                case 3:
                    run = false;
            }
            while(run){
                run = controller.run();
            }
            view.goodBye();
        } catch (DVDDaoException | NumberFormatException er) {
            view.bannerError(er.getMessage());
        }
    }
}
