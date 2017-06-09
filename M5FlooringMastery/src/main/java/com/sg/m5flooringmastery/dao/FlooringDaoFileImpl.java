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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.IntStream;
import com.opencsv.CSVWriter;
import static com.opencsv.CSVWriter.NO_ESCAPE_CHARACTER;
import static com.opencsv.CSVWriter.NO_QUOTE_CHARACTER;

public class FlooringDaoFileImpl implements FlooringDao {

    private static final String[] ORDERHEADER = {
        "OrderNumber",
        "CustomerName",
        "State",
        "TaxRate",
        "ProductType",
        "Area",
        "CostPerSquareFoot",
        "LaborCostPerSquareFoot",
        "MaterialCost",
        "LaborCost",
        "Tax",
        "Total"
    };

    Map<Integer, Order> ordersForDay = new HashMap<>();
    int currKey;

    @Override
    public List<LocalDate> getDatesWithOrders() {
        File dir = new File("OrderArchive/");
        File[] list = dir.listFiles();
        List<LocalDate> validDates = new ArrayList<>();
        IntStream.range(0, list.length).forEach(idx -> {
            if (list[idx].getName().contains("Orders_")) {
                String dateStr = list[idx].getName().substring(7, 15);
                validDates.add(LocalDate.parse(dateStr, DateTimeFormatter.ofPattern("MMdduuuu")));
            }
        });
        return validDates;
    }

    @Override
    public Order addOrder(Order order, LocalDate day) {
        if (order.getOrderNum() == 0) {
            try {
                loadKey();
            } catch (FileNotFoundException ex) {
                currKey = 1;
            }
            currKey++;
            order.setKey(currKey);
            try {
                saveKey();
            } catch (IOException ex) {
                System.out.println("Failed to persist Order Number at " + currKey);
            }
        }
        load(day);
        ordersForDay.put(order.getOrderNum(), order);
        save(day);
        return order;
    }

    @Override
    public void changeOrderDay(Order order, LocalDate newDay) throws
            IOException,
            FileNotFoundException {
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
    public Order getOrder(int id, LocalDate day) {
        load(day);
        return ordersForDay.get(id);
    }

    @Override
    public Map<Integer, Order> getOrderMap(LocalDate day) {
        load(day);
        return ordersForDay;
    }

    @Override
    public Map<Integer, Order> getOrderMap(String findName) {
        List<LocalDate> validDates = getDatesWithOrders();
        Map<Integer, Order> matchingOrders = new HashMap<>();
        validDates.stream().forEach(day -> {
            Map<Integer, Order> tempOrderMap = getOrderMap(day);
            tempOrderMap.values().stream().forEach(order -> {
                if (order.getCustomerName().toLowerCase().contains(findName)) {
                    matchingOrders.put(order.getOrderNum(), order);
                }
            });
        });
        return matchingOrders;
    }

    @Override
    public Map<Integer, Order> getOrderMap(int orderNum) {
        List<LocalDate> validDates = getDatesWithOrders();
        Map<Integer, Order> matchingOrder = new HashMap<>();
        validDates.stream().forEach(day -> {
            if (matchingOrder.isEmpty()) {
                Map<Integer, Order> tempOrderMap = getOrderMap(day);
                tempOrderMap.values().stream().forEach(order -> {
                    if (order.getOrderNum() == orderNum) {
                        matchingOrder.put(order.getOrderNum(), order);
                    }
                });
            }
        });
        return matchingOrder;
    }

    @Override
    public Order removeOrder(int id, LocalDate day) {
        load(day);
        Order removed = ordersForDay.remove(id);
        save(day);
        return removed;
    }

    public void load(LocalDate day) {
        ordersForDay = new HashMap<>();
        String dayAsString = day.format(DateTimeFormatter.ofPattern("MMdduuuu"));
        File filename = new File("OrderArchive/Orders_" + dayAsString + ".txt");
        if (filename.exists()) {
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

                    ordersForDay.put(tempOrder.getOrderNum(), tempOrder);
                }
                sc.close();

            } catch (IOException e) {
                System.out.println("Unexpected error reading " + filename + ".");
            }

        }
    }

    public void save(LocalDate day) {
        String dayAsString = day.format(DateTimeFormatter.ofPattern("MMdduuuu"));
        File filename = new File("OrderArchive/Orders_" + dayAsString + ".txt");
        if (ordersForDay.isEmpty()) {
            filename.delete();
        } else {
            try {
                CSVWriter out = new CSVWriter(new FileWriter(filename), ',', NO_QUOTE_CHARACTER, NO_ESCAPE_CHARACTER);
                out.writeNext(ORDERHEADER);
                ordersForDay.values().stream().forEachOrdered(
                        order -> {
                            try {
                                out.writeNext(order.toStringAry());
                                out.flush();
                            } catch (IOException ex) {
                                System.out.println("Unexpected error writing to " + filename + ".");
                            }
                        }
                );
                out.close();
            } catch (IOException ex) {
                System.out.println("Unexpected error writing to " + filename + ".");
            }
        }
    }

    public int loadKey() throws FileNotFoundException {
        Scanner sc = new Scanner(new BufferedReader(new FileReader("index.txt")));
        currKey = sc.nextInt();
        sc.close();
        return currKey;
    }

    public int saveKey() throws IOException {
        PrintWriter out1 = new PrintWriter(new FileWriter("index.txt", false));
        out1.print(currKey);
        out1.flush();
        out1.close();
        return currKey;
    }

}
