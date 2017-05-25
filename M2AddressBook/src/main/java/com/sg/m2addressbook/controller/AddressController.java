package com.sg.m2addressbook.controller;
import com.sg.m2addressbook.dto.Address;
import com.sg.m2addressbook.service.AddressService;
import com.sg.m2addressbook.service.AddressValidationException;
import com.sg.m2addressbook.ui.AddressView;
public class AddressController {
    
    AddressView view;
    AddressService service;
    boolean run = true;
    int choice;
    
    public AddressController(AddressService service, AddressView view){
        this.service = service;
        this.view = view;
    }
    
    public void run() throws AddressValidationException{
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
        view.chooseAddress(service.getAddresses(view.getLastName()));
    }
    
    private void addAddress() throws AddressValidationException{
        Address addy = view.getAddressInfo();
        service.addAddress(addy);
        view.showSuccessAdd();
    }
    
    private void rmAddress(){
        String ln = view.getLastName();
        Address addy = view.chooseAddress(service.getAddresses(ln));
        addy = service.removeAddress(addy);
        if(addy != null){
            view.showSuccessRemove();
        }
    }
    
    private void countAddressAndSayIfNone(){
        view.showCountOrNone(service.countAddresses());
    }
    
    private void printAll(){
        if (service.countAddresses()==0){
            countAddressAndSayIfNone();
        } else {
            for (Address addy : service.getAddresses()){
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
