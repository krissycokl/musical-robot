package com.sg.m2addressbook;

import com.sg.m2addressbook.controller.AddressController;
import com.sg.m2addressbook.dao.*;
import com.sg.m2addressbook.service.*;
import com.sg.m2addressbook.ui.*;

public class App {
    
    public static void main(String[] args) throws AddressValidationException {
        UserIO io = new UserIOConsoleImpl();
        AddressDao dao = new AddressDaoFileImpl();
        AddressView view = new AddressView(io);
        AddressService service = new AddressServiceImpl(dao);
        
        AddressController app = new AddressController(service, view);
        app.run();
    }
}
