package com.sg.m5flooringmastery.view;

import com.sg.m5flooringmastery.model.Material;
import com.sg.m5flooringmastery.model.Order;
import com.sg.m5flooringmastery.model.State;
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

    public void bannerAdminEditMaterial(String oldMatName) {
        io.print("\n=== Editing "+oldMatName+" ===");
    }

    public void bannerAdminEditState(String oldStateName) {
        io.print("\n=== Editing "+oldStateName+" ===");
    }

    public void bannerAdminMaterials() {
        io.print("\n=== Admin: Materials ===");
    }

    public void bannerAdminMenu() {
        io.print("\n=== Admin Menu ===");
    }

    public void bannerAdminNewMaterial() {
        io.print("\n=== Adding New Material ===");
    }

    public void bannerAdminNewState() {
        io.print("\n=== Adding New State ===");
    }

    public void bannerAdminNewSuccess(String newThingName){
        io.print("\n=== Successfully added "+newThingName+" ===");
    }
    
    public void bannerAdminEditSuccess(String thingName){
        io.print("\n=== Successfully edited "+thingName+" ===");
    }
    
    public void bannerAdminRemoveSuccess(String oldThingName){
        io.print("\n=== Successfully removed "+oldThingName+" ===");
    }
    
    public void bannerAdminState() {
        io.print("\n=== Admin: States ===");
    }

    public Material getAdminNewMaterial(){
        Material material = new Material();
        material.setName(io.getString("Material name:", false));
        material.setMaterialCost(io.getBigD("Material cost per sqft", false, BigDecimal.ZERO, new BigDecimal("1000")));
        material.setLaborCost(io.getBigD("Labor cost per sqft:", false, BigDecimal.ZERO, new BigDecimal("1000")));
        return material;
    }
    
    public State getAdminNewState(){
        State state = new State();
        state.setName(io.getString("State:", false));
        state.setTaxRate(io.getBigD("Tax rate:", true));
        return state;
    }
    
    public int getAdminAction(String type) {
        io.print("1.) Add new "+type);
        io.print("2.) Edit "+type);
        io.print("3.) Remove "+type);
        io.print("4.) Back");
        return io.getInt("What would you like to do?", true,1,4);
    }
    
    public int getMainMenuChoice(){
        io.print("1.) Display orders by date");
        io.print("2.) Look up order by customer name");
        io.print("3.) Look up order by number");
        io.print("4.) Add an order");
        io.print("5.) Admin menu");
        io.print("6.) Quit");
        return io.getInt("What would you like to do?", false, 1,6);
    }

    public int getAdminMainMenuChoice(){
        io.print("1.) Change materials");
        io.print("2.) Change states");
        io.print("3.) Back");
        return io.getInt("What would you like to do?", false, 1, 3);
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
        String prompt = "Area in sq ft: ";
        if (area.compareTo(BigDecimal.ZERO) != 0){
            prompt += "(currently "+area.toPlainString()+" sq ft, press Enter to leave unchanged)";
        }
        BigDecimal newArea = io.getBigD(prompt, blankOk, BigDecimal.ONE, new BigDecimal("1000000"));
        if(newArea.compareTo(BigDecimal.ZERO)==0){
            return area;
        }
        return newArea;
    }

    public String getOrderCustomer(String name) {
        String prompt = "Customer name: ";
        if (!name.isEmpty()){
            prompt += "(currently "+name+", press Enter to leave unchanged)";
        }
        String newName = io.getString(prompt, true);
        if(newName.isEmpty()){
            return name;
        }
        return newName;
    }

    public String getOrderMaterial(String material, List<Material> validMaterials) {
        String prompt = "Material: ";
        if (!material.isEmpty()){
            prompt += "(currently "+material+", press Enter to leave unchanged)";
        }
        io.print(
                String.format("%15.15s","Material |")
               +String.format("%10.10s","Mat cost |")
               +String.format("%10.10s","Labor cost")
        );
        IntStream.range(0, validMaterials.size()).forEach(index->{
            Material currMat = validMaterials.get(index);
            String currLine = String.format("%-15.15s",(index+1)+".) "+currMat.getName());
            currLine += String.format("%10.10s"," $"+currMat.getMaterialCost());
            currLine += String.format("%10.10s"," $"+currMat.getLaborCost());
            io.print(currLine);
        });
        int choice = io.getInt(prompt, true, 1, validMaterials.size()+1);
        if (choice == 0){
            return material;
        }
        return validMaterials.get(choice-1).getName();
    }

    public String getOrderState(String state, List<State> validStates) {
        String prompt = "State: ";
        if (!state.isEmpty()){
            prompt += "(currently "+state+", press Enter to leave unchanged)";
        }
        io.print(
                String.format("%10.10s", "  State  |")
               +String.format("%10.10s", "Tax rate")
        );
        IntStream.range(0, validStates.size()).forEach(index->{
            State currState = validStates.get(index);
            String currLine = String.format("%-10.10s", (index+1)+".) "+currState.getName());
            currLine += String.format("%10.10s", currState.getTaxRate());
            io.print(currLine);
        });
        int choice = io.getInt(prompt, true, 1, validStates.size()+1);
        if (choice == 0){
            return state;
        }
        return validStates.get(choice-1).getName();
    }
    
    public LocalDate getOrderDay(LocalDate day, boolean blankOk){
        String prompt = "Date: ";
        if(!day.isEqual(LocalDate.of(1900, Month.JANUARY, 1))){
            prompt += "(currently "+day.format(DateTimeFormatter.ofPattern("MM/dd/uuuu"))+", press Enter to leave unchanged)";
        }
        return io.getDate(prompt, blankOk, day);
    }
    
    public void showSingleOrderInfo(Order order){
        io.print("\n=== Order #"+order.getOrderNum()+" ===");
            io.print(String.format("%16s","Area (sqft): ")+order.getArea());
            io.print(String.format("%16s","Customer Name: ")+order.getCustomerName());
            io.print(String.format("%16s","Material: ")+order.getMaterial());
            io.print(String.format("%16s","State: ")+order.getState());
            io.print(String.format("%17s","Material Cost: $")+order.getMaterialCost());
            io.print(String.format("%17s","Labor Cost: $")+order.getLaborCost());
            io.print(String.format("%17s","Tax Amount: $")+order.getTaxAmount());
            io.print(String.format("%17s","Total Cost: $")+order.getTotalCost());
    }
    
    public void showOrders(List<Order> orders){
        if (orders.isEmpty()) {
            io.print("No orders found with selected criteria.");
        } else {
            io.print(
                    "  Ord # |    Date    |       Customer       |  Cost"
            );
            orders.stream().forEach(order->
            {
                String p1=String.format("%7d", order.getOrderNum());
                String p2=" | "+order.getDay().format(DateTimeFormatter.ofPattern("MM/dd/uuuu"));
                String p3=" | "+String.format("%20.20s",order.getCustomerName());
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
    
    public void bannerAddSuccess(int orderNum){
        io.print("\n=== Order #"+orderNum+" Successfully Created ===");
    }
    
    public void bannerMainMenu(){
        io.print("\n=== Main Menu ===");
    }
    
    public void bannerOrderSearchResults(){
        io.print("\n=== Search Results ===");
    }
    
    public void bannerOrderEditSuccess(int orderNum){
        io.print("\n=== Order #"+orderNum+" Successfully Edited ===");
    }
    
    public void bannerOrderRemoveSuccess(int orderNum){
        io.print("\n=== Order #"+orderNum+" Successfully Deleted ===");
    }
}
