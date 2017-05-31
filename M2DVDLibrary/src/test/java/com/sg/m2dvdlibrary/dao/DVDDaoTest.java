/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.sg.m2dvdlibrary.dao;

import com.sg.m2dvdlibrary.dto.DVD;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DVDDaoTest {

    //DVDDao dao = new DVDDaoFileImpl();
    
    DVDDao dao;
    
    public DVDDaoTest() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        dao = ctx.getBean("dao",DVDDao.class);
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
        dvd.setYear(LocalDate.parse("01/06/1990",DateTimeFormatter.ofPattern("mm/DD/uuuu")));
        
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
        dvd.setYear(LocalDate.parse("01/06/1990",DateTimeFormatter.ofPattern("mm/DD/uuuu")));
        
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
        dvd.setYear(LocalDate.parse("01/06/1990",DateTimeFormatter.ofPattern("mm/DD/uuuu")));
        
        DVD dvd2 = new DVD();
        dvd2.setDirector("Ian Grimes");
        dvd2.setNote("Never");
        dvd2.setRating("R");
        dvd2.setTitle("Palo Alto");
        dvd2.setStudio("Hmm");
        dvd.setYear(LocalDate.parse("01/06/1990",DateTimeFormatter.ofPattern("mm/DD/uuuu")));
        
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
        dvd.setYear(LocalDate.parse("01/06/1990",DateTimeFormatter.ofPattern("mm/DD/uuuu")));
        
        DVD dvd2 = new DVD();
        dvd2.setDirector("Ian Grimes");
        dvd2.setNote("Never");
        dvd2.setRating("R");
        dvd2.setTitle("Palo Alto");
        dvd2.setStudio("Hmm");
        dvd.setYear(LocalDate.parse("01/06/1990",DateTimeFormatter.ofPattern("mm/DD/uuuu")));
        
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