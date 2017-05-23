/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.sg.m2addressbook.dao;

import com.sg.m2addressbook.dto.Address;
import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class AddressDaoTest {

    public AddressDaoTest() {
    }

    AddressDao dao = new AddressDaoFileImpl();
    
    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        List<Address> addresses = dao.getAddresses();
        for (Address address : addresses){
            addresses.remove(address);
        }
    }

    @After
    public void tearDown() {
    }

    @Test
    public void testAddAddress() {
        Address address = new Address();
        address.setNameFirst("Lorie");
        address.setNameLast("Ann");
        address.setCity("Chicago");
        address.setState("IL");
        address.setStreetName("W Foster");
        address.setStreetNum("2000");
        address.setZip("60625");
        
        dao.addAddress(address);
        
        assertEquals(dao.getAddresses().get(0),address);
    }

    @Test
    public void testRemoveAddress() {
        Address address = new Address();
        address.setNameFirst("Lorie");
        address.setNameLast("Ann");
        address.setCity("Chicago");
        address.setState("IL");
        address.setStreetName("W Foster");
        address.setStreetNum("2000");
        address.setZip("60625");
        
        dao.addAddress(address);
        Address fromDao = dao.removeAddress(address);
        
        assertEquals(fromDao, address);
        assertEquals(dao.getAddresses().size(),0);
    }

    @Test
    public void testCountAddresses() {
        assertEquals(dao.countAddresses(),0);
        
        Address address = new Address();
        address.setNameFirst("Lorie");
        address.setNameLast("Ann");
        address.setCity("Chicago");
        address.setState("IL");
        address.setStreetName("W Foster");
        address.setStreetNum("2000");
        address.setZip("60625");
        
        dao.addAddress(address);
        
        assertEquals(dao.countAddresses(),1);
    }

    @Test
    public void testGetAddresses_0args() {
        Address address = new Address();
        address.setNameFirst("Lorie");
        address.setNameLast("Ann");
        address.setCity("Chicago");
        address.setState("IL");
        address.setStreetName("W Foster");
        address.setStreetNum("2000");
        address.setZip("60625");
        
        Address address2 = new Address();
        address2.setNameFirst("Lorie");
        address2.setNameLast("Milquebone");
        address2.setCity("Chicago");
        address2.setState("IL");
        address2.setStreetName("W Foster");
        address2.setStreetNum("2000");
        address2.setZip("60625");
        
        dao.addAddress(address);
        dao.addAddress(address2);
        
        assertEquals(dao.getAddresses().get(0),address);
        assertEquals(dao.getAddresses().size(),2);
    }

    @Test
    public void testGetAddresses_String() {
        Address address = new Address();
        address.setNameFirst("Lorie");
        address.setNameLast("Ann");
        address.setCity("Chicago");
        address.setState("IL");
        address.setStreetName("W Foster");
        address.setStreetNum("2000");
        address.setZip("60625");
        
        Address address2 = new Address();
        address2.setNameFirst("Lorie");
        address2.setNameLast("Milquebone");
        address2.setCity("Chicago");
        address2.setState("IL");
        address2.setStreetName("W Foster");
        address2.setStreetNum("2000");
        address2.setZip("60625");
        
        dao.addAddress(address);
        dao.addAddress(address2);
        
        assertEquals(dao.getAddresses("Milquebone").size(),1);
    }

}