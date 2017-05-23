package com.sg.classroster.controller;
import com.sg.classroster.dao.ClassRosterPersistenceException;
import com.sg.classroster.service.ClassRosterDuplicateException;

import com.sg.classroster.ui.*;
import com.sg.classroster.dto.*;
import com.sg.classroster.service.ClassRosterDataValidationException;
import com.sg.classroster.service.ClassRosterService;
import java.util.List;

public class ClassRosterController {
    
    public ClassRosterController(ClassRosterService service, ClassRosterView view){
        this.service = service;
        this.view = view;
    }
    
    ClassRosterView view;
    ClassRosterService service;
    
    public void run() {
        boolean run = true;
        int menuSelection;
        try{
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
        }
        catch (ClassRosterPersistenceException e){
            view.displayErrorMessage(e.getMessage());
        }
    }

    private int getSelection() {
        return view.printMenuAndGetSelection();
    }
    
    private void createStudent() throws ClassRosterPersistenceException {
        view.displayCreateStudentBanner();
        boolean hasErrors;
        do {
            Student newStudent = view.getNewStudentInfo();
            try {
                service.createStudent(newStudent);
                view.displayCreateSuccessBanner();
                hasErrors = false;
            } catch (ClassRosterDuplicateException | ClassRosterDataValidationException e){
                hasErrors = true;
                view.displayErrorMessage(e.getMessage());
            }
        } while(hasErrors);
    }
    
    private void listStudents() throws ClassRosterPersistenceException {
        view.displayDisplayAllBanner();
        List<Student> studentList = service.getAllStudents();
        view.displayStudentList(studentList);
    }
    
    private void viewStudent() throws ClassRosterPersistenceException {
        view.displayDisplayStudentBanner();
        String id = view.getStudentID();
        view.displayStudent(service.getStudent(id));
    }
    
    private void removeStudent() throws ClassRosterPersistenceException {
        view.displayRemoveStudentBanner();
        service.removeStudent(view.getStudentID());
        view.displayRemoveSuccessBanner();
    }
    
    private void unknownCommand(){
        view.displayUnknownCommandBanner();
    }
    
    private void exitBanner(){
        view.displayExitBanner();
    }
}
