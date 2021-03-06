package com.sg.m3vendingmachine.service;

import com.sg.m3vendingmachine.dto.Item;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

public interface VendingService {
    public BigDecimal getBalance();
    public void changeBalance(BigDecimal increment) throws FullOfMoneyException;
    public BigDecimal[] makeChange(BigDecimal cost);
    public void addStock(int id, int qty);
    public void decStock(int id);
    public Item getItem(int id);
    public List<Item> getStock();
    public void loadStock() throws FileNotFoundException;
    public void saveStock() throws IOException;
    public int addItem();
    public void toggleActive(int id) throws MachineAtCapacityException;
    public void buy(int itemKey) throws ItemOutOfStockException, InsufficientFundsException;
    public String itemSetName(int itemKey, String newName);
    public BigDecimal itemSetCost(int itemKey, BigDecimal newCost);
}
