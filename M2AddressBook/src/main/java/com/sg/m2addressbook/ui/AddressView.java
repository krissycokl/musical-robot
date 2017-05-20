package com.sg.m2addressbook.ui;

import com.sg.m2addressbook.dto.Address;
import java.util.ArrayList;

public class AddressView {

    private UserIO io;
    
    public AddressView(UserIO io){
        this.io = io;
    }
    
    public int menuAndGetChoice(){
        io.print("\n=== Address Book ===");
        io.print("1.) Add address");
        io.print("2.) Remove address");
        io.print("3.) Count of addresses");
        io.print("4.) List all addresses");
        io.print("5.) Get address");
        io.print("6.) Exit");
        return io.getInt("What would you like to do?",1,6);
    }
    
    public Address getAddressInfo(){
        Address addy = new Address();
        addy.setNameFirst(io.getString("First name:"));
        addy.setNameLast(io.getString("Last name:"));
        addy.setStreetNum(io.getString("Street number:"));
        addy.setStreetName(io.getString("Street name:"));
        addy.setCity(io.getString("City:"));
        addy.setState(io.getString("State:"));
        addy.setZip(io.getString("Zip:"));
        return addy;
    }
    
    public void showSuccessAdd(){
        io.getString("Address added.  Hit return to continue.");
    }
    
    public void showSuccessRemove(){
        io.getString("Address removed.  Hit return to continue.");
    }
    
    public void showSuccessList(){
        io.getString("End of stored addresses.  Hit return to continue.");
    }
    
    public String getLastName(){
        return io.getString("What is the last name?");
    }
    
    public Address chooseAddress(ArrayList<Address> matches){
        printAddresses(matches);
        if (matches.size() == 0){
            io.getString("No addresses with that last name. Hit return to continue.");
            return null;
        } else if (matches.size()==1){
            return matches.get(0);
        }
        int choice = io.getInt("Which address did you mean?",1,matches.size());
        return matches.get(choice-1);
    }
    
    public void printAddresses(ArrayList<Address> matches){
        int numMatches = matches.size();
        if (numMatches == 1){
            printAddress(matches.get(0));
            return;
        }
        for (int i = 0 ; i<numMatches; i++){
                io.print((i+1)+".)");
                printAddress(matches.get(i));
        }
    }
    
    public void printAddress(Address address){
        io.print("\t"+address.getNameFirst()+" "+address.getNameLast());
        io.print("\t"+address.getStreetNum()+" "+address.getStreetName());
        io.print("\t"+address.getCity()+", "+address.getState()+" "+address.getZip()+"\n");
    }
    
    public void showCountOrNone(int count){
        if (count>0){
            io.print("There are "+count+" addresses in the book.");
        } else {
            io.print("No addresses stored.");
        }
    }
    
    public void invalidInput(){
        io.print("Sorry, that's not an option.");
    }
    
    public void finish(){
        io.print("\nThank you!");
    }
    
}
