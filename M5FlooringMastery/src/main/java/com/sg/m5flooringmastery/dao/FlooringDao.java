package com.sg.m5flooringmastery.dao;

import com.sg.m5flooringmastery.model.Order;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDate;

public interface FlooringDao {
    public void load(LocalDate day) throws FileNotFoundException;
    public void save(LocalDate day) throws IOException;
    public int loadKey() throws FileNotFoundException;
    public int saveKey() throws IOException;
    
    public int addOrder(Order order);
    public Order editOrder(Order order);
    public Order removeOrder(int id);
    public Order getOrder(int id);

    public void changeOrderDay(Order order, LocalDate newDay);
}
