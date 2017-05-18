package com.sg.D9StudentQuizScores;
import com.sg.D8UserIO.ImplementsUserIO;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class StudentQuizScores {
    
    public static ImplementsUserIO UIO = new ImplementsUserIO();
    
    public static void main(String[] args) {
        String input;
        boolean cancel=false;
        
        HashMap<Integer, Student> students = new HashMap<>();
        createDummyStudents(students);
        int numStudents=students.size();
        
        while(!cancel){
            input = UIO.getString("What do you want to do?\n"
                    + "\tList Students\n"
                    + "\tAdd Student\n"
                    + "\tRemove Student\n"
                    + "\tView Scores\n"
                    + "\tAdd Score\n"
                    + "\tView Average\n"
                    + "Type cancel at any time to quit.");
            
            if(input.equalsIgnoreCase("list students")){
                getListOfStudents(students);
            } else if(input.equalsIgnoreCase("add student")){
                numStudents+=addStudent(students,numStudents);
            } else if(input.equalsIgnoreCase("remove student")){
                numStudents-=removeStudent(students);
            } else if(input.equalsIgnoreCase("view scores")){
                getScores(students);
            } else if(input.equalsIgnoreCase("add score")){
                addScore(students);
            } else if(input.equalsIgnoreCase("view average")){
                getAverage(students);
            } else if(input.equalsIgnoreCase("cancel")){
                cancel=true;
            }
            System.out.println();
            
        }
    }
    
    public static int getID(HashMap<Integer,Student> students){
        ArrayList<Integer> names = new ArrayList<>();
        String name;
        int gottenID;
        String way = UIO.getString("Find student by name or ID? Type anything else to quit.");
        
        if (way.equalsIgnoreCase("id")){
            gottenID = UIO.getInt("Please enter the student's id.");
            if(students.containsKey(gottenID)){return gottenID;}
            else{
                System.out.println("No student by that ID.");
                return -1;
            }
        } else if (way.equalsIgnoreCase("name")){
            name = UIO.getString("Please enter the student's name.");
            for ( Integer id : students.keySet()){
                if (students.get(id).getName().equalsIgnoreCase(name) ){
                    names.add(id);
                    System.out.println("ID: "+id+ ", Name: "+students.get(id).getName());
                }
            }
            switch (names.size()){
                case 0: System.out.println("No student by that name.");
                        return -1;
                case 1: return names.get(0);
                default: return UIO.getInt("Which student do you want? (enter ID)");
            }
        } else {return -1;}
    }
    
    public static void getListOfStudents(HashMap<Integer,Student> students){
        if (students.isEmpty()){
            System.out.println("No students.");
            return;
        }
        for ( Integer id : students.keySet()){
            System.out.println("ID: "+id+ ", Name: "+students.get(id).getName());
        }
    }
    
    public static int addStudent(HashMap<Integer,Student> students, int id){
        String name = UIO.getString("Enter student's name or type cancel");
        if (name.equalsIgnoreCase("cancel")){return 0;}
        else {
            students.put(id,new Student(name.toUpperCase()));
            System.out.println(name+" added with id "+id);
            return 1;
        }
    }
    
    public static int removeStudent(HashMap<Integer,Student> students){
        int id = getID(students);
        if(id==-1){return 0;}
        
        students.remove(id);
        return 1;
    }
    
    public static void getScores(HashMap<Integer,Student> students){
        int id = getID(students);
        if(id==-1){return;}
        
        int numScores = students.get(id).getScores().size();
        if (numScores == 0){
            System.out.println("No scores on file for "+students.get(id).getName()+".");
            return;
        }
        
        System.out.println("\n"+students.get(id).getName()+"'s scores: ");
        for ( Integer score : students.get(id).getScores()){
            System.out.print(score+", ");
        }
        System.out.println();
    }
    
    public static void addScore(HashMap<Integer,Student> students){
        int id = getID(students);
        if(id==-1){return;}
        students.get(id).addScore(UIO.getInt("Please enter the student's score."));
    }
    
    public static void getAverage(HashMap<Integer,Student> students){
        int id = getID(students);
        if(id==-1){return;}
        
        int numScores;
        int sumScores=0;
        
        numScores = students.get(id).getScores().size();
        for (Integer score : students.get(id).getScores()){
            sumScores += score;
        }
        if(numScores==0){
            System.out.println("No scores on file for "+students.get(id).getName()+".");
            return;
        }
        System.out.println(students.get(id).getName() + "'s average is "+ 1.0*sumScores/numScores);
    }
    
    public static void createDummyStudents(HashMap<Integer,Student> students){
        Random ran = new Random();
        
        students.put(0,new Student("HARRIET"));
        students.put(1,new Student("CARL"));
        students.put(2,new Student("LOUISE"));
        students.put(3,new Student("CAROL"));
        students.put(4,new Student("MICHAEL"));
        students.put(5,new Student("JASON"));
        students.put(6,new Student("FREDDY"));
        students.put(7,new Student("NESSIE"));
        
        for (Integer id : students.keySet()){
            for (int i=0; i<10; i++){
                students.get(id).addScore(ran.nextInt(30)+71);
            }
        }
    }
}