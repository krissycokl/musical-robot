package com.sg.D9StudentQuizScores;
import com.sg.D8UserIO.ImplementsUserIO;
import java.util.ArrayList;
import java.util.HashMap;

// Random only used to initialize dummy student scores
import java.util.Random;

public class StudentQuizScores {
    
    public static ImplementsUserIO UIO = new ImplementsUserIO();
    
    public static int IDat = 7;
    
    public static void main(String[] args) {
        HashMap<Integer, Student> students = new HashMap<>();
        createDummyStudents(students);
        
        boolean cancel=false;
        while(!cancel){
            cancel = direct(students);
        }
    }
    
    public static int getID(HashMap<Integer,Student> students){
        if(students.isEmpty()){
            System.out.println("There are no students.");
            return -1;
        }
        
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
            System.out.println();
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
    
    public static int addStudent(HashMap<Integer,Student> students){
        String name = UIO.getString("Enter student's name or type cancel");
        if (name.equalsIgnoreCase("cancel")){return 0;}
        else {
            IDat++;
            students.put(IDat,new Student(name.toUpperCase()));
            System.out.println(name+" added with id "+IDat);
            return 1;
        }
    }
    
    public static int removeStudent(HashMap<Integer,Student> students){
        int id = getID(students);
        if(id==-1){return 0;}
        
        System.out.println("Student ID: "+id+", Name: "+students.get(id).getName()+" removed.");
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
        
        if(students.get(id).getScores().isEmpty()){
            System.out.println("No scores on file for "+students.get(id).getName()+".");
            return;
        }
        System.out.println(students.get(id).getName() + "'s average is "+ getAverage(students, id));
    }
    
    public static double getAverage(HashMap<Integer,Student> students, int id){
        int numScores=0;
        int sumScores=0;
        for (Integer score : students.get(id).getScores()){
            sumScores += score;
            numScores++;
        }
        return 1.0*sumScores/numScores;
    }
    
    public static void getOverallAverage(HashMap<Integer,Student> students){
        int sumScores = 0;
        int numScores = 0;
        for (Integer id : students.keySet()){
            for (Integer score : students.get(id).getScores()){
                numScores++;
                sumScores+=score;
            }
        }
        if(numScores==0){
            System.out.println("No scores on file.");
            return;
        }
        System.out.println("Class overall average is "+ 1.0*sumScores/numScores);
    }
    
    public static void getStudentByScore(HashMap<Integer,Student> students, boolean best){
        if(students.isEmpty()){
            System.out.println("There are no students.");
            return;
        }
        
        double minAvg=101;
        int minID = -1;
        double maxAvg=-1;
        int maxID = -1;
        double tempAvg;
        
        for (Integer id : students.keySet()){
            tempAvg = getAverage(students,id);
            if(tempAvg<minAvg){
                minAvg=tempAvg;
                minID = id;
            }
            if(tempAvg>maxAvg){
                maxAvg=tempAvg;
                maxID = id;
            }
        }
        
        if(best){
            if (maxID==-1){System.out.println("Score validation error. Scores should be between 0 and 100.");}
            System.out.println("The student with the highest grade is "+students.get(maxID).getName()+""
                    + " with an average of "+maxAvg);
        }
        else {
            if (minID==-1){System.out.println("Score validation error. Scores should be between 0 and 100.");}
            System.out.println("The student with the lowest grade is "+students.get(minID).getName()+""
                    + " with an average of "+minAvg);
        }
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
    
    public static boolean direct(HashMap<Integer,Student> students){
        String input;
        input = UIO.getString("What do you want to do?\n"
                + "\t1.) List Students\n"
                + "\t2.) Add Student\n"
                + "\t3.) Remove Student\n"
                + "\t4.) View Scores\n"
                + "\t5.) Add Score\n"
                + "\t6.) View Average (one student)\n"
                + "\t7.) View Average (all students)\n"
                + "\t8.) Best Average\n"
                + "\t9.) Worst Average\n"
                + "Type cancel at any time to quit.");
        System.out.println();

        if(input.equalsIgnoreCase("1") || input.equalsIgnoreCase("list students")){
            getListOfStudents(students);
        } else if(input.equalsIgnoreCase("2") || input.equalsIgnoreCase("add student")){
            addStudent(students);
        } else if(input.equalsIgnoreCase("3") || input.equalsIgnoreCase("remove student")){
            removeStudent(students);
        } else if(input.equalsIgnoreCase("4") || input.equalsIgnoreCase("view scores")){
            getScores(students);
        } else if(input.equalsIgnoreCase("5") || input.equalsIgnoreCase("add score")){
            addScore(students);
        } else if(input.equalsIgnoreCase("6") || input.equalsIgnoreCase("view average (one student)")){
            getAverage(students);
        } else if(input.equalsIgnoreCase("7") || input.equalsIgnoreCase("view average (all students)")){
            getOverallAverage(students);
        } else if(input.equalsIgnoreCase("8") || input.equalsIgnoreCase("best average")){
            getStudentByScore(students,true);
        } else if(input.equalsIgnoreCase("9") || input.equalsIgnoreCase("worst average")){
            getStudentByScore(students,false);
        } else if(input.equalsIgnoreCase("cancel")){
            return true;
        }
        System.out.println();
        return false;
    }
}