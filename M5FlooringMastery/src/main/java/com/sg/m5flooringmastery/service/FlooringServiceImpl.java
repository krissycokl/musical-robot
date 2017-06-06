package com.sg.m5flooringmastery.service;

import com.sg.m5flooringmastery.dao.FlooringDao;
import com.sg.m5flooringmastery.dao.MaterialsDao;
import com.sg.m5flooringmastery.dao.TaxesDao;
import com.sg.m5flooringmastery.model.Order;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.util.List;

public class FlooringServiceImpl implements FlooringService {
    
    private FlooringDao flooringDao;
    private MaterialsDao materialsDao;
    private TaxesDao taxesDao;
    
    public FlooringServiceImpl(FlooringDao flooringDao,
                               MaterialsDao materialsDao,
                               TaxesDao taxesDao)
    {
        this.flooringDao = flooringDao;
        this.materialsDao = materialsDao;
        this.taxesDao = taxesDao;
    }

    @Override
    public int addOrder(Order order, LocalDate day) throws InvalidOrderException{
        if (validateOrder(order)){
            return flooringDao.addOrder(order, day);
        } else {
            throw new InvalidOrderException("Order parameters invalid. Not added.");
        }
    }

    @Override
    public void changeOrderDay(Order order, LocalDate newDay) throws IOException, FileNotFoundException {
        flooringDao.changeOrderDay(order, newDay);
    }

    @Override
    public Order editOrder(Order order, LocalDate day) throws InvalidOrderException{
        if (validateOrder(order)){
            return flooringDao.editOrder(order, day);
        } else {
            throw new InvalidOrderException("Unknown validation error. Order not added.");
        }
    }

    @Override
    public Order getOrder(int id, LocalDate day) throws NoSuchOrderException{
        Order order = flooringDao.getOrder(id, day);
        if (order == null){
            throw new NoSuchOrderException("No order #"+id+" found for "+day.toString()+".");
        } else {
            return order;
        }
    }
    
    @Override
    public List<Order> getOrderList(LocalDate day){
        return flooringDao.getOrderList(day);
    }

    @Override
    public Order removeOrder(int id, LocalDate day) throws NoSuchOrderException{
        Order order = flooringDao.removeOrder(id, day);
        if (order == null){
            throw new NoSuchOrderException("No order #"+id+" found for "+day.toString()+".");
        } else {
            return order;
        }
    }

    @Override
    public int loadKey() throws FileNotFoundException {
        return flooringDao.loadKey();
    }
    
    @Override
    public int saveKey() throws IOException {
        return flooringDao.saveKey();
    }

    @Override
    public boolean validateOrder(Order order) throws InvalidOrderException{
        if (order == null){
            throw new InvalidOrderException("Order is null. Not added.");
        } else if (
                // BigDecimal field validations
                order.getArea().compareTo(BigDecimal.ZERO)<=0
            ||  order.getArea() == null
            ){
            throw new InvalidOrderException("Order area null or 0. Not added.");
        } else if (
                // String field validations
                order.getCustomerName() == null
            ||  order.getCustomerName().isEmpty()
            ||  order.getMaterial() == null
            ||  order.getMaterial().isEmpty()
            ||  order.getState() == null
            ||  order.getState().isEmpty()
                ){
            throw new InvalidOrderException("Order name/material/state null or empty. Not added.");
        } else if(
                // int and LocalDate validations
                order.getOrderNum()<0
            ||  order.getDay() == null
                ){
            throw new InvalidOrderException("Order num negative or day null. Not added.");
        } else {
            try{
                // Retrieve material costs & tax rate
                order.setMaterialCostPerSqFt(materialsDao.getMaterialCostPerSqFt(order.getMaterial()));
                order.setLaborCostPerSqFt(materialsDao.getLaborCostPerSqFt(order.getMaterial()));
                order.setTaxRate(taxesDao.getRate(order.getState()));
            } catch (Exception ex){
                throw new InvalidOrderException("State or material not recognized. Order not added.");
            }
            
            // Calculate aggregate fields
            order.setLaborCost(order.getArea().multiply(order.getLaborCostPerSqFt()).setScale(2, RoundingMode.HALF_UP));
            order.setMaterialCost(order.getArea().multiply(order.getMaterialCostPerSqFt().setScale(2, RoundingMode.HALF_UP)));
            BigDecimal grossCost = order.getLaborCost().add(order.getMaterialCost());
            BigDecimal tax = order.getTaxRate().multiply(grossCost);
            order.setTaxAmount(tax.setScale(2, RoundingMode.HALF_UP));
            order.setTotalCost(grossCost.add(tax).setScale(2, RoundingMode.HALF_UP));
            
            return true;
        }
    }
    
}
