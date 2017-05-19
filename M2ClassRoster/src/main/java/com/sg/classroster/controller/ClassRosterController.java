package com.sg.classroster.controller;
import com.sg.classroster.ui.*;
import com.sg.classroster.dao.*;
import com.sg.classroster.dto.*;
import java.util.List;

public class ClassRosterController {
    
    public ClassRosterController(ClassRosterDao dao, ClassRosterView view){
        this.dao = dao;
        this.view = view;
    }
    
    ClassRosterView view;
    ClassRosterDao dao;
    
    public void run(){
        boolean run = true;
        int menuSelection;
        while(run){
            
            menuSelection = getSelection();
            
            switch(menuSelection){
                case 1:
                    listStudents();
                    break;
                case 2:
                    createStudent();
                    break;
                case 3:
                    viewStudent();
                    break;
                case 4:
                    removeStudent();
                    break;
                case 5:
                    run = false;
                    break;
                default:
                    unknownCommand();
            }
        }
        exitBanner();
        //view.displayExitBanner();
    }

    private int getSelection() {
        return view.printMenuAndGetSelection();
    }
    
    private void createStudent() {
        view.displayCreateStudentBanner();
        Student newStudent = view.getNewStudentInfo();
        dao.addStudent(newStudent.getStudentID(), newStudent);
        view.displayCreateSuccessBanner();
    }
    
    private void listStudents(){
        view.displayDisplayAllBanner();
        List<Student> studentList = dao.getAllStudents();
        view.displayStudentList(studentList);
    }
    
    private void viewStudent(){
        view.displayDisplayStudentBanner();
        String id = view.getStudentID();
        view.displayStudent(dao.getStudent(id));
    }
    
    private void removeStudent(){
        view.displayRemoveStudentBanner();
        dao.removeStudent(view.getStudentID());
        view.displayRemoveSuccessBanner();
    }
    
    private void unknownCommand(){
        view.displayUnknownCommandBanner();
    }
    
    private void exitBanner(){
        view.displayExitBanner();
    }
}
