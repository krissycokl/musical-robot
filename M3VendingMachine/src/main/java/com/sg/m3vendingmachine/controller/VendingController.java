package com.sg.m3vendingmachine.controller;

import com.sg.m3vendingmachine.dto.Change;
import com.sg.m3vendingmachine.dto.Item;
import com.sg.m3vendingmachine.service.*;
import com.sg.m3vendingmachine.ui.VendingView;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

public class VendingController {
    private VendingService service;
    private VendingView view;
    
    public VendingController(VendingService service, VendingView view){
        this.service = service;
        this.view = view;
    }
    
    public void run() throws IOException{
        try{
            service.loadStock();
        } catch (FileNotFoundException e){
            view.bannerNoInputFile();
        }
        int choice;
        boolean stop = false;
        while (!stop) {
            List<Item> itemsForDisplay = service.getStock()
                                                .stream()
                                                .filter(e->e.getActive())
                                                .collect(Collectors.toList());
            
            view.showInventoryAndMenu(service.getStock());
            view.showBalance(service.getBalance());
            choice = view.getChoice();
            switch(choice){
                case 1:
                case 2:
                case 3:
                case 4:
                case 5:
                case 6:
                    buy(itemsForDisplay.get(choice-1).getID());
                    break;
                case 7:
            {
                try {
                    service.changeBalance(Change.quarter);
                } catch (FullOfMoneyException ex) {
                    view.bannerError(ex.getMessage());
                }
            }
                    break;
                case 8:
            {
                try {
                    service.changeBalance(Change.nickel);
                } catch (FullOfMoneyException ex) {
                    view.bannerError(ex.getMessage());
                }
            }
                    break;
                case 9:
            {
                try {
                    service.changeBalance(Change.dime);
                } catch (FullOfMoneyException ex) {
                    view.bannerError(ex.getMessage());
                }
            }
                    break;
                case 10:
            {
                try {
                    service.changeBalance(Change.penny);
                } catch (FullOfMoneyException ex) {
                    view.bannerError(ex.getMessage());
                }
            }
                    break;
                case 11:
            {
                try {
                    service.changeBalance(Change.dollar);
                } catch (FullOfMoneyException ex) {
                    view.bannerError(ex.getMessage());
                }
            }
                    break;
                case 91119:
                    adminMenu();
                    break;
                case -1:
                    stop = true;
                    break;
            }
        }
    }
    
    public void adminMenu(){
        boolean stop = false;
        while (!stop){
            view.adminShowMainMenu(service.getStock());
            int itemKey = view.adminGetMainChoice(service.getStock().size());
            if (itemKey == 0){
                int newItemKey = service.addItem();
                service.getItem(newItemKey).setName(view.adminGetName());
                service.getItem(newItemKey).setCost(view.adminGetPrice());
                service.getItem(newItemKey).addQty(view.adminGetAddQty());
                try{
                    service.saveStock();
                } catch (IOException e) {
                    view.bannerFailedToSave();
                }
            } else if (itemKey==-1) {
                view.adminBannerLeaving();
                stop = true;
            } else if (service.getItem(itemKey) != null) {
                try{
                    adminItemMenu(itemKey);
                } catch(IOException e){
                    view.bannerFailedToSave();
                }
            }
        }
    }
    
    public void adminItemMenu(int itemKey) throws IOException{
        int action = view.adminShowItemMenuAndGetChoice();
        boolean valid = false;
        while(!valid){
            switch(action){
                case 1:
                    service.getItem(itemKey).setName(view.adminGetName());
                    service.saveStock();
                    valid = true;
                    break;
                case 2:
                    service.getItem(itemKey).addQty(view.adminGetAddQty());
                    service.saveStock();
                    valid = true;
                    break;
                case 3:
                    service.getItem(itemKey).setCost(view.adminGetPrice());
                    service.saveStock();
                    valid = true;
                    break;
                case 4:
                    boolean active = service.getItem(itemKey).getActive();
                    if (active){
                        if(service.getItem(itemKey).getQty()>0){
                            int disactivate = view.adminConfirmDisactivation(service.getItem(itemKey).getQty());
                            if (disactivate == 1){
                                while (service.getItem(itemKey).getQty()>0){
                                    service.decStock(itemKey);
                                }
                                try {
                                    service.toggleActive(itemKey);
                                } catch (MachineAtCapacityException ex) {
                                    view.bannerError(ex.getMessage());
                                }
                                view.adminBannerActivated(false);
                            }
                        } else {
                            view.adminBannerActivated(false);
                        }
                    } else {
                        try {
                            service.toggleActive(itemKey);
                        } catch (MachineAtCapacityException ex) {
                            view.bannerError(ex.getMessage());
                        }
                        view.adminBannerActivated(true);
                    }
                    service.saveStock();
                    valid = true;
                    break;
                case 5:
                    valid = true;
                    break;
                default:
                    break;
            }
        }
    }
    
    public void buy(int itemKey) throws IOException {
        try{
            
            BigDecimal[] change = service.buy(itemKey);
            view.bannerVend(service.getItem(itemKey).getName());
            view.showChange(change);
            service.saveStock();
        } catch(InsufficientFundsException | ItemOutOfStockException e){
            view.bannerError(e.getMessage());
        }
    }
}