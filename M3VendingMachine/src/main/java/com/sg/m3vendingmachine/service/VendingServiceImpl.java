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
    public void changeBalance(BigDecimal increment){
        dao.changeBalance(increment);
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
    public BigDecimal[] makeChange(int itemKey) {
        return dao.makeChange(itemKey);
    }

    @Override
    public void saveStock() throws IOException {
        dao.saveStock();
    }

    @Override
    public void toggleActive(int id) {
        dao.toggleActive(id);
    }
    
    @Override
    public BigDecimal[] buy(int itemKey) throws ItemOutOfStockException, InsufficientFundsException {
        BigDecimal balance = dao.getBalance();
        BigDecimal itemCost = dao.getItem(itemKey).getCost();
        String itemName = dao.getItem(itemKey).getName();
        int qtyOH = dao.getItem(itemKey).getQty();
        if (qtyOH<1){
            throw new ItemOutOfStockException("No "+itemName+" in stock.");
        } else if (balance.compareTo(itemCost)==-1){
            throw new InsufficientFundsException(itemName+" costs "
                    +itemCost.toPlainString()+"but you only have "
                    +balance.toPlainString());
        } else {
            dao.decStock(itemKey);
            return dao.makeChange(itemKey);
        }
    }

}
