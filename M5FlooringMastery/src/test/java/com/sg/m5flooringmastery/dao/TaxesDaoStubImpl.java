package com.sg.m5flooringmastery.dao;

import com.sg.m5flooringmastery.model.State;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class TaxesDaoStubImpl implements TaxesDao {

    @Override
    public void addState(State state) throws StatePersistenceException {
        //trust me, it's added
    }

    @Override
    public void editState(State oldState, State newState) throws StatePersistenceException {
        //trust me, it's edited
    }

    @Override
    public BigDecimal getRate(String state) {
        return new BigDecimal("5");
    }

    @Override
    public State getState(String name) {
        State tempState = new State();
        tempState.setName("IL");
        tempState.setTaxRate(new BigDecimal("5"));
        return tempState;
    }

    @Override
    public List<State> getStatesList() {
        List<State> states = new ArrayList<>();
        State tempState = new State();
        tempState.setName("IL");
        tempState.setTaxRate(new BigDecimal("5"));
        states.add(tempState);
        return states;
    }

    @Override
    public void removeState(String name) throws StatePersistenceException {
        //trust me, it's removed
    }

}