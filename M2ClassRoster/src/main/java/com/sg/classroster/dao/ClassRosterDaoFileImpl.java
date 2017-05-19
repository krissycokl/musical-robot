package com.sg.classroster.dao;

import com.sg.classroster.dto.Student;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.List;

public class ClassRosterDaoFileImpl implements ClassRosterDao {
    
    private Map<String, Student> students = new HashMap<>();

    @Override
    public Student addStudent(String studentID, Student student) {
        Student newStudent = students.put(studentID, student);
        return newStudent;
    }

    @Override
    public List<Student> getAllStudents() {
        return new ArrayList<Student>(students.values());
    }

    @Override
    public Student getStudent(String studentID) {
        return students.get(studentID);
    }

    @Override
    public Student removeStudent(String studentID) {
        Student removed = students.remove(studentID);
        return removed;
    }

}
