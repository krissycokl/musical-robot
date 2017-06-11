package com.sg.m5flooringmastery.service;

import com.sg.m5flooringmastery.dao.StatePersistenceException;
import com.sg.m5flooringmastery.dao.TaxesDao;
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

public class TaxesDaoFileROImpl implements TaxesDao {

    Map<String, State> stateTaxRates = new HashMap<>();
    
    public TaxesDaoFileROImpl() throws FileNotFoundException{
        load();
    }

    @Override
    public void addState(State state) throws StatePersistenceException{
        stateTaxRates.put(state.getName(), state);
    }

    @Override
    public void editState(State oldState, State newState) throws StatePersistenceException{
        stateTaxRates.remove(oldState.getName());
        stateTaxRates.put(newState.getName(), newState);
    }
    
    @Override
    public void removeState(String name) throws StatePersistenceException{
        stateTaxRates.remove(name);
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
    
    @Override
    public State getState(String name){
        return stateTaxRates.get(name);
    }
    
}
