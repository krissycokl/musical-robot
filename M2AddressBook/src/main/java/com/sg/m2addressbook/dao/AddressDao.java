package com.sg.m2addressbook.dao;

import com.sg.m2addressbook.dto.Address;
import java.util.ArrayList;
import java.util.List;

public interface AddressDao {
    
    public Address addAddress(Address address);
    public Address removeAddress(Address address);
    public int countAddresses();
    public List<Address> getAddresses();
    public ArrayList<Address> getAddresses(String ln);
    public void write();
    public void read();
    
}
