package com.sg.m2addressbook.controller;
import com.sg.m2addressbook.dao.AddressDao;
import com.sg.m2addressbook.dto.Address;
import com.sg.m2addressbook.ui.AddressView;
public class AddressController {
    
    AddressDao dao;
    AddressView view;
    boolean run = true;
    int choice;
    
    public AddressController(AddressDao dao, AddressView view){
        this.dao = dao;
        this.view = view;
    }
    
    public void run(){
        while(run){
            choice = getChoice();
            switch(choice){
                case 1:
                    addAddress();
                    break;
                case 2:
                    rmAddress();
                    break;
                case 3:
                    countAddressAndSayIfNone();
                    break;
                case 4:
                    printAll();
                    break;
                case 5:
                    getAddyByLn();
                    break;
                case 6:
                    run = false;
                    break;
                default:
                    invalidInput();
            }
        }
        finish();
    }
    
    private int getChoice(){
        return view.menuAndGetChoice();
    }
    
    private void getAddyByLn(){
        view.chooseAddress(dao.getAddresses(view.getLastName()));
    }
    
    private void addAddress(){
        Address addy = view.getAddressInfo();
        dao.addAddress(addy);
        view.showSuccessAdd();
    }
    
    private void rmAddress(){
        String ln = view.getLastName();
        Address addy = view.chooseAddress(dao.getAddresses(ln));
        addy = dao.removeAddress(addy);
        if(addy != null){
            view.showSuccessRemove();
        }
    }
    
    private void countAddressAndSayIfNone(){
        view.showCountOrNone(dao.countAddresses());
    }
    
    private void printAll(){
        if (dao.countAddresses()==0){
            countAddressAndSayIfNone();
        } else {
            for (Address addy : dao.getAddresses()){
                view.printAddress(addy);
            }
            view.showSuccessList();
        }
    }
    
    private void invalidInput(){
        view.invalidInput();
    }
    
    private void finish(){
        view.finish();
    }
}
