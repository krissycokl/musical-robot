package com.sg.m5flooringmastery.dao;

import com.sg.m5flooringmastery.model.Order;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public interface FlooringDao {
    
    public int addOrder(Order order, LocalDate day);
    public Order editOrder(Order order, LocalDate day);
    public Order removeOrder(int id, LocalDate day);
    public Order getOrder(int id, LocalDate day);
    
    public Map<Integer,Order> getOrderMap(String findName);
    public Map<Integer,Order> getOrderMap(int orderNum);
    public Map<Integer,Order> getOrderMap(LocalDate day);
    public List<LocalDate> getDatesWithOrders();

    public void changeOrderDay(Order order, LocalDate newDay) throws IOException, FileNotFoundException;
}
