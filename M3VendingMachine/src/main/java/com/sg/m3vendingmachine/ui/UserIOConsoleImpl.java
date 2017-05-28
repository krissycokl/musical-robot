package com.sg.m3vendingmachine.ui;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class UserIOConsoleImpl implements UserIO {
    private static Scanner sc = new Scanner(System.in);
    
    @Override
    public int getInt(String prompt){
        String response;
        int responseInt;
        while (true){
            System.out.println(prompt);
            response = sc.nextLine();
            try{
                responseInt = Integer.parseInt(response);
                return responseInt;
            } catch (NumberFormatException e) {}
        }
    }
    
    @Override
    public int getInt(String prompt, int min, int max){
        String response;
        int responseInt;
        while (true){
            System.out.println(prompt);
            response = sc.nextLine();
            try{
                responseInt = Integer.parseInt(response);
                if(responseInt <= max && responseInt >= min){
                    return responseInt;
                }
            } catch (NumberFormatException e) {}
        }
    }
    
    @Override
    public String getString(String prompt){
        System.out.println(prompt);
        return sc.nextLine();
    }
    
    @Override
    public float getFloat(String prompt){
        String response;
        float responseFloat;
        while (true){
            System.out.println(prompt);
            response = sc.nextLine();
            try{
                responseFloat = Float.parseFloat(response);
                return responseFloat;
            } catch (NumberFormatException e) {}
        }
    }
    
    @Override
    public float getFloat(String prompt, float min, float max){
        String response;
        float responseFloat;
        while (true){
            System.out.println(prompt);
            response = sc.nextLine();
            try{
                responseFloat = Float.parseFloat(response);
                if(responseFloat <= max && responseFloat >= min){
                    return responseFloat;
                }
            } catch (NumberFormatException e) {}
        }
    }
    
    @Override
    public double getDouble(String prompt){
        String response;
        double responseDbl;
        while (true){
            System.out.println(prompt);
            response = sc.nextLine();
            try{
                responseDbl = Double.parseDouble(response);
                return responseDbl;
            } catch (NumberFormatException e) {}
        }
    }
    
    @Override
    public double getDouble(String prompt, double min, double max){
        String response;
        double responseDouble;
        while (true){
            System.out.println(prompt);
            response = sc.nextLine();
            try{
                responseDouble = Double.parseDouble(response);
                if(responseDouble <= max && responseDouble >= min){
                    return responseDouble;
                }
            } catch (NumberFormatException e) {}
        }
    }
    
    @Override
    public LocalDate getDate(String prompt, String otherwise){
        System.out.println(prompt);
        LocalDate ld;
        String ans;
        boolean tried = false;
        while (true){
            ans = sc.nextLine();
            try{
                if(ans.isEmpty() && tried){
                    return LocalDate.parse(otherwise,DateTimeFormatter.ofPattern("MM/dd/uuuu"));
                }
                ld = LocalDate.parse(ans,DateTimeFormatter.ofPattern("MM/dd/uuuu"));
                return ld;
            } catch (DateTimeParseException e){
                System.out.println("Please enter a date in format MM/DD/YYYY,"
                        + " or hit enter to use system default of "+otherwise+".");
                tried = true;
            }
        }
    }
    
    @Override
    public void print(String prompt){
        System.out.println(prompt);
    }
        
}