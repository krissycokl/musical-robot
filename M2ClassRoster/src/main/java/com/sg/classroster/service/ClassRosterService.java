package com.sg.classroster.service;

import com.sg.classroster.dao.ClassRosterPersistenceException;
import com.sg.classroster.dto.Student;
import java.util.List;

public interface ClassRosterService {

    void createStudent(Student student) throws
        ClassRosterDuplicateException,
        ClassRosterDataValidationException,
        ClassRosterPersistenceException;
    
    List<Student> getAllStudents() throws
        ClassRosterPersistenceException;
    
    Student getStudent(String StudentID) throws
        ClassRosterPersistenceException;
    
    Student removeStudent(String StudentID) throws
        ClassRosterPersistenceException;    
    
}
