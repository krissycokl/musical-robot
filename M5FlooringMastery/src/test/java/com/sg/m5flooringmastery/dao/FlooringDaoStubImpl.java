package com.sg.m5flooringmastery.dao;

import com.sg.m5flooringmastery.model.Order;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FlooringDaoStubImpl implements FlooringDao {

    Map<Integer, Order> day1 = new HashMap<>();
    Map<Integer, Order> day2 = new HashMap<>();
    
    @Override
    public int addOrder(Order order, LocalDate day) {
        day1.put(order.getOrderNum(), order);
        return order.getOrderNum();
    }

    @Override
    public void changeOrderDay(Order order, LocalDate newDay) throws IOException, FileNotFoundException {
        
    }

    @Override
    public Order editOrder(Order order, LocalDate day) {
        day1.put(order.getOrderNum(), order);
        return order;
    }

    @Override
    public List<LocalDate> getDatesWithOrders() {
        List<LocalDate> dummyList = new ArrayList<>();
        dummyList.add(LocalDate.now());
        return dummyList;
    }

    @Override
    public Order getOrder(int id, LocalDate day) {
        return day1.get(id);
    }

    @Override
    public Map<Integer, Order> getOrderMap(LocalDate day) {
        return day1;
    }

    @Override
    public Map<Integer, Order> getOrderMap(String findName) {
        return day1;
    }

    @Override
    public Map<Integer, Order> getOrderMap(int orderNum) {
        return day1;
    }
    @Override
    public Order removeOrder(int id, LocalDate day) {
        return day1.remove(id);
    }
}
