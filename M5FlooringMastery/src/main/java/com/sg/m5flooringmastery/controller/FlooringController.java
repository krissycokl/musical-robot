package com.sg.m5flooringmastery.controller;

import com.sg.m5flooringmastery.model.Order;
import com.sg.m5flooringmastery.service.FlooringService;
import com.sg.m5flooringmastery.service.InvalidOrderException;
import com.sg.m5flooringmastery.view.FlooringView;

public class FlooringController {
    private FlooringView view;
    private FlooringService service;
    
    public FlooringController(FlooringView view, FlooringService service){
        this.view = view;
        this.service = service;
    }
    
    public boolean run() {
        switch(view.getMainMenuChoice()){
            case 1:
                view.showOrders(service.getOrderList(view.getOrderDay()));
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                Order order = view.getOrder();
                {
                    try {
                        service.addOrder(order, order.getDay());
                    } catch (InvalidOrderException ex) {
                        view.showError(ex);
                    }
                }
                break;
            case 5:
                break;
            case 6:
                break;
            case 7:
                return true;
        }
        return false;
    }
}
