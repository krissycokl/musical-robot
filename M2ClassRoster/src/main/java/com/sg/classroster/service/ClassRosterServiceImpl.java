package com.sg.classroster.service;

import com.sg.classroster.dao.ClassRosterAuditDao;
import com.sg.classroster.dao.ClassRosterDao;
import com.sg.classroster.dao.ClassRosterPersistenceException;
import com.sg.classroster.dto.Student;
import java.util.List;

public class ClassRosterServiceImpl implements ClassRosterService {

ClassRosterDao dao;
private ClassRosterAuditDao auditDao;

public ClassRosterServiceImpl(ClassRosterDao dao, ClassRosterAuditDao auditDao){
    this.dao = dao;
    this.auditDao = auditDao;
}

    @Override
    public void createStudent(Student student) throws
            ClassRosterDuplicateException,
            ClassRosterDataValidationException,
            ClassRosterPersistenceException {
        if(dao.getStudent(student.getStudentID()) != null){
            throw new ClassRosterDuplicateException("Error: student with this "
                    + "ID already exists.");
        }
        
        validateStudentData(student);
        dao.addStudent(student.getStudentID(), student);
        auditDao.writeAuditEntry("Student "+student.getStudentID()+" added.");
    }

    @Override
    public List<Student> getAllStudents() throws
            ClassRosterPersistenceException {
        return dao.getAllStudents();
    }

    @Override
    public Student getStudent(String StudentID) throws
            ClassRosterPersistenceException {
        return dao.getStudent(StudentID);
    }

    @Override
    public Student removeStudent(String StudentID) throws
            ClassRosterPersistenceException {
        Student removedStudent = dao.removeStudent(StudentID);
        auditDao.writeAuditEntry("Student "+StudentID+" removed.");
        return removedStudent;
    }
    
    private void validateStudentData(Student student) throws
            ClassRosterDataValidationException {
        if(     student.getFirstName()==null||
                student.getFirstName().trim().length()==0||
                student.getLastName()==null||
                student.getLastName().trim().length()==0||
                student.getCohort()==null||
                student.getCohort().trim().length()==0){
            throw new ClassRosterDataValidationException("Error: first name, "
                    + "last name, and cohort may not be blank.");
        }
    }
}
