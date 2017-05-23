/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.classroster.dao;

import com.sg.classroster.dto.Student;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class ClassRosterDaoTest {
    
    ClassRosterDao dao = new ClassRosterDaoFileImpl();
    
    public ClassRosterDaoTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        List<Student> studentList = dao.getAllStudents();
        for (Student student : studentList){
            dao.removeStudent(student.getStudentID());
        }
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void testAddGetStudent() {
        Student student = new Student("0001");
        student.setFirstName("Gabriel");
        student.setLastName("Knight");
        student.setCohort("Forever Night");
        
        dao.addStudent(student.getStudentID(), student);
        
        Student fromDao = dao.getStudent("0001");
        
        assertEquals(fromDao, student);
    }

    @Test
    public void testGetAllStudents() {
        dao.addStudent("01", new Student("01"));
        dao.addStudent("02", new Student("02"));
        
        assertEquals(dao.getAllStudents().size(),2);
    }
    
    @Test
    public void testRemoveStudent() {
        Student student = new Student("0001");
        student.setFirstName("Gabriel");
        student.setLastName("Knight");
        student.setCohort("Forever Night");
        
        dao.addStudent(student.getStudentID(), student);
        
        Student fromDao = dao.removeStudent(student.getStudentID());
        
        assertEquals(fromDao, student);
        assertEquals(dao.getAllStudents().size(),0);
    }
    
}
