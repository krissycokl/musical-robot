package com.sg.m5flooringmastery.controller;

import com.sg.m5flooringmastery.model.Order;
import com.sg.m5flooringmastery.service.FlooringService;
import com.sg.m5flooringmastery.service.InvalidOrderException;
import com.sg.m5flooringmastery.service.NoSuchOrderException;
import com.sg.m5flooringmastery.view.FlooringView;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Month;
import java.util.Map;
import java.util.stream.Collectors;

public class FlooringController {
    private FlooringView view;
    private FlooringService service;
    
    public FlooringController(FlooringView view, FlooringService service){
        this.view = view;
        this.service = service;
    }

    public boolean run() {
        view.bannerMainMenu();
        switch(view.getMainMenuChoice()){
            case 1:
                orderListByDay();
                break;
            case 2:
                orderListByLastName();
                break;
            case 3:
                orderListByNumber();
                break;
            case 4:
                addOrder();
                break;
            case 5:
                return true;
        }
        return false;
    }
    
    private void orderListByDay(){
        LocalDate day = view.getOrderDay(LocalDate.of(1900, Month.JANUARY, 1), false);
        Map<Integer,Order> matchingOrders = service.getOrderMap(day);
        orderList(matchingOrders);
    }
    
    private void orderListByLastName() {
        //LocalDate fromDay = view.getOrderDay(LocalDate.of(1900, Month.JANUARY, 1), false);
        //LocalDate toDay   = view.getOrderDay(LocalDate.of(1900, Month.JANUARY, 1), false)
        String findName = view.getOrderCustomer("").toLowerCase();
        Map<Integer,Order> matchingOrders = service.getOrderMap(findName);
        orderList(matchingOrders);
    }

    private void orderListByNumber() {
        int findNumber = view.getOrderFromList();
        Map<Integer,Order> matchingOrder = service.getOrderMap(findNumber);
        orderList(matchingOrder);
    }
    
    private void orderList(Map<Integer,Order> orderMap) {
        view.bannerOrderSearchResults();
        view.showOrders(orderMap.values().stream().collect(Collectors.toList()));
        if(!orderMap.isEmpty()){
            boolean stop = false;
            int orderNum;
            LocalDate orderDay;
            while(!stop){
                Order order = orderMap.get(view.getOrderFromList());
                try{
                    orderNum = order.getOrderNum();
                    orderDay = order.getDay();
                    singleOrderAction(orderNum, orderDay);
                    stop = true;
                } catch (NullPointerException ex) {}
            }
        }
    }
    
    private void singleOrderAction(int orderNum, LocalDate orderDay){
        try {
            Order order = service.getOrder(orderNum, orderDay);
            view.showSingleOrderInfo(order);
            boolean stop = false;
            int action = view.getAction();
            while(!stop){
                switch(action){
                    case 1:
                        editOrder(orderNum, orderDay);
                        stop = true;
                        break;
                    case 2:
                        removeOrder(orderNum, orderDay);
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
    
    private void addOrder(){
        Order order = buildOrder();
        int orderNum;
        {
            try {
                orderNum = service.addOrder(order, order.getDay());
                order = service.getOrder(orderNum, order.getDay());
                view.showSingleOrderInfo(order);
                view.bannerAddSuccess(order.getOrderNum());
            } catch (InvalidOrderException | NoSuchOrderException ex) {
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
                view.bannerOrderEditSuccess(orderNum);
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
                view.bannerOrderRemoveSuccess(orderNum);
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
        
        Order editedOrder = new Order();
        editedOrder.setArea(newArea);
        editedOrder.setCustomerName(newName);
        editedOrder.setDay(newDay);
        editedOrder.setMaterial(newMater);
        editedOrder.setState(newState);
        
        return editedOrder;
    }
}
