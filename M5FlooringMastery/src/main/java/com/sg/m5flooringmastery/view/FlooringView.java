package com.sg.m5flooringmastery.view;

import com.sg.m5flooringmastery.model.Order;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.IntStream;

public class FlooringView {
    UserIO io;
    
    public FlooringView(UserIO io){
        this.io = io;
    }
    
    public int getMainMenuChoice(){
        io.print("1. Display orders by date");
        //io.print("2. Look up order by customer name");
        //io.print("3. Look up order by number");
        io.print("4. Add an order");
        io.print("5. Quit");
        return io.getInt("What would you like to do?", false, 1,5);
    }

    public int getOrderFromList(){
        return io.getInt("Enter # of desired order.", false);
    }
    
    public int getAction(){
        io.print("1.) Edit order");
        io.print("2.) Remove order");
        io.print("3.) Back");
        return io.getInt("What would you like to do?",false,1,3);
    }
    
    public BigDecimal getOrderArea(BigDecimal area, boolean blankOk) {
        String prompt = String.format("%15s","Area in sq ft: ");
        if (area.compareTo(BigDecimal.ZERO) != 0){
            prompt += "(currently "+area.toPlainString()+" sq ft, press Enter to leave unchanged)";
        }
        return io.getBigD(prompt, blankOk, BigDecimal.ONE, new BigDecimal("1000000"));
    }

    public String getOrderCustomer(String name) {
        String prompt = String.format("%15s","Customer name: ");
        if (!name.isEmpty()){
            prompt += "(currently "+name+", press Enter to leave unchanged)";
        }
        return io.getString(prompt);
    }

    public String getOrderMaterial(String material, List<String> validMaterials) {
        String prompt = String.format("%15s","Material: ");
        if (!material.isEmpty()){
            prompt += "(currently "+material+", press Enter to leave unchanged)";
        }
        IntStream.range(0, validMaterials.size()).forEach(index->{
            io.print((index+1)+".) "+validMaterials.get(index));
        });
        int choice = io.getInt(prompt, true, 1, validMaterials.size()+1);
        return validMaterials.get(choice-1);
    }

    public String getOrderState(String state, List<String> validStates) {
        String prompt = String.format("%15s","State: ");
        if (!state.isEmpty()){
            prompt += "(currently "+state+", press Enter to leave unchanged)";
        }
        IntStream.range(0, validStates.size()).forEach(index->{
            io.print((index+1)+".) "+validStates.get(index));
        });
        int choice = io.getInt(prompt, true, 1, validStates.size()+1);
        return validStates.get(choice-1);
    }
    
    public LocalDate getOrderDay(LocalDate day, boolean blankOk){
        String prompt = String.format("%15s","Date: ");
        if(!day.isEqual(LocalDate.of(1900, Month.JANUARY, 1))){
            prompt += "(currently "+day.format(DateTimeFormatter.ofPattern("MM/dd/uuuu"))+", press Enter to leave unchanged)";
        }
        return io.getDate(prompt, blankOk, day);
    }
    
    public void showOrders(List<Order> orders){
        if (orders.isEmpty()) {
            io.print("No orders found with selected criteria.");
        } else {
            io.print(
                    "  Ord |    Date    |  Customer  |  Cost"
            );
            orders.stream().forEach(order->
            {
                String p1=String.format("%5d", order.getOrderNum());
                String p2=" | "+order.getDay().format(DateTimeFormatter.ofPattern("MM/dd/uuuu"));
                String p3=" | "+String.format("%-10s", order.getCustomerName());
                String p4=" | $"+String.format("%10s",order.getTotalCost().toPlainString());
                io.print(p1+p2+p3+p4);
            }
            );
        }
    }
    
    public void showError(Throwable ex){
        io.print(ex.getMessage());
    }
    
    public int confirmRemove(){
        io.print("Really delete this order? This action cannot be undone.");
        return io.getInt("1. Delete   2. Cancel",false,1,2);
    }
}
