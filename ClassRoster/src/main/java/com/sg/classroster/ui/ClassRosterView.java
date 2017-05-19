package com.sg.classroster.ui;
import com.sg.classroster.dto.Student;
import java.util.List;

public class ClassRosterView {
    UserIO io = new UserIOConsoleImpl();
    
    public int printMenuAndGetSelection(){
        io.print("Main Menu");
        io.print("1. List Student IDs");
        io.print("2. Create New Student");
        io.print("3. View a Student");
        io.print("4. Remove a Student");
        io.print("5. Exit");

        return io.getInt("Please select from the above.",1,5);
    }
    
    public Student getNewStudentInfo(){
        String studentID = io.getString("Please enter new ID");
        String firstName = io.getString("Please enter first name");
        String lastName = io.getString("Please enter last name");
        String cohort = io.getString("Please enter cohort");
        
        Student cur = new Student(studentID);
        cur.setFirstName(firstName);
        cur.setLastName(lastName);
        cur.setCohort(cohort);
        
        return cur;
    }

    public void displayCreateStudentBanner(){
        io.print("=== Create Student ===");
    }
    
    public void displayCreateSuccessBanner(){
        io.getString("Student successfully created.  Hit enter to continue.");
    }
    
    public void displayStudentList(List<Student> studentList){
       for (Student cur : studentList){
           io.print(cur.getStudentID() + ": "
                   + cur.getFirstName() + " "
                   + cur.getLastName());
       }
       io.getString("Please hit enter to continue.");
    }
    
    public void displayDisplayAllBanner(){
        io.print("=== Display All Students ===");
    }
    
    public void displayStudent(Student student){
        if (student!=null){
            io.print(student.getStudentID() + ": "
                    + student.getFirstName() + " "
                    + student.getLastName());
        } else {
            io.print("No such student.");
        }
        io.getString("Please hit enter to continue.");
    }
    
    public String getStudentID(){
        return io.getString("Please enter ID of student.");
    }
    
    public void displayDisplayStudentBanner(){
        io.print("=== Display Student ===");
    }
    
    public void displayRemoveStudentBanner(){
        io.print("=== Remove Student ===");
    }
    
    public void displayRemoveSuccessBanner(){
        io.getString("Student successfully removed.  Please hit enter to continue.");
    }
    
    public void displayExitBanner(){
        io.print("Thank you for using STUDENTVIEW(tm)");
    }
    
    public void displayUnknownCommandBanner(){
        io.print("Unknown command entered.");
    }
}