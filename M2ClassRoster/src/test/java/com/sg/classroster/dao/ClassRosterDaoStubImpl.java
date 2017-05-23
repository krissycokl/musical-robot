package com.sg.classroster.dao;

import com.sg.classroster.dto.Student;
import java.util.ArrayList;
import java.util.List;

public class ClassRosterDaoStubImpl implements ClassRosterDao {

    private Student onlyStudent;
    private List<Student> studentList = new ArrayList<Student>();
    
    public ClassRosterDaoStubImpl(){
        onlyStudent = new Student("0001");
        onlyStudent.setFirstName("Gabriel");
        onlyStudent.setLastName("Knight");
        onlyStudent.setCohort("Forever Badgers");
        
        studentList.add(onlyStudent);
    }
    
    @Override
    public Student addStudent(String studentID, Student student) {
        if(studentID.equals(onlyStudent.getStudentID())){
            return onlyStudent;
        } else {
            return null;
        }
    }

    @Override
    public List<Student> getAllStudents() {
        return studentList;
    }

    @Override
    public Student getStudent(String studentID) {
        if(studentID.equals(onlyStudent.getStudentID())){
            return onlyStudent;
        } else {
            return null;
        }
    }

    @Override
    public Student removeStudent(String studentID) {
        if(studentID.equals(onlyStudent.getStudentID())){
            return onlyStudent;
        } else {
            return null;
        }
    }

}
