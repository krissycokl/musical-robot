package com.sg.m2addressbook;

import com.sg.m2addressbook.controller.AddressController;
import com.sg.m2addressbook.dao.*;
import com.sg.m2addressbook.ui.*;

public class App {
    
    public static void main(String[] args) {
        UserIO io = new UserIOConsoleImpl();
        AddressDao dao = new AddressDaoFileImpl();
        AddressView view = new AddressView(io);
        
        AddressController app = new AddressController(dao, view);
        app.run();
    }
}
