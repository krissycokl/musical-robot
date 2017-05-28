package com.sg.m3vendingmachine.controller;

import com.sg.m3vendingmachine.dto.Change;
import com.sg.m3vendingmachine.service.*;
import com.sg.m3vendingmachine.ui.VendingView;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigDecimal;

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
            view.showBalance(service.getBalance());
            view.showInventoryAndMenu(service.getStock());
            choice = view.getChoice();
            switch(choice){
                case 11:
                    buy(1);
                    break;
                case 12:
                    buy(2);
                    break;
                case 13:
                    buy(3);
                    break;
                case 21:
                    buy(4);
                    break;
                case 22:
                    buy(5);
                    break;
                case 23:
                    buy(6);
                    break;
                case 250:
                    service.changeBalance(Change.quarter);
                    break;
                case 50:
                    service.changeBalance(Change.nickel);
                    break;
                case 100:
                    service.changeBalance(Change.dime);
                    break;
                case 10:
                    service.changeBalance(Change.penny);
                    break;
                case 1000:
                    service.changeBalance(Change.dollar);
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
                                service.toggleActive(itemKey);
                                view.adminBannerActivated(false);
                            }
                        } else {
                            view.adminBannerActivated(false);
                        }
                    } else {
                        service.getItem(itemKey).toggleActive();
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
            view.showChange(change);
            service.saveStock();
        } catch(InsufficientFundsException | ItemOutOfStockException e){
            view.communicate(e.getMessage());
        }
    }
}