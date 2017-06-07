package com.sg.m5flooringmastery.view;

import java.math.BigDecimal;
import java.time.LocalDate;

public interface UserIO {
    /**
     * Forces user to input an integer.
     * 
     * @param prompt    Shown to user
     * @param blankOk   If true, an empty response will return 0
     * @return          Inputted integer or 0, if blankOK
     */
    public int getInt(String prompt, boolean blankOk);
    
    /**
     * Forces user to input an integer.
     * 
     * @param prompt    Shown to user
     * @param blankOk   If true, an empty response will return 0
     * @param min       Minimum acceptable value
     * @param max       Maximum acceptable value
     * @return          Inputted integer or 0, if blankOK
     */
    public int getInt(String prompt, boolean blankOk, int min, int max);
    
    /**
     * Forces user to input a string.
     * 
     * @param prompt    Shown to user
     * @return          Inputted string
     */
    public String getString(String prompt);
    
    public float getFloat(String prompt);
    public float getFloat(String prompt, float min, float max);
    public double getDouble(String prompt);
    public double getDouble(String prompt, double min, double max);
    
    /**
     * Forces user to input a BigDecimal-parsable string.
     * 
     * @param prompt    Shown to user
     * @param blankOk   If true, an empty response will return 0 (scale 0)
     * @return          Inputted BigDecimal or 0 (scale 0)
     */
    public BigDecimal getBigD(String prompt, boolean blankOk);
    
    /**
     * Forces user to input a BigDecimal-parseable string.
     * 
     * @param prompt    Shown to user
     * @param blankOk   If true, an empty response will return 0 (scale 0)
     * @param min       Minimum acceptable value
     * @param max       Maximum acceptable value
     * @return          Inputted BigDecimal or 0 (scale 0)
     */
    public BigDecimal getBigD(String prompt, boolean blankOk, BigDecimal min, BigDecimal max);
    
    /**
     * Forces user to input a LocalDate-parsable string.
     * 
     * @param prompt    Shown to user
     * @param blankOk   If true, an empty response will return otherwise-value
     * @param otherwise Default value if blankOK
     * @return          Inputted LocalDate or otherwise LocalDate
     */
    public LocalDate getDate(String prompt, boolean blankOk, LocalDate otherwise);
    
    /**
     * Forces user to input a LocalDate-parsable string.
     * 
     * @param prompt    Shown to user
     * @param blankOk   If true, an empty response will return otherwise-value
     * @param min       Minimum acceptable value
     * @param max       Maximum acceptable value, default value if blankOk
     * @return          Inputted LocalDate or otherwise LocalDate
     */
    public LocalDate getDate(String prompt, boolean blankOk, LocalDate min, LocalDate max);
    public void print(String prompt);
}