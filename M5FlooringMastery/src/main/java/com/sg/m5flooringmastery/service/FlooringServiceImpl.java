package com.sg.m5flooringmastery.service;

import com.sg.m5flooringmastery.dao.FlooringDao;
import com.sg.m5flooringmastery.dao.MaterialsDao;
import com.sg.m5flooringmastery.dao.MaterialsPersistenceException;
import com.sg.m5flooringmastery.dao.StatePersistenceException;
import com.sg.m5flooringmastery.dao.TaxesDao;
import com.sg.m5flooringmastery.model.Material;
import com.sg.m5flooringmastery.model.Order;
import com.sg.m5flooringmastery.model.State;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public class FlooringServiceImpl implements FlooringService {

    private FlooringDao flooringDao;
    private MaterialsDao materialsDao;
    private TaxesDao taxesDao;

    @Override
    public void adminAddMaterial(Material newMat) throws MaterialOverwriteException, MaterialsPersistenceException {
        for (Material mat : getValidMaterials()) {
            if (mat.getName().equals(newMat.getName())) {
                throw new MaterialOverwriteException(newMat + " already exists. Please Edit if you wish to change its costs.");
            }
        }
        materialsDao.addMaterial(newMat);
    }

    @Override
    public void adminAddState(State newState) throws StateOverwriteException, StatePersistenceException {
        for (State state : getValidStates()) {
            if (state.getName().equals(newState.getName())) {
                throw new StateOverwriteException(state + " already exists. Please Edit if you wish to change its tax rate.");
            }
        }
        taxesDao.addState(newState);
    }

    @Override
    public void adminEditMaterial(String oldMatName, Material newMat) throws MaterialOverwriteException, MaterialsPersistenceException {
        if (!oldMatName.equals(newMat.getName())) {
            for (Material mat : getValidMaterials()) {
                if (mat.getName().equals(newMat.getName())) {
                    throw new MaterialOverwriteException("Cannot change name to existing material " + mat + ".");
                }
            }
        }
        materialsDao.editMaterial(materialsDao.getMaterial(oldMatName), newMat);
    }

    @Override
    public void adminEditState(String oldStateName, State newState) throws StateOverwriteException, StatePersistenceException {
        if (!oldStateName.equals(newState.getName())) {
            for (State state : getValidStates()) {
                if (state.getName().equals(newState.getName())) {
                    throw new StateOverwriteException("Cannot change name to existing state " + state + ".");
                }
            }
        }
        taxesDao.editState(taxesDao.getState(oldStateName), newState);
    }

    @Override
    public void adminRemoveMaterial(String removeMat) throws MaterialsPersistenceException {
        materialsDao.removeMaterial(removeMat);
    }

    @Override
    public void adminRemoveState(String removeState) throws StatePersistenceException {
        taxesDao.removeState(removeState);
    }

    @Override
    public Map<Integer, Order> getOrderMap(LocalDate day) {
        return flooringDao.getOrderMap(day);
    }

    @Override
    public Map<Integer, Order> getOrderMap(String findName) {
        return flooringDao.getOrderMap(findName);
    }

    @Override
    public Map<Integer, Order> getOrderMap(int orderNum) {
        return flooringDao.getOrderMap(orderNum);
    }

    @Override
    public List<Material> getValidMaterials() {
        return materialsDao.getMaterialsList();
    }

    @Override
    public List<State> getValidStates() {
        return taxesDao.getStatesList();
    }

    public FlooringServiceImpl(FlooringDao flooringDao,
            MaterialsDao materialsDao,
            TaxesDao taxesDao) {
        this.flooringDao = flooringDao;
        this.materialsDao = materialsDao;
        this.taxesDao = taxesDao;
    }

    @Override
    public Order addOrder(Order order, LocalDate day) throws InvalidOrderException {
        if (validateOrder(order)) {
            order = retrieveCosts(order);
            order = retrieveTaxRate(order);
            order = calculateCosts(order);
            return flooringDao.addOrder(order, day);
        } else {
            throw new InvalidOrderException("Order parameters invalid. Not added.");
        }
    }

    @Override
    public void changeOrderDay(Order order, LocalDate newDay) throws
            IOException,
            FileNotFoundException,
            OrderEditException {
        if (newDay.isBefore(LocalDate.now())) {
            throw new OrderEditException("Cannot backdate an order. Not changed.");
        }
        flooringDao.changeOrderDay(order, newDay);
    }

    @Override
    public Order editOrder(Order order, Order editedOrder, LocalDate day) throws
            InvalidOrderException,
            OrderEditException,
            IOException {

        editedOrder.setKey(order.getOrderNum());
        if (validateOrder(editedOrder)) {
            if (!editedOrder.getDay().equals(order.getDay())) {
                changeOrderDay(order, editedOrder.getDay());
            }
            if (!order.getMaterial().equals(editedOrder.getMaterial())) {
                retrieveCosts(editedOrder);
            } else {
                editedOrder.setLaborCostPerSqFt(order.getLaborCostPerSqFt());
                editedOrder.setMaterialCostPerSqFt(order.getMaterialCostPerSqFt());
            }
            if (!order.getState().equals(editedOrder.getState())) {
                retrieveTaxRate(editedOrder);
            } else {
                editedOrder.setTaxRate(order.getTaxRate());
            }
            calculateCosts(editedOrder);
            if (editedOrder.equals(order)) {
                throw new OrderEditException("No fields changed. Order not edited.");
            }
            return flooringDao.editOrder(editedOrder, editedOrder.getDay());
        } else {
            throw new OrderEditException("Unknown validation error. Order not added.");
        }
    }

    @Override
    public Order getOrder(int id, LocalDate day) throws NoSuchOrderException {
        Order order = flooringDao.getOrder(id, day);
        if (order == null) {
            throw new NoSuchOrderException("No order #" + id + " found for " + day.toString() + ".");
        } else {
            return order;
        }
    }

    @Override
    public Order removeOrder(int id, LocalDate day) throws NoSuchOrderException {
        Order order = flooringDao.removeOrder(id, day);
        if (order == null) {
            throw new NoSuchOrderException("No order #" + id + " found for " + day.toString() + ".");
        } else {
            return order;
        }
    }

    @Override
    public boolean validateOrder(Order order) throws InvalidOrderException {
        if (order == null) {
            throw new InvalidOrderException("Order is null. Not added.");
        } else if ( // BigDecimal field validations
                order.getArea() == null
                || order.getArea().compareTo(BigDecimal.ZERO) <= 0) {
            throw new InvalidOrderException("Order area null or 0. Not added.");
        } else if ( // String field validations
                order.getCustomerName() == null
                || order.getCustomerName().isEmpty()
                || order.getMaterial() == null
                || order.getMaterial().isEmpty()
                || order.getState() == null
                || order.getState().isEmpty()) {
            throw new InvalidOrderException("Order name/material/state null or empty. Not added.");
        } else if ( // int and LocalDate validations
                order.getOrderNum() < 0
                || order.getDay() == null) {
            throw new InvalidOrderException("Order num negative or day null. Order not updated.");
        } else {
            if (taxesDao.getRate(order.getState()) == null) {
                throw new InvalidOrderException("State not recognized. Order not updated.");
            }
            try {
                materialsDao.getMaterialCostPerSqFt(order.getMaterial());
            } catch (NullPointerException e) {
                throw new InvalidOrderException("Material not recognized.  Order not updated.");
            }
            return true;
        }
    }

    @Override
    public Order retrieveCosts(Order order) throws InvalidOrderException {
        order.setMaterialCostPerSqFt(materialsDao.getMaterialCostPerSqFt(order.getMaterial()));
        order.setLaborCostPerSqFt(materialsDao.getLaborCostPerSqFt(order.getMaterial()));

        if (order.getMaterialCostPerSqFt() == null) {
            throw new InvalidOrderException("Material not recognized. Order not updated.");
        }

        return order;
    }

    @Override
    public Order retrieveTaxRate(Order order) throws InvalidOrderException {
        order.setTaxRate(taxesDao.getRate(order.getState()));

        if (order.getTaxRate() == null) {
            throw new InvalidOrderException("State not recognized. Order not updated.");
        }

        return order;
    }

    @Override
    public Order calculateCosts(Order order) {
        order.setLaborCost(order.getArea().multiply(
                order.getLaborCostPerSqFt()).setScale(2, RoundingMode.HALF_UP));

        order.setMaterialCost(order.getArea().multiply(
                order.getMaterialCostPerSqFt().setScale(2, RoundingMode.HALF_UP)));

        BigDecimal grossCost = order.getLaborCost().add(
                order.getMaterialCost());

        BigDecimal tax = order.getTaxRate().multiply(grossCost).divide(new BigDecimal("100"), 2, RoundingMode.HALF_UP);

        order.setTaxAmount(tax);

        order.setTotalCost(grossCost.add(tax).setScale(2, RoundingMode.HALF_UP));

        return order;
    }

}
