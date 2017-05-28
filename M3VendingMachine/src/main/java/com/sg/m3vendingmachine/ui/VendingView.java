package com.sg.m3vendingmachine.ui;

import com.sg.m3vendingmachine.dto.Item;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class VendingView {
    private final UserIO io;
    
    public VendingView(UserIO io){
        this.io = io;
    }
    
    
    public void machineTop(){
        io.print(" _____________________________\n" +
"|.-----------------..--------.|");
    }
    public void machineItem(Item item, int index){
        String name = String.format("%-12.12s", item.getName());
        if(item.getQty()>0){
                        io.print("|| "+(index+1)+". "
                                +name+" || $"
                                +item.getCost()+"  ||");
                    } else {
                        io.print("|| "+(index+1)+". "
                                +name+" ||  OOS   ||");
        }
    }
    public void machineBalanceAndBottom(BigDecimal balance){
        io.print("||                 ||        ||\n" +
                "||_________________||________||");
        io.print("|| You've inserted:   $"+balance.setScale(2).toPlainString()+"  ||");
        io.print("||---------------------------.|\n" +
                "||  A. Insert dollar         ||\n" +
                "||  B. Insert quarter        ||\n" +
                "||  C. Insert dime           ||\n" +
                "||  D. Insert nickel         ||\n" +
                "||  E. Insert penny          ||\n" +
                "||        .----------.       ||\n" +
                "||       |__F._EXIT___|      ||\n" +
                "||____________|  |___________||\n" +
                "'-----------------------------'");
    }
    
    public void bannerFailedToSave(){
        io.print("Failed to save file.");
    }
    public void bannerInvalidInput(){
        io.print("Invalid input.");
    }
    public void bannerNoInputFile(){
        io.print("No input file found. Building from sratch.");
    }
    public void bannerVend(String itemName){
        io.print("KER-THUNK! Please take your "+itemName+"!");
    }
    public void bannerError(String message){
        io.print(message);
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
                    return 11;
                } else if (holder.equalsIgnoreCase("B")) {
                    return 7;
                } else if (holder.equalsIgnoreCase("C")) {
                    return 9;
                } else if (holder.equalsIgnoreCase("D")) {
                    return 8;
                } else if (holder.equalsIgnoreCase("E")) {
                    return 10;
                } else if (holder.equalsIgnoreCase("F")) {
                    return -1;
                } else {
                    bannerInvalidInput();
                }
            }
        }
        return 0;
    }
    public void showBalance(BigDecimal balance){    
        machineBalanceAndBottom(balance);
    }
    public void showChange(BigDecimal[] change){
        io.print("\nThanks for your purchase!");
        if(change[0].add(change[1].add(change[2].add(change[3]))).intValue()!=0){
            io.print("Don't forget your change!");
            if(change[0].intValue()!=0) {io.print("   ( 25¢ ) x "+change[0].toPlainString());}
            if(change[1].intValue()!=0) {io.print("     (10¢) x "+change[1].toPlainString());}
            if(change[2].intValue()!=0) {io.print("    ( 5¢ ) x "+change[2].toPlainString());}
            if(change[3].intValue()!=0) {io.print("     ( 1¢) x "+change[3].setScale(0).toPlainString());}
            io.print("");
        }
    }
    public void showInventoryAndMenu(List<Item> stock){
        machineTop();
        List<Item> active = stock.stream().filter(e->e.getActive()).collect(Collectors.toList());
        IntStream.range(0, active.size())
                .forEachOrdered(index->machineItem(active.get(index),index));
    }
    
    public void adminBannerActivated(boolean activated){
        if (activated){
            io.print("Item activated.");
        } else {
            io.print("Item disactivated. Remaining product vended, if applicable.");
        }
    }
    public void adminBannerLeaving(){
        io.print("Leaving service menu.");
    }
    public int adminConfirmDisactivation(int qty){
        io.print("Really disactivate? There are "+qty+" on-hand, which will"
                + " be vended if you choose yes.");
        return io.getInt("1.) Yes   2.) No",1,2);
    }
    public int adminGetAddQty(){
        return io.getInt("Add how many? ");
    }
    public int adminGetMainChoice(int max){
        return io.getInt("Which item? (service)",-1,max);
    }
    public String adminGetName(){
        return io.getString("New product name: ");
    }
    public BigDecimal adminGetPrice(){
        return new BigDecimal(io.getString("New price: ")).setScale(2, RoundingMode.HALF_UP);
    }
    public int adminShowItemMenuAndGetChoice(){
        io.print(" 1.) Change product name");
        io.print(" 2.) Stock product");
        io.print(" 3.) Change price");
        io.print(" 4.) (Dis)activate");
        io.print(" 5.) Back");
        return io.getInt("",1,5);
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
}