/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.sg.m2dvdlibrary.dao;

import com.sg.m2dvdlibrary.dto.DVD;
import java.util.HashMap;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class DVDDaoTest {

    DVDDao dao = new DVDDaoFileImpl();
    
    public DVDDaoTest() {
    }

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
    public void testAddGetDVD() {
        DVD dvd = new DVD();
        dvd.setDirector("Ian Grimes");
        dvd.setNote("");
        dvd.setRating("R");
        dvd.setTitle("3:10 to Yuma");
        dvd.setStudio("");
        dvd.setYear(1990);
        
        dao.addDVD(dvd);
        DVD fromDao = dao.getDVD(0);
        
        assertEquals(fromDao, dvd);
    }

    @Test
    public void testRemoveDVD() {
        DVD dvd = new DVD();
        dvd.setDirector("Ian Grimes");
        dvd.setNote("");
        dvd.setRating("R");
        dvd.setTitle("3:10 to Yuma");
        dvd.setStudio("");
        dvd.setYear(1990);
        
        dao.addDVD(dvd);
        DVD fromDao = dao.removeDVD(0);
        assertEquals(fromDao, dvd);
    }

    @Test
    public void testListDVDs_0args() {
        DVD dvd = new DVD();
        dvd.setDirector("Ian Grimes");
        dvd.setNote("");
        dvd.setRating("R");
        dvd.setTitle("3:10 to Yuma");
        dvd.setStudio("");
        dvd.setYear(1990);
        
        DVD dvd2 = new DVD();
        dvd2.setDirector("Ian Grimes");
        dvd2.setNote("Never");
        dvd2.setRating("R");
        dvd2.setTitle("Palo Alto");
        dvd2.setStudio("Hmm");
        dvd2.setYear(2001);
        
        dao.addDVD(dvd);
        dao.addDVD(dvd2);
        
        assertEquals(dao.listDVDs().size(),2);
        assertEquals(dao.listDVDs().get(1),dvd2);
    }

    @Test
    public void testListDVDs_String() {
        DVD dvd = new DVD();
        dvd.setDirector("Ian Grimes");
        dvd.setNote("");
        dvd.setRating("R");
        dvd.setTitle("3:10 to Yuma");
        dvd.setStudio("");
        dvd.setYear(1990);
        
        DVD dvd2 = new DVD();
        dvd2.setDirector("Ian Grimes");
        dvd2.setNote("Never");
        dvd2.setRating("R");
        dvd2.setTitle("Palo Alto");
        dvd2.setStudio("Hmm");
        dvd2.setYear(2001);
        
        dao.addDVD(dvd);
        dao.addDVD(dvd2);
        
        assertEquals(dao.listDVDs("palo").size(),1);
        assertEquals(dao.listDVDs("palo").get(1),dvd2);
    }

    @Test
    public void testPopulate() throws Exception {
    }

    @Test
    public void testSave() throws Exception {
    }

}