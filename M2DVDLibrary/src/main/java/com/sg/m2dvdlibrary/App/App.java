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
        controller.begin();
    }
}
