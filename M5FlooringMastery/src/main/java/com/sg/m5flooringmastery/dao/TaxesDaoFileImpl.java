package com.sg.m5flooringmastery.dao;

import com.sg.m5flooringmastery.model.State;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class TaxesDaoFileImpl implements TaxesDao {

    Map<String, State> stateTaxRates = new HashMap<>();
    
    private static final String[] STATEHEADER = {
        "State",
        "TaxRate"
    };
    
    public TaxesDaoFileImpl() throws FileNotFoundException{
        load();
    }

    @Override
    public void addState(State state) throws StatePersistenceException{
        stateTaxRates.put(state.getName(), state);
        try {
            save();
        } catch (IOException ex) {
            // failed to save
        }
    }

    @Override
    public void editState(State oldState, State newState) throws StatePersistenceException{
        stateTaxRates.remove(oldState.getName());
        stateTaxRates.put(newState.getName(), newState);
        try {
            save();
        } catch (IOException ex) {
            // failed to save
        }
    }
    
    @Override
    public void removeState(String name) throws StatePersistenceException{
        stateTaxRates.remove(name);
        try {
            save();
        } catch (IOException ex) {
            throw new StatePersistenceException("Failed to save after removing state.");
        }
    }
    
    @Override
    public BigDecimal getRate(String state) {
        return stateTaxRates.get(state).getTaxRate();
    }

    @Override
    public List<State> getStatesList() {
        return stateTaxRates.values().stream().collect(Collectors.toList());
    }

    void load() throws FileNotFoundException {
        Scanner sc = new Scanner(new BufferedReader(new FileReader("Taxes.txt")));
        sc.nextLine();
        while(sc.hasNextLine()){
            State newState = new State();
            String[] stateInfo = sc.nextLine().split(",");
            newState.setName(stateInfo[0]);
            newState.setTaxRate(new BigDecimal(stateInfo[1]));
            
            stateTaxRates.put(newState.getName(), newState);
        }
        sc.close();
    }
    
    private void save() throws IOException {
        PrintWriter out = new PrintWriter(new FileWriter("Taxes.txt", false));
        for (String s : STATEHEADER){
            out.print(s+",");
            out.flush();
        }
        out.print("\n");
        stateTaxRates.values().stream().forEach(e->{
            out.print(e.getName()+",");
            out.print(e.getTaxRate()+"\n");
            out.flush();
        });
        out.close();
    }
    
    @Override
    public State getState(String name){
        return stateTaxRates.get(name);
    }
    
}
