package com.sg.classroster.dao;
import com.sg.classroster.dto.*;
import java.util.List;

public interface ClassRosterDao {
    /**
     * Adds the given Student to the roster and associates it with given ID.
     * If a student associated with that ID already exists, return that student
     * object, otherwise it will return null.
     * 
     * @param studentID id with which student is associated
     * @param student student to be added to the roster
     * @return the Student object previously associated with the given id, or 
     * null if none exists.
     */
    Student addStudent(String studentID, Student student);
    
    
    /**
     * Returns a String array containing the student IDs of all students
     * in the roster.
     * 
     * @return String array containing all existing student IDs
     */
    List<Student> getAllStudents();
    
    /**
     * Returns the Student object associated with the given ID.
     * Returns null if no such student exists.
     * 
     * @param studentID of the student to retrieve
     * @return the Student object associated with given ID, or null if none 
     * exists.
     */
    Student getStudent(String studentID);
    
    
    /**
     * Removes from the roster the student associated with the given ID.
     * Returns the student object that has been removed, or null if there is no
     * student associated with the given id.
     * 
     * @param studentID ID of the student to be removed
     * @return Student object that was removed, or null if none found.
     */
    Student removeStudent(String studentID);
}
