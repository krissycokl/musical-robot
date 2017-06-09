package com.sg.m5flooringmastery.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Audit {

    private final String timestamp;
    private final Order added;
    private final Order removed;

    public Audit(Order added, Order removed) {
        this.added = added;
        this.removed = removed;
        this.timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("MM/dd/uuuu hh:mm:ssa"));
    }

    public String getTimeStamp() {
        return timestamp;
    }

    @Override
    public String toString() {
        String auditEntry = "";
        if (removed == null) {
            auditEntry += timestamp + " Order #" + added.getOrderNum() + " added:\n";
            auditEntry += "\t" + String.format("%16s", "Date: ") + added.getDay() + "\n";
            auditEntry += "\t" + String.format("%16s", "Area (sqft): ") + added.getArea() + "\n";
            auditEntry += "\t" + String.format("%16s", "Customer Name: ") + added.getCustomerName() + "\n";
            auditEntry += "\t" + String.format("%16s", "Material: ") + added.getMaterial() + "\n";
            auditEntry += "\t" + String.format("%16s", "State: ") + added.getState() + "\n";
            auditEntry += "\t" + String.format("%17s", "Material Cost: $") + added.getMaterialCost() + "\n";
            auditEntry += "\t" + String.format("%17s", "Labor Cost: $") + added.getLaborCost() + "\n";
            auditEntry += "\t" + String.format("%17s", "Tax Amount: $") + added.getTaxAmount() + "\n";
            auditEntry += "\t" + String.format("%17s", "Total Cost: $") + added.getTotalCost() + "\n";
            return auditEntry;
        } else if (added == null) {
            auditEntry += timestamp + " Order #" + removed.getOrderNum() + " deleted.\n";
            return auditEntry;
        } else {
            auditEntry += timestamp + " Order #" + added.getOrderNum() + " changed:\n";
            if (!added.getDay().equals(removed.getDay())) {
                auditEntry += "\t" + String.format("%16s", "Date: ") + removed.getDay() + " to " + added.getDay() + "\n";
            }
            if (added.getArea() != removed.getArea()) {
                auditEntry += "\t" + String.format("%16s", "Area (sqft): ") + removed.getArea() + " to " + added.getArea() + "\n";
            }
            if (!added.getCustomerName().equals(removed.getCustomerName())) {
                auditEntry += "\t" + String.format("%16s", "Customer Name: ") + removed.getCustomerName() + " to " + added.getCustomerName() + "\n";
            }
            if (!added.getMaterial().equals(removed.getMaterial())) {
                auditEntry += "\t" + String.format("%16s", "Material: ") + removed.getMaterial() + " to " + added.getMaterial() + "\n";
            }
            if (!added.getState().equals(removed.getState())) {
                auditEntry += "\t" + String.format("%16s", "State: ") + removed.getState() + " to " + added.getState() + "\n";
            }
            if (!added.getTotalCost().equals(removed.getTotalCost())) {
                auditEntry += "\t" + String.format("%17s", "Total Cost: $") + removed.getTotalCost() + " to $" + added.getTotalCost() + "\n";
            }
            return auditEntry;
        }
    }
}
