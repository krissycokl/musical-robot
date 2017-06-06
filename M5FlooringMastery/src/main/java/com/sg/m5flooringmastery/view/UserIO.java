package com.sg.m5flooringmastery.view;

import java.math.BigDecimal;
import java.time.LocalDate;

public interface UserIO {
    public int getInt(String prompt);
    public int getInt(String prompt, int min, int max);
    public String getString(String prompt);
    public float getFloat(String prompt);
    public float getFloat(String prompt, float min, float max);
    public double getDouble(String prompt);
    public double getDouble(String prompt, double min, double max);
    public BigDecimal getBigD(String prompt);
    public BigDecimal getBigD(String prompt, BigDecimal min, BigDecimal max);
    public LocalDate getDate(String prompt, LocalDate otherwise);
    public void print(String prompt);
}