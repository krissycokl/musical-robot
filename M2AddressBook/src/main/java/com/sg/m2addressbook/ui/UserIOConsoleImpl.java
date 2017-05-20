package com.sg.m2addressbook.ui;

import java.util.Scanner;

public class UserIOConsoleImpl implements UserIO {
    private static Scanner sc = new Scanner(System.in);
    
    @Override
    public int getInt(String prompt){
        System.out.println(prompt);
        return Integer.parseInt(sc.nextLine());
    }
    
    @Override
    public int getInt(String prompt, int min, int max){
        int response;
        while (true){
            System.out.println(prompt);
            response = Integer.parseInt(sc.nextLine());
            if(response <= max && response >= min){
                return response;
            }
        }
    }
    
    @Override
    public String getString(String prompt){
        System.out.println(prompt);
        return sc.nextLine();
    }
    
    @Override
    public float getFloat(String prompt){
        System.out.println(prompt);
        return Float.parseFloat(sc.nextLine());
    }
    
    @Override
    public float getFloat(String prompt, float min, float max){
        float response;
        while (true){
            System.out.println(prompt);
            response = Float.parseFloat(sc.nextLine());
            if(response <= max && response >= min){
                return response;
            }
        }
    }
    
    @Override
    public double getDouble(String prompt){
        System.out.println(prompt);
        return Double.parseDouble(sc.nextLine());
    }
    
    @Override
    public double getDouble(String prompt, double min, double max){
        double response;
        while (true){
            System.out.println(prompt);
            response = Double.parseDouble(sc.nextLine());
            if(response <= max && response >= min){
                return response;
            }
        }
    }
    
    @Override
    public void print(String prompt){
        System.out.println(prompt);
    }
        
}