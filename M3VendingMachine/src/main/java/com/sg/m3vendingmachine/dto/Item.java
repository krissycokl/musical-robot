package com.sg.m3vendingmachine.dto;
import java.math.BigDecimal;

public class Item {
    final int ID;
    String name;
    BigDecimal cost;
    int qty;
    boolean active;

    public int getID(){
        return this.ID;
    }
    
    public String getName() {
        return name;
    }

    public String setName(String name) {
        String currName = this.name;
        this.name = name;
        return currName;
    }

    public BigDecimal getCost() {
        return cost;
    }

    public BigDecimal setCost(BigDecimal cost) {
        BigDecimal currCost = this.cost;
        this.cost = cost;
        return currCost;
    }

    public int getQty() {
        return qty;
    }

    public void addQty(int qty) {
        this.qty += qty;
    }
    
    public void decQty(){
        qty--;
    }
    
    public Item(int ID){
        this.ID     = ID;
        this.active = false;
        this.qty    = 0;
    }

    public void toggleActive() {
        active = !active;
    }
    
    public void setActive(boolean active){
        this.active = active;
    }
    
    public boolean getActive(){
        return active;
    }
}