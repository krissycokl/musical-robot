package com.sg.m2addressbook.service;

import com.sg.m2addressbook.dto.Address;
import java.util.ArrayList;
import java.util.List;

public interface AddressService {
    public Address addAddress(Address address) throws AddressValidationException;
    public Address removeAddress(Address address);
    public int countAddresses();
    public List<Address> getAddresses();
    public ArrayList<Address> getAddresses(String ln);
}
