package com.sg.m3vendingmachine.service;

import com.sg.m3vendingmachine.dao.InventoryDao;
import com.sg.m3vendingmachine.dto.Change;
import com.sg.m3vendingmachine.dto.Item;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class InventoryDaoStubImpl implements InventoryDao {

    private HashMap<Integer, Item> itemList = new HashMap<>();
    private Change currentBalance = new Change(BigDecimal.ZERO);
    
    public InventoryDaoStubImpl(){
        Item item = itemList.put(1, new Item(1));
        itemList.get(1).setName("Test Item 1");
        itemList.get(1).setActive(true);
        itemList.get(1).addQty(1);
        itemList.get(1).setCost(BigDecimal.ONE);
    }
    
    @Override
    public int addItem() {
        itemList.put(2, new Item(2));
        return 2;
    }

    @Override
    public void addStock(int id, int qty) {
        itemList.get(id).addQty(qty);
    }

    @Override
    public void changeBalance(BigDecimal increment) {
        currentBalance.changeBalance(increment);
    }

    @Override
    public void decStock(int id) {
        itemList.get(id).decQty();
    }

    @Override
    public BigDecimal getBalance() {
        return currentBalance.getBalance();
    }

    @Override
    public Item getItem(int id) {
        return itemList.get(id);
    }

    @Override
    public List<Item> getStock() {
        return itemList.values().stream()
                .collect(Collectors.toList());
    }

    @Override
    public void loadStock() throws FileNotFoundException {
        // Not needed in stub
    }

    @Override
    public BigDecimal[] makeChange(int itemKey) {
        return currentBalance.makeChange(itemList.get(itemKey).getCost());
    }

    @Override
    public void saveStock() throws IOException {
        // Not needed in stub
    }

    @Override
    public void toggleActive(int id) {
        itemList.get(id).toggleActive();
    }

}
