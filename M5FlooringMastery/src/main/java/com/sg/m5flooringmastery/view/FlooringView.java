package com.sg.m5flooringmastery.view;

import com.sg.m5flooringmastery.model.Order;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

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
        io.print("5. Edit an order");
        io.print("6. Remove an order");
        io.print("7. Quit");
        return io.getInt("What would you like to do?", 1,7);
    }

    private BigDecimal getOrderArea() {
        return io.getBigD("Please enter the area to be floored:", BigDecimal.ZERO, new BigDecimal("1000000"));
    }

    private String getOrderCustomer() {
        return io.getString("Please enter the customer's name:");
    }

    private String getOrderMaterial() {
        return io.getString("Material:");
        //going to print known materials
    }

    private String getOrderState() {
        return io.getString("State:");
        //going to print known states
    }
    
    public void showOrders(List<Order> orders){
        if (orders.isEmpty()) {
            io.print("No orders found with selected criteria.");
        } else {
            io.print(
                    "  Ord |   Date   |  Customer  |  Cost"
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
    
    public LocalDate getOrderDay(){
        return io.getDate("Please enter a date of format MM/DD/YYYY", LocalDate.now());
    }
    
    public void showError(Throwable ex){
        io.print(ex.getMessage());
    }
    
    public Order getOrder(){
        Order thisOrder = new Order();
        thisOrder.setArea(getOrderArea());
        thisOrder.setCustomerName(getOrderCustomer());
        thisOrder.setDay(getOrderDay());
        thisOrder.setMaterial(getOrderMaterial());
        thisOrder.setState(getOrderState());
        return thisOrder;
    }
}
