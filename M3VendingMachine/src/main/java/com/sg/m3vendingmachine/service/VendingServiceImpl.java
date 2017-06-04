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
    public void changeBalance(BigDecimal increment) throws FullOfMoneyException{
        if (dao.getBalance().add(increment).compareTo(new BigDecimal("9.99")) == 1){
            throw new FullOfMoneyException("The machine will take no more money.");
        } else {
            dao.changeBalance(increment);
        }
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
    public BigDecimal itemSetCost(int itemKey, BigDecimal newCost) {
        return dao.getItem(itemKey).setCost(newCost);
    }

    @Override
    public String itemSetName(int itemKey, String newName) {
        return dao.getItem(itemKey).setName(newName);
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
    public BigDecimal[] makeChange(BigDecimal cost) {
        return dao.makeChange(cost);
    }

    @Override
    public void saveStock() throws IOException {
        dao.saveStock();
    }

    @Override
    public void toggleActive(int id) throws MachineAtCapacityException {
        if (dao.getStock()
                .stream()
                .filter(e->e.getActive())
                .count() >=6 && !dao.getItem(id).getActive()){
            throw new MachineAtCapacityException("Only 6 items may be sold at once."
                    + "\nPlease disactivate another item first.");
        } else {
            dao.toggleActive(id);
        }
    }
    
    @Override
    public void buy(int itemKey) throws ItemOutOfStockException, InsufficientFundsException {
        BigDecimal balance = dao.getBalance();
        BigDecimal itemCost = dao.getItem(itemKey).getCost();
        String itemName = dao.getItem(itemKey).getName();
        int qtyOH = dao.getItem(itemKey).getQty();
        if (qtyOH<1){
            throw new ItemOutOfStockException("No "+itemName+" in stock.");
        } else if (balance.compareTo(itemCost)==-1){
            throw new InsufficientFundsException(itemName+" costs $"
                    +itemCost.toPlainString()+". You have inserted $"
                    +balance.toPlainString()+".");
        } else {
            dao.decStock(itemKey);
        }
    }

}
