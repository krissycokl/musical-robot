package com.sg.m5flooringmastery.dao;

import com.sg.m5flooringmastery.model.Order;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class FlooringDaoFileImpl implements FlooringDao {
    
    Map<Integer, Order> ordersForDay = new HashMap<>();
    int currKey;
    
    @Override
    public int addOrder(Order order, LocalDate day) {
        try {
            loadKey();
        } catch (FileNotFoundException ex) {
            currKey = 1;
        }
        currKey++;
        load(day);
        order.setKey(currKey);
        ordersForDay.put(currKey, order);
        save(day);
        try {
            saveKey();
        } catch (IOException ex) {
            System.out.println("Failed to persist Order Number at "+currKey);
        }
        return currKey;
    }

    @Override
    public void changeOrderDay(Order order, LocalDate newDay) throws IOException, FileNotFoundException {
        Order holder = removeOrder(order.getOrderNum(), order.getDay());
        holder.setDay(newDay);
        addOrder(holder, newDay);
    }

    @Override
    public Order editOrder(Order order, LocalDate day) {
        load(day);
        ordersForDay.put(order.getOrderNum(), order);
        save(day);
        return order;
    }

    @Override
    public Order getOrder(int id, LocalDate day){
        load(day);
        return ordersForDay.get(id);
    }

    @Override
    public List<Order> getOrderList(LocalDate day) {
        load(day);
        return ordersForDay.values().stream().collect(Collectors.toList());
    }

    @Override
    public Order removeOrder(int id, LocalDate day) {
        load(day);
        Order removed = ordersForDay.remove(id);
        save(day);
        return removed;
    }

    @Override
    public void load(LocalDate day) {
        ordersForDay = new HashMap<>();
        String dayAsString = day.format(DateTimeFormatter.ofPattern("MMdduuuu"));
        File filename = new File("OrderArchive/Orders_"+dayAsString+".txt");
        if (filename.exists()){
            try {
                Scanner sc = new Scanner(new BufferedReader(new FileReader(filename)));
                while(sc.hasNextLine()){
                    String[] orderInfo = sc.nextLine().split(",");
                    Order tempOrder = new Order(Integer.parseInt(orderInfo[0]));
                    tempOrder.setDay(day);
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
            catch (FileNotFoundException e) {System.out.println("Unexpected error reading "+filename+".");}

        }
    }

    @Override
    public void save(LocalDate day) {
        String dayAsString = day.format(DateTimeFormatter.ofPattern("MMdduuuu"));
        File filename = new File("OrderArchive/Orders_"+dayAsString+".txt");
        try {
            PrintWriter out2 = new PrintWriter(new FileWriter(filename, false));
            ordersForDay.values().stream().forEachOrdered(
                    order->{
                        out2.println(order.toString());
                        out2.flush();
                    }
            );
            out2.close();
        } catch (IOException ex) {
            System.out.println("Unexpected error writing to "+filename+".");
        }
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
