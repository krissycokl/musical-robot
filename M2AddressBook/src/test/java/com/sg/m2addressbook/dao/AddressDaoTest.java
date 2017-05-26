/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.sg.m2addressbook.dao;

import com.sg.m2addressbook.dto.Address;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class AddressDaoTest {

    AddressDao dao = new AddressDaoFileImpl();
    List<Address> tempAddresses;
    
    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
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
        
        int numAddies = dao.getAddresses().size();
        assertEquals(dao.getAddresses().get(numAddies-1),address);
        
        dao.removeAddress(address);
    }

    @Test
    public void testRemoveAddress() {
        int sizeAtStart = dao.getAddresses().size();
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
        assertEquals(dao.getAddresses().size(),sizeAtStart);
    }

    @Test
    public void testCountAddresses() {
        int sizeAtStart = dao.getAddresses().size();
        
        Address address = new Address();
        address.setNameFirst("Lorie");
        address.setNameLast("Ann");
        address.setCity("Chicago");
        address.setState("IL");
        address.setStreetName("W Foster");
        address.setStreetNum("2000");
        address.setZip("60625");
        
        dao.addAddress(address);
        
        assertEquals(dao.countAddresses(),sizeAtStart+1);
        
        dao.removeAddress(address);
    }

    @Test
    public void testGetAddresses_0args() {
        int sizeAtStart = dao.getAddresses().size();
        Address address = new Address();
        address.setNameFirst("Lorie");
        address.setNameLast("Ann");
        address.setCity("Chicago");
        address.setState("IL");
        address.setStreetName("W Foster");
        address.setStreetNum("2000");
        address.setZip("60625");
        
        Address address2 = new Address();
        address2.setNameFirst("Lanie");
        address2.setNameLast("Milquebone");
        address2.setCity("Chicago");
        address2.setState("IL");
        address2.setStreetName("W Foster");
        address2.setStreetNum("2000");
        address2.setZip("60625");
        
        dao.addAddress(address);
        dao.addAddress(address2);
        int numAddies = dao.getAddresses().size();
        assertEquals(dao.getAddresses().get(numAddies-1),address2);
        assertEquals(dao.getAddresses().size(),sizeAtStart+2);
        
        dao.removeAddress(address);
        dao.removeAddress(address2);
    }

    @Test
    public void testGetAddresses_String() {
        Address address = new Address();
        address.setNameFirst("Lorie");
        address.setNameLast("Ann Gilchrie");
        address.setCity("Chicago");
        address.setState("IL");
        address.setStreetName("W Foster");
        address.setStreetNum("2000");
        address.setZip("60625");
        
        Address address2 = new Address();
        address2.setNameFirst("Lorie");
        address2.setNameLast("Milque**&bone");
        address2.setCity("Chicago");
        address2.setState("Illinoise");
        address2.setStreetName("W Foster");
        address2.setStreetNum("2000");
        address2.setZip("60625");
        
        dao.addAddress(address);
        dao.addAddress(address2);
        
        assertEquals(dao.getAddresses("Milque**&bone").size(),1);
        
        dao.removeAddress(address);
        dao.removeAddress(address2);
    }

}