package com.sg.m5flooringmastery.service;

import com.sg.m5flooringmastery.dao.MaterialsPersistenceException;
import com.sg.m5flooringmastery.dao.StatePersistenceException;
import com.sg.m5flooringmastery.model.Material;
import com.sg.m5flooringmastery.model.Order;
import com.sg.m5flooringmastery.model.State;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public interface FlooringService {
    public int addOrder(Order order, LocalDate day) throws InvalidOrderException;

    public void adminAddMaterial(Material newMat) throws MaterialOverwriteException, MaterialsPersistenceException;

    public void adminAddState(State newState) throws StateOverwriteException, StatePersistenceException;

    public void adminEditMaterial(String oldMatName, Material newMat) throws MaterialOverwriteException, MaterialsPersistenceException;

    public void adminEditState(String oldStateName, State newState) throws StateOverwriteException, StatePersistenceException;

    public void adminRemoveMaterial(String removeMat) throws MaterialsPersistenceException;

    public void adminRemoveState(String removeState) throws StatePersistenceException;
    
    public List<Material> getValidMaterials();
    public List<State> getValidStates();
    
    public void changeOrderDay(Order order, LocalDate newDay) throws 
            IOException,
            FileNotFoundException,
            OrderEditException;
    
    public Order editOrder(Order order, Order editedOrder, LocalDate day) throws
            InvalidOrderException,
            OrderEditException,
            IOException;
    
    public Order getOrder(int id, LocalDate day) throws
            NoSuchOrderException;
    
    public Map<Integer,Order> getOrderMap(String findName);
    public Map<Integer,Order> getOrderMap(int orderNum);
    public Map<Integer,Order> getOrderMap(LocalDate day);
    
    public Order removeOrder(int id, LocalDate day) throws
            NoSuchOrderException;
    
    public boolean validateOrder(Order order) throws
            InvalidOrderException;
    
    public Order calculateCosts(Order order);
    
    public Order retrieveCosts(Order order) throws
            InvalidOrderException;
    
    public Order retrieveTaxRate(Order order) throws
            InvalidOrderException;
}
