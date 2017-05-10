/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.windowmaster;
import java.util.Scanner;

/**
 *
 * @author kristen
 */
public class WindowMaster {
    public static void main (String[] args){
        float width;
        float height;
        
        String widthString;
        String heightString;
        
        Scanner myScanner = new Scanner(System.in);
        
        System.out.println("What is the width of the window?");
        widthString = myScanner.nextLine();
        System.out.println("What is the height of the window?");
        heightString = myScanner.nextLine();
        
        width = Float.parseFloat(widthString);
        height = Float.parseFloat(heightString);
        
        System.out.println("The area of the window is: " + (width*height));
        System.out.println("The perimeter of the window is: " + (2*(width+height)));
    }
}
