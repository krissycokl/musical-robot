package com.sg.m5flooringmastery.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

public class Order {

    private LocalDate day;

    public LocalDate getDay() {
        return day;
    }

    public void setDay(LocalDate day) {
        this.day = day;
    }

    private String customerName;
    private int orderNum;
    private String state;
    private BigDecimal taxRate;
    private String material;
    private BigDecimal area;
    private BigDecimal materialCostPerSqFt;
    private BigDecimal laborCostPerSqFt;
    private BigDecimal materialCost;
    private BigDecimal laborCost;
    private BigDecimal taxAmount;
    private BigDecimal totalCost;

    public Order() {
    }

    public Order(int orderNum) {
        this.orderNum = orderNum;
    }

    public BigDecimal getMaterialCost() {
        return materialCost;
    }

    public void setKey(int key) {
        this.orderNum = key;
    }

    public void setMaterialCost(BigDecimal materialCost) {
        this.materialCost = materialCost;
    }

    public BigDecimal getLaborCost() {
        return laborCost;
    }

    public void setLaborCost(BigDecimal laborCost) {
        this.laborCost = laborCost;
    }

    public String getCustomerName() {
        //String tempCustomerName = customerName.replace("\\\\,", ",");
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public int getOrderNum() {
        return orderNum;
    }

    public void setState(String state) {
        this.state = state;
    }

    public BigDecimal getTaxRate() {
        return taxRate;
    }

    public void setTaxRate(BigDecimal taxRate) {
        this.taxRate = taxRate;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public BigDecimal getArea() {
        return area;
    }

    public void setArea(BigDecimal area) {
        this.area = area;
    }

    public BigDecimal getMaterialCostPerSqFt() {
        return materialCostPerSqFt;
    }

    public void setMaterialCostPerSqFt(BigDecimal materialCostPerSqFt) {
        this.materialCostPerSqFt = materialCostPerSqFt;
    }

    public BigDecimal getLaborCostPerSqFt() {
        return laborCostPerSqFt;
    }

    public void setLaborCostPerSqFt(BigDecimal laborCostPerSqFt) {
        this.laborCostPerSqFt = laborCostPerSqFt;
    }

    public BigDecimal getTaxAmount() {
        return taxAmount;
    }

    public void setTaxAmount(BigDecimal taxAmount) {
        this.taxAmount = taxAmount;
    }

    public BigDecimal getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(BigDecimal totalCost) {
        this.totalCost = totalCost;
    }

    public String getState() {
        return state;
    }

    public String[] toStringAry() {
        String[] stringAry = new String[12];
        stringAry[0] = "" + this.orderNum;
        stringAry[1] = this.customerName.replace(",", "\\,");
        stringAry[2] = this.state;
        stringAry[3] = this.taxRate.multiply(new BigDecimal("100")).toPlainString();
        stringAry[4] = this.material;
        stringAry[5] = this.area.toPlainString();
        stringAry[6] = this.materialCostPerSqFt.toPlainString();
        stringAry[7] = this.laborCostPerSqFt.toPlainString();
        stringAry[8] = this.materialCost.toPlainString();
        stringAry[9] = this.laborCost.toPlainString();
        stringAry[10] = this.taxAmount.toPlainString();
        stringAry[11] = this.totalCost.toPlainString();
        return stringAry;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 11 * hash + Objects.hashCode(this.customerName);
        hash = 11 * hash + this.orderNum;
        hash = 11 * hash + Objects.hashCode(this.state);
        hash = 11 * hash + Objects.hashCode(this.taxRate);
        hash = 11 * hash + Objects.hashCode(this.material);
        hash = 11 * hash + Objects.hashCode(this.area);
        hash = 11 * hash + Objects.hashCode(this.materialCostPerSqFt);
        hash = 11 * hash + Objects.hashCode(this.laborCostPerSqFt);
        hash = 11 * hash + Objects.hashCode(this.taxAmount);
        hash = 11 * hash + Objects.hashCode(this.totalCost);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Order other = (Order) obj;
        if (this.orderNum != other.orderNum) {
            return false;
        }
        if (!Objects.equals(this.customerName, other.customerName)) {
            return false;
        }
        if (!Objects.equals(this.state, other.state)) {
            return false;
        }
        if (!Objects.equals(this.material, other.material)) {
            return false;
        }
        if (this.taxRate.compareTo(other.taxRate) != 0) {
            return false;
        }
        if (this.area.compareTo(other.area) != 0) {
            return false;
        }
        if (this.materialCostPerSqFt.compareTo(other.materialCostPerSqFt) != 0) {
            return false;
        }
        if (this.laborCostPerSqFt.compareTo(other.laborCostPerSqFt) != 0) {
            return false;
        }
        if (this.taxAmount.compareTo(other.taxAmount) != 0) {
            return false;
        }
        if (this.totalCost.compareTo(other.totalCost) != 0) {
            return false;
        }
        return true;
    }

}
