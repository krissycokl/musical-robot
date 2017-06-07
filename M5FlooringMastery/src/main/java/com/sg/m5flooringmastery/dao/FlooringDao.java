package com.sg.m5flooringmastery.dao;

import com.sg.m5flooringmastery.model.Order;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public interface FlooringDao {
    public void load(LocalDate day) throws FileNotFoundException;
    public void save(LocalDate day) throws IOException;
    public int loadKey() throws FileNotFoundException;
    public int saveKey() throws IOException;
    
    public int addOrder(Order order, LocalDate day);
    public Order editOrder(Order order, LocalDate day);
    public Order removeOrder(int id, LocalDate day);
    public Order getOrder(int id, LocalDate day);
    
    public Map<Integer,Order> getOrderMap(LocalDate day);
    public List<LocalDate> getDatesWithOrders();

    public void changeOrderDay(Order order, LocalDate newDay) throws IOException, FileNotFoundException;
}
