package com.sg.m2addressbook.dao;

import com.sg.m2addressbook.dto.Address;
import java.util.ArrayList;
import java.util.List;

public class AddressDaoFileImpl implements AddressDao {
    
    private List<Address> addresses = new ArrayList<>();

    @Override
    public Address addAddress(Address address) {
        addresses.add(address);
        return address;
    }

    @Override
    public Address removeAddress(Address address) {
        addresses.remove(address);
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
