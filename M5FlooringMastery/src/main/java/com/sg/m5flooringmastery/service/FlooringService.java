package com.sg.m5flooringmastery.service;

import com.sg.m5flooringmastery.model.Order;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public interface FlooringService {
    public int addOrder(Order order, LocalDate day) throws InvalidOrderException;
    
    public List<String> getValidMaterials();
    public List<String> getValidStates();
    
    public void changeOrderDay(Order order, LocalDate newDay) throws 
            IOException,
            FileNotFoundException,
            OrderEditException;
    
    public Order editOrder(Order order, Order editedOrder, LocalDate day) throws
            InvalidOrderException,
            OrderEditException,
            IOException;
    
    public Order getOrder(int id, LocalDate day) throws
            NoSuchOrderException;
    
    public Map<Integer,Order> getOrderMap(LocalDate day);
    
    public Order removeOrder(int id, LocalDate day) throws
            NoSuchOrderException;
    
    public int loadKey() throws
            FileNotFoundException;
    
    public int saveKey() throws
            IOException;
    
    public boolean validateOrder(Order order) throws
            InvalidOrderException;
    
    public Order calculateCosts(Order order);
    
    public Order retrieveCosts(Order order) throws
            InvalidOrderException;
    
    public Order retrieveTaxRate(Order order) throws
            InvalidOrderException;
    
    public List<LocalDate> getDatesWithOrders();
}
