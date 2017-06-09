package com.sg.m5flooringmastery.dao;

import com.sg.m5flooringmastery.model.State;
import java.math.BigDecimal;
import java.util.List;

public interface TaxesDao {
    public BigDecimal getRate(String state);
    public List<State> getStatesList();
    
    /**
     * Add a new state
     * @param state
     * @throws com.sg.m5flooringmastery.dao.StatePersistenceException
     */
    public void addState(State state) throws StatePersistenceException;
    
    /**
     * Edit an existing state
     * @param oldState
     * @param newState
     * @throws com.sg.m5flooringmastery.dao.StatePersistenceException
     */
    public void editState(State oldState, State newState) throws StatePersistenceException;
    
    /**
     * Remove an existing state
     * @param name 
     * @throws com.sg.m5flooringmastery.dao.StatePersistenceException 
     */
    public void removeState(String name) throws StatePersistenceException;
    
    public State getState(String name);
}
