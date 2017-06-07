package com.sg.m5flooringmastery.controller;

import com.sg.m5flooringmastery.model.Order;
import com.sg.m5flooringmastery.service.FlooringService;
import com.sg.m5flooringmastery.service.InvalidOrderException;
import com.sg.m5flooringmastery.service.NoSuchOrderException;
import com.sg.m5flooringmastery.view.FlooringView;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Month;
import java.util.List;

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
                orderList();
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                addOrder();
                break;
            case 5:
                return true;
        }
        return false;
    }
    
    private void orderList(){
        boolean stop = false;
        LocalDate day = view.getOrderDay(LocalDate.of(1900, Month.JANUARY, 1), false);
        List<Order> orderList = service.getOrderList(day);
        view.showOrders(service.getOrderList(day));
        if(!orderList.isEmpty()){
            int orderNum = view.getOrderFromList();
            try{
                service.getOrder(orderNum, day);
                //NEED TO SHOW ALL ORDER DEETS HERE
                int action = view.getAction();
                while(!stop){
                    switch(action){
                        case 1:
                            editOrder(orderNum, day);
                            stop = true;
                            break;
                        case 2:
                            removeOrder(orderNum, day);
                            stop = true;
                            break;
                        case 3:
                            stop = true;
                            break;
                    }
                }
            } catch (NoSuchOrderException ex) {
                view.showError(ex);
            }
        }
    }
    
    private void addOrder(){
        Order order = buildOrder();
        {
            try {
                service.addOrder(order, order.getDay());
            } catch (InvalidOrderException ex) {
                view.showError(ex);
            }
        }
    }
    
    private void editOrder(int orderNum, LocalDate day){
        try {
            Order order = service.getOrder(orderNum, day);
            Order editedOrder = editOrder(order);
            try {
                service.editOrder(order, editedOrder, day);
            } catch (Exception ex) {
                view.showError(ex);
            }
        } catch (NoSuchOrderException ex) {
            view.showError(ex);
        }
    }
    
    private void removeOrder(int orderNum, LocalDate day){
        if(view.confirmRemove() == 1){
            try {
                service.removeOrder(orderNum, day);
            } catch (NoSuchOrderException ex) {
                view.showError(ex);
            }
        }
    }
    
    private Order buildOrder(){
        Order thisOrder = new Order();
        thisOrder.setArea(view.getOrderArea(BigDecimal.ZERO, false));
        thisOrder.setCustomerName(view.getOrderCustomer(""));
        thisOrder.setDay(view.getOrderDay(LocalDate.of(1900, Month.JANUARY, 1), false));
        thisOrder.setMaterial(view.getOrderMaterial("", service.getValidMaterials()));
        thisOrder.setState(view.getOrderState("", service.getValidStates()));
        return thisOrder;
    }
    
    private Order editOrder(Order order){
        BigDecimal  newArea  = view.getOrderArea(order.getArea(), true);
        String      newName  = view.getOrderCustomer(order.getCustomerName());
        LocalDate   newDay   = view.getOrderDay(order.getDay(), true);
        String      newMater = view.getOrderMaterial(order.getMaterial(), service.getValidMaterials());
        String      newState = view.getOrderState(order.getState(), service.getValidStates());
        
        if(newArea.compareTo(BigDecimal.ZERO)==0){
            newArea = order.getArea();
        }
        if(newName.isEmpty()){
            newName = order.getCustomerName();
        }
        if(newDay.equals(LocalDate.of(1900, Month.JANUARY, 1))){
            newDay = order.getDay();
        }
        if(newMater.isEmpty()){
            newMater = order.getMaterial();
        }
        if(newState.isEmpty()){
            newState = order.getState();
        }
        
        Order editedOrder = new Order();
        editedOrder.setArea(newArea);
        editedOrder.setCustomerName(newName);
        editedOrder.setDay(newDay);
        editedOrder.setMaterial(newMater);
        editedOrder.setState(newState);
        
        return editedOrder;
    }
}
