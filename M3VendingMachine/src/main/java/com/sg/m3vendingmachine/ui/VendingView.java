package com.sg.m3vendingmachine.ui;

import com.sg.m3vendingmachine.dto.Item;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.Map;

public class VendingView {
    private final UserIO io;
    
    public VendingView(UserIO io){
        this.io = io;
    }
    
    public void adminShowMainMenu(List<Item> stock){
        io.print(" 0.) Add new item");
        stock
                .stream()
                .forEachOrdered(e->{
                    io.print(" "+e.getID()+".) "
                            +e.getName()+" $"
                            +e.getCost()+" OH:"
                            +e.getQty()+" Active: "
                            +e.getActive()
                    );
                });
        io.print("-1.) Go back");
    }
    
    public void bannerNoInputFile(){
        io.print("No input file found. Building from sratch.");
    }
    
    public void bannerFailedToSave(){
        io.print("Failed to save file.");
    }
    
    public void adminBannerLeaving(){
        io.print("Leaving service menu.");
    }
    
    public int adminShowItemMenuAndGetChoice(){
        io.print(" 1.) Change product name");
        io.print(" 2.) Stock product");
        io.print(" 3.) Change price");
        io.print(" 4.) (Dis)activate");
        io.print(" 5.) Back");
        return io.getInt("",1,5);
    }
    
    public void showBalance(BigDecimal balance){
        io.print(balance.setScale(2).toPlainString());
    }
    
    public void showInventoryAndMenu(List<Item> stock){
        stock
                .stream()
                .filter(e-> e.getActive())
                .forEachOrdered(e-> {
                    if(e.getQty()>0){
                        io.print(" "+e.getID()+".) "
                            +e.getName()+" $"
                            +e.getCost());
                    } else {
                        io.print(" "+e.getID()+".) "
                            +e.getName()+" Out of Stock");
                    }
                });
    }
    
    public int adminGetMainChoice(int max){
        return io.getInt("Which item? (service)",-1,max);
    }
    
    public String adminGetName(){
        return io.getString("New product name: ");
    }
    
    public int adminGetAddQty(){
        return io.getInt("Add how many? ");
    }
    
    public BigDecimal adminGetPrice(){
        return new BigDecimal(io.getString("New price: ")).setScale(2, RoundingMode.HALF_UP);
    }
    
    public int adminConfirmDisactivation(int qty){
        io.print("Really disactivate? There are "+qty+" on-hand, which will"
                + " be vended if you choose yes.");
        return io.getInt("1.) Yes   2.) No",1,2);
    }
    
    public void adminBannerActivated(boolean activated){
        if (activated){
            io.print("Item activated.");
        } else {
            io.print("Item disactivated. Remaining product vended, if applicable.");
        }
    }
    
    public int getChoice(){
        boolean validChoice = false;
        while (!validChoice){
            String holder = io.getString("What do you want?");
            try{
                int response = Integer.parseInt(holder);
                return response;
                }
            catch (NumberFormatException e){
                if(holder.equalsIgnoreCase("A")){
                    return 10;
                } else if (holder.equalsIgnoreCase("B")) {
                    return 11;
                } else if (holder.equalsIgnoreCase("C")) {
                    return 12;
                } else if (holder.equalsIgnoreCase("D")) {
                    return 13;
                } else if (holder.equalsIgnoreCase("E")) {
                    return 14;
                } else if (holder.equalsIgnoreCase("F")) {
                    return 15;
                } else {
                    bannerInvalidInput();
                }
            }
        }
        return 0;
    }
    
    public void communicate(String message){
        io.print(message);
    }
    
    public void bannerInvalidInput(){
        io.print("Invalid input.");
    }
    
    public void showChange(BigDecimal[] change){
        io.print("Coin return:");
        io.print(change[0].toPlainString()+" quarter"+plural(change[0].intValueExact()));
        io.print(change[1].toPlainString()+" dime"+plural(change[1].intValueExact()));
        io.print(change[2].toPlainString()+" nickel"+plural(change[2].intValueExact()));
        io.print(change[3].toPlainString()+" quarter"+pluralIes(change[3].intValueExact()));
    }
    
    public String plural(int num){
        if(num==1) {return "";}
        else {return "s";}
    }
    
    public String pluralIes(int num){
        if(num==1) {return "y";}
        else {return "ies";}
    }

}