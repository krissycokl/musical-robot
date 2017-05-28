package com.sg.m3vendingmachine.dao;

import com.sg.m3vendingmachine.dto.Item;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

public interface InventoryDao {
    public void changeBalance(BigDecimal increment);
    public BigDecimal[] makeChange(int itemKey);
    public BigDecimal getBalance();
    public void addStock(int id, int qty);
    public void decStock(int id);
    public Item getItem(int id);
    public List<Item> getStock();
    public void loadStock() throws FileNotFoundException;
    public void saveStock() throws IOException;
    public int addItem();
    public void toggleActive(int id);
}
