package com.sg.m2addressbook.service;

import com.sg.m2addressbook.dao.*;
import com.sg.m2addressbook.dto.Address;
import java.util.ArrayList;
import java.util.List;

public class AddressServiceImpl implements AddressService {
    
    AddressDao dao;
    
    public AddressServiceImpl(AddressDao dao){
        this.dao = dao;
    }

    @Override
    public Address addAddress(Address address) throws AddressValidationException{
        validateAddress(address);
        return dao.addAddress(address);
    }

    @Override
    public Address removeAddress(Address address) {
        return dao.removeAddress(address);
    }

    @Override
    public int countAddresses() {
        return dao.countAddresses();
    }

    @Override
    public List<Address> getAddresses() {
        return dao.getAddresses();
    }

    @Override
    public ArrayList<Address> getAddresses(String ln) {
        return dao.getAddresses(ln);
    }

    private void validateAddress(Address address) throws AddressValidationException {
        if (address.getNameLast().isEmpty()){
            throw new AddressValidationException("Last name must not be empty.");
        }
        if (address.getStreetName().isEmpty()){
            throw new AddressValidationException("Street name must not be empty.");
        }
        if (address.getStreetNum().isEmpty()){
            throw new AddressValidationException("Street number must not be empty.");
        }
        if (address.getZip().isEmpty() &&
             (address.getCity().isEmpty() ||
              address.getState().isEmpty())){
            throw new AddressValidationException("Either city & state or zip required.");
        }
    }
}