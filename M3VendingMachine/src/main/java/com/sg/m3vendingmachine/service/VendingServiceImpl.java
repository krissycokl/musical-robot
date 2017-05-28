package com.sg.m3vendingmachine.service;

import com.sg.m3vendingmachine.dao.InventoryDao;
import com.sg.m3vendingmachine.dto.Item;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

public class VendingServiceImpl implements VendingService {

    InventoryDao dao;
    
    public VendingServiceImpl(InventoryDao dao){
        this.dao = dao;
    }

    @Override
    public int addItem() {
        return dao.addItem();
    }
    
    @Override
    public void setBalance(BigDecimal increment){
        dao.setBalance(increment);
    }
    
    @Override
    public BigDecimal getBalance(){
        return dao.getBalance();
    }
    
    @Override
    public void addStock(int id, int qty) {
        dao.addStock(id, qty);
    }

    @Override
    public Item getItem(int id) {
        return dao.getItem(id);
    }

    @Override
    public List<Item> getStock() {
        return dao.getStock();
    }

    @Override
    public void loadStock() throws FileNotFoundException {
        dao.loadStock();
    }

    @Override
    public void decStock(int id) {
        dao.decStock(id);
    }

    @Override
    public void saveStock() throws IOException {
        dao.saveStock();
    }

    @Override
    public void toggleActive(int id) {
        dao.toggleActive(id);
    }

}
