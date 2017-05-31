package com.sg.classroster.service;

import com.sg.classroster.dao.ClassRosterAuditDao;
import com.sg.classroster.dao.ClassRosterAuditDaoStubImpl;
import com.sg.classroster.dao.ClassRosterDao;
import com.sg.classroster.dao.ClassRosterDaoStubImpl;
import com.sg.classroster.dto.Student;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ClassRosterServiceTest {
    
    private ClassRosterService service;

    public ClassRosterServiceTest() {
        /*ClassRosterDao dao = new ClassRosterDaoStubImpl();
        ClassRosterAuditDao auditDao = new ClassRosterAuditDaoStubImpl();
        
        service = new ClassRosterServiceImpl(dao, auditDao);*/
        
        ApplicationContext ctx = 
                new ClassPathXmlApplicationContext("applicationContext.xml");
        service = ctx.getBean("service", ClassRosterService.class);
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
    public void testCreateStudent() throws Exception {
        Student student = new Student("0002");
        student.setFirstName("Mary");
        student.setLastName("Joseph");
        student.setCohort("Angelus");
        service.createStudent(student);
    }
    
    @Test
    public void testCreateStudentDupID() throws Exception {
        Student student = new Student("0001");
        student.setFirstName("Mary");
        student.setLastName("Joseph");
        student.setCohort("Angelus");
        try{
            service.createStudent(student);
            fail("Expected ClassRosterDuplicateException not thrown.");
        } catch (ClassRosterDuplicateException e){
        }
    }
    
    @Test
    public void testCreateStudentInvalidData() throws Exception {
        Student student = new Student("0002");
        student.setFirstName("Mary");
        student.setLastName("");
        student.setCohort("Angelus");
        try{
            service.createStudent(student);
            fail("Expected ClassRosterInvalidException not thrown.");
        } catch (ClassRosterDataValidationException e){
        }
    }

    @Test
    public void testGetAllStudents() throws Exception {
        assertEquals(service.getAllStudents().size(),1);
    }

    @Test
    public void testGetStudent() throws Exception {
        assertNull(service.getStudent("999"));
        assertNotNull(service.getStudent("0001"));
    }

    @Test
    public void testRemoveStudent() throws Exception {
        assertNotNull(service.removeStudent("0001"));
        assertNull(service.removeStudent("9999"));
    }
}