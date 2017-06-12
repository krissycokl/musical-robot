package com.sg.m5flooringmastery.controller;

import com.sg.m5flooringmastery.dao.MaterialsPersistenceException;
import com.sg.m5flooringmastery.dao.StatePersistenceException;
import com.sg.m5flooringmastery.model.Material;
import com.sg.m5flooringmastery.model.Order;
import com.sg.m5flooringmastery.model.State;
import com.sg.m5flooringmastery.service.FlooringService;
import com.sg.m5flooringmastery.service.InvalidOrderException;
import com.sg.m5flooringmastery.service.MaterialOverwriteException;
import com.sg.m5flooringmastery.service.NoSuchOrderException;
import com.sg.m5flooringmastery.service.StateOverwriteException;
import com.sg.m5flooringmastery.view.FlooringView;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Month;
import java.util.Map;
import java.util.stream.Collectors;

public class FlooringController {
    
    private FlooringView view;
    private FlooringService service;
    private String currMode = "Production";
    
    public FlooringController(FlooringView view, FlooringService service) {
        this.view = view;
        this.service = service;
    }
    
    private void adminMenuMaterials() {
        view.bannerAdminMaterials();
        int choice = view.getAdminAction("Material");
        switch (choice) {
            case 1:
                adminAddMat();
                break;
            case 2:
                adminEditMat();
                break;
            case 3:
                adminRemoveMat();
                break;
            case 4:
                break;
        }
    }
    
    private void adminMenuStates() {
        view.bannerAdminState();
        int choice = view.getAdminAction("State");
        switch (choice) {
            case 1:
                adminAddState();
                break;
            case 2:
                adminEditState();
                break;
            case 3:
                adminRemoveState();
                break;
            case 4:
                break;
        }
    }
    
    private void adminAddMat(){
        Material newMat;
        view.bannerAdminNewMaterial();
        newMat = view.getAdminNewMaterial();
        try {
            service.adminAddMaterial(newMat);
            view.bannerAdminNewSuccess(newMat.getName());
        } catch (MaterialOverwriteException | MaterialsPersistenceException e) {
            view.showError(e);
        }
    }
    
    private void adminRemoveMat(){
        String removeMat = view.getOrderMaterial("", service.getValidMaterials());
        try {
            service.adminRemoveMaterial(removeMat);
            view.bannerAdminRemoveSuccess(removeMat);
        } catch (MaterialsPersistenceException e) {
            view.showError(e);
        }
    }
    
    private void adminEditMat(){
        Material newMat;
        String oldMatName = view.getOrderMaterial("", service.getValidMaterials());
        view.bannerAdminEditMaterial(oldMatName);
        newMat = view.getAdminNewMaterial();
        try {
            service.adminEditMaterial(oldMatName, newMat);
            view.bannerAdminEditSuccess(newMat.getName());
        } catch (MaterialOverwriteException | MaterialsPersistenceException e) {
            view.showError(e);
        }
    }
    
    private void adminAddState(){
        view.bannerAdminNewState();
        State newState = view.getAdminNewState();
        try {
            service.adminAddState(newState);
            view.bannerAdminNewSuccess(newState.getName());
        } catch (StateOverwriteException | StatePersistenceException e) {
            view.showError(e);
        }
    }
    
    private void adminRemoveState(){
        String removeStateName = view.getOrderState("", service.getValidStates());
        try {
            service.adminRemoveState(removeStateName);
            view.bannerAdminRemoveSuccess(removeStateName);
        } catch (StatePersistenceException e) {
            view.showError(e);
        }
    }
    
    private void adminEditState(){
        String oldStateName = view.getOrderState("", service.getValidStates());
        view.bannerAdminEditState(oldStateName);
        State newState = view.getAdminNewState();
        try {
            service.adminEditState(oldStateName, newState);
            view.bannerAdminEditSuccess(newState.getName());
        } catch (StateOverwriteException | StatePersistenceException e) {
            view.showError(e);
        }
    }
    
    private void adminMenu() {
        view.bannerAdminMenu();
        switch (view.getAdminMainMenuChoice()) {
            case 1:
                adminMenuMaterials();
                break;
            case 2:
                adminMenuStates();
                break;
            case 3:
                break;
        }
    }
    
    public boolean run() {
        view.bannerMainMenu();
        switch (view.getMainMenuChoice(currMode)) {
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
                adminMenu();
                break;
            case 6:
                switchMode();
                break;
            case 7:
                return true;
        }
        return false;
    }
    
    private void orderListByDay() {
        LocalDate day = view.getOrderDay(LocalDate.of(1900, Month.JANUARY, 1), false);
        Map<Integer, Order> matchingOrders = service.getOrderMap(day);
        orderList(matchingOrders);
    }
    
    private void orderListByLastName() {
        //LocalDate fromDay = view.getOrderDay(LocalDate.of(1900, Month.JANUARY, 1), false);
        //LocalDate toDay   = view.getOrderDay(LocalDate.of(1900, Month.JANUARY, 1), false)
        String findName = view.getOrderCustomer("").toLowerCase();
        Map<Integer, Order> matchingOrders = service.getOrderMap(findName);
        orderList(matchingOrders);
    }
    
    private void orderListByNumber() {
        int findNumber = view.getOrderFromList();
        Map<Integer, Order> matchingOrder = service.getOrderMap(findNumber);
        orderList(matchingOrder);
    }
    
    private void orderList(Map<Integer, Order> orderMap) {
        view.bannerOrderSearchResults();
        view.showOrders(orderMap.values().stream().collect(Collectors.toList()));
        if (!orderMap.isEmpty()) {
            boolean stop = false;
            int orderNum;
            LocalDate orderDay;
            while (!stop) {
                Order order = orderMap.get(view.getOrderFromList());
                if (order == null) {
                    view.bannerOrderSearchResults();
                    view.showOrders(null);
                    stop = true;
                } else {
                    orderNum = order.getOrderNum();
                    orderDay = order.getDay();
                    singleOrderAction(orderNum, orderDay);
                    stop = true;
                }
            }
        }
    }
    
    private void singleOrderAction(int orderNum, LocalDate orderDay) {
        try {
            Order order = service.getOrder(orderNum, orderDay);
            view.showSingleOrderInfo(order);
            boolean stop = false;
            int action = view.getAction();
            while (!stop) {
                switch (action) {
                    case 1:
                        editOrder(order);
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
        } catch (NoSuchOrderException e) {
            view.showError(e);
        }
    }
    
    private void addOrder() {
        Order order = buildOrder();
        {
            try {
                order = service.addOrder(order, order.getDay());
                view.showSingleOrderInfo(order);
                view.bannerAddSuccess(order.getOrderNum());
            } catch (InvalidOrderException e) {
                view.showError(e);
            }
        }
    }
    
    private void editOrder(Order order) {
        Order editedOrder = buildEditedOrder(order);
        try {
            service.editOrder(order, editedOrder, order.getDay());
            view.bannerOrderEditSuccess(order.getOrderNum());
        } catch (Exception e) {
            view.showError(e);
        }
        
    }
    
    private void removeOrder(int orderNum, LocalDate day) {
        if (view.confirmRemove() == 1) {
            try {
                service.removeOrder(orderNum, day);
                view.bannerOrderRemoveSuccess(orderNum);
            } catch (NoSuchOrderException e) {
                view.showError(e);
            }
        }
    }
    
    private Order buildOrder() {
        Order thisOrder = new Order();
        thisOrder.setArea(view.getOrderArea(BigDecimal.ZERO, false));
        thisOrder.setCustomerName(view.getOrderCustomer(""));
        thisOrder.setDay(view.getOrderDay(LocalDate.of(1900, Month.JANUARY, 1), false));
        thisOrder.setMaterial(view.getOrderMaterial("", service.getValidMaterials()));
        thisOrder.setState(view.getOrderState("", service.getValidStates()));
        return thisOrder;
    }
    
    private Order buildEditedOrder(Order order) {
        BigDecimal newArea = view.getOrderArea(order.getArea(), true);
        String newName = view.getOrderCustomer(order.getCustomerName());
        LocalDate newDay = view.getOrderDay(order.getDay(), true);
        String newMater = view.getOrderMaterial(order.getMaterial(), service.getValidMaterials());
        String newState = view.getOrderState(order.getState(), service.getValidStates());
        
        Order editedOrder = new Order();
        editedOrder.setArea(newArea);
        editedOrder.setCustomerName(newName);
        editedOrder.setDay(newDay);
        editedOrder.setMaterial(newMater);
        editedOrder.setState(newState);
        
        return editedOrder;
    }

    private void switchMode() {
        if(view.confirmSwitchMode(currMode) == 1){
            try {
                currMode = service.switchMode();
                view.bannerSwitchModeSuccess(currMode);
            } catch (FileNotFoundException e){
                view.showError(e);
            }
        }
    }
}
