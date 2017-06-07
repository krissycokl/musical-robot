package com.sg.m5flooringmastery.view;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class UserIOConsoleImpl implements UserIO {
    private static Scanner sc = new Scanner(System.in);

    @Override
    public BigDecimal getBigD(String prompt, boolean blankOk) {
        String response;
        BigDecimal responseBigD;
        while (true){
            System.out.println(prompt);
            response = sc.nextLine();
            if(response.isEmpty() && blankOk){
                return BigDecimal.ZERO.setScale(0);
            }
            try{
                responseBigD = new BigDecimal(response);
                return responseBigD;
            } catch (Exception e){}
        }
    }

    @Override
    public BigDecimal getBigD(String prompt, boolean blankOk, BigDecimal min, BigDecimal max) {
        String response;
        BigDecimal responseBigD;
        while (true){
            System.out.println(prompt);
            response = sc.nextLine();
            if(response.isEmpty() && blankOk){
                return BigDecimal.ZERO.setScale(0);
            }
            try{
                responseBigD = new BigDecimal(response);
                if (    responseBigD.compareTo(max)<=0
                     && responseBigD.compareTo(min)>=0){
                    return responseBigD;
                }
            } catch (Exception e){}
        }
    }

    @Override
    public LocalDate getDate(String prompt, boolean blankOk, LocalDate min, LocalDate max) {
        System.out.println(prompt);
        LocalDate ld;
        String ans;
        while (true){
            ans = sc.nextLine();
            if(ans.isEmpty() && blankOk){
                return max;
            }
            try{
                ld = LocalDate.parse(ans,DateTimeFormatter.ofPattern("MM/dd/uuuu"));
                if ( (ld.isAfter(min) || ld.isEqual(min))
                        &&
                     (ld.isBefore(max) || ld.isEqual(max)) ){
                    return ld;
                }
            } catch (DateTimeParseException e){
                System.out.println("Please enter a date in format MM/DD/YYYY.");
                if(blankOk){
                    System.out.println("Hit enter to use default of "+max+".");
                }
            }
        }
    }
    
    @Override
    public int getInt(String prompt, boolean blankOk){
        String response;
        int responseInt;
        while (true){
            System.out.println(prompt);
            response = sc.nextLine();
            if(response.isEmpty() && blankOk){
                return 0;
            }
            try{
                responseInt = Integer.parseInt(response);
                return responseInt;
            } catch (NumberFormatException e) {}
        }
    }
    
    @Override
    public int getInt(String prompt, boolean blankOk, int min, int max){
        String response;
        int responseInt;
        while (true){
            System.out.println(prompt);
            response = sc.nextLine();
            if(response.isEmpty() && blankOk){
                return 0;
            }
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
    public LocalDate getDate(String prompt, boolean blankOk, LocalDate otherwise){
        System.out.println(prompt);
        LocalDate ld;
        String ans;
        while (true){
            ans = sc.nextLine();
            if(ans.isEmpty() && blankOk){
                return otherwise;
            }
            try{
                ld = LocalDate.parse(ans,DateTimeFormatter.ofPattern("MM/dd/uuuu"));
                return ld;
            } catch (DateTimeParseException e){
                System.out.println("Please enter a date in format MM/DD/YYYY.");
                if(blankOk){
                    System.out.println("Hit enter to use default of "+otherwise+".");
                }
            }
        }
    }
    
    @Override
    public void print(String prompt){
        System.out.println(prompt);
    }
        
}