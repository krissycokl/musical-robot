package com.sg.m5flooringmastery.dao;

import com.sg.m5flooringmastery.model.Order;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class FlooringDaoFileROImpl implements FlooringDao {

    int removedOrders = 0;
    private Map<Integer, Order> orderMap = new HashMap<>();
    private int currKey;
    
    private void initialize(){
        loadKey();
        List<LocalDate> validDates = getDatesWithOrders();
        validDates.stream().forEach(day->{
            load(day);
        });
    }
    
    @Override
    public Order addOrder(Order order, LocalDate day) {
        currKey++;
        order.setKey(currKey);
        orderMap.put(currKey, order);
        return order;
    }

    @Override
    public void changeOrderDay(Order order, LocalDate newDay) throws
            IOException,
            FileNotFoundException {
        order.setDay(newDay);
        orderMap.put(order.getOrderNum(), order);
    }

    @Override
    public Order editOrder(Order order, LocalDate day) {
        return orderMap.put(order.getOrderNum(), order);
    }

    @Override
    public List<LocalDate> getDatesWithOrders() {
        File dir = new File("OrderArchive/");
        File[] list = dir.listFiles();
        List<LocalDate> validDates = new ArrayList<>();
        IntStream.range(0, list.length).forEach(idx->{
            if(list[idx].getName().contains("Orders_")){
                String dateStr = list[idx].getName().substring(7,15);
                validDates.add(LocalDate.parse(dateStr, DateTimeFormatter.ofPattern("MMdduuuu")));
            }
        });
        return validDates;
    }

    @Override
    public Order getOrder(int id, LocalDate day) {
        return orderMap.get(id);
    }

    @Override
    public Map<Integer, Order> getOrderMap(String findName) {
        if(orderMap.isEmpty() && removedOrders == 0){
            initialize();
        }
        
        Map<Integer,Order> matchingOrders = new HashMap<>();
        orderMap.values().stream().forEach(order->{
            if(order.getCustomerName().toLowerCase().contains(findName)){
                matchingOrders.put(order.getOrderNum(),order);
            }
        });
        
        return matchingOrders;
    }

    @Override
    public Map<Integer, Order> getOrderMap(int orderNum) {
        if(orderMap.isEmpty() && removedOrders == 0){
            initialize();
        }
        
        Map<Integer,Order> matchingOrder = new HashMap<>();
        Order order = orderMap.get(orderNum);
        if (order != null){
            matchingOrder.put(orderNum, order);
        }
        
        return matchingOrder;
    }

    @Override
    public Map<Integer, Order> getOrderMap(LocalDate day) {
        if(orderMap.isEmpty() && removedOrders == 0){
            initialize();
        }
        
        return orderMap
                .entrySet()
                .stream()
                .filter(e->e.getValue().getDay().equals(day))
                .collect(Collectors.toMap(e->e.getKey(), e->e.getValue()));
    }

    @Override
    public Order removeOrder(int id, LocalDate day) {
        Order toRemove = getOrder(id, day);
        orderMap.remove(id);
        removedOrders++;
        return toRemove;
    }
    
    public void load(LocalDate day) {
        String dayAsString = day.format(DateTimeFormatter.ofPattern("MMdduuuu"));
        File filename = new File("OrderArchive/Orders_"+dayAsString+".txt");
        if (filename.exists()){
            try {
                Scanner sc = new Scanner(new BufferedReader(new FileReader(filename)));
                String[] orderInfo;
                sc.nextLine();
                while (sc.hasNextLine()) {
                    orderInfo = sc.nextLine().split("(?<!\\\\),");
                    Order tempOrder = new Order(Integer.parseInt(orderInfo[0]));
                    tempOrder.setDay(day);
                    orderInfo[1] = orderInfo[1].replace("\\,", ",");
                    tempOrder.setCustomerName(orderInfo[1]);
                    tempOrder.setState(orderInfo[2]);
                    tempOrder.setTaxRate(new BigDecimal(orderInfo[3]).divide(new BigDecimal("100")));
                    tempOrder.setMaterial(orderInfo[4]);
                    tempOrder.setArea(new BigDecimal(orderInfo[5]));
                    tempOrder.setMaterialCostPerSqFt(new BigDecimal(orderInfo[6]));
                    tempOrder.setLaborCostPerSqFt(new BigDecimal(orderInfo[7]));
                    tempOrder.setMaterialCost(new BigDecimal(orderInfo[8]));
                    tempOrder.setLaborCost(new BigDecimal(orderInfo[9]));
                    tempOrder.setTaxAmount(new BigDecimal(orderInfo[10]));
                    tempOrder.setTotalCost(new BigDecimal(orderInfo[11]));

                    orderMap.put(tempOrder.getOrderNum(), tempOrder);
                }
                sc.close();
            }
            catch (IOException e) {System.out.println("Unexpected error reading "+filename+".");}
        }
    }

    public int loadKey() {
        try{
            Scanner sc = new Scanner(new BufferedReader(new FileReader("index.txt")));
            currKey = sc.nextInt();
            sc.close();
            return currKey;
        } catch (FileNotFoundException e) {
            System.out.println("Could not locate index.txt.  Key set at 1.");
            return currKey = 1;
        }
    }
}
