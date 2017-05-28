package com.sg.m3vendingmachine;

import com.sg.m3vendingmachine.dao.*;
import com.sg.m3vendingmachine.controller.*;
import com.sg.m3vendingmachine.service.*;
import com.sg.m3vendingmachine.ui.*;

public class App {
    public static void main(String[] args) {
        String              filename = "output.txt";
        
        UserIO                    io = new UserIOConsoleImpl();
        InventoryDao             dao = new InventoryDaoFileImpl(filename);
        VendingView             view = new VendingView(io);
        VendingService       service = new VendingServiceImpl(dao);
        VendingController controller = new VendingController(service, view);
        
        controller.run();
    }
}
