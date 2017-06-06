package com.sg.m5flooringmastery.service;

import com.sg.m5flooringmastery.model.Order;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

public interface FlooringService {
    public int addOrder(Order order, LocalDate day) throws InvalidOrderException;
    public void changeOrderDay(Order order, LocalDate newDay) throws IOException, FileNotFoundException;
    public Order editOrder(Order order, LocalDate day) throws InvalidOrderException;
    public Order getOrder(int id, LocalDate day) throws NoSuchOrderException;
    public List<Order> getOrderList(LocalDate day);
    public Order removeOrder(int id, LocalDate day) throws NoSuchOrderException;
    public int loadKey() throws FileNotFoundException;
    public int saveKey() throws IOException;
    public boolean validateOrder(Order order) throws InvalidOrderException;
}
