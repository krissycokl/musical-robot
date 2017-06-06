package com.sg.m5flooringmastery.dao;

import com.sg.m5flooringmastery.model.Order;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class FlooringDaoFileImpl implements FlooringDao {
    
    Map<Integer, Order> ordersForDay = new HashMap<>();
    int currKey;
    
    @Override
    public int addOrder(Order order) {
        currKey++;
        ordersForDay.put(currKey, order);
        return currKey;
    }

    @Override
    public void changeOrderDay(Order order, LocalDate newDay) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Order editOrder(Order order) {
        return ordersForDay.put(order.getOrderNum(), order);
    }

    @Override
    public Order getOrder(int id){
        return ordersForDay.get(id);
    }

    @Override
    public Order removeOrder(int id) {
        return ordersForDay.remove(id);
    }

    @Override
    public void load(LocalDate day) throws FileNotFoundException {
        ordersForDay = new HashMap<>();
        String dayAsString = day.format(DateTimeFormatter.ofPattern("MMdduuuu"));
        Scanner sc = new Scanner(new BufferedReader(new FileReader(
                "OrderArchive/Orders_"+dayAsString+".txt"
        )));
        while(sc.hasNextLine()){
            String[] orderInfo = sc.nextLine().split(",");
            Order tempOrder = new Order(Integer.parseInt(orderInfo[0]));
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
            
            ordersForDay.put(tempOrder.getOrderNum(), tempOrder);
        }
        sc.close();
    }

    @Override
    public void save(LocalDate day) throws IOException {
        String dayAsString = day.format(DateTimeFormatter.ofPattern("MMdduuuu"));
        PrintWriter out2 = new PrintWriter(new FileWriter(
                "OrderArchive/Orders_"+dayAsString+".txt"
                , false));
        
        ordersForDay.values().stream().forEachOrdered(
                order->{
                    out2.println(order.toString());
                    out2.flush();
                }
        );
        out2.close();
    }

    @Override
    public int loadKey() throws FileNotFoundException {
        Scanner sc = new Scanner(new BufferedReader(new FileReader("index.txt")));
        currKey = sc.nextInt();
        sc.close();
        return currKey;
    }
    
    @Override
    public int saveKey() throws IOException {
        PrintWriter out1 = new PrintWriter(new FileWriter("index.txt", false));
        out1.print(currKey);
        out1.flush();
        out1.close();
        return currKey;
    }

}
