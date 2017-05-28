package com.sg.m3vendingmachine.dao;

import com.sg.m3vendingmachine.dto.Change;
import com.sg.m3vendingmachine.dto.Item;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InventoryDaoFileImpl implements InventoryDao {

    private HashMap<Integer,Item> stock = new HashMap<Integer,Item>();
    private int currId = 1;
    private Change currentBalance = new Change(BigDecimal.ZERO);
    private final String FILENAME;
    private final String    DELIM = "::";
    
    public InventoryDaoFileImpl(String filename){
        this.FILENAME = filename;
    }
    
    @Override
    public void setBalance(BigDecimal increment){
        currentBalance.changeBalance(increment);
    }
    
    @Override
    public BigDecimal getBalance(){
        return currentBalance.getBalance();
    }
    
    @Override
    public void addStock(int id, int qty) {
        stock.get(id).addQty(qty);
    }

    @Override
    public Item getItem(int id) {
        return stock.get(id);
    }

    @Override
    public List<Item> getStock() {
        return stock.values()
                .stream()
                .collect(Collectors.toList());
    }

    @Override
    public void loadStock() throws FileNotFoundException {
        Scanner sc = new Scanner(new BufferedReader(new FileReader(FILENAME)));
        while(sc.hasNextLine()){
            String[] itemInfo = sc.nextLine().split(DELIM);
            try{
                int tempKey = Integer.parseInt(itemInfo[0]);
                stock.put(tempKey, new Item(tempKey));
                stock.get(tempKey).setName(itemInfo[1]);
                stock.get(tempKey).setCost(new BigDecimal(itemInfo[2]));
                stock.get(tempKey).addQty(Integer.parseInt(itemInfo[3]));
                stock.get(tempKey).setActive(Boolean.parseBoolean(itemInfo[4]));
            } catch (NullPointerException | NumberFormatException e) {
                //write to audit file that a line failed to load
            }
        }
        int tempId = stock.values()
                .stream()
                .map(item -> item.getID())
                .mapToInt(id-> id)
                .max()
                .getAsInt();
        currId = Math.max(tempId, currId);
    }

    @Override
    public void decStock(int id) {
        stock.get(id).decQty();
    }

    @Override
    public void saveStock() throws IOException {
        PrintWriter out = new PrintWriter(new FileWriter(FILENAME, false));
        for (Item item : stock.values()){
            out.print(item.getID()+DELIM
                    +item.getName()+DELIM
                    +item.getCost().toPlainString()+DELIM
                    +item.getQty()+DELIM
                    +item.getActive()+"\n");
            out.flush();
        }
        out.close();
    }
    
    @Override
    public int addItem(){
        currId++;
        stock.put(currId, new Item(currId));
        return currId;
    }
    
    @Override
    public void toggleActive(int id){
        stock.get(id).toggleActive();
    }
}
