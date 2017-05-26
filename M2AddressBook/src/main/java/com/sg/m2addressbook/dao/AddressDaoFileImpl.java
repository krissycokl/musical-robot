package com.sg.m2addressbook.dao;

import com.sg.m2addressbook.dto.Address;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public final class AddressDaoFileImpl implements AddressDao {
    
    private final List<Address> addresses = new ArrayList<>();
    private final String FILENAME = "output.txt";
    private final String DELIM    = "::";
    
    public AddressDaoFileImpl(){
        read();
    }
    
    @Override
    public void write() {
        try{
            PrintWriter out = new PrintWriter(new FileWriter(FILENAME));

            for (Address address : addresses){
                out.write(nullC(address.getNameFirst())+DELIM+
                        nullC(address.getNameLast())+DELIM+
                        nullC(address.getStreetNum())+DELIM+
                        nullC(address.getStreetName())+DELIM+
                        nullC(address.getCity())+DELIM+
                        nullC(address.getState())+DELIM+
                        nullC(address.getZip()));
                out.write("\n");
                out.flush();
            }
            out.close();}
        catch (IOException e){
            System.out.println("Failed to write to file.");
        }
    }
    
    @Override
    public void read(){
        try{
            Scanner sc = new Scanner(new BufferedReader(new FileReader(FILENAME)));
            while(sc.hasNextLine()){
                String[] values = sc.nextLine().split(DELIM);
                Address temp = new Address();
                temp.setNameFirst(values[0]);
                temp.setNameLast(values[1]);
                temp.setStreetNum(values[2]);
                temp.setStreetName(values[3]);
                temp.setCity(values[4]);
                temp.setState(values[5]);
                temp.setZip(values[6]);
                addAddress(temp);
            }
            sc.close(); 
        }
        catch (IOException e){
            System.out.println("Error reading file.");
        }
        
    }
    
    public String nullC(String field){
        if(field.isEmpty()){
            return "none";
        }
        return field;
    }
    
    @Override
    public Address addAddress(Address address) {
        addresses.add(address);
        write();
        return address;
    }

    @Override
    public Address removeAddress(Address address) {
        addresses.remove(address);
        write();
        return address;
    }

    @Override
    public ArrayList<Address> getAddresses(String ln){
        ArrayList<Address> matches = new ArrayList<>();
        for (Address addy : addresses){
            if (addy.getNameLast().equals(ln)){
                matches.add(addy);
            }
        }
        return matches;
    }
    
    @Override
    public int countAddresses() {
        return addresses.size();
    }

    @Override
    public List<Address> getAddresses() {
        return addresses;
    }

}
